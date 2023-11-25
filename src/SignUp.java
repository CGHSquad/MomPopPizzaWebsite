import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp {

    private static JTextField emailText;
    private static JPasswordField passText;
    public SignUp() {
    }

    public void CreateWindow() {
        JFrame var1 = new JFrame("Mom and Pops Pizzeria");
        JPanel var2 = new JPanel();
        var2.setBackground(new Color(58, 34, 32));
        var2.setPreferredSize(new Dimension(800, 100));
        var2.setLayout((LayoutManager)null);
        JPanel var3 = new JPanel(new GridBagLayout());
        var3.setBackground(Color.WHITE);
        var3.setPreferredSize(new Dimension(800, 400));
        var3.setLayout((LayoutManager)null);



        var1.add(var2, "North");
        var1.add(var3, "South");
        var2.add(getjLabel());
        var2.add(getShopCartButton());
        var2.add(getHomeLogo());
        var2.add(getMenuButton());
        var3.add(getBackButton());
        var3.setPreferredSize(new Dimension(800, 400));
        var3.setLayout((LayoutManager)null);

        JLabel title = new JLabel("CREATE YOUR ACCOUNT");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(230,10,400,95);
        var3.add(title);

        JLabel label = new JLabel("First Name");
        label.setBounds(100,90,80,25);
        var3.add(label);
        JTextField FNameText = new JTextField(20);
        FNameText.setBounds(90, 110,265,25);
        var3.add(FNameText);

        JLabel label2 = new JLabel("Last Name");
        label2.setBounds(400,90,80,25);
        var3.add(label2);
        JTextField LNameText = new JTextField(20);
        LNameText.setBounds(390, 110,265,25);
        var3.add(LNameText);

        JLabel label3 = new JLabel("Email");
        label3.setBounds(100,150,80,25);
        var3.add(label3);
        emailText = new JTextField(20);
        emailText.setBounds(90, 170,265,25);
        var3.add(emailText);

        JLabel label4 = new JLabel("Phone Number");
        label4.setBounds(400,150,120,25);
        var3.add(label4);
        JTextField phoneNumber = new JTextField(20);
        phoneNumber.setBounds(390, 170,265,25);
        var3.add(phoneNumber);

        JLabel label5 = new JLabel("Password");
        label5.setBounds(100,210,80,25);
        var3.add(label5);
        passText = new JPasswordField(20);
        passText.setBounds(90, 230,265,25);
        var3.add(passText);
        var3.add(getCreateYourAccountButton());


        var1.setSize(800, 500);
        var1.setDefaultCloseOperation(3);
        var1.setVisible(true);

    }

    private static void signUp() {
        // Get the entered email and password
        String email = emailText.getText();
        char[] passwordChars = passText.getPassword();
        String password = new String(passwordChars);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/bho4/Downloads/user_credentials.txt", true))) {
            writer.write(email + "," + password);
            writer.newLine();
            writer.flush();
            System.out.println("sign up successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("error");
        }

        // Clear the fields after signing up
        emailText.setText("");
        passText.setText("");
    }

    private static JButton getBackButton() {
        JButton backButton = new JButton("←Back");
        backButton.setBounds(20, 40, 100,35);
        backButton.setForeground(new Color(58, 34, 32));
        backButton.setBackground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setOpaque(true);
        backButton.addActionListener((var0x) -> {
            System.out.println("Back button clicked");
        });
        return backButton;
    }

    private static JButton getHomeLogo() {
        ImageIcon var0 = new ImageIcon("/Users/bho4/Downloads/HomeLogo.png");
        JButton var1 = new JButton();
        var1.setIcon(var0);
        var1.setFocusPainted(false);
        var1.setContentAreaFilled(false);
        var1.setBorderPainted(false);
        int var2 = var0.getIconWidth();
        int var3 = var0.getIconHeight();
        var1.setBounds(250, 40, var2, var3);
        var1.addActionListener((var0x) -> {
            System.out.println("Home logo clicked");
        });
        return var1;
    }

    private static JButton getMenuButton() {
        JButton var1 = new JButton("Menu");
        var1.setFocusPainted(false);
        var1.setContentAreaFilled(false);
        var1.setBorderPainted(false);
        var1.setForeground(Color.WHITE);
        var1.setBounds(280, 5, 80, 105);
        var1.addActionListener((var0x) -> {
            System.out.println("Menu button clicked");
        });
        return var1;
    }


    private static JButton getCreateYourAccountButton() {
        ImageIcon var0 = new ImageIcon("/Users/bho4/Downloads/createAccount.png");
        JButton var1 = new JButton();
        var1.setIcon(var0);
        var1.setFocusPainted(false);
        var1.setContentAreaFilled(false);
        var1.setBorderPainted(false);
        int var2 = var0.getIconWidth();
        int var3 = var0.getIconHeight();
        var1.setBounds(260, 280, var2 - 30, var3 - 30);
        var1.addActionListener((var0x) -> {
            signUp();
        });
        return var1;
    }

    private static JButton getShopCartButton() {
        ImageIcon var0 = new ImageIcon("/Users/bho4/Downloads/ShoppingCart.png");
        JButton var1 = new JButton();
        var1.setIcon(var0);
        var1.setFocusPainted(false);
        var1.setContentAreaFilled(false);
        var1.setBorderPainted(false);
        int var2 = var0.getIconWidth();
        int var3 = var0.getIconHeight();
        var1.setBounds(700, 25, var2, var3);
        var1.addActionListener((var0x) -> {
            System.out.println("ShopCart button clicked");
        });
        return var1;
    }



    private static JLabel getjLabel() {
        ImageIcon var0 = new ImageIcon("/Users/bho4/Downloads/logo.png");
        JLabel var1 = new JLabel();
        var1.setIcon(var0);
        int var2 = var0.getIconWidth();
        int var3 = var0.getIconHeight();
        var1.setBounds(0, 18, var2, var3);
        return var1;
    }
}


