import javax.swing.JFrame;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args){
        ReadAccounts readAccount = new ReadAccounts();
        
        readAccount.ReadAccount("Accounts.csv");

        LinkedList<String> firstNames = readAccount.getFirstNames();
        LinkedList<String> lastNames = readAccount.getLastNames();
        LinkedList<Integer> accountNumber = readAccount.getAccounts();
        LinkedList<Integer> accountBalance = readAccount.getBalances();

        LinkedList<Account> accounts = new LinkedList<Account>();
        
        for (int i = 0; i < firstNames.size(); i++){
            //FName, LName, AccNum, AccBal
            Account newAccount = new Account(firstNames.get(i), lastNames.get(i), accountNumber.get(i), accountBalance.get(i));
            accounts.add(newAccount);
        }

        GUI g = new GUI(accounts);
        // g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(1000,1300);
        g.setVisible(true);
    }
}