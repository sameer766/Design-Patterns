package all_projects.src.designPattern.Payment;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class TransactionController {
    TransactionService transactionService;

    TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    public void makePayment(TransactionDto transactionDto){
        transactionService.makePayment(transactionDto);
    }
}


class TransactionService {

    InstrumentController controller;
    TransactionProcessor processor;
    Map<String, List<Transaction>> map=new HashMap<>();

    public TransactionService(InstrumentController controller, TransactionProcessor processor) {
        this.controller = controller;
        this.processor=processor;
    }

    public void makePayment(TransactionDto transactionDto){
        List<InstrumentDto> instrumentById = controller.getInstrumentById(transactionDto.getSenderId());

        Optional<InstrumentDto> debit =
                instrumentById.stream().filter(instrumentDto -> instrumentDto.getInstrumentId().equalsIgnoreCase(transactionDto.getDebitInstrumentId())).findFirst();

        InstrumentDto instrumentDtoDebit;
        if(debit.isPresent()){
            instrumentDtoDebit = debit.get();
        } else {
            throw new IllegalArgumentException();
        }

        List<InstrumentDto> credit = controller.getInstrumentById(transactionDto.getCreditIntrumentId());
        Optional<InstrumentDto> creditInstrumentIds =
                credit.stream().filter(instrumentDto -> instrumentDto.getInstrumentId().equalsIgnoreCase(transactionDto.getDebitInstrumentId())).findFirst();

        InstrumentDto instrumentDtoCredit;
        if(creditInstrumentIds.isPresent()){
            instrumentDtoCredit = creditInstrumentIds.get();
        } else {
            throw new IllegalArgumentException();
        }
        boolean isSucces = processor.processTransaction(instrumentDtoDebit, instrumentDtoCredit);



        if(isSucces) {
            Transaction transaction = new Transaction();
            transaction.setAmount(transactionDto.getDebitAmount());
            transaction.setCreditIntrumentId(transactionDto.getCreditIntrumentId());
            transaction.setDebitInstrumentId(transactionDto.getDebitInstrumentId());
            transaction.setSenderId(transactionDto.getSenderId());
            transaction.setReceiverId(transactionDto.getReceiverId());
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            transaction.setTxnId(UUID.randomUUID().hashCode());
            if (map.get(transaction.getSenderId()) != null) {
                List<Transaction> transactions = map.get(transaction.getSenderId());
                transactions.add(transaction);
                map.put(transaction.getSenderId(), transactions);
            } else {
                map.put(transaction.getSenderId(), Arrays.asList(transaction));
            }

            if (map.get(transaction.getReceiverId()) != null) {
                List<Transaction> transactions = map.get(transaction.getReceiverId());
                transactions.add(transaction);
                map.put(transaction.getReceiverId(), transactions);
            } else {
                map.put(transaction.getReceiverId(), Arrays.asList(transaction));
            }
        }

    }
}



class TransactionProcessor{


    public boolean processTransaction(InstrumentDto instrumentDtoDebit, InstrumentDto instrumentDtoCredit) {
       return true;
    }
}


class Transaction {
    private Integer amount;
    private Integer txnId;
    private String senderId;
    private String receiverId;
    private String debitInstrumentId;
    private String creditIntrumentId;
    private int debitAmount;
    TransactionStatus transactionStatus;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTxnId() {
        return txnId;
    }

    public void setTxnId(Integer txnId) {
        this.txnId = txnId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getDebitInstrumentId() {
        return debitInstrumentId;
    }

    public void setDebitInstrumentId(String debitInstrumentId) {
        this.debitInstrumentId = debitInstrumentId;
    }

    public String getCreditIntrumentId() {
        return creditIntrumentId;
    }

    public void setCreditIntrumentId(String creditIntrumentId) {
        this.creditIntrumentId = creditIntrumentId;
    }

    public int getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(int debitAmount) {
        this.debitAmount = debitAmount;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
class TransactionDto{
    private String id;
    private String senderId;
    private String receiverId;
    private String debitInstrumentId;
    private String creditIntrumentId;
    private int debitAmount;
    TransactionStatus transactionStatus;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getDebitInstrumentId() {
        return debitInstrumentId;
    }

    public void setDebitInstrumentId(String debitInstrumentId) {
        this.debitInstrumentId = debitInstrumentId;
    }

    public String getCreditIntrumentId() {
        return creditIntrumentId;
    }

    public void setCreditIntrumentId(String creditIntrumentId) {
        this.creditIntrumentId = creditIntrumentId;
    }

    public int getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(int debitAmount) {
        this.debitAmount = debitAmount;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}


enum TransactionStatus{
    PENDING, SUCCESS, FAILED
}