import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MenuSides  extends Menu{

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

        JLabel headLogo = MethodFactory.createLogoLabel("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/logo.png");
        JButton homeButton = MethodFactory.getHomeButton(frame);
        JButton menuButton = MethodFactory.getMenuButton(frame);
        JButton shopCartButton = MethodFactory.getShopCartButton(frame);

        //SIDES Text
        JLabel sidesText = getYouText("SIDES");


        //Sides Images
        JLabel BreadStick = getSides("Bread Stick");
        JLabel BreadSticksBites= getSides("Bread Stick Bites");
        JLabel ChocolateChip = getSides("Cookies");


        //Buttons
        JButton backButton = getBackButton();
        JButton pizzaButton = getPizzaButton();
        JButton sidesButton = getSidesButton();
        JButton drinksButton = getDrinksButton();
        JButton orderNowButtonBreadStick = getOrderNowButton("Bread Stick");
        JButton orderNowButtonBreadBites = getOrderNowButton("Bread Stick Bites");
        JButton orderNowButtonCookie = getOrderNowButton("Cookie");
        //select sides

        //box1
        JPanel box1 =   box("Regular");
        JPanel whiteBox1 = box("White");

        JLabel breadStickLabel = getItemText("Bread Stick");

        //box2
        JPanel box2 =   box("Regular");
        JPanel whiteBox2 = box("White");
        JLabel breadBites = getItemText("Bread Stick Bites");
        //box 3
        JPanel box3 =   box("Regular");
        JPanel whiteBox3 = box("White");
        JLabel cookie = getItemText("COOKIE");





        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        header.add(menuButton);
        header.add(homeButton);
        header.add(shopCartButton);
        lwrSection.add(backButton);
        lwrSection.add(sidesText);
        lwrSection.add(pizzaButton);
        lwrSection.add(sidesButton);
        lwrSection.add(drinksButton);
        lwrSection.add(box1);
        lwrSection.add(box2);
        lwrSection.add(box3);
        lwrSection.add(orderNowButtonBreadStick);
        lwrSection.add(orderNowButtonBreadBites);
        lwrSection.add(orderNowButtonCookie);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo,backButton, sidesText,
                pizzaButton,sidesButton, drinksButton,box1,box2,box3,breadStickLabel, breadBites, cookie,
                BreadStick, BreadSticksBites, ChocolateChip,orderNowButtonBreadStick,orderNowButtonBreadBites,orderNowButtonCookie,
                whiteBox1,whiteBox2,whiteBox3, homeButton, menuButton, shopCartButton));

        frame.setVisible(true);

    }

    private JLabel getSides(String side){
        ImageIcon sideIcon = null;
        //load Images for each one
        if(side.equals("Bread Stick")){
            sideIcon = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/BreadStick.PNG");
        } else if (side.equals("Bread Stick Bites")) {
            sideIcon = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/BreadStickBites.jpg");
        } else if (side.equals("Cookies")) {
            sideIcon = new ImageIcon("/Users/realcgh/IdeaProjects/Sprint2TestChris/src/CSEIcons/cokie.PNG");
        }
        Image originalImage = sideIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(120,100,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(resizedImage);
        //create a Jlabel
        JLabel sideImg = new JLabel();
        sideImg.setIcon(icon);



        return sideImg;

    }

    @Override
    protected JButton getOrderNowButton(String sides) {

        JButton orderNow = new JButton();
        orderNow.setText("Order Now");
        orderNow.setFont(new Font(null, Font.PLAIN, 20));
        orderNow.setForeground(Color.white);

        orderNow.setBackground(new Color(58, 34, 32));

        orderNow.setFocusPainted(false);
        orderNow.setContentAreaFilled(true);
        orderNow.setBorderPainted(false);
        orderNow.setOpaque(true);

        orderNow.addActionListener(e -> {
            // GO to order Screen
            if(sides.equals("Bread Stick")){
                //select thin crust
                System.out.println("Bread Stick Selected");
            }else if(sides.equals("Bread Stick Bites")){
                //select regular crust
                System.out.println("Bread Stick Bites Selected");
            }else if(sides.equals("Cookie")){
                //select regular crust
                System.out.println("Cookie Selected");
            }
        });
        return orderNow;

    }

    @Override
    protected JButton getPizzaButton(){
        JButton pizzaButton = super.getPizzaButton();
        pizzaButton.setForeground(new Color(58, 34, 32));


        pizzaButton.setBackground(Color.WHITE);

        return pizzaButton;
    }
    @Override
    protected JButton getSidesButton(){
        JButton sidesButton = super.getSidesButton();
        sidesButton.setForeground(Color.WHITE);
        sidesButton.setBackground(new Color(58, 34, 32));

        return sidesButton;

    }

    private static class ResizeListener extends ComponentAdapter {
        private final JPanel header;
        private final JPanel lwrSection;
        private final JLabel headLogo;
        private final JButton pizzaButton, sidesButton,drinksButton, backButton,
                orderNowBreadStick, ordernowBreadStickBites, ordernowCookie, homeButton, menuButton, shopCartButton;
        private final JPanel box1,box2,box3,whiteBox1, whiteBox2, whiteBox3;

        private final JLabel sidesText, breadStickLabel, breadStickBitesLabel, cookieLabel, breadStickImg, breadSickBitesImg, cookieImg ;

        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton backButton,JLabel sidesText,
                       JButton pizzaButton, JButton sidesButton, JButton drinksButton, JPanel box1, JPanel box2, JPanel box3,
                       JLabel breadStickLabel, JLabel breadStickBitesLabel, JLabel cookieLabel,
                       JLabel breadStickImg, JLabel breadSickBitesImg, JLabel cookieImg,
                       JButton orderNowBreadStick, JButton ordernowBreadStickBites, JButton ordernowCookie,
                       JPanel whiteBox1, JPanel whiteBox2, JPanel whiteBox3,
                       JButton homeButton, JButton menuButton, JButton shopCartButton) {
            this.header = header;
            this.lwrSection = lwrSection;
            this.headLogo = headLogo;
            this.backButton = backButton;
            this.pizzaButton = pizzaButton;
            this.sidesButton = sidesButton;
            this.drinksButton = drinksButton;
            this.sidesText = sidesText;
            this.box1 = box1;
            this.box2 = box2;
            this.box3 = box3;
            this.breadStickLabel = breadStickLabel;
            this.breadStickBitesLabel = breadStickBitesLabel;
            this.cookieLabel = cookieLabel;
            this.orderNowBreadStick = orderNowBreadStick;
            this.ordernowBreadStickBites = ordernowBreadStickBites;
            this.ordernowCookie = ordernowCookie;
            this.breadStickImg = breadStickImg;
            this.breadSickBitesImg = breadSickBitesImg;
            this.cookieImg = cookieImg;
            this.whiteBox1 = whiteBox1;
            this.whiteBox2 = whiteBox2;
            this.whiteBox3 = whiteBox3;
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

            //Makes the buttons move alongside the logo
            int buttonY = logoY + headLogoHeight / 2 - homeButton.getHeight() / 2;
            MethodFactory.MenuHomeScreenFit(homeButton, frameWidth, frameHeight, logoX + headLogoWidth + 10, buttonY);
            MethodFactory.MenuHomeScreenFit(menuButton, frameWidth, frameHeight, logoX + headLogoWidth + 15 + homeButton.getWidth(), buttonY);

            MethodFactory.resizeAndSetBoundsForShopCartButton(shopCartButton, frameWidth, frameHeight);

            //buttons
            backButton.setBounds(15, 30, (frameWidth / 6), frameHeight / 9);
            sidesText.setBounds(200, 35,frameWidth/2,frameHeight/6);
            pizzaButton.setBounds(15, 100, (75), 40);
            sidesButton.setBounds(50,150,(75), 40);
            drinksButton.setBounds(15,200,(75), 40);

            //orderNow
            orderNowBreadStick.setBounds(200,270,150,40);
            ordernowBreadStickBites.setBounds(400,270,150,40);
            ordernowCookie.setBounds(600,270,150,40);

            //box -> BreadStick
            box1.setBounds(200,100,150, 160);
            //box1.add(whiteBox1);
            whiteBox1.setBounds(7,35,135,120);
            box1.add(breadStickLabel);
            breadStickLabel.setBounds(50,0,75,40);
            box1.add(breadStickImg);
            breadStickImg.setBounds(10, 15,120,100);


            //box2 -> BreadStickBites
            box2.setBounds(400,100,150, 160);
            //box2.add(whiteBox2);
            whiteBox2.setBounds(7,35,135,120);
            box2.add(breadStickBitesLabel);
            breadStickBitesLabel.setBounds(30,0,95,40);
            box2.add(breadSickBitesImg);
            breadSickBitesImg.setBounds(10, 15,120,100);

            //box3 -> Cookie
            box3.setBounds(600,100,150, 160);
            //box3.add(whiteBox3);
            whiteBox3.setBounds(7,35,135,120);
            box3.add(cookieLabel);
            cookieLabel.setBounds(50,0,75,40);
            box3.add(cookieImg);
            cookieImg.setBounds(10, 15,120,100);



        }
    }
}
