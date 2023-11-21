import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LoginScreen {

    private JFrame frame;
    public void CreateWindow() {
        frame = new JFrame("Login Screen");

        JPanel header = new JPanel();
        header.setBackground(new Color(58, 34, 32));
        header.setPreferredSize(new Dimension(800, 100));
        header.setLayout(null);

        JPanel lwrSection = new JPanel(new GridBagLayout());
        lwrSection.setBackground(Color.WHITE);
        lwrSection.setPreferredSize(new Dimension(800, 400));
        lwrSection.setLayout(null);

        JLabel headLogo = getjLabel();
        JButton customerButton = getCustomerButton();
        JButton employeeButton = getEmployeeButton();
        JLabel sloganButton = getSlogan();
        JButton backButton = getBackButton();

        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        lwrSection.add(customerButton);
        lwrSection.add(employeeButton);
        lwrSection.add(sloganButton);
        lwrSection.add(backButton);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo, customerButton, employeeButton, sloganButton, backButton));
        frame.setVisible(true);

    }


    // Function to create and configure the JLabel with the logo
    private static JLabel getjLabel() {
        // Load images for the logo
        ImageIcon logo = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/logo.png");

        // Create a JLabel for the logo
        JLabel headLogo = new JLabel();
        headLogo.setIcon(logo);

        // Get the dimensions of the image
        int widthLogo = logo.getIconWidth();
        int heightLogo = logo.getIconHeight();

        // Set the bounds of the label to the actual size of the image
        headLogo.setBounds(0, 15, widthLogo, heightLogo);

        return headLogo;
    }

    // Function to create and configure the JButton for the shopCart
    /*private static JButton getShopCartButton() {
        // Load image for the shopCart
        ImageIcon shopCartIcon = new ImageIcon("C:\\Users\\chris\\IdeaProjects\\Sprint2TestChris\\src\\CSEIcons\\ShoppingCart.png");

        // Create a JButton for the shopCart
        JButton shopCartButton = new JButton();
        shopCartButton.setIcon(shopCartIcon);
        shopCartButton.setFocusPainted(false);
        shopCartButton.setContentAreaFilled(false);
        shopCartButton.setBorderPainted(false);

        // Get the dimensions of the image
        int widthCart = shopCartIcon.getIconWidth();
        int heightCart = shopCartIcon.getIconHeight();

        // Set the bounds of the button to the actual size of the image
        shopCartButton.setBounds(700, 25, widthCart, heightCart);

        // Add an ActionListener to handle button clicks
        shopCartButton.addActionListener(e -> {
            // Add your logic for handling shopCart button clicks here
            System.out.println("ShopCart button clicked");
        });

        return shopCartButton;
    }*/

    private static JButton getCustomerButton() {
        ImageIcon loginIcon = new ImageIcon("C:\\Users\\chris\\IdeaProjects\\Sprint2TestChris\\src\\CSEIcons\\LoginBrown.png");

        Image image = loginIcon.getImage();
        Image newImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        loginIcon = new ImageIcon(newImage);

        JButton customerButton = new JButton();
        customerButton.setIcon(loginIcon);
        customerButton.setText("Customer");
        customerButton.setFont(new Font(null, Font.PLAIN, 20));

        // Set the background color to brown using RGB (58, 34, 32)
        customerButton.setBackground(new Color(58, 34, 32));
        customerButton.setForeground(Color.WHITE);
        customerButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 20, true));

        customerButton.setFocusPainted(false);
        customerButton.setContentAreaFilled(true);
        customerButton.setBorderPainted(false);
        customerButton.setOpaque(true);

        ///loginButton.setBounds(150, 170, 200, 75);
        customerButton.addActionListener(e -> {
            // Add your logic for handling shopCart button clicks here
            System.out.println("Customer button clicked");
        });

        return customerButton;
    }
    private static JButton getEmployeeButton() {

        JButton employeeButton = new JButton();
        employeeButton.setText("Employee");
        employeeButton.setFont(new Font(null, Font.PLAIN, 20));
        // Set the background color to brown using RGB (58, 34, 32)
        employeeButton.setBackground(new Color(58, 34, 32));
        employeeButton.setForeground(Color.WHITE);
        employeeButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 20, true));

        employeeButton.setFocusPainted(false);
        employeeButton.setContentAreaFilled(true);
        employeeButton.setBorderPainted(false);
        employeeButton.setOpaque(true);

        ///guestButton.setBounds(450, 170, 200, 75);
        employeeButton.addActionListener(e -> {
            // Add your logic for handling shopCart button clicks here
            System.out.println("Employee button clicked");
        });

        return employeeButton;
    }

    private static JLabel getSlogan() {
        // Load images for the logo
        ImageIcon slogan = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/Slogan.PNG");

        // Create a JLabel for the logo
        JLabel headLogo = new JLabel();
        headLogo.setIcon(slogan);

        // Get the dimensions of the image
        int widthLogo = slogan.getIconWidth();
        int heightLogo = slogan.getIconHeight();

        // Set the bounds of the label to the actual size of the image
        headLogo.setBounds(225, 180, widthLogo, heightLogo);

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
    private static class ResizeListener extends ComponentAdapter {
        private final JPanel header;
        private final JPanel lwrSection;
        private final JLabel headLogo;
        private final JButton customerButton;
        private final JButton employeeButton;
        private final JLabel sloganButton;
        private final JButton backButton;

        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton customerButton, JButton employeeButton, JLabel sloganButton, JButton backButton) {
            this.header = header;
            this.lwrSection = lwrSection;
            this.headLogo = headLogo;
            this.customerButton = customerButton;
            this.employeeButton = employeeButton;
            this.sloganButton = sloganButton;
            this.backButton = backButton;
        }

        @Override
        public void componentResized(ComponentEvent e) {
            int frameWidth = e.getComponent().getWidth();
            int frameHeight = e.getComponent().getHeight();

            // Adjust header size
            header.setPreferredSize(new Dimension(frameWidth, frameHeight / 6));

            // Stretched icon for logo
            headLogo.setBounds(2, frameHeight / 30, headLogo.getWidth(), headLogo.getHeight());
            // Adjust lower section size
            lwrSection.setPreferredSize(new Dimension(frameWidth, 5 * frameHeight / 6));

            // Adjust button positions
            customerButton.setBounds((int) (2*frameWidth / 5.55), (int) (frameHeight / 2.6), (int) (frameWidth / 3.7), frameHeight / 7);
            employeeButton.setBounds((int) (2*frameWidth / 5.55), (int) (frameHeight / 1.7), (int) (frameWidth / 3.7), frameHeight / 7);
            backButton.setBounds(15, 30, (frameWidth / 6), frameHeight / 9);

            // Stretched icon for slogan
            ImageIcon slogan = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/Slogan.PNG");
            int sloganWidth = frameWidth / 2;
            int sloganHeight = (int) (sloganWidth * ((double) slogan.getIconHeight() / slogan.getIconWidth()));

            Image scaledSlogan = slogan.getImage().getScaledInstance(sloganWidth, sloganHeight, Image.SCALE_SMOOTH);
            sloganButton.setIcon(new ImageIcon(scaledSlogan));

            // Adjust slogan position
            int sloganX = frameWidth / 4;
            int sloganY = frameHeight / 15;
            sloganButton.setBounds(sloganX, sloganY, sloganWidth, sloganHeight);

        }
    }
}