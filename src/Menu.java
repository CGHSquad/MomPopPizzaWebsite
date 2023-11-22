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

        JLabel headLogo = getjLabel();

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
        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo,backButton, text, pizzaButton,
                sidesButton, drinksButton,box1,box2,box3, thin, regular, pan, pizzaImg, pizzaImg2,pizzaImg3,orderNowButtonThin,orderNowButtonRegular,orderNowButtonPan,
                whiteBox1,whiteBox2,whiteBox3));

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
    protected   JLabel getjLabel() {
        // Load images for the logo
        ImageIcon logo = new ImageIcon("images/logo.png");

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
    private  JLabel getPizzaImg() {
        // Load images
        ImageIcon pizzaIcon = new ImageIcon("images/pizzaImg.PNG");
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
            if(crust.equals("Thin")){
                //select thin crust
                System.out.println("Thin Crust Selected");
            }else if(crust.equals("Regular")){
                //select regular crust
                System.out.println("Regular Crust Selected");
            }else if(crust.equals("Pan")){
                //select regular crust
                System.out.println("Pan Crust Selected");
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
                OrderNowThin,OrderNowRegular,OrderNowPan;


        private final JPanel box1,box2,box3,whiteBox1, whiteBox2, whiteBox3;

        private final JLabel text, regular, pan, thin, pizzaImg,pizzaImg2,pizzaImg3;

        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton backButton,JLabel text,
                       JButton pizzaButton, JButton sidesButton, JButton drinksButton,JPanel box1, JPanel
                               box2, JPanel box3, JLabel thin, JLabel regular, JLabel pan,
                       JLabel pizzaImg, JLabel pizzaImg2, JLabel pizzaImg3,
                       JButton OrderNowThin,JButton OrderNowRegular, JButton OrderNowPan,
                       JPanel whiteBox1, JPanel whiteBox2, JPanel whiteBox3) {
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

            //buttons
            backButton.setBounds(15, 30, (frameWidth / 6), frameHeight / 9);
            text.setBounds(200, 35,frameWidth/2,frameHeight/6);
            pizzaButton.setBounds(50, 100, (75), 40);
            sidesButton.setBounds(10,150,(75), 40);
            drinksButton.setBounds(15,200,(75), 40);
            //orderNow
            OrderNowThin.setBounds(200,250,150,40);
            OrderNowThin.setBounds(200,250,150,40);
            OrderNowRegular.setBounds(400,250,150,40);
            OrderNowPan.setBounds(600,250,150,40);



            //box -> thin Crust

            box1.setBounds(200,100,150, 160);
            box1.add(whiteBox1);
            whiteBox1.setBounds(7,35,135,120);
            box1.add(thin);
            thin.setBounds(50,0,75,40);
            whiteBox1.add(pizzaImg);
            pizzaImg.setBounds(10, 15,120,100);

            //box2 -> regular crust
            box2.setBounds(400,100,150, 160);
            box2.add(whiteBox2);
            whiteBox2.setBounds(7,35,135,120);
            box2.add(regular);
            regular.setBounds(30,0,95,40);
            whiteBox2.add(pizzaImg2);
            pizzaImg2.setBounds(10, 15,120,100);

            //box3 -> pan Crust
            box3.setBounds(600,100,150, 160);
            box3.add(whiteBox3);
            whiteBox3.setBounds(7,35,135,120);
            box3.add(pan);
            pan.setBounds(50,0,75,40);
            whiteBox3.add(pizzaImg3);
            pizzaImg3.setBounds(10, 15,120,100);



        }
    }




}
