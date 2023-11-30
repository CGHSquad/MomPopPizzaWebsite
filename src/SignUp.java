import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SignUp {

    private static JTextField emailText;
    private static JPasswordField passText;

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
        lwrSection.add(getBackButton());
        lwrSection.setPreferredSize(new Dimension(800, 400));
        lwrSection.setLayout(null);

        JLabel title = new JLabel("CREATE YOUR ACCOUNT");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(230,10,400,95);
        lwrSection.add(title);

        JLabel label = new JLabel("First Name");
        label.setBounds(100,90,80,25);
        lwrSection.add(label);
        JTextField FNameText = new JTextField(20);
        FNameText.setBounds(90, 110,265,25);
        lwrSection.add(FNameText);

        JLabel label2 = new JLabel("Last Name");
        label2.setBounds(400,90,80,25);
        lwrSection.add(label2);
        JTextField LNameText = new JTextField(20);
        LNameText.setBounds(390, 110,265,25);
        lwrSection.add(LNameText);

        JLabel label3 = new JLabel("Email");
        label3.setBounds(100,150,80,25);
        lwrSection.add(label3);
        emailText = new JTextField(20);
        emailText.setBounds(90, 170,265,25);
        lwrSection.add(emailText);

        JLabel label4 = new JLabel("Phone Number");
        label4.setBounds(400,150,120,25);
        lwrSection.add(label4);
        JTextField phoneNumber = new JTextField(20);
        phoneNumber.setBounds(390, 170,265,25);
        lwrSection.add(phoneNumber);

        JLabel label5 = new JLabel("Password");
        label5.setBounds(100,210,80,25);
        lwrSection.add(label5);
        passText = new JPasswordField(20);
        passText.setBounds(90, 230,265,25);
        lwrSection.add(passText);
        lwrSection.add(getCreateYourAccountButton());


        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo, getBackButton(), homeButton, menuButton, shopCartButton));
        frame.setVisible(true);

    }

    private static void signUp() {
        // Get the entered email and password
        String email = emailText.getText();
        char[] passwordChars = passText.getPassword();
        String password = new String(passwordChars);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/user_credentials.txt", true))) {
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

            LoginPage lp = new LoginPage();
            lp.CreateWindow();
        });
        return backButton;
    }

    private static JButton getCreateYourAccountButton() {
        ImageIcon var0 = new ImageIcon("src/CSEIcons/createAccount.png");
        JButton var1 = new JButton();
        var1.setIcon(var0);
        var1.setFocusPainted(false);
        var1.setContentAreaFilled(false);
        var1.setBorderPainted(false);
        int var2 = var0.getIconWidth();
        int var3 = var0.getIconHeight();
        var1.setBounds(190, 280, var2 - 20, var3 - 20);
        var1.addActionListener((var0x) -> signUp());
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


