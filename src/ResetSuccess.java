import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ResetSuccess {

    private JFrame frame;

    public void CreateWindow() {
        frame = new JFrame("Forgot Password Screen 2");

        JPanel header = new JPanel();
        header.setBackground(new Color(58, 34, 32));
        header.setPreferredSize(new Dimension(800, 100));
        header.setLayout(null);

        JPanel lwrSection = new JPanel(new GridBagLayout());
        lwrSection.setBackground(Color.WHITE);
        lwrSection.setPreferredSize(new Dimension(800, 400));
        lwrSection.setLayout(null);

        JLabel headLogo = getjLabel();
        JTextArea success = getSuccess();
        JTextArea codeMessage = getCodeMessage();
        JTextField code = getCode();
        JLabel enterCode = getEnterCode();
        JButton backButton = getBackButton();
        JButton submitButton = getSubmitButton();
        JButton homeButton = getHomeButton();
        JButton menuButton = getMenuButton();

        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        header.add(menuButton);
        header.add(homeButton);
        lwrSection.add(success);
        lwrSection.add(backButton);
        lwrSection.add(codeMessage);
        lwrSection.add(enterCode);
        lwrSection.add(code);
        lwrSection.add(submitButton);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo, submitButton, success, codeMessage, enterCode, code, backButton, homeButton, menuButton));
        frame.setVisible(true);
    }
    private JButton getHomeButton() {
        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font(null, Font.PLAIN, 14));
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(new Color(58, 34, 32));
        homeButton.setFocusPainted(false);
        homeButton.setContentAreaFilled(true);
        homeButton.setBorderPainted(false);
        homeButton.setOpaque(true);
        // Add your action listener for the home button here
        return homeButton;
    }

    private JButton getMenuButton() {
        JButton menuButton = new JButton("Menu");
        menuButton.setFont(new Font(null, Font.PLAIN, 14));
        menuButton.setForeground(Color.WHITE);
        menuButton.setBackground(new Color(58, 34, 32));
        menuButton.setFocusPainted(false);
        menuButton.setContentAreaFilled(true);
        menuButton.setBorderPainted(false);
        menuButton.setOpaque(true);
        // Add your action listener for the menu button here
        return menuButton;
    }

    private static JLabel getjLabel() {
        ImageIcon logo = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/logo.png");

        // Create a JLabel for the logo
        JLabel headLogo = new JLabel();
        headLogo.setIcon(logo);

        // Get the dimensions of the image
        int widthLogo = logo.getIconWidth();
        int heightLogo = logo.getIconHeight();

        // Set the bounds of the label to the actual size of the image
        headLogo.setBounds(0, 5, widthLogo, heightLogo);

        return headLogo;
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

            // Add your logic for handling shopCart button clicks here
            FrontEnd fe = new FrontEnd();
            fe.CreateWindow();
        });

        return backButton;
    }

    private static JTextArea getSuccess() {
        JTextArea success = new JTextArea();
        success.setEditable(false);
        success.setOpaque(false);
        success.setLineWrap(true);
        success.setWrapStyleWord(true);
        success.setFont(new Font(null, Font.PLAIN, 50));
        success.setForeground(new Color(58, 34, 32));
        success.append("Success!");

        return success;
    }

    private static JTextArea getCodeMessage() {
        JTextArea codeMessage = new JTextArea();
        codeMessage.setEditable(false);
        codeMessage.setOpaque(false);
        codeMessage.setLineWrap(true);
        codeMessage.setWrapStyleWord(true);
        codeMessage.setFont(new Font(null, Font.PLAIN, 30));
        codeMessage.setForeground(Color.DARK_GRAY);
        codeMessage.append("A code has been sent to your e-mail");

        return codeMessage;
    }

    private static JTextField getCode() {
        JTextField code = new JTextField();
        code.setFont(new Font(null, Font.PLAIN, 15));
        return code;
    }

    private static JLabel getEnterCode() {
        JLabel enterCode = new JLabel("Please enter the code:");
        enterCode.setFont(new Font(null, Font.PLAIN, 30));
        enterCode.setForeground(Color.DARK_GRAY);
        return enterCode;
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
        private final JTextArea success;
        private final JTextArea codeMessage;
        private final JLabel enterCode;
        private final JTextField code;
        private final JButton backButton;
        private final JButton homeButton;
        private final JButton menuButton;

        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton submitButton, JTextArea success,
                       JTextArea codeMessage, JLabel enterCode, JTextField code, JButton backButton,
                       JButton homeButton, JButton menuButton) {
            this.header = header;
            this.lwrSection = lwrSection;
            this.headLogo = headLogo;
            this.submitButton = submitButton;
            this.success = success;
            this.codeMessage = codeMessage;
            this.enterCode = enterCode;
            this.code = code;
            this.backButton = backButton;
            this.homeButton = homeButton;
            this.menuButton = menuButton;
        }

        @Override
        public void componentResized(ComponentEvent e) {
            int frameWidth = e.getComponent().getWidth();
            int frameHeight = e.getComponent().getHeight();


            // Adjust header size
            header.setPreferredSize(new Dimension(frameWidth, frameHeight / 6));
            homeButton.setBounds(250, (frameHeight / 22), (frameWidth / 8), frameHeight / 12);
            menuButton.setBounds(230 + (frameWidth / 8) + 5, (frameHeight / 22), (frameWidth / 8), frameHeight / 12);
            // Stretched icon for logo
            ImageIcon logo = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/logo.png");
            int headLogoWidth = (int) (frameWidth / 3.5);
            int headLogoHeight = (int) (headLogoWidth * ((double) logo.getIconHeight() / logo.getIconWidth()));

            Image scaledHeadLogo = logo.getImage().getScaledInstance(headLogoWidth, headLogoHeight, Image.SCALE_SMOOTH);
            headLogo.setIcon(new ImageIcon(scaledHeadLogo));

            int logoX = 5;
            int logoY = 10;
            headLogo.setBounds(logoX, logoY, headLogoWidth, headLogoHeight);

            // Move buttons alongside the logo
            int buttonY = logoY + headLogoHeight / 2 - homeButton.getHeight() / 2;
            homeButton.setBounds(logoX + headLogoWidth + 10, buttonY, (frameWidth / 8), frameHeight / 12);
            menuButton.setBounds(logoX + headLogoWidth + 15 + homeButton.getWidth(), buttonY, (frameWidth / 8), frameHeight / 12);

            // Adjust button positions
            success.setBounds((int) (2 * frameWidth / 9), (frameHeight / 8), (int) (frameWidth / 1.8), frameHeight / 7);
            codeMessage.setBounds((int) (2 * frameWidth / 9), (frameHeight / 4), (int) (frameWidth / 1.2), frameHeight / 7);
            enterCode.setBounds((int) (2 * frameWidth / 9), (frameHeight / 3) - 5, (int) (frameWidth / 2), 50);
            code.setBounds((int) (2 * frameWidth / 9), (int) (frameHeight / 2.5), (int) (frameWidth / 2), frameHeight / 10);
            backButton.setBounds(15, 30, (frameWidth / 6), frameHeight / 9);
            submitButton.setBounds((int) (3.5*frameWidth / 9), (frameHeight / 2) + 20, (int) (frameWidth / 7), frameHeight / 12);

            // Dynamically adjust font sizes based on frame height
            float fontSizeHome = Math.max(15, frameHeight / 28f);
            float fontSizeMenu = Math.max(15, frameHeight / 28f);
            float fontSizeSuccess = Math.max(15, frameHeight / 10f);
            float fontSizeCodeMessage = Math.max(10, frameHeight / 20f);
            float fontSizeEnterCode = Math.max(12, frameHeight / 20f);
            float fontSizeCode = Math.max(12, frameHeight / 15f);
            float fontSizeSubmitButton = Math.max(12, frameHeight / 35f);

            // Set new font sizes
            homeButton.setFont(new Font(null, Font.PLAIN, (int) fontSizeHome));
            menuButton.setFont(new Font(null, Font.PLAIN, (int) fontSizeMenu));
            success.setFont(new Font(null, Font.PLAIN, (int) fontSizeSuccess));
            codeMessage.setFont(new Font(null, Font.PLAIN, (int) fontSizeCodeMessage));
            enterCode.setFont(new Font(null, Font.PLAIN, (int) fontSizeEnterCode));
            code.setFont(new Font(null, Font.PLAIN, (int) fontSizeCode));
            submitButton.setFont(new Font(null, Font.PLAIN, (int) fontSizeSubmitButton));
        }
    }
}
