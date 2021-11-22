import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();


        //Read a CSV file then create new accounts based on that data
        String file = "C:\\Users\\carte\\Desktop\\NewBankAccounts.csv";

        List<String[]> newAccountHolder = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolder){
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initialDeposit = Double.parseDouble(accountHolder[3]);

            if (accountType.equals("Savings")){
                accounts.add(new Savings(name, sSN,initialDeposit));
            }else if (accountType.equals("Checking")){
                accounts.add(new Checking(name, sSN, initialDeposit));
            } else {
                out.println("ERROR READING ACCOUNT TYPE");
            }
        }
        for (Account acc : accounts) {
            out.println("\n******************");
            acc.showInfo();
     }
    }
}