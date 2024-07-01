package all_projects.src.designPattern.Payment;

import javax.sound.midi.Instrument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstrumentEntity {

    String instrumentId;
    String userId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public InstrumentType getIntrumentType() {
        return intrumentType;
    }

    public void setIntrumentType(InstrumentType intrumentType) {
        this.intrumentType = intrumentType;
    }

    InstrumentType intrumentType;
}


 class InstrumentDto {

     BankInfoDto bankInfoDto = new BankInfoDto();
     CardInfoDto cardInfoDto = new CardInfoDto();

    String instrumentId;
    String userId;

     InstrumentType intrumentType;


     public String getUserId() {
         return userId;
     }

     public void setUserId(String userId) {
         this.userId = userId;
     }

     public InstrumentType getIntrumentType() {
         return intrumentType;
     }

     public void setIntrumentType(InstrumentType intrumentType) {
         this.intrumentType = intrumentType;
     }

     public String getInstrumentId() {
         return instrumentId;
     }

}


class BankInfoDto{
    String bankAccNo;
    String branch;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    String ifscCode;

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}

class CardInfoDto{
    String cardNumber;
    String cvvNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }
}


class Bank extends InstrumentEntity{
    public Bank() {
        this.intrumentType = InstrumentType.BANK;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    private String bankAccNo;
    private String branch;
    private String ifscCode;
}


class Card extends InstrumentEntity{
    public Card() {
        this.intrumentType = InstrumentType.CARD;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private String cvv;
    private String cardNumber;
}


enum InstrumentType{
    BANK, CARD
}


abstract class InstrumentService{
    static Map<String, List<InstrumentEntity>> map=new HashMap<>();
    public abstract String addInstrument(InstrumentDto instrument);

    public abstract List<InstrumentDto>  getInstrumentByUserId(String id);
}

class BankService extends InstrumentService{
    public String addInstrument(InstrumentDto instrument){
        Bank bank = new Bank();
        bank.setUserId(instrument.getUserId());
        bank.setBankAccNo(instrument.bankInfoDto.bankAccNo);
        bank.setBranch(instrument.bankInfoDto.branch);
        if(map.containsKey(instrument.getUserId())){
            List<InstrumentEntity> instrumentEntities = map.get(instrument.getUserId());
            instrumentEntities.add(bank);
            map.put(instrument.getUserId(), instrumentEntities);
        } else {
            map.put(instrument.getUserId(), Arrays.asList(bank));
        }
      return bank.instrumentId;
    }

    @Override
    public List<InstrumentDto> getInstrumentByUserId(String id) {
        List<InstrumentDto> instrumentDtos=new ArrayList<>();
        map.get(id).stream().filter(instrumentEntity -> instrumentEntity.intrumentType == InstrumentType.BANK).forEach(
                instrumentEntity->{
                    InstrumentDto instrumentDto = new InstrumentDto();
                    instrumentDto.setIntrumentType(instrumentEntity.intrumentType);
                    instrumentDto.setUserId(instrumentEntity.getUserId());
                    instrumentDto.bankInfoDto.setBankAccNo(((Bank) instrumentEntity).getBankAccNo());
                    instrumentDto.bankInfoDto.setBranch(((Bank) instrumentEntity).getBranch());
                    instrumentDto.bankInfoDto.setIfscCode(((Bank) instrumentEntity).getIfscCode());
                    instrumentDtos.add(instrumentDto);
                }
        );
         return instrumentDtos;
    }
}

class CardService extends InstrumentService{
    public String addInstrument(InstrumentDto instrument){
        Card card = new Card();
        card.setUserId(instrument.getUserId());
        card.setCardNumber(instrument.cardInfoDto.cardNumber);
        card.setCvv(instrument.cardInfoDto.cvvNumber);
        if(map.containsKey(instrument.getUserId())){
            List<InstrumentEntity> instrumentEntities = map.get(instrument.getUserId());
            instrumentEntities.add(card);
            map.put(instrument.getUserId(), instrumentEntities);
        } else {
            map.put(instrument.getUserId(), Arrays.asList(card));
        }
        return card.instrumentId;
    }

    @Override
    public List<InstrumentDto> getInstrumentByUserId(String id) {
        List<InstrumentDto> instrumentDtos=new ArrayList<>();
        map.get(id).stream().filter(instrumentEntity -> instrumentEntity.intrumentType == InstrumentType.CARD).forEach(
                instrumentEntity->{
                    InstrumentDto instrumentDto = new InstrumentDto();
                    instrumentDto.setIntrumentType(instrumentEntity.intrumentType);
                    instrumentDto.setUserId(instrumentEntity.getUserId());
                    instrumentDto.cardInfoDto.setCardNumber(((Card) instrumentEntity).getCardNumber());
                    instrumentDto.cardInfoDto.setCvvNumber(((Card) instrumentEntity).getCvv());
                    instrumentDtos.add(instrumentDto);
                }
        );
        return instrumentDtos;
    }
}