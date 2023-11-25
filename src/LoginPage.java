import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage {
    public LoginPage() {
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
        var3.add(getLoginLabel());
        var3.add(getForgotPassButton());
        var3.add(signUpPassButton());
        var3.setPreferredSize(new Dimension(800, 400));
        var3.setLayout((LayoutManager)null);
        JLabel label = new JLabel("Email:");
        label.setBounds(280,130,80,25);
        var3.add(label);
        JTextField emailText = new JTextField(20);
        emailText.setBounds(280, 150,265,25);
        var3.add(emailText);

        JLabel passlabel = new JLabel("Password:");
        passlabel.setBounds(280,180,80,25);
        var3.add(passlabel);
        JPasswordField passText = new JPasswordField(20);
        passText.setBounds(280, 200,265,25);
        var3.add(passText);




        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(380, 280, 70,25);
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(new Color(58, 34, 32));
        loginButton.setOpaque(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailText.getText();

                char[] password = passText.getPassword();

                if (authenticate(email, password)) {
                    System.out.println("Login successfully");

                } else {
                    System.out.println("Wrong email or pass");
                }
            }
        });
        var3.add(loginButton);
        var3.add(getBackButton());


        var1.setSize(800, 500);
        var1.setDefaultCloseOperation(3);
        var1.setVisible(true);


    }

    private boolean authenticate(String email, char[] password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/bho4/Downloads/user_credentials.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                parts[0] = parts[0].replaceAll("([\\n\\r]+\\s*)*$", "");
                parts[1] = parts[1].replaceAll("([\\n\\r]+\\s*)*$", "");


                if (parts.length == 2 && parts[0].equals(email) && parts[1].equals(String.valueOf(password))) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
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

    private static JButton getForgotPassButton() {
        JButton forgotPassButton = new JButton("Forgot Password");
        forgotPassButton.setForeground(Color.BLUE);
        forgotPassButton.setBorderPainted(false);
        forgotPassButton.setBounds(410,230,150,25);
        forgotPassButton.addActionListener((var0x) -> {
            System.out.println("Forgot Pass button clicked");
        });
        return forgotPassButton;
    }

    private static JButton signUpPassButton() {
        JButton signUpButton = new JButton("Sign-up");
        signUpButton.setBorderPainted(false);
        signUpButton.setBounds(240,230,150,25);
        signUpButton.addActionListener((var0x) -> {
            System.out.println("Sign-up button clicked");
        });
        return signUpButton;
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

    private static JLabel getLoginLabel(){
        ImageIcon login = new ImageIcon("/Users/bho4/Downloads/Sign_in.png");
        JLabel var1 = new JLabel();
        var1.setIcon(login);
        var1.setBounds(250, 40, login.getIconWidth(),login.getIconHeight());
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

