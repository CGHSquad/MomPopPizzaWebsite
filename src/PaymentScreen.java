import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class PaymentScreen extends DefaultCheckoutScreen{
    private JFrame frame;

    public void CreateWindow() {
        frame = new JFrame("Mom and Pops Pizzeria");

        JPanel header = new JPanel();
        header.setBackground(new Color(58, 34, 32));
        header.setPreferredSize(new Dimension(800, 100));
        header.setLayout(null);

        JPanel lwrSection = new JPanel(new GridBagLayout());
        lwrSection.setBackground(Color.WHITE);
        lwrSection.setPreferredSize(new Dimension(800, 400));
        lwrSection.setLayout(null);

        //Methods for homebutton, headlogo, menu button, and shop cart button for ease of access
        JLabel headLogo = MethodFactory.createLogoLabel("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/logo.png");
        JButton homeButton = MethodFactory.getHomeButton(frame);
        JButton menuButton = MethodFactory.getMenuButton(frame);
        JButton shopCartButton = MethodFactory.getShopCartButton();

        JButton backButton = getBackButton();

        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        header.add(menuButton);
        header.add(homeButton);
        header.add(shopCartButton);

        lwrSection.add(backButton);


        // Gray panel for items, add more items, and payment
        JPanel grayPanel = new JPanel();
        grayPanel.setBackground(Color.LIGHT_GRAY);
        grayPanel.setBounds(400, 0, 300, 320);
        grayPanel.setLayout(null);

        JLabel itemsLabel = new JLabel("Your Items");
        itemsLabel.setFont(new Font(null, Font.PLAIN, 16));
        itemsLabel.setForeground(new Color(58, 34, 32));
        itemsLabel.setBounds(110, 20, 100, 20);

        JButton placeOrderButton = getPlaceOrderButton();
        placeOrderButton.setBounds(70, 270, 180, 30);

        grayPanel.add(itemsLabel);
        grayPanel.add(placeOrderButton);

        // Text fields for payment details
        JLabel cardholderLabel = new JLabel("Cardholder Name:");
        JLabel billingAddressLabel = new JLabel("Billing Address:");
        JLabel creditCardLabel = new JLabel("Credit Card Number:");
        JLabel expirationLabel = new JLabel("Expiration Date:");
        JLabel cvvLabel = new JLabel("CVV:");

        JTextField cardholderField = new JTextField("Cardholder Name");
        JTextField billingAddressField = new JTextField("Billing Address");
        JTextField creditCardField = new JTextField("Credit Card Number");
        JTextField expirationField = new JTextField("Expiration Date");
        JTextField cvvField = new JTextField("CVV");

        cardholderLabel.setBounds(15, 50, 150, 40);
        billingAddressLabel.setBounds(15, 100, 150, 40);
        creditCardLabel.setBounds(15, 150, 150, 40);
        expirationLabel.setBounds(15, 200, 150, 40);
        cvvLabel.setBounds(15, 250, 150, 40);

        cardholderField.setBounds(175, 50, 200, 40);
        billingAddressField.setBounds(175, 100, 200, 40);
        creditCardField.setBounds(175, 150, 200, 40);
        expirationField.setBounds(175, 200, 200, 40);
        cvvField.setBounds(175, 250, 200, 40);

        // Add components to the lwrSection panel
        lwrSection.add(grayPanel);
        lwrSection.add(cardholderLabel);
        lwrSection.add(billingAddressLabel);
        lwrSection.add(creditCardLabel);
        lwrSection.add(expirationLabel);
        lwrSection.add(cvvLabel);
        lwrSection.add(cardholderField);
        lwrSection.add(billingAddressField);
        lwrSection.add(creditCardField);
        lwrSection.add(expirationField);
        lwrSection.add(cvvField);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo,backButton, homeButton, menuButton, shopCartButton));
    }

    private static JButton getPlaceOrderButton() {

        JButton placeOrderButton = new JButton("PLACE ORDER");
        placeOrderButton.setForeground(Color.WHITE);
        placeOrderButton.setBackground(new Color(58, 34, 32));
        placeOrderButton.setFocusPainted(false);
        placeOrderButton.setContentAreaFilled(true);
        placeOrderButton.setBorderPainted(false);
        placeOrderButton.setOpaque(true);

        ///guestButton.setBounds(450, 170, 200, 75);
        placeOrderButton.addActionListener(e -> {
            // Add your logic for handling shopCart button clicks here
            System.out.println("Submitted");
        });

        return placeOrderButton;
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
            DefaultCheckoutScreen dcs = new DefaultCheckoutScreen();
            dcs.CreateWindow();
        });

        return backButton;
    }

    private static class ResizeListener extends ComponentAdapter {
        private final JPanel header;
        private final JPanel lwrSection;
        private final JLabel headLogo;
        private final JButton backButton;
        private final JButton homeButton;
        private final JButton menuButton;

        private final JButton shopCartButton;

        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton backButton,
                       JButton homeButton, JButton menuButton, JButton shopCartButton) {
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
            MethodFactory.MenuHomeScreenFit(homeButton, frameWidth, frameHeight, logoX + headLogoWidth + 10, buttonY);
            MethodFactory.MenuHomeScreenFit(menuButton, frameWidth, frameHeight, logoX + headLogoWidth + 15 + homeButton.getWidth(), buttonY);

            MethodFactory.resizeAndSetBoundsForShopCartButton(shopCartButton, frameWidth, frameHeight);
            // Adjust button positions
            backButton.setBounds(15, 30, (frameWidth / 6), frameHeight / 9);
        }
    }
}
