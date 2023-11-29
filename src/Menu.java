import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Menu {
    protected JFrame frame;

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
        JButton homeButton = MethodFactory.getHomeButton(frame);
        JButton menuButton = MethodFactory.getMenuButton(frame);
        JButton shopCartButton = MethodFactory.getShopCartButton(frame);

        //CREATE YOUR OWN PIZZA TEXT
        JLabel text = getYouText("CREATE YOUR OWN PIZZA");


        //Pizza Images
        JLabel pizzaImg = getPizzaImg();
        JLabel pizzaImg2 = getPizzaImg();
        JLabel pizzaImg3 = getPizzaImg();


        //buttons
        JButton backButton = getBackButton();
        JButton pizzaButton = getPizzaButton();
        JButton sidesButton = getSidesButton();
        JButton drinksButton = getDrinksButton();
        JButton orderNowButtonThin = getOrderNowButton("Thin");
        JButton orderNowButtonRegular = getOrderNowButton("Regular");
        JButton orderNowButtonPan = getOrderNowButton("Pan");


        //select Pizza
        JPanel box1 =   box("Regular");
        JPanel whiteBox1 = box("White");
        JLabel thin = getItemText("THIN CRUST");

        JPanel box2 =   box("Regular");
        JPanel whiteBox2 = box("White");
        JLabel regular = getItemText("REGULAR CRUST");


        JPanel box3 =   box("Regular");
        JPanel whiteBox3 = box("White");
        JLabel pan = getItemText("PAN CRUST");


        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        header.add(menuButton);
        header.add(homeButton);
        header.add(shopCartButton);
        lwrSection.add(backButton);
        lwrSection.add(text);
        lwrSection.add(pizzaButton);
        lwrSection.add(sidesButton);
        lwrSection.add(drinksButton);
        lwrSection.add(box1);
        lwrSection.add(box2);
        lwrSection.add(box3);
        lwrSection.add(orderNowButtonThin);
        lwrSection.add(orderNowButtonRegular);
        lwrSection.add(orderNowButtonPan);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo, backButton, text, pizzaButton,
                sidesButton, drinksButton, box1, box2, box3, thin, regular, pan, pizzaImg, pizzaImg2, pizzaImg3, orderNowButtonThin, orderNowButtonRegular, orderNowButtonPan,
                whiteBox1, whiteBox2, whiteBox3, homeButton, menuButton, shopCartButton));

        frame.setVisible(true);

    }
    protected JLabel getItemText(String Text){
        JLabel item = new JLabel();
        item.setText(Text);
        item.setFont(new Font(null,Font.PLAIN, 10));
        item.setForeground(Color.WHITE);

        return item;
    }

    protected JLabel getYouText(String text){
        JLabel label = new JLabel();
        label.setText(text);
        label.setFont(new Font(null,Font.PLAIN, 30));
        label.setForeground(new Color(58, 34, 32));

        return label;
    }
    private  JLabel getPizzaImg() {
        // Load images
        ImageIcon pizzaIcon = new ImageIcon("src/CSEIcons/pizzaImg.PNG");
        Image originalImage = pizzaIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(120,100,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(resizedImage);
        // Create a JLabel
        JLabel pizzaImg = new JLabel();
        pizzaImg.setIcon(icon);

        return pizzaImg;
    }
    protected JButton getBackButton(){

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
    protected JButton getOrderNowButton(String crust){

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
            switch (crust) {
                case "Thin" -> {
                    //select thin crust
                    this.frame.dispose();
                    Toppings tp = new Toppings();
                    tp.CreateWindow();
                }
                case "Regular" -> {
                    //select regular crust
                    this.frame.dispose();
                    Toppings tp = new Toppings();
                    tp.CreateWindow();
                }
                case "Pan" -> {
                    //select regular crust
                    this.frame.dispose();
                    Toppings tp = new Toppings();
                    tp.CreateWindow();
                }
            }
        });

        return orderNow;
    }


    protected JButton getPizzaButton(){
        ImageIcon pizza  = new ImageIcon("images/PIZZA_BTN");
        JButton pizzaButton = new JButton();
        pizzaButton.setText("Pizza");
        pizzaButton.setFont(new Font(null, Font.PLAIN, 10));
        pizzaButton.setForeground(Color.WHITE);


        pizzaButton.setBackground(new Color(58, 34, 32));


        pizzaButton.setFocusPainted(false);
        //pizzaButton.setContentAreaFilled(true);
        pizzaButton.setBorderPainted(false);
        pizzaButton.setOpaque(true);

        pizzaButton.addActionListener(e -> {
            this.frame.dispose();

            //menu Drinks
            Menu m = new Menu();
            m.CreateWindow();
        });

        return pizzaButton;
    }

    protected JButton getDrinksButton(){

        JButton drinksButton = new JButton();
        drinksButton.setText("Drinks");
        drinksButton.setFont(new Font(null, Font.PLAIN, 10));
        drinksButton.setForeground(new Color(58, 34, 32));


        drinksButton.setBackground(Color.WHITE);

        drinksButton.setFocusPainted(false);
        drinksButton.setContentAreaFilled(true);
        drinksButton.setBorderPainted(false);
        drinksButton.setOpaque(true);

        drinksButton.addActionListener(e -> {
            this.frame.dispose();

            // drinks menu
            MenuDrinks MD = new MenuDrinks();
            MD.CreateWindow();
        });

        return drinksButton;
    }


    protected JButton getSidesButton(){

        JButton sidesButton = new JButton();
        sidesButton.setText("Sides");
        sidesButton.setFont(new Font(null, Font.PLAIN, 10));
        sidesButton.setForeground(new Color(58, 34, 32));


        sidesButton.setBackground(Color.WHITE);

        sidesButton.setFocusPainted(false);
        sidesButton.setContentAreaFilled(true);
        sidesButton.setBorderPainted(false);
        sidesButton.setOpaque(true);

        sidesButton.addActionListener(e -> {
            this.frame.dispose();

            // sides menu
            MenuSides MS = new MenuSides();
            MS.CreateWindow();


        });

        return sidesButton;
    }

    protected JPanel box(String color){
        JPanel box =new JPanel();
        box.setPreferredSize(new Dimension(200, 400/3));
        if(color.equals("White"))
        {
            box.setBackground(Color.WHITE);
        } else if (color.equals("Regular")) {
            box.setBackground(new Color(58, 34, 32));
        }


        return box;
    }


    private static class ResizeListener extends ComponentAdapter {
        private final JPanel header;
        private final JPanel lwrSection;
        private final JLabel headLogo;

        private final JButton pizzaButton, sidesButton, drinksButton, backButton,
                OrderNowThin,OrderNowRegular,OrderNowPan, homeButton, menuButton, shopCartButton;



        private final JPanel box1,box2,box3,whiteBox1, whiteBox2, whiteBox3;

        private final JLabel text, regular, pan, thin, pizzaImg,pizzaImg2,pizzaImg3;

        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton backButton,JLabel text,
                       JButton pizzaButton, JButton sidesButton, JButton drinksButton,JPanel box1, JPanel
                               box2, JPanel box3, JLabel thin, JLabel regular, JLabel pan,
                       JLabel pizzaImg, JLabel pizzaImg2, JLabel pizzaImg3,
                       JButton OrderNowThin,JButton OrderNowRegular, JButton OrderNowPan,
                       JPanel whiteBox1, JPanel whiteBox2, JPanel whiteBox3, JButton homeButton, JButton menuButton, JButton shopCartButton) {
            this.header = header;
            this.lwrSection = lwrSection;
            this.headLogo = headLogo;
            this.backButton = backButton;
            this.text = text;
            this.pizzaButton = pizzaButton;
            this.sidesButton = sidesButton;
            this.drinksButton = drinksButton;
            this.box1 = box1;
            this.box2 = box2;
            this.box3 = box3;
            this.regular = regular;
            this.thin = thin;
            this.pan = pan;
            this.pizzaImg = pizzaImg;
            this.pizzaImg2 = pizzaImg2;
            this.pizzaImg3 = pizzaImg3;
            this.OrderNowThin = OrderNowThin;
            this.OrderNowRegular = OrderNowRegular;
            this.OrderNowPan = OrderNowPan;
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
            ImageIcon logo = new ImageIcon("src/CSEIcons/logo.png");
            int headLogoWidth = (int) (frameWidth / 3.5);
            int headLogoHeight = (int) (headLogoWidth * ((double) logo.getIconHeight() / logo.getIconWidth()));

            Image scaledHeadLogo = logo.getImage().getScaledInstance(headLogoWidth, headLogoHeight, Image.SCALE_SMOOTH);
            headLogo.setIcon(new ImageIcon(scaledHeadLogo));

            int logoX = 5;
            int logoY = 10;
            headLogo.setBounds(logoX, logoY, headLogoWidth, headLogoHeight);

            int buttonY = logoY + headLogoHeight / 2 - homeButton.getHeight() / 2;
            MethodFactory.MenuHomeScreenFit(homeButton, frameWidth, frameHeight, logoX + headLogoWidth + 10, buttonY);
            MethodFactory.MenuHomeScreenFit(menuButton, frameWidth, frameHeight, logoX + headLogoWidth + 15 + homeButton.getWidth(), buttonY);

            MethodFactory.resizeAndSetBoundsForShopCartButton(shopCartButton, frameWidth, frameHeight);

            //buttons
            backButton.setBounds(15, 30, (frameWidth / 6), frameHeight / 9);
            text.setBounds(200, 35, frameWidth / 2, frameHeight / 6);
            pizzaButton.setBounds(frameWidth / 16, frameHeight / 4, (frameWidth / 8), frameHeight / 22);
            sidesButton.setBounds(frameWidth / 32, frameHeight / 3, (frameWidth / 8), frameHeight / 22);
            drinksButton.setBounds(frameWidth / 32, frameHeight / 2, (frameWidth / 8), frameHeight / 22);
            //orderNow


            lwrSection.setPreferredSize(new Dimension(frameWidth, 5 * frameHeight / 6));

            //box -> thin Crust
            ImageIcon pizzaImgIcon = MethodFactory.resizeMenuImage("src/CSEIcons/pizzaImg.PNG", frameWidth, frameHeight);
            pizzaImg.setIcon(pizzaImgIcon);
            int pizzaX = frameWidth / 80;
            int pizzaY = frameHeight / 20 + frameHeight / 30;
            pizzaImg.setBounds(pizzaX, pizzaY , pizzaImgIcon.getIconWidth(), pizzaImgIcon.getIconHeight());
            //box1.add(whiteBox1);
            box1.add(thin);
            box1.add(pizzaImg);
            //whiteBox1.add(pizzaImg);
            box1.setBounds(frameWidth / 5, frameHeight / 5, (int) (frameWidth / 4.5), frameHeight / 3);
            //whiteBox1.setBounds(box1.getX(), box1.getY(), box1.getWidth(), box1.getHeight());
            thin.setBounds(frameWidth / 32, frameHeight / 30, frameWidth / 9, frameHeight / 30);



            //box2 -> regular crust
            pizzaImg2.setIcon(pizzaImgIcon);
            int pizzaX2 = frameWidth / 80 + frameWidth / 5;
            int pizzaY2 = frameHeight / 20 + frameHeight / 30;
            pizzaImg2.setBounds(pizzaX2, pizzaY2 , pizzaImgIcon.getIconWidth(), pizzaImgIcon.getIconHeight());
            //box2.add(whiteBox2);
            box2.add(regular);
            box2.add(pizzaImg2);
            //whiteBox2.add(pizzaImg2);
            box2.setBounds(frameWidth * 2 / 5 + 55, frameHeight / 5, (int) (frameWidth / 4.5), frameHeight / 3);
            //whiteBox2.setBounds(box2.getX(), box2.getY(), box2.getWidth(), box2.getHeight());
            regular.setBounds(frameWidth / 32 + frameWidth / 5, frameHeight / 30, frameWidth / 9, frameHeight / 30);
            //pizzaImg2.setBounds(frameWidth / 80 + frameWidth / 5, frameHeight / 20 + frameHeight / 30, (int) (frameWidth / 4.5), frameHeight / 4);

            //box3 -> pan Crust
            pizzaImg3.setIcon(pizzaImgIcon);
            int pizzaX3 = frameWidth / 80 + frameWidth * 2/ 5;
            int pizzaY3 = frameHeight / 20 + frameHeight / 30;
            pizzaImg3.setBounds(pizzaX3, pizzaY3 , pizzaImgIcon.getIconWidth(), pizzaImgIcon.getIconHeight());
            //box3.add(whiteBox3);
            box3.add(pan);
            box3.add(pizzaImg3);
            box3.setBounds(frameWidth * 3 / 5 + 115, frameHeight / 5, (int) (frameWidth / 4.5), frameHeight / 3);
            whiteBox3.setBounds(box3.getX(), box3.getY(), box3.getWidth(), box3.getHeight());
            pan.setBounds(frameWidth / 32 + frameWidth * 2 / 5, frameHeight / 30, frameWidth / 9, frameHeight / 30);

            int orderNowButtonWidth = frameWidth / 8;
            int orderNowButtonHeight = frameHeight / 22;

            //Using the Y and X from box 1,2, and 3 to make sure order buttons stay right below the images
            int orderNowY = box1.getY() + box1.getHeight() + (frameHeight / 30);

            OrderNowThin.setBounds(box1.getX() + (box1.getWidth() - orderNowButtonWidth) / 3, orderNowY + 10, orderNowButtonWidth + 50, orderNowButtonHeight + 30);


            orderNowY = box2.getY() + box2.getHeight() + (frameHeight / 30);
            OrderNowRegular.setBounds(box2.getX() + (box2.getWidth() - orderNowButtonWidth) / 3, orderNowY + 10, orderNowButtonWidth + 50, orderNowButtonHeight + 30);


            orderNowY = box3.getY() + box3.getHeight() + (frameHeight / 30);
            OrderNowPan.setBounds(box3.getX() + (box3.getWidth() - orderNowButtonWidth) / 3, orderNowY + 10, orderNowButtonWidth + 50, orderNowButtonHeight + 30);



        }
    }
}
