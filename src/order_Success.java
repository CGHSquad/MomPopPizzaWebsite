import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class order_Success {
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

        JPanel grayPanel = new JPanel();
        grayPanel.setBackground(Color.LIGHT_GRAY);
        grayPanel.setBounds(150, 50, 550, 220);
        grayPanel.setLayout(null);

        //Text area for the thank-you confirmation
        JTextArea thankYouArea = new JTextArea("Thank you for your purchase!");
        thankYouArea.setFont(new Font(null, Font.PLAIN, 25));
        thankYouArea.setForeground(new Color(58, 34, 32));
        thankYouArea.setBackground(Color.LIGHT_GRAY);
        thankYouArea.setBounds(90, 100, 500, 50);

        //Using Checkmark text to visualize confirmation
        JLabel checkLabel = new JLabel("✓");
        checkLabel.setFont(new Font(null, Font.PLAIN, 50));
        checkLabel.setForeground(new Color(0,128,0));
        checkLabel.setBounds(270, 30, 250, 50);


        grayPanel.add(thankYouArea);
        grayPanel.add(checkLabel);

        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        lwrSection.add(grayPanel);
        header.add(menuButton);
        header.add(homeButton);
        header.add(shopCartButton);

        lwrSection.add(backButton);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo,backButton, homeButton, menuButton, shopCartButton));
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


