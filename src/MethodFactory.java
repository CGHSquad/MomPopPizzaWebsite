import javax.swing.*;
import java.awt.*;

public class MethodFactory {

    public static JLabel createLogoLabel(String imagePath) {
        ImageIcon logo = new ImageIcon(imagePath);

        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);

        int widthLogo = logo.getIconWidth();
        int heightLogo = logo.getIconHeight();

        logoLabel.setBounds(0, 5, widthLogo, heightLogo);

        return logoLabel;
    }

    public static JButton getHomeButton() {
        JButton homeButton = new JButton("Home");

        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(new Color(58, 34, 32));
        homeButton.setFocusPainted(false);
        homeButton.setContentAreaFilled(true);
        homeButton.setBorderPainted(false);
        homeButton.setOpaque(true);
        // Add your action listener for the home button here
        return homeButton;
    }

    public static JButton getMenuButton() {
        JButton menuButton = new JButton("Menu");

        menuButton.setForeground(Color.WHITE);
        menuButton.setBackground(new Color(58, 34, 32));
        menuButton.setFocusPainted(false);
        menuButton.setContentAreaFilled(true);
        menuButton.setBorderPainted(false);
        menuButton.setOpaque(true);
        // Add your action listener for the menu button here
        return menuButton;
    }

    public static JButton getShopCartButton() {
        // Load image for the shopCart
        ImageIcon shopCartIcon = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/ShoppingCart.png");

        // Create a JButton for the shopCart
        JButton shopCartButton = getjButton(shopCartIcon);

        // Add an ActionListener to handle button clicks
        shopCartButton.addActionListener(e -> {
            // Add your logic for handling shopCart button clicks here
            System.out.println("ShopCart button clicked");
        });

        return shopCartButton;
    }

    private static JButton getjButton(ImageIcon shopCartIcon) {
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
        return shopCartButton;
    }

    public static void MenuHomeScreenFit(JButton button, int frameWidth, int frameHeight, int x, int y) {
        float fontSize = Math.max(15, frameHeight / 28f);
        button.setFont(new Font(null, Font.PLAIN, (int) fontSize));

        int buttonWidth = frameWidth / 8;
        int buttonHeight = frameHeight / 28;
        button.setBounds(x, y, buttonWidth, buttonHeight);
    }

    public static void resizeAndSetBoundsForShopCartButton(JButton shopCartButton, int frameWidth, int frameHeight) {
        ImageIcon shopCartIcon = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/ShoppingCart.png");

        // Get the dimensions of the image
        int widthCart = shopCartIcon.getIconWidth();
        int heightCart = shopCartIcon.getIconHeight();

        // Set the bounds of the button to the actual size of the image
        int shopCartX = frameWidth - 10 - widthCart;
        int shopCartY = 27;
        shopCartButton.setBounds(shopCartX, shopCartY, widthCart, heightCart);
    }




    // Add more methods for creating other components if needed
}