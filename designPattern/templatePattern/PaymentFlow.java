package all_projects.src.designPattern.templatePattern;

 abstract class PaymentFlow {

    public final void sendMoney(){
        validateRequest();
        calculateFees();
        debitAmount();
        creditAmount();
    }

    public abstract void validateRequest();
    public abstract void calculateFees();
    public abstract void debitAmount();
    public abstract void creditAmount();
}


class PayToFriend extends PaymentFlow{

    @Override
    public void validateRequest() {
        System.out.println("valida payment to friend");
    }

    @Override
    public void calculateFees() {
        System.out.println("calculate payment fees");
    }

    @Override
    public void debitAmount() {
        System.out.println("debit amount" );
    }

    @Override
    public void creditAmount() {
        System.out.println("credit amount" );
    }
}

class PayToCompany extends PaymentFlow{

    @Override
    public void validateRequest() {
        System.out.println("valida payment to company");
    }

    @Override
    public void calculateFees() {
        System.out.println("calculate payment fees");
    }

    @Override
    public void debitAmount() {
        System.out.println("debit amount" );
    }

    @Override
    public void creditAmount() {
        System.out.println("credit amount" );
    }
}


class Main {

    public static void main(String[] args) {
        PaymentFlow paymentFlow=new PayToCompany();
        paymentFlow.sendMoney();
    }
}