package all_projects.src.designPattern.Payment;

import java.util.List;

public class InstrumentController {

   private IntrumentFactory intrumentFactory;

    public InstrumentController(IntrumentFactory intrumentFactory) {
        this.intrumentFactory = intrumentFactory;
    }

    public void addInstrument(InstrumentDto instrumentDto){
        InstrumentService instrument = intrumentFactory.createInstrument(instrumentDto);
        instrument.addInstrument(instrumentDto);
    }

    public List<InstrumentDto> getInstrumentById(String id){
        InstrumentDto instrumentDto = new InstrumentDto();
        instrumentDto.setIntrumentType(InstrumentType.BANK);
        InstrumentService instrument = intrumentFactory.createInstrument(instrumentDto);
        List<InstrumentDto> bankInstruments = instrument.getInstrumentByUserId(id);
        instrumentDto.setIntrumentType(InstrumentType.CARD);
        instrument = intrumentFactory.createInstrument(instrumentDto);
        List<InstrumentDto> cardInstruments = instrument.getInstrumentByUserId(id);
        bankInstruments.addAll(cardInstruments);
        return bankInstruments;
    }
}

class IntrumentFactory{

    BankService bankService;
    CardService cardService;
    public IntrumentFactory(BankService bankService, CardService cardService) {
        this.bankService=bankService;
        this.cardService=cardService;
    }

    public InstrumentService createInstrument(InstrumentDto instrumentDto){
        if(instrumentDto.getIntrumentType() == InstrumentType.BANK){
            return bankService;
        }
        else if(instrumentDto.getIntrumentType() == InstrumentType.CARD){
           return cardService;
        }
        return null;
    }
}


class TxnController {

}