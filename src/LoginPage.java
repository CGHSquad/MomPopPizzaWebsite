import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LoginPage {
    private JFrame frame;
    public void CreateWindow() {
        //panel for the brown header on top of the screen
        frame = new JFrame("Mom and Pops Pizzeria");

        JPanel header = new JPanel();
        header.setBackground(new Color(58, 34, 32));
        header.setPreferredSize(new Dimension(800, 100));
        header.setLayout(null);

        //panel for the white section of the screen
        JPanel lwrSection = new JPanel(new GridBagLayout());
        lwrSection.setBackground(Color.WHITE);
        lwrSection.setPreferredSize(new Dimension(800, 400));
        lwrSection.setLayout(null);


        //methods from another class
        JLabel headLogo = MethodFactory.createLogoLabel("src/CSEIcons/logo.png");
        JButton homeButton = MethodFactory.getHomeButton(frame);
        JButton menuButton = MethodFactory.getMenuButton(frame);
        JButton shopCartButton = MethodFactory.getShopCartButton(frame);

        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        header.add(shopCartButton);
        header.add(homeButton);
        header.add(menuButton);
        lwrSection.add(getLoginLabel());
        lwrSection.add(getForgotPassButton());
        lwrSection.add(signUpPassButton());
        lwrSection.setPreferredSize(new Dimension(800, 400));
        lwrSection.setLayout(null);
        JLabel label = new JLabel("Email:");
        label.setBounds(280,130,80,25);
        lwrSection.add(label);
        JTextField emailText = new JTextField(20);
        emailText.setBounds(280, 150,265,25);
        lwrSection.add(emailText);

        JLabel passlabel = new JLabel("Password:");
        passlabel.setBounds(280,180,80,25);
        lwrSection.add(passlabel);
        JPasswordField passText = new JPasswordField(20);
        passText.setBounds(280, 200,265,25);
        lwrSection.add(passText);




        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(380, 280, 70,25);
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(new Color(58, 34, 32));
        loginButton.setOpaque(true);
        loginButton.addActionListener(e -> {
            String email = emailText.getText();

            char[] password = passText.getPassword();

            if (authenticate(email, password)) {
                System.out.println("Login successfully");

            } else {
                System.out.println("Wrong email or pass");
            }
        });
        lwrSection.add(loginButton);
        lwrSection.add(getBackButton());


        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo, getBackButton(), homeButton, menuButton, shopCartButton));
        frame.setVisible(true);


    }

    private boolean authenticate(String email, char[] password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/user_credentials.txt"))) {
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

    private JButton getBackButton() {
        JButton backButton = new JButton("←Back");
        backButton.setBounds(20, 40, 100,35);
        backButton.setForeground(new Color(58, 34, 32));
        backButton.setBackground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setOpaque(true);
        backButton.addActionListener(e -> {
            this.frame.dispose();

            LoginScreen ls = new LoginScreen();
            ls.CreateWindow();

        });
        return backButton;
    }

    private JButton getForgotPassButton() {
        JButton forgotPassButton = new JButton("Forgot Password");
        forgotPassButton.setForeground(Color.BLUE);
        forgotPassButton.setBorderPainted(false);
        forgotPassButton.setBounds(410,230,150,25);
        forgotPassButton.addActionListener(e -> {
            this.frame.dispose();

            ResetPass rp = new ResetPass();
            rp.CreateWindow();

        });
        return forgotPassButton;
    }

    private JButton signUpPassButton() {
        JButton signUpButton = new JButton("Sign-up");
        signUpButton.setBorderPainted(false);
        signUpButton.setBounds(240,230,150,25);
        signUpButton.addActionListener(e -> {
            this.frame.dispose();

            SignUp su = new SignUp();
            su.CreateWindow();

        });
        return signUpButton;
    }


    private static JLabel getLoginLabel(){
        ImageIcon login = new ImageIcon("src/CSEIcons/Sign_in.png");
        JLabel var1 = new JLabel();
        var1.setIcon(login);
        var1.setBounds(250, 40, login.getIconWidth(),login.getIconHeight());
        return var1;
    }
    private static class ResizeListener extends ComponentAdapter {
        private final JPanel header;
        private final JPanel lwrSection;
        private final JLabel headLogo;

        private final JButton backButton;

        private final JButton homeButton;
        private final JButton menuButton;

        private final JButton shopCartButton;

        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton backButton, JButton homeButton, JButton menuButton, JButton shopCartButton) {
            this.header = header;
            this.lwrSection = lwrSection;
            this.headLogo = headLogo;
            this.backButton = backButton;
            this.homeButton = homeButton;
            this.menuButton = menuButton;
            this.shopCartButton = shopCartButton;
        }

        @Override
        public void componentResized(ComponentEvent e) {
            int frameWidth = e.getComponent().getWidth();
            int frameHeight = e.getComponent().getHeight();


            // Adjust header size
            header.setPreferredSize(new Dimension(frameWidth, frameHeight / 6));
            // Stretched icon for logo
            ImageIcon logo = new ImageIcon("src/CSEIcons/logo.png");
            int headLogoWidth = (int) (frameWidth / 3.5);
            int headLogoHeight = (int) (headLogoWidth * ((double) logo.getIconHeight() / logo.getIconWidth()));

            Image scaledHeadLogo = logo.getImage().getScaledInstance(headLogoWidth, headLogoHeight, Image.SCALE_SMOOTH);
            headLogo.setIcon(new ImageIcon(scaledHeadLogo));

            int logoX = 5;
            int logoY = 10;
            headLogo.setBounds(logoX, logoY, headLogoWidth, headLogoHeight);

            // Move buttons alongside the logo
            int buttonY = logoY + headLogoHeight / 2 - homeButton.getHeight() / 2;
            MethodFactory.MenuHomeScreenFit(homeButton, frameWidth, frameHeight, logoX + headLogoWidth + 10, buttonY);
            MethodFactory.MenuHomeScreenFit(menuButton, frameWidth, frameHeight, logoX + headLogoWidth + 15 + homeButton.getWidth(), buttonY);

            MethodFactory.resizeAndSetBoundsForShopCartButton(shopCartButton, frameWidth, frameHeight);


            // Adjust button positions
            backButton.setBounds(15, 30, (frameWidth / 6), frameHeight / 9);

            // Dynamically adjust font sizes based on frame height
        }
    }
}

