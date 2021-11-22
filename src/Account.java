import static java.lang.System.out;

public abstract class Account implements IRate {
    //List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    //Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initialDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initialDeposit;


        //Set account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2);
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        out.println("Accrued Interest: " + accruedInterest);
        printBalance();
    }


    //List common methods - transactions

    public void deposit(double amount) {
        balance = balance + amount;
        out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance(){
        out.println("Your balance is now $" + balance);
    }


    public void showInfo() {
        out.println(
                "NAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALANCE: " + balance +
                "\nRATE: " + rate + "%"
        );
    }
}
