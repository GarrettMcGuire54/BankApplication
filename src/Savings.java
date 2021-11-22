import static java.lang.System.out;

public class Savings extends Account{
    //List properties specific to savings accounts
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    //Constructor to initialize settings for the savings properties
    public Savings(String name, String sSN, double initialDeposit){
        super(name, sSN, initialDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }


    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }


    //Methods specific for savings account

    public void showInfo() {
        out.println("ACCOUNT TYPE: Savings");
        super.showInfo();
        out.println(
                "Your Savings Account Features" +
                        "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                        "\n Safety Deposit Box Key: " + safetyDepositBoxKey
        );
    }

}
