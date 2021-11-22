import static java.lang.System.out;

public class Checking extends Account{
    //List the properties specific to a Checking account (debit card, pin, etc.)
    private int debitCardNumber;
    private int debitCardPin;

    //Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initialDeposit) {
        super(name, sSN, initialDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();

    }
    @Override
    public void setRate(){
        rate = getBaseRate() * .15;
    }


    //List any methods specific to a checking account
    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10,12));
        debitCardPin = (int) (Math.random() * Math.pow(10,4));
    }

    public void showInfo() {
        super.showInfo();
        out.println("Your Checking Account Features" +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card Pin: " + debitCardPin
        );
    }
}
