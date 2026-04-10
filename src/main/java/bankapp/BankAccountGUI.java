package bankapp;
import javax.swing.*;
import java.awt.*;

public class BankAccountGUI extends JFrame {

    private BankAccount account;

    // GUI Components
    private JLabel balanceLabel;
    private JTextField amountField;
    private JLabel messageLabel;

    public BankAccountGUI() {
        // Create account with Rs.1000 initial balance
        account = new BankAccount("User", 1000.0);

        // Window Settings
        setTitle("🏦 Bank Account Simulator");
        setSize(420, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 248, 255));

        // ── TOP PANEL: Balance Display ──
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 102, 204));
        setPadding(topPanel);

        balanceLabel = new JLabel("Balance: ₹ 1000.0");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 22));
        balanceLabel.setForeground(Color.WHITE);
        topPanel.add(balanceLabel);
        add(topPanel, BorderLayout.NORTH);

        // ── CENTER PANEL: Input + Buttons ──
        JPanel centerPanel = new JPanel(new GridLayout(5, 1, 8, 8));
        centerPanel.setBackground(new Color(240, 248, 255));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 10, 30));

        JLabel nameLabel = new JLabel("Account Holder: " + account.getAccountHolder(),
                                       SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel enterLabel = new JLabel("Enter Amount (₹):", SwingConstants.CENTER);
        enterLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        amountField = new JTextField();
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));
        amountField.setHorizontalAlignment(JTextField.CENTER);

        JButton depositBtn = new JButton("💰 Deposit");
        depositBtn.setBackground(new Color(34, 139, 34));
        depositBtn.setForeground(Color.WHITE);
        depositBtn.setFont(new Font("Arial", Font.BOLD, 14));

        JButton withdrawBtn = new JButton("💸 Withdraw");
        withdrawBtn.setBackground(new Color(204, 0, 0));
        withdrawBtn.setForeground(Color.WHITE);
        withdrawBtn.setFont(new Font("Arial", Font.BOLD, 14));

        centerPanel.add(nameLabel);
        centerPanel.add(enterLabel);
        centerPanel.add(amountField);
        centerPanel.add(depositBtn);
        centerPanel.add(withdrawBtn);
        add(centerPanel, BorderLayout.CENTER);

        // ── BOTTOM PANEL: Message ──
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(240, 248, 255));

        messageLabel = new JLabel("Welcome! Ready to transact 🎉");
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 13));
        messageLabel.setForeground(new Color(0, 102, 204));
        bottomPanel.add(messageLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        // ── Button Actions ──
        depositBtn.addActionListener(e -> handleDeposit());
        withdrawBtn.addActionListener(e -> handleWithdraw());

        setVisible(true);
    }

    private void handleDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText().trim());
            account.deposit(amount);
            updateBalance();
            showMessage("✅ Deposited ₹" + amount + " successfully!", new Color(0, 128, 0));
        } catch (NumberFormatException ex) {
            showMessage("❌ Please enter a valid number!", Color.RED);
        } catch (IllegalArgumentException ex) {
            showMessage("❌ " + ex.getMessage(), Color.RED);
        }
    }

    private void handleWithdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText().trim());
            account.withdraw(amount);
            updateBalance();
            showMessage("✅ Withdrew ₹" + amount + " successfully!", new Color(0, 128, 0));
        } catch (IllegalArgumentException ex) {
            showMessage("❌ " + ex.getMessage(), Color.RED);
        } catch (NumberFormatException ex) {
            showMessage("❌ Please enter a valid number!", Color.RED);
        }
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: ₹ " + account.getBalance());
        amountField.setText("");
    }

    private void showMessage(String msg, Color color) {
        messageLabel.setText(msg);
        messageLabel.setForeground(color);
    }

    // Helper method (ignore - just for padding)
    private void setPadding(JPanel panel) {
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankAccountGUI::new);
    }
}