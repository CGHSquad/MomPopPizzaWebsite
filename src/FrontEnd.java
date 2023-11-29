import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FrontEnd {
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

        JLabel headLogo = MethodFactory.createLogoLabel("src/CSEIcons/logo.png");
        JButton loginButton = getLoginButton();
        JButton guestButton = getGuestButton();
        JLabel sloganButton = getSlogan();

        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        lwrSection.add(loginButton);
        lwrSection.add(guestButton);
        lwrSection.add(sloganButton);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo, loginButton, guestButton, sloganButton));
        frame.setVisible(true);
    }


    // Function to create and configure the JLabel with the logo
    /*private static JLabel getjLabel() {
        // Load images for the logo
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
    }*/

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

    private JButton getLoginButton() {
        ImageIcon loginIcon = new ImageIcon("src/CSEIcons/LoginBrown.png");

        Image image = loginIcon.getImage();
        Image newImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        loginIcon = new ImageIcon(newImage);

        JButton loginButton = new JButton();
        loginButton.setIcon(loginIcon);
        loginButton.setText("Login");
        loginButton.setFont(new Font(null, Font.PLAIN, 20));

        // Set the background color to brown using RGB (58, 34, 32)
        loginButton.setBackground(new Color(58, 34, 32));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE,20));

        loginButton.setFocusPainted(false);
        loginButton.setContentAreaFilled(true);
        loginButton.setBorderPainted(false);
        loginButton.setOpaque(true);

        ///loginButton.setBounds(150, 170, 200, 75);
        loginButton.addActionListener(e -> {
            this.frame.dispose();

            // Add your logic for handling shopCart button clicks here
            LoginScreen ls = new LoginScreen();
            ls.CreateWindow();
        });

        return loginButton;
    }
    //Method for Guest Button which will send you to Menu
    private JButton getGuestButton() {

        JButton guestButton = new JButton();
        guestButton.setText("Continue as a guest");
        guestButton.setFont(new Font(null, Font.PLAIN, 20));
        // Set the background color to brown using RGB (58, 34, 32)
        guestButton.setBackground(new Color(58, 34, 32));
        guestButton.setForeground(Color.WHITE);
        guestButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 20, true));

        guestButton.setFocusPainted(false);
        guestButton.setContentAreaFilled(true);
        guestButton.setBorderPainted(false);
        guestButton.setOpaque(true);

        guestButton.addActionListener(e -> {
            this.frame.dispose();

            Menu m = new Menu();
            m.CreateWindow();
        });

        return guestButton;
    }


    private static JLabel getSlogan() {
        // Load images for the logo
        ImageIcon slogan = new ImageIcon("src/CSEIcons/Slogan.PNG");

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
    private static class ResizeListener extends ComponentAdapter {
        private final JPanel header;
        private final JPanel lwrSection;
        private final JLabel headLogo;
        private final JButton loginButton;
        private final JButton guestButton;
        private final JLabel sloganButton;

        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton loginButton, JButton guestButton, JLabel sloganButton) {
            this.header = header;
            this.lwrSection = lwrSection;
            this.headLogo = headLogo;
            this.loginButton = loginButton;
            this.guestButton = guestButton;
            this.sloganButton = sloganButton;
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
            // Adjust lower section size
            lwrSection.setPreferredSize(new Dimension(frameWidth, 5 * frameHeight / 6));

            // Adjust button positions
            loginButton.setBounds((int) (frameWidth / 5.55), (int) (frameHeight / 2.6), (int) (frameWidth / 3.7), frameHeight / 7);
            guestButton.setBounds((int) (3 * frameWidth / 5.55), (int) (frameHeight / 2.6), (int) (frameWidth / 3.7), frameHeight / 7);

            // Stretched icon for slogan
            ImageIcon slogan = new ImageIcon("src/CSEIcons/Slogan.PNG");
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