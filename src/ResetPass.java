import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ResetPass {

    private JFrame frame;

    public void CreateWindow() {
        frame = new JFrame("Forgot Password Screen");

        JPanel header = new JPanel();
        header.setBackground(new Color(58, 34, 32));
        header.setPreferredSize(new Dimension(800, 100));
        header.setLayout(null);

        JPanel lwrSection = new JPanel(new GridBagLayout());
        lwrSection.setBackground(Color.WHITE);
        lwrSection.setPreferredSize(new Dimension(800, 400));
        lwrSection.setLayout(null);

        JLabel headLogo = MethodFactory.createLogoLabel("src/CSEIcons/logo.png");
        JTextArea resetPass = getResetPassword();
        JTextArea emailMessage = getEmailMessage();
        JTextField email = getEmail();
        JLabel emailLabel = getEmailLabel();
        JButton backButton = getBackButton();
        JButton submitButton = getSubmitButton();
        JButton homeButton = MethodFactory.getHomeButton(frame);
        JButton menuButton = MethodFactory.getMenuButton(frame);
        JButton shopCartButton = MethodFactory.getShopCartButton(frame);

        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        header.add(shopCartButton);
        header.add(menuButton);
        header.add(homeButton);
        lwrSection.add(resetPass);
        lwrSection.add(backButton);
        lwrSection.add(emailMessage);
        lwrSection.add(emailLabel);
        lwrSection.add(email);
        lwrSection.add(submitButton);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo, submitButton, resetPass, emailMessage, emailLabel, email, backButton, homeButton, menuButton, shopCartButton));
        frame.setVisible(true);
    }

    private JButton getBackButton(){

        JButton backButton = new JButton();
        backButton.setText("← Back");
        backButton.setFont(new Font(null, Font.PLAIN, 20));
        backButton.setForeground(new Color(58, 34, 32));

        backButton.setBackground(Color.white);

        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(true);
        backButton.setBorderPainted(false);
        backButton.setOpaque(true);

        backButton.addActionListener(e -> {
            this.frame.dispose();

            LoginPage lp = new LoginPage();
            lp.CreateWindow();
        });

        return backButton;
    }

    private static JTextArea getResetPassword() {
        JTextArea resetPassword = new JTextArea();
        resetPassword.setEditable(false);
        resetPassword.setOpaque(false);
        resetPassword.setLineWrap(true);
        resetPassword.setWrapStyleWord(true);
        resetPassword.setFont(new Font(null, Font.PLAIN, 50));
        resetPassword.setForeground(new Color(58, 34, 32));
        resetPassword.append("Reset Password");

        return resetPassword;
    }

    private static JTextArea getEmailMessage() {
        JTextArea emailMessage = new JTextArea();
        emailMessage.setEditable(false);
        emailMessage.setOpaque(false);
        emailMessage.setLineWrap(true);
        emailMessage.setWrapStyleWord(true);
        emailMessage.setFont(new Font(null, Font.PLAIN, 30));
        emailMessage.setForeground(Color.DARK_GRAY);
        emailMessage.append("Enter the email associated with your account");

        return emailMessage;
    }

    private static JTextField getEmail() {
        JTextField email = new JTextField();
        email.setFont(new Font(null, Font.PLAIN, 15));
        return email;
    }

    private static JLabel getEmailLabel() {
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font(null, Font.PLAIN, 20));
        return emailLabel;
    }

    private static JButton getSubmitButton() {

        JButton submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setFont(new Font(null, Font.PLAIN, 20));
        // Set the background color to brown using RGB (58, 34, 32)
        submitButton.setBackground(new Color(58, 34, 32));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 20, true));

        submitButton.setFocusPainted(false);
        submitButton.setContentAreaFilled(true);
        submitButton.setBorderPainted(false);
        submitButton.setOpaque(true);

        ///guestButton.setBounds(450, 170, 200, 75);
        submitButton.addActionListener(e -> {
            // Add your logic for handling shopCart button clicks here
            System.out.println("Submitted");
        });

        return submitButton;
    }

    private static class ResizeListener extends ComponentAdapter {
        private final JPanel header;
        private final JPanel lwrSection;
        private final JLabel headLogo;
        private final JButton submitButton;
        private final JTextArea resetPass;
        private final JTextArea emailMessage;
        private final JLabel emailLabel;
        private final JTextField email;
        private final JButton backButton;

        private final JButton homeButton;
        private final JButton menuButton;

        private final JButton shopCartButton;

        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton submitButton, JTextArea resetPass, JTextArea emailMessage, JLabel emailLabel, JTextField email, JButton backButton, JButton homeButton, JButton menuButton, JButton shopCartButton) {
            this.header = header;
            this.lwrSection = lwrSection;
            this.headLogo = headLogo;
            this.submitButton = submitButton;
            this.resetPass = resetPass;
            this.emailMessage = emailMessage;
            this.emailLabel = emailLabel;
            this.email = email;
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
            resetPass.setBounds((int) (2 * frameWidth / 9), (frameHeight / 8), (int) (frameWidth / 1.8), frameHeight / 7);
            emailMessage.setBounds((int) (2 * frameWidth / 9), (frameHeight / 4), (int) (frameWidth / 1.2), frameHeight / 7);
            emailLabel.setBounds((int) (2 * frameWidth / 9), (frameHeight / 3) - 10, (int) (frameWidth / 2), 30);
            email.setBounds((int) (2 * frameWidth / 9), (int) (frameHeight / 2.5), (int) (frameWidth / 2), frameHeight / 10);
            backButton.setBounds(15, 30, (frameWidth / 6), frameHeight / 9);
            submitButton.setBounds((int) (2*frameWidth / 9), (frameHeight / 2) + 20, (int) (frameWidth / 7), frameHeight / 12);

            // Dynamically adjust font sizes based on frame height
            float fontSizeResetPass = Math.max(15, frameHeight / 10f);
            float fontSizeEmailMessage = Math.max(10, frameHeight / 20f);
            float fontSizeEmailLabel = Math.max(12, frameHeight / 30f);
            float fontSizeEmail = Math.max(12, frameHeight / 15f);
            float fontSizeSubmitButton = Math.max(12, frameHeight / 35f);

            // Set new font sizes
            resetPass.setFont(new Font(null, Font.PLAIN, (int) fontSizeResetPass));
            emailMessage.setFont(new Font(null, Font.PLAIN, (int) fontSizeEmailMessage));
            emailLabel.setFont(new Font(null, Font.PLAIN, (int) fontSizeEmailLabel));
            email.setFont(new Font(null, Font.PLAIN, (int) fontSizeEmail));
            submitButton.setFont(new Font(null, Font.PLAIN, (int) fontSizeSubmitButton));
        }
    }
}
