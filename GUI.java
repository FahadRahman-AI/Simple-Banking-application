

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame {
    private StringBuilder sbAllData;
    private LinkedList<Account> globalAccounts;
    private JLabel showAllData;
    private JButton showAllButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JTextField accDeposit;
    private JTextField accWithdraw;
    private JTextField acc1Transfer;
    private JTextField acc2Transfer;
    private JTextField depositInput;
    private JTextField withdrawInput;
    private JTextField transferAmount;

    public GUI(LinkedList<Account> accounts) {
        super("Banking System");
        setLayout(null);
        globalAccounts = accounts;
        sbAllData = new StringBuilder();
        for (Account acc : globalAccounts) {
            sbAllData.append(acc.toString()).append("\n");
        }

        showAllData = new JLabel(sbAllData.toString());
        showAllButton = new JButton("Show All");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        transferButton = new JButton("Transfer");

        accDeposit = new JTextField("Account Number for Deposit");
        accWithdraw = new JTextField("Account Number for Withdraw");
        acc1Transfer = new JTextField("Account 1 for Transfer");
        acc2Transfer = new JTextField("Account 2 for Transfer");
        depositInput = new JTextField("Deposit Amount");
        withdrawInput = new JTextField("Withdraw Amount");
        transferAmount = new JTextField("Transfer Amount");

        showAllButton.setBounds(50, 50, 100, 30);
        depositButton.setBounds(50, 100, 100, 30);
        withdrawButton.setBounds(50, 150, 100, 30);
        transferButton.setBounds(50, 200, 100, 30);

        accDeposit.setBounds(200, 100, 150, 30);
        accWithdraw.setBounds(200, 150, 150, 30);
        acc1Transfer.setBounds(200, 200, 150, 30);
        acc2Transfer.setBounds(200, 250, 150, 30);
        depositInput.setBounds(380, 100, 150, 30);
        withdrawInput.setBounds(380, 150, 150, 30);
        transferAmount.setBounds(380, 200, 150, 30);

        showAllData.setBounds(200, 50, 500, 30);

        add(showAllButton);
        add(depositButton);
        add(withdrawButton);
        add(transferButton);
        add(accDeposit);
        add(accWithdraw);
        add(acc1Transfer);
        add(acc2Transfer);
        add(depositInput);
        add(withdrawInput);
        add(transferAmount);
        add(showAllData);

        HandlerClass handler = new HandlerClass();
        showAllButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);
    }

    private class HandlerClass implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == showAllButton) {
                showAllData.setText(sbAllData.toString());
            } else if (e.getSource() == depositButton) {
                int accNumber = Integer.parseInt(accDeposit.getText());
                double amount = Double.parseDouble(depositInput.getText());
                // Find the account and deposit
                // account.deposit(amount);
            } else if (e.getSource() == withdrawButton) {
                int accNumber = Integer.parseInt(accWithdraw.getText());
                double amount = Double.parseDouble(withdrawInput.getText());
                // Find the account and withdraw
                // account.withdraw(amount);
            } else if (e.getSource() == transferButton) {
                int acc1 = Integer.parseInt(acc1Transfer.getText());
                int acc2 = Integer.parseInt(acc2Transfer.getText());
                double amount = Double.parseDouble(transferAmount.getText());
                // Find both accounts and transfer amount
                // account1.transfer(account2, amount);
            }
        }
    }

    public static void main(String[] args) {
        // Assuming you have read the CSV file and populated accounts LinkedList
        LinkedList<Account> accounts = new LinkedList<>();

        // Populate accounts LinkedList from CSV or wherever

        GUI gui = new GUI(accounts);
        gui.setSize(1000, 1000);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

