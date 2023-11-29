import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Toppings {
    private JFrame frame;

    public void CreateWindow() {
        frame = new JFrame("Mom and Pops Pizzeria");

        JPanel header = new JPanel();
        header.setBackground(new Color(58, 34, 32));
        header.setPreferredSize(new Dimension(800, 100));
        header.setLayout(null);

        JPanel lwrSection = new JPanel();
        lwrSection.setBackground(Color.WHITE);
        lwrSection.setPreferredSize(new Dimension(800, 400));
        lwrSection.setLayout(null);

        // Methods for home button, head logo, menu button, and shop cart button for ease of access
        JLabel headLogo = MethodFactory.createLogoLabel("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/logo.png");
        JButton homeButton = MethodFactory.getHomeButton(frame);
        JButton menuButton = MethodFactory.getMenuButton(frame);
        JButton shopCartButton = MethodFactory.getShopCartButton();

        JButton backButton = getBackButton();

        //Label for Size
        JLabel size = new JLabel("SIZE:");

        // Buttons for size
        JRadioButton smallSize = new JRadioButton("Small");
        JRadioButton mediumSize = new JRadioButton("Medium");
        JRadioButton largeSize = new JRadioButton("Large");
        JRadioButton extraLargeSize = new JRadioButton("Extra Large");

        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallSize);
        sizeGroup.add(mediumSize);
        sizeGroup.add(largeSize);
        sizeGroup.add(extraLargeSize);

        // Buttons for toppings
        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        JCheckBox sausage = new JCheckBox("Sausage");
        JCheckBox onion = new JCheckBox("Onion");
        JCheckBox ham = new JCheckBox("Ham");
        JCheckBox tomato = new JCheckBox("Tomato");
        JCheckBox greenPepper = new JCheckBox("Green Pepper");
        JCheckBox pineapple = new JCheckBox("Pineapple");
        JCheckBox mushroom = new JCheckBox("Mushroom");



        // Quantity button
        JButton quantityButton = new JButton("Quantity: ");

        // Add button
        JButton addButton = new JButton("Add");
        int[] toppingCount = {0}; // To keep track of the number of toppings added

        addButton.addActionListener(e -> {
            // Charge for toppings after the first one
            if (toppingCount[0] > 0) {
                // Add your logic to charge for additional toppings
                System.out.println("Charge for additional topping");
            }
            toppingCount[0]++;
            quantityButton.setText("Quantity: " + (toppingCount[0] + 1));
        });



        // Add components to the frame
        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        header.add(menuButton);
        header.add(homeButton);
        header.add(shopCartButton);
        lwrSection.add(backButton);
        lwrSection.add(size);
        lwrSection.add(smallSize);
        lwrSection.add(mediumSize);
        lwrSection.add(largeSize);
        lwrSection.add(extraLargeSize);
        lwrSection.add(quantityButton);
        lwrSection.add(pepperoni);
        lwrSection.add(sausage);
        lwrSection.add(onion);
        lwrSection.add(ham);
        lwrSection.add(tomato);
        lwrSection.add(greenPepper);
        lwrSection.add(pineapple);
        lwrSection.add(mushroom);
        lwrSection.add(addButton);

        // Other frame settings...
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo, backButton, size,
                homeButton, menuButton, shopCartButton,
                smallSize, mediumSize, largeSize, extraLargeSize,
                quantityButton,
                pepperoni, sausage, onion, ham,
                tomato, greenPepper, pineapple, mushroom,
                addButton));
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
            Menu me = new Menu();
            me.CreateWindow();
        });

        return backButton;
    }

    private static class ResizeListener extends ComponentAdapter {
        private final JPanel header;
        private final JPanel lwrSection;
        private final JLabel headLogo;
        private final JButton backButton;
        private final JLabel size;
        private final JButton homeButton;
        private final JButton menuButton;
        private final JButton shopCartButton;

        private final JRadioButton smallSize;
        private final JRadioButton mediumSize;
        private final JRadioButton largeSize;
        private final JRadioButton extraLargeSize;
        private final JButton quantityButton;
        private final JCheckBox pepperoni;
        private final JCheckBox sausage;
        private final JCheckBox onion;
        private final JCheckBox ham;
        private final JCheckBox tomato;
        private final JCheckBox greenPepper;
        private final JCheckBox pineapple;
        private final JCheckBox mushroom;
        private final JButton addButton;

        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton backButton, JLabel size,
                       JButton homeButton, JButton menuButton, JButton shopCartButton,
                       JRadioButton smallSize, JRadioButton mediumSize, JRadioButton largeSize, JRadioButton extraLargeSize,
                       JButton quantityButton,
                       JCheckBox pepperoni, JCheckBox sausage, JCheckBox onion, JCheckBox ham,
                       JCheckBox tomato, JCheckBox greenPepper, JCheckBox pineapple, JCheckBox mushroom,
                       JButton addButton) {
            this.header = header;
            this.lwrSection = lwrSection;
            this.headLogo = headLogo;
            this.backButton = backButton;
            this.size = size;
            this.homeButton = homeButton;
            this.menuButton = menuButton;
            this.shopCartButton = shopCartButton;
            this.smallSize = smallSize;
            this.mediumSize = mediumSize;
            this.largeSize = largeSize;
            this.extraLargeSize = extraLargeSize;
            this.quantityButton = quantityButton;
            this.pepperoni = pepperoni;
            this.sausage = sausage;
            this.onion = onion;
            this.ham = ham;
            this.tomato = tomato;
            this.greenPepper = greenPepper;
            this.pineapple = pineapple;
            this.mushroom = mushroom;
            this.addButton = addButton;

        }

        @Override
        public void componentResized(ComponentEvent e) {
            int frameWidth = e.getComponent().getWidth();
            int frameHeight = e.getComponent().getHeight();

            // Adjust header size
            //header.setPreferredSize(new Dimension(frameWidth, frameHeight / 6));

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

            smallSize.setBounds(10, 120, 80, 20);
            mediumSize.setBounds(10, 150, 80, 20);
            largeSize.setBounds(10, 180, 80, 20);
            extraLargeSize.setBounds(10, 210, 120, 20);
            size.setBounds(30, 95, 120, 20);

            quantityButton.setBounds(10, 240, 120, 30);

            pepperoni.setBounds(500, 10, 100, 20);
            sausage.setBounds(500, 40, 100, 20);
            onion.setBounds(500, 70, 100, 20);
            ham.setBounds(500, 100, 100, 20);
            tomato.setBounds(500, 130, 100, 20);
            greenPepper.setBounds(500, 160, 120, 20);
            pineapple.setBounds(500, 190, 100, 20);
            mushroom.setBounds(500, 220, 100, 20);

            addButton.setBounds(500, 250, 80, 30);
        }
    }
}


