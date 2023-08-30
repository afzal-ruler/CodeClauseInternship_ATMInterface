import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface extends JFrame {
    private double balance = 1000.0;

    private JLabel balanceLabel;
    private JButton checkBalanceButton;
    private JButton withdrawButton;
    private JButton depositButton;
    private JTextField amountField;

    public ATMInterface() {
        setTitle("ATM Interface");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        balanceLabel = new JLabel("Current Balance: $" + balance);
        checkBalanceButton = new JButton("Check Balance");
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        amountField = new JTextField(10);

        add(balanceLabel);
        add(checkBalanceButton);
        add(withdrawButton);
        add(depositButton);
        add(new JLabel("Amount:"));
        add(amountField);

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Current Balance: $" + balance);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                if (amount <= balance) {
                    balance -= amount;
                    balanceLabel.setText("Current Balance: $" + balance);
                    JOptionPane.showMessageDialog(null, "Withdraw successful. New balance: $" + balance);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                balance += amount;
                balanceLabel.setText("Current Balance: $" + balance);
                JOptionPane.showMessageDialog(null, "Deposit successful. New balance: $" + balance);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMInterface().setVisible(true);
            }
        });
    }
}
