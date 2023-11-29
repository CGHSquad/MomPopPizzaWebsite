import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class CheckoutScreenDelivery extends DefaultCheckoutScreen {
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
        JButton shopCartButton = MethodFactory.getShopCartButton(frame);

        JButton backButton = getBackButton();

        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        header.add(menuButton);
        header.add(homeButton);
        header.add(shopCartButton);

        lwrSection.add(backButton);

        // Add checkout, pickup/delivered buttons, and delivery details
        JLabel checkoutLabel = new JLabel("Checkout");
        checkoutLabel.setFont(new Font(null, Font.PLAIN, 20));
        checkoutLabel.setForeground(new Color(58, 34, 32));
        checkoutLabel.setBounds(15, 100, 100, 20);

        JButton pickUpButton = getPickUpButton();
        pickUpButton.setBounds(15, 130, 100, 30);

        JButton deliveredButton = getDeliveredButton();
        deliveredButton.setBounds(130, 130, 100, 30);



        // Gray panel for items, add more items, and payment
        JPanel grayPanel = new JPanel();
        grayPanel.setBackground(Color.LIGHT_GRAY);
        grayPanel.setBounds(400, 0, 300, 320);
        grayPanel.setLayout(null);

        JLabel itemsLabel = new JLabel("Your Items");
        itemsLabel.setFont(new Font(null, Font.PLAIN, 16));
        itemsLabel.setForeground(new Color(58, 34, 32));
        itemsLabel.setBounds(110, 20, 100, 20);

        JButton addMoreItemsButton = getItemButton();
        JButton paymentButton = getPaymentButton();
        paymentButton.setBounds(60, 230, 180, 30);
        addMoreItemsButton.setBounds(60, 270, 180, 30);

        //Adding these inside the gray panel to adjust position
        grayPanel.add(itemsLabel);
        grayPanel.add(addMoreItemsButton);
        grayPanel.add(paymentButton);

        // Text fields for delivery details
        JLabel addressLabel = new JLabel("Address:");
        JLabel cityLabel = new JLabel("City:");
        JLabel zipCodeLabel = new JLabel("Zip Code:");

        addressLabel.setBounds(15, 180, 100, 20);
        cityLabel.setBounds(15, 210, 100, 20);
        zipCodeLabel.setBounds(15, 240, 100, 20);

        JTextField addressField = new JTextField("Delivery Address");
        JTextField cityField = new JTextField("City");
        JTextField zipCodeField = new JTextField("Zip Code");

        addressField.setBounds(115, 180, 200, 20);
        cityField.setBounds(115, 210, 200, 20);
        zipCodeField.setBounds(115, 240, 200, 20);

        // Add components to the lwrSection panel
        lwrSection.add(checkoutLabel);
        lwrSection.add(pickUpButton);
        lwrSection.add(deliveredButton);
        lwrSection.add(grayPanel);
        lwrSection.add(addressLabel);
        lwrSection.add(cityLabel);
        lwrSection.add(zipCodeLabel);
        lwrSection.add(addressField);
        lwrSection.add(cityField);
        lwrSection.add(zipCodeField);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo,backButton, homeButton, menuButton, shopCartButton));
    }

    private JButton getDeliveredButton() {

        JButton deliveredButton = new JButton("Delivery");
        deliveredButton.setForeground(new Color(58, 34, 32));

        deliveredButton.addActionListener(e -> {
            System.out.println("Delivery Screen");

        });

        return deliveredButton;
    }

    private JButton getPickUpButton() {

        JButton pickUpButton = new JButton("Pick Up");
        pickUpButton.setForeground(new Color(58, 34, 32));

        pickUpButton.addActionListener(e -> {
            this.frame.dispose();

            DefaultCheckoutScreen dcs = new DefaultCheckoutScreen();
            dcs.CreateWindow();

        });

        return pickUpButton;
    }

    private JButton getItemButton() {

        JButton addMoreItemsButton = new JButton("Add More Items");
        addMoreItemsButton.setForeground(Color.WHITE);
        addMoreItemsButton.setBackground(new Color(58, 34, 32));
        addMoreItemsButton.setFocusPainted(false);
        addMoreItemsButton.setContentAreaFilled(true);
        addMoreItemsButton.setBorderPainted(false);
        addMoreItemsButton.setOpaque(true);

        addMoreItemsButton.addActionListener(e -> {
            this.frame.dispose();

            Menu m = new Menu();
            m.CreateWindow();
        });

        return addMoreItemsButton;
    }
    private JButton getPaymentButton() {

        JButton paymentButton = new JButton("Payment");
        paymentButton.setForeground(Color.WHITE);
        paymentButton.setBackground(new Color(58, 34, 32));
        paymentButton.setFocusPainted(false);
        paymentButton.setContentAreaFilled(true);
        paymentButton.setBorderPainted(false);
        paymentButton.setOpaque(true);

        paymentButton.addActionListener(e -> {
            this.frame.dispose();

            PaymentScreen ps = new PaymentScreen();
            ps.CreateWindow();
        });

        return paymentButton;
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
            Menu m = new Menu();
            m.CreateWindow();
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
