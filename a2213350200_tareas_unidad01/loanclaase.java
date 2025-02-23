package U1_Trabajos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class loanclaase extends JFrame {

    private JTextField balanceTextField, interestTextField, monthsTextField, paymentTextField;
    private JTextArea analysisTextArea;
    private JButton computeButton, newLoanButton, monthsButton, paymentButton, exitButton;
    private boolean computePayment;
    private Color lightYellow = new Color(255, 255, 128);

    public static void main(String args[]) {
        new loanclaase().setVisible(true);
    }

    public loanclaase() {
        setTitle("Loan Assistant");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });

        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;
        Font myFont = new Font("Arial", Font.PLAIN, 16);

        // Labels
        JLabel balanceLabel = new JLabel("Loan Balance:");
        balanceLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(balanceLabel, gridConstraints);

        JLabel interestLabel = new JLabel("Interest Rate:");
        interestLabel.setFont(myFont);
        gridConstraints.gridy = 1;
        getContentPane().add(interestLabel, gridConstraints);

        JLabel monthsLabel = new JLabel("Number of Payments:");
        monthsLabel.setFont(myFont);
        gridConstraints.gridy = 2;
        getContentPane().add(monthsLabel, gridConstraints);

        JLabel paymentLabel = new JLabel("Monthly Payment:");
        paymentLabel.setFont(myFont);
        gridConstraints.gridy = 3;
        getContentPane().add(paymentLabel, gridConstraints);

        JLabel analysisLabel = new JLabel("Loan Analysis:");
        analysisLabel.setFont(myFont);
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 0;
        getContentPane().add(analysisLabel, gridConstraints);

        // Text Fields
        balanceTextField = new JTextField();
        balanceTextField.setPreferredSize(new Dimension(100, 25));
        balanceTextField.setFont(myFont);
        balanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        getContentPane().add(balanceTextField, gridConstraints);

        interestTextField = new JTextField();
        interestTextField.setPreferredSize(new Dimension(100, 25));
        interestTextField.setFont(myFont);
        interestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints.gridy = 1;
        getContentPane().add(interestTextField, gridConstraints);

        monthsTextField = new JTextField();
        monthsTextField.setPreferredSize(new Dimension(100, 25));
        monthsTextField.setFont(myFont);
        monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints.gridy = 2;
        getContentPane().add(monthsTextField, gridConstraints);

        paymentTextField = new JTextField();
        paymentTextField.setPreferredSize(new Dimension(100, 25));
        paymentTextField.setFont(myFont);
        paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints.gridy = 3;
        getContentPane().add(paymentTextField, gridConstraints);

        // Buttons
        computeButton = new JButton("Compute Monthly Payment");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        getContentPane().add(computeButton, gridConstraints);
        computeButton.addActionListener(e -> computeLoan());

        newLoanButton = new JButton("New Loan Analysis");
        newLoanButton.setEnabled(false);
        gridConstraints.gridy = 5;
        getContentPane().add(newLoanButton, gridConstraints);
        newLoanButton.addActionListener(e -> resetForm());

        monthsButton = new JButton("X");
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        getContentPane().add(monthsButton, gridConstraints);
        monthsButton.addActionListener(e -> switchToComputePayment());

        paymentButton = new JButton("X");
        paymentButton.setEnabled(false);
        gridConstraints.gridy = 3;
        getContentPane().add(paymentButton, gridConstraints);
        paymentButton.addActionListener(e -> switchToComputeMonths());

        exitButton = new JButton("Exit");
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 5;
        getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(e -> System.exit(0));

        // Text Area for Analysis
        analysisTextArea = new JTextArea();
        analysisTextArea.setPreferredSize(new Dimension(250, 150));
        analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        analysisTextArea.setEditable(false);
        analysisTextArea.setBackground(Color.WHITE);
        gridConstraints.gridx = 4;
        gridConstraints.gridy = 1;
        gridConstraints.gridheight = 4;
        getContentPane().add(analysisTextArea, gridConstraints);

        // Initialize mode
        switchToComputePayment();
        pack();
        setLocationRelativeTo(null);
    }

    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }

    private void switchToComputePayment() {
        computePayment = true;
        paymentButton.setVisible(false);
        monthsButton.setVisible(true);
        monthsTextField.setEditable(true);
        monthsTextField.setBackground(Color.WHITE);
        paymentTextField.setText("");
        paymentTextField.setEditable(false);
        paymentTextField.setBackground(lightYellow);
        computeButton.setText("Compute Monthly Payment");
    }

    private void switchToComputeMonths() {
        computePayment = false;
        paymentButton.setVisible(true);
        monthsButton.setVisible(false);
        monthsTextField.setText("");
        monthsTextField.setEditable(false);
        monthsTextField.setBackground(lightYellow);
        paymentTextField.setEditable(true);
        paymentTextField.setBackground(Color.WHITE);
        computeButton.setText("Compute Number of Payments");
    }

    private void computeLoan() {
        double balance, interest, payment;
        int months;
        double monthlyInterest, multiplier;

        balance = Double.parseDouble(balanceTextField.getText());
        interest = Double.parseDouble(interestTextField.getText());
        monthlyInterest = interest / 1200;

        if (computePayment) {
            months = Integer.parseInt(monthsTextField.getText());
            multiplier = Math.pow(1 + monthlyInterest, months);
            payment = balance * monthlyInterest * multiplier / (multiplier - 1);
            paymentTextField.setText(new DecimalFormat("0.00").format(payment));
        } else {
            payment = Double.parseDouble(paymentTextField.getText());
            months = (int) ((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) / Math.log(1 + monthlyInterest));
            monthsTextField.setText(String.valueOf(months));
        }

        analysisTextArea.setText("Loan Balance: $" + new DecimalFormat("0.00").format(balance) +
                                 "\nInterest Rate: " + new DecimalFormat("0.00").format(interest) + "%" +
                                 "\nNumber of Payments: " + months +
                                 "\nMonthly Payment: $" + new DecimalFormat("0.00").format(payment));

        computeButton.setEnabled(false);
        newLoanButton.setEnabled(true);
    }

    private void resetForm() {
        monthsTextField.setText("");
        paymentTextField.setText("");
        analysisTextArea.setText("");
        computeButton.setEnabled(true);
        newLoanButton.setEnabled(false);
    }
}