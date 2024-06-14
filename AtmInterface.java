import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class AtmInterface {
    public static UserAccount User;

    public static void atmInterface() {
        User = new UserAccount(6000);

        // Creating frame for atm
        JFrame frame = new JFrame("ATM Machine");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        // frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null); // Use null layout for absolute positioning
        panel.setBackground(Color.blue);
        frame.add(panel);

        // Add a label with text
        JLabel textLabel = new JLabel("Welcome to the ATM!");
        textLabel.setFont(new Font("Arial ", Font.BOLD, 30));
        textLabel.setBounds(150, 100, 350, 55);
        textLabel.setForeground(Color.white);
        panel.add(textLabel);

        JLabel textLabel1 = new JLabel("Please Select Language!");
        textLabel1.setFont(new Font("Arial ", Font.BOLD, 25));
        textLabel1.setForeground(Color.WHITE);
        textLabel1.setBounds(160, 180, 380, 55);
        panel.add(textLabel1);

        // Add a button to submit the account number and PIN
        JButton submitButton1 = new JButton("English");
        submitButton1.setBounds(240, 250, 100, 30);
        submitButton1.setBackground(Color.cyan); // Set button background color
        submitButton1.setForeground(Color.BLACK); // Set button text color
        submitButton1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(submitButton1);

        // Add a button to submit the account number and PIN
        JButton submitButton2 = new JButton("Hindi");
        submitButton2.setBounds(240, 300, 100, 30);
        submitButton2.setBackground(Color.cyan); // Set button background color
        submitButton2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        submitButton2.setForeground(Color.BLACK); // Set button text color
        panel.add(submitButton2);

        submitButton1.addActionListener(e -> {
           English(User, panel);

        });

        submitButton2.addActionListener(e -> {
            Hindi(User, panel);
        });

        frame.setVisible(true);
    }

    public static void English(UserAccount User, JPanel panel){
         // Remove existing components from the panel
         panel.removeAll();
         panel.revalidate();
         panel.repaint();

         JLabel textLabel3 = new JLabel("Please Select One Option");
         textLabel3.setFont(new Font("Arial ", Font.BOLD, 25));
         textLabel3.setForeground(Color.WHITE);
         textLabel3.setBounds(140, 120, 380, 55);
         panel.add(textLabel3);

         JButton submitBtn1 = new JButton("DEPOSIT");
         submitBtn1.setBounds(220, 200, 150, 40);
         submitBtn1.setBackground(Color.cyan); // Set button background color
         submitBtn1.setForeground(Color.BLACK); // Set button text color
         submitBtn1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
         panel.add(submitBtn1);

         submitBtn1.addActionListener(el -> {
             panel.removeAll();
             panel.revalidate();
             panel.repaint();

             JLabel textLabel4 = new JLabel("Enter Amount:");
             textLabel4.setFont(new Font("Arial ", Font.BOLD, 25));
             textLabel4.setForeground(Color.WHITE);
             textLabel4.setBounds(220, 120, 380, 55);
             panel.add(textLabel4);

             // Add text field for PIN input
             JTextField amountField = new JTextField();
             amountField.setFont(new Font("Arial", Font.PLAIN, 20));
             amountField.setBounds(220, 220, 150, 55);
             panel.add(amountField);

             JButton confirmBtn1 = new JButton("CONFIRM");
             confirmBtn1.setBounds(400, 400, 150, 40);
             confirmBtn1.setBackground(Color.cyan); // Set button background color
             confirmBtn1.setForeground(Color.BLACK); // Set button text color
             confirmBtn1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
             panel.add(confirmBtn1);

             confirmBtn1.addActionListener(e1 -> {
                 panel.removeAll();
                 panel.revalidate();
                 panel.repaint();

                 String amount = amountField.getText();
                 int Amount = Integer.valueOf(amount);
                 User.deposit(Amount);

                 double newBalance = User.getBalance();

                 JLabel textLabel6 = new JLabel("AVAILABLE BALANCE:");
                 textLabel6.setFont(new Font("Arial ", Font.BOLD, 25));
                 textLabel6.setForeground(Color.WHITE);
                 textLabel6.setBounds(100, 160, 550, 35);
                 panel.add(textLabel6);

                 JLabel textLabel7 = new JLabel(String.valueOf(newBalance));
                 textLabel7.setFont(new Font("Arial ", Font.BOLD, 25));
                 textLabel7.setForeground(Color.WHITE);
                 textLabel7.setBounds(100, 200, 550, 35);
                 panel.add(textLabel7);

             });

         });

         JButton submitBtn2 = new JButton("WITHDRAWL");
         submitBtn2.setBounds(220, 280, 150, 40);
         submitBtn2.setBackground(Color.cyan); // Set button background color
         submitBtn2.setForeground(Color.BLACK); // Set button text color
         submitBtn2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
         panel.add(submitBtn2);

         submitBtn2.addActionListener(el -> {
             panel.removeAll();
             panel.revalidate();
             panel.repaint();

             JLabel textLabel4 = new JLabel("Enter Amount:");
             textLabel4.setFont(new Font("Arial ", Font.BOLD, 25));
             textLabel4.setForeground(Color.WHITE);
             textLabel4.setBounds(220, 120, 380, 55);
             panel.add(textLabel4);

             JLabel textLabel5 = new JLabel("(Cash Available 200, 100, 500, 2000)");
             textLabel5.setFont(new Font("Arial ", Font.BOLD, 25));
             textLabel5.setForeground(Color.WHITE);
             textLabel5.setBounds(100, 160, 550, 35);
             panel.add(textLabel5);

             // Add text field for PIN input
             JTextField amountField = new JTextField();
             amountField.setFont(new Font("Arial", Font.PLAIN, 20));
             amountField.setBounds(220, 220, 150, 55);
             panel.add(amountField);

             JButton confirmBtn1 = new JButton("CONFIRM");
             confirmBtn1.setBounds(400, 400, 150, 40);
             confirmBtn1.setBackground(Color.cyan); // Set button background color
             confirmBtn1.setForeground(Color.BLACK); // Set button text color
             confirmBtn1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
             panel.add(confirmBtn1);

             confirmBtn1.addActionListener(e1 -> {
                 panel.removeAll();
                 panel.revalidate();
                 panel.repaint();

                 String amount = amountField.getText();
                 double Amount = Integer.valueOf(amount);

                 if (Amount <= User.getBalance()) {
                     User.withdraw(Amount);

                     double newBalance = User.getBalance();

                     JLabel textLabel6 = new JLabel("AVAILABLE BALANCE:");
                     textLabel6.setFont(new Font("Arial ", Font.BOLD, 25));
                     textLabel6.setForeground(Color.WHITE);
                     textLabel6.setBounds(100, 160, 550, 35);
                     panel.add(textLabel6);

                     JLabel textLabel7 = new JLabel(String.valueOf(newBalance));
                     textLabel7.setFont(new Font("Arial ", Font.BOLD, 25));
                     textLabel7.setForeground(Color.WHITE);
                     textLabel7.setBounds(100, 200, 550, 35);
                     panel.add(textLabel7);

                 } else {
                     JLabel textLabel7 = new JLabel(String.valueOf("Insufficient Balance"));
                     textLabel7.setFont(new Font("Arial ", Font.BOLD, 25));
                     textLabel7.setForeground(Color.WHITE);
                     textLabel7.setBounds(100, 200, 550, 35);
                     panel.add(textLabel7);

                 }

             });

         });

         JButton submitBtn3 = new JButton("BALANCE ENQUIRY");
         submitBtn3.setBounds(220, 360, 150, 40);
         submitBtn3.setBackground(Color.cyan); // Set button background color
         submitBtn3.setForeground(Color.BLACK); // Set button text color
         submitBtn3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
         panel.add(submitBtn3);

         submitBtn3.addActionListener(e2 -> {
             panel.removeAll();
             panel.revalidate();
             panel.repaint();

             JLabel textLabel6 = new JLabel("AVAILABLE BALANCE:");
             textLabel6.setFont(new Font("Arial ", Font.BOLD, 25));
             textLabel6.setForeground(Color.WHITE);
             textLabel6.setBounds(100, 160, 550, 35);
             panel.add(textLabel6);

             JLabel textLabel7 = new JLabel(String.valueOf(User.getBalance()));
             textLabel7.setFont(new Font("Arial ", Font.BOLD, 25));
             textLabel7.setForeground(Color.WHITE);
             textLabel7.setBounds(100, 200, 550, 35);
             panel.add(textLabel7);

         });

    }

    public static void Hindi(UserAccount User, JPanel panel) {

         // Remove existing components from the panel
         panel.removeAll();
         panel.revalidate();
         panel.repaint();

         JLabel textLabel3 = new JLabel("कृपया एक विकल्प चुनें |");
         textLabel3.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
         // textLabel3.setFont(new Font("Arial ", Font., 25));
         textLabel3.setForeground(Color.WHITE);
         textLabel3.setBounds(180, 120, 380, 55);
         panel.add(textLabel3);

         JButton submitBtn1 = new JButton("जमा");
         submitBtn1.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
         submitBtn1.setBounds(220, 200, 150, 40);
         submitBtn1.setBackground(Color.cyan); // Set button background color
         submitBtn1.setForeground(Color.BLACK); // Set button text color
         submitBtn1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
         panel.add(submitBtn1);

         submitBtn1.addActionListener(el -> {
             panel.removeAll();
             panel.revalidate();
             panel.repaint();

             JLabel textLabel4 = new JLabel("राशि डालें");
             textLabel4.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
             textLabel4.setForeground(Color.WHITE);
             textLabel4.setBounds(220, 120, 380, 55);
             panel.add(textLabel4);

             // Add text field for PIN input
             JTextField amountField = new JTextField();
             amountField.setFont(new Font("Arial", Font.PLAIN, 20));
             amountField.setBounds(220, 220, 150, 55);
             panel.add(amountField);

             JButton confirmBtn1 = new JButton("पुष्टि करें");
             confirmBtn1.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
             confirmBtn1.setBounds(400, 400, 150, 40);
             confirmBtn1.setBackground(Color.cyan); // Set button background color
             confirmBtn1.setForeground(Color.BLACK); // Set button text color
             confirmBtn1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
             panel.add(confirmBtn1);

             confirmBtn1.addActionListener(e1 -> {
                 panel.removeAll();
                 panel.revalidate();
                 panel.repaint();

                 String amount = amountField.getText();
                 int Amount = Integer.valueOf(amount);
                 User.deposit(Amount);

                 double newBalance = User.getBalance();

                 JLabel textLabel6 = new JLabel("शेष राशि:");
                 textLabel6.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
                 textLabel6.setForeground(Color.WHITE);
                 textLabel6.setBounds(100, 160, 550, 35);
                 panel.add(textLabel6);

                 JLabel textLabel7 = new JLabel(String.valueOf(newBalance));
                 textLabel7.setFont(new Font("Arial ", Font.BOLD, 25));
                 textLabel7.setForeground(Color.WHITE);
                 textLabel7.setBounds(100, 200, 550, 35);
                 panel.add(textLabel7);

             });

         });

         JButton submitBtn2 = new JButton("निकासी");
         submitBtn2.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
         submitBtn2.setBounds(220, 280, 150, 40);
         submitBtn2.setBackground(Color.cyan); // Set button background color
         submitBtn2.setForeground(Color.BLACK); // Set button text color
         submitBtn2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
         panel.add(submitBtn2);

         submitBtn2.addActionListener(el -> {
             panel.removeAll();
             panel.revalidate();
             panel.repaint();

             JLabel textLabel4 = new JLabel("राशि डालें:");
             textLabel4.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
             textLabel4.setForeground(Color.WHITE);
             textLabel4.setBounds(220, 120, 380, 55);
             panel.add(textLabel4);

             JLabel textLabel5 = new JLabel("(नकद उपलब्ध 200, 100, 500, 2000)");
             textLabel5.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
             textLabel5.setForeground(Color.WHITE);
             textLabel5.setBounds(100, 160, 550, 35);
             panel.add(textLabel5);

             // Add text field for PIN input
             JTextField amountField = new JTextField();
             amountField.setFont(new Font("Arial", Font.PLAIN, 20));
             amountField.setBounds(220, 220, 150, 55);
             panel.add(amountField);

             JButton confirmBtn1 = new JButton("पुष्टि करें");
             confirmBtn1.setBounds(400, 400, 150, 40);
             confirmBtn1.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
             confirmBtn1.setBackground(Color.cyan); // Set button background color
             confirmBtn1.setForeground(Color.BLACK); // Set button text color
             confirmBtn1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
             panel.add(confirmBtn1);

             confirmBtn1.addActionListener(e1 -> {
                 panel.removeAll();
                 panel.revalidate();
                 panel.repaint();

                 String amount = amountField.getText();
                 double Amount = Integer.valueOf(amount);

                 if (Amount <= User.getBalance()) {
                     User.withdraw(Amount);

                     double newBalance = User.getBalance();
                     JLabel textLabel6 = new JLabel("शेष राशि:");
                     textLabel6.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
                     textLabel6.setForeground(Color.WHITE);
                     textLabel6.setBounds(100, 160, 550, 35);
                     panel.add(textLabel6);

                     JLabel textLabel7 = new JLabel(String.valueOf(newBalance));
                     textLabel7.setFont(new Font("Arial", Font.PLAIN, 20));
                     textLabel7.setForeground(Color.WHITE);
                     textLabel7.setBounds(100, 200, 550, 35);
                     panel.add(textLabel7);

                 } else {
                     JLabel textLabel7 = new JLabel(String.valueOf("अपर्याप्त शेषराशि"));
                     textLabel7.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
                     textLabel7.setForeground(Color.WHITE);
                     textLabel7.setBounds(100, 200, 550, 35);
                     panel.add(textLabel7);

                 }

             });

         });


         JButton submitBtn3 = new JButton("बैलेंस पूछताछ");
         submitBtn3.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
         submitBtn3.setBounds(220, 360, 150, 40);
         submitBtn3.setBackground(Color.cyan); // Set button background color
         submitBtn3.setForeground(Color.BLACK); // Set button text color
         submitBtn3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
         panel.add(submitBtn3);

         submitBtn3.addActionListener(e2 -> {
             panel.removeAll();
             panel.revalidate();
             panel.repaint();

             JLabel textLabel6 = new JLabel("शेष राशि:");
             textLabel6.setFont(new Font("Tiro Devanagari Hindi", Font.PLAIN, 25));
             textLabel6.setForeground(Color.WHITE);
             textLabel6.setBounds(100, 160, 550, 35);
             panel.add(textLabel6);

             JLabel textLabel7 = new JLabel(String.valueOf(User.getBalance()));
             textLabel7.setFont(new Font("Arial", Font.PLAIN, 20));
             textLabel7.setForeground(Color.WHITE);
             textLabel7.setBounds(100, 200, 550, 35);
             panel.add(textLabel7);

         });

        

    }

    public static void main(String[] args) {
        atmInterface();
    }

}

class UserAccount {

    double Balance;

    public UserAccount(double amount) {
        this.Balance = amount;
    }

    public double getBalance() {
        return Balance;
    }

    public void deposit(double amount) {
        this.Balance += amount;
    }

    public void withdraw(double amount) {
        this.Balance -= amount;
    }

}
