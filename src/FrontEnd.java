import javax.swing.*;
import java.awt.*;

public class FrontEnd {
    public void CreateWindow() {
        // Create the main JFrame for the application
        JFrame frame = new JFrame("Mom and Pops Pizzeria");

        // Create the header panel with a specified background color and size
        JPanel header = new JPanel();
        header.setBackground(new Color(58, 34, 32));
        header.setPreferredSize(new Dimension(800, 100));
        header.setLayout(null); // Using absolute positioning

        // Create the lower section panel with GridBagLayout for precise positioning
        JPanel lwrSection = new JPanel(new GridBagLayout());
        lwrSection.setBackground(Color.WHITE);
        lwrSection.setPreferredSize(new Dimension(800, 400));
        lwrSection.setLayout(null); // Using absolute positioning

        // Load images for the logo
        JLabel headLogo = getjLabel();

        // Create a JButton for the shopCart
        JButton shopCartButton = getShopCartButton();

        // Create a JButton for the Login
        JButton loginButton = getLoginButton();

        // Set up the layout for the main frame
        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.SOUTH);
        header.add(headLogo);
        header.add(shopCartButton);// Add the shopCart button to the header panel
        lwrSection.add(loginButton);

        // Set the size, default close operation, and visibility of the main frame
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Function to create and configure the JLabel with the logo
    private static JLabel getjLabel() {
        // Load images for the logo
        ImageIcon logo = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint 2/src/CSEIcons/logo.png");

        // Create a JLabel for the logo
        JLabel headLogo = new JLabel();
        headLogo.setIcon(logo);

        // Get the dimensions of the image
        int widthLogo = logo.getIconWidth();
        int heightLogo = logo.getIconHeight();

        // Set the bounds of the label to the actual size of the image
        headLogo.setBounds(0, 25, widthLogo, heightLogo);

        return headLogo;
    }

    // Function to create and configure the JButton for the shopCart
    private static JButton getShopCartButton() {
        // Load image for the shopCart
        ImageIcon shopCartIcon = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint 2/src/CSEIcons/ShoppingCart.png");

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
    }

    private static JButton getLoginButton() {
        ImageIcon loginIcon = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint 2/src/CSEIcons/loginpanel.png");

        JButton loginButton = new JButton();
        loginButton.setIcon(loginIcon);
        loginButton.setFocusPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);

        // Get the dimensions of the image
        int widthCart = loginIcon.getIconWidth();
        int heightCart = loginIcon.getIconHeight();

        // Set the bounds of the button to the actual size of the image
        loginButton.setBounds(50, 150, widthCart, heightCart);


        // Add an ActionListener to handle button clicks
        loginButton.addActionListener(e -> {
            // Add your logic for handling shopCart button clicks here
            System.out.println("Login Button clciked");
        });

        return loginButton;
    }
}
