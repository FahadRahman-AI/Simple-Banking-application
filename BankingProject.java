import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.AcceptPendingException;

public class BankingProject {

}
    
class Customer{
    public String FName;
    public String LName;

    public String getFirstName(){
        return FName;
    }

    public void setFirstName(String firstName){
        this.FName  = firstName;
    }

    public String getLastName(){
        return LName;
    }

    public void setLastName(String lastName){
        this.LName = lastName;
    }
}
    
    
class Account extends Customer{
    public int balance;
    public int accountNumber;

    public Account(String FName, String LName, int accNum, int accBal){
        setFirstName(FName);
        setLastName(LName);
        this.accountNumber = accNum;
        this.balance = accBal;
    }

    public int getBalance(){
        return balance;
    }

    public int getAccountNum(){
        return accountNumber;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        balance -= amount;
    }


}

class Transaction{
    public void transfer(Account acc1, Account acc2, int amount){
        // System.out.println(acc1.FName);
        acc2.withdraw(amount);

        acc1.deposit(amount);
       
    }
    public void withdrawAmount(Account acc1,int amount){
        // System.out.println(acc1.FName);
        acc1.withdraw(amount);
       
    }
    public void depositAmount(Account acc1,int amount){
        // System.out.println(acc1.FName);
        acc1.deposit(amount);
       
    }
    
}

class ReadAccounts{
    LinkedList<String> firstNames = new LinkedList<String>();
    LinkedList<String> lastNames = new LinkedList<String>();
    LinkedList<Integer> accNumber = new LinkedList<Integer>();
    LinkedList<Integer> accBalance = new LinkedList<Integer>();

    public void ReadAccount(String URL) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(URL));
            String line;
            int lineNo = 0;

            while ((line = reader.readLine()) != null) {
                lineNo++;
                if (lineNo == 1) {
                    System.out.println("Header is ignored");
                    continue;
                }

                String[] data = line.split(",");

                for (int i = 0; i < data.length; i++) {
                data[i] = data[i].trim();
                }
                
                firstNames.add(data[0]);
                lastNames.add(data[1]);
                accNumber.add(Integer.parseInt(data[2]));
                accBalance.add(Integer.parseInt(data[3]));
            }
            reader.close();

            System.out.println("CSV file read successfully!");
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing integer: " + e);
        }


    }

    public LinkedList<String> getFirstNames(){
        return firstNames;
    }

    public LinkedList<String> getLastNames(){
        return lastNames;
    }
    
    public LinkedList<Integer> getAccounts(){
        return accNumber;
    }

    public LinkedList<Integer> getBalances(){
        return accBalance;
    }   
}