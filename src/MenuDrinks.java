import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MenuDrinks extends Menu{
    @Override
    public void CreateWindow() {
        frame = new JFrame("Mom and Pops Pizzeria");

        JPanel header = new JPanel();
        header.setBackground(new Color(58, 34, 32));
        header.setPreferredSize(new Dimension(800, 100));
        header.setLayout(null);

        JPanel lwrSection = new JPanel(new GridBagLayout());
        lwrSection.setBackground(Color.WHITE);
        lwrSection.setPreferredSize(new Dimension(800, 500));
        lwrSection.setLayout(null);

        JLabel headLogo = getjLabel();

        //Drinks Text
        JLabel drinksText = getYouText("PEPSI BEVERAGES");
        //images
        JLabel pepsiImg = getImages("images/pepsi.PNG",40,70);
        JLabel pepsiDietImg = getImages("images/pepsi_diet.PNG",60,70); // not same size
        JLabel pepsiOrangeImg = getImages("images/pepsi_orange.PNG",40,70);
        JLabel pepsiOrangeDietImg = getImages("images/pepsi_orange.PNG",40,70);
        JLabel rootBeerImg = getImages("images/root_beer.PNG",40,70);
        JLabel rootBeerDietImg = getImages("images/root_beer.PNG",40,70);
        JLabel starryImg= getImages("images/starry.PNG",40,70);
        JLabel lemonadeImg = getImages("images/Lemonade.jpg",40,70);


        //buttons
        JButton backButton = getBackButton();
        JButton pizzaButton = getPizzaButton();
        JButton sidesButton = getSidesButton();
        JButton drinksButton = getDrinksButton();
        JButton addPepsi = getAddButton("Pepsi");
        JButton addPepsiDiet = getAddButton("Pepsi Diet");
        JButton addOrange = getAddButton("Orange");
        JButton addOrangeDiet = getAddButton("Orange Diet");
        JButton addBeer = getAddButton("Root Beer");
        JButton addBeerDiet = getAddButton("Root Beer Diet");
        JButton addStarry = getAddButton("Starry");
        JButton addLemonade = getAddButton("Lemonade");

        //boxes
        JPanel box1 =   box("Regular");
        JPanel whiteBox1 = box("White");
        JLabel pepsiText = getItemText("PEPSI");

        JPanel box2 =   box("Regular");
        JPanel whiteBox2 = box("White");
        JLabel pepsiDietText = getItemText("PEPSI DIET");

        JPanel box3 =   box("Regular");
        JPanel whiteBox3 = box("White");
        JLabel OrangeText = getItemText("ORANGE");

        JPanel box4 =   box("Regular");
        JPanel whiteBox4 = box("White");
        JLabel OrangeDietText = getItemText("ORANGE DIET");

        JPanel box5 =   box("Regular");
        JPanel whiteBox5 = box("White");
        JLabel beerText = getItemText("ROOT BEER");

        JPanel box6 =   box("Regular");
        JPanel whiteBox6 = box("White");
        JLabel beerDietText = getItemText("DIET ROOT BEER");

        JPanel box7 =   box("Regular");
        JPanel whiteBox7 = box("White");
        JLabel starryText = getItemText("STARRY");

        JPanel box8 =   box("Regular");
        JPanel whiteBox8 = box("White");
        JLabel lemonadeText = getItemText("LEMONADE");



        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.CENTER);
        header.add(headLogo);
        lwrSection.add(backButton);
        lwrSection.add(drinksText);
        lwrSection.add(pizzaButton);
        lwrSection.add(sidesButton);
        lwrSection.add(drinksButton);
        lwrSection.add(box1);
        lwrSection.add(box2);
        lwrSection.add(box3);
        lwrSection.add(box4);
        lwrSection.add(box5);
        lwrSection.add(box6);
        lwrSection.add(box7);
        lwrSection.add(box8);
        lwrSection.add(addPepsi);
        lwrSection.add(addPepsiDiet);
        lwrSection.add(addOrange);
        lwrSection.add(addOrangeDiet);
        lwrSection.add(addPepsi);
        lwrSection.add(addBeer);
        lwrSection.add(addBeerDiet);
        lwrSection.add(addStarry);
        lwrSection.add(addLemonade);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addComponentListener(new ResizeListener(header, lwrSection, headLogo,backButton,pizzaButton,sidesButton, drinksButton,box1,box2,box3,box4,box5,box6,box7,box8,pepsiText,pepsiDietText,OrangeText,OrangeDietText,beerText,beerDietText,starryText,lemonadeText,pepsiImg,pepsiDietImg,pepsiOrangeImg,pepsiOrangeDietImg,rootBeerImg,rootBeerDietImg,starryImg,lemonadeImg,addPepsi,addPepsiDiet,addOrange,addOrangeDiet,addBeer,addBeerDiet,addStarry,addLemonade,whiteBox1,whiteBox2,whiteBox3,whiteBox4,whiteBox5,whiteBox6,whiteBox7,whiteBox8,drinksText));

        frame.setVisible(true);
    }

        private JButton getAddButton(String drink){
            JButton add = new JButton();
            add.setText("Add");
            add.setFont(new Font(null,Font.PLAIN,15));
            add.setForeground(Color.WHITE);
            add.setBackground(new Color(58, 34, 32));

            add.setFocusPainted(false);
            add.setContentAreaFilled(false);
            add.setBorderPainted(false);
            add.setOpaque(true);

            add.addActionListener(e -> {
                switch (drink) {
                    case "Pepsi":
                        //add pepsi
                        System.out.println("Pepsi added");
                        break;
                    case "Pepsi Diet":
                        //add pepsi diet
                        System.out.println("Pepsi diet added");
                        break;
                    case "Orange":
                        //add orange
                        System.out.println("orange added");
                        break;
                    case "Orange Diet":
                        System.out.println("Orange diet added");
                        break;
                    case "Root Beer":
                        System.out.println("Beer added");
                        break;
                    case "Root Beer Diet":
                        System.out.println("beer diet added");
                        break;
                    case "Starry":
                        System.out.println("Starry added");
                        break;
                    case "Lemonade":
                        System.out.println("Lemonade added");
                        break;
                }

            });
            return add;
        }

        private JLabel getImages(String url, int width, int height){
        // to change the image location change the parameter
            ImageIcon imageIcon = new ImageIcon(url);
            Image originalImage = imageIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(width,height,Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);

            JLabel img = new JLabel();
            img.setIcon(icon);

            return img;
        }
        @Override
        protected JButton getPizzaButton(){
            JButton pizzaButton = super.getPizzaButton();
            pizzaButton.setForeground(new Color(58, 34, 32));
            pizzaButton.setBackground(Color.WHITE);
            return pizzaButton;
        }
    @Override
    protected JButton getDrinksButton(){
        JButton drinksButton = super.getDrinksButton();
        drinksButton.setForeground(Color.white);
        drinksButton.setBackground(new Color(58, 34, 32));
        return drinksButton;
    }

    private static class ResizeListener extends ComponentAdapter {
        private final JPanel header;
        private final JPanel lwrSection;
        private final JLabel headLogo;
        private final JButton pizzaButton, sidesButton, drinksButton, backButton,
                addPepsi, addPepsiDiet,  addOrange,  addOrangeDiet,  addBeer,  addBeerDiet,  addStarry,  addLemonade;
        private final  JPanel box1,  box2,  box3,  box4,  box5,  box6, box7,  box8,
         whiteBox1,  whiteBox2,  whiteBox3,  whiteBox4,  whiteBox5,  whiteBox6,  whiteBox7,  whiteBox8;
        private final  JLabel drinksText, pepsiText,  pepsiDietText,  orangeText,  orangeDietText,  beerText,  beerDietText,  starryText,  lemonadeText,
         pepsiImg,  pepsiDietImg,  orangeImg,  orangeDietImg,  beerImg,  beerDietImg,  starryImg,  lemonadeImg;



        ResizeListener(JPanel header, JPanel lwrSection, JLabel headLogo, JButton backButton,JButton pizzaButton, JButton sidesButton, JButton drinksButton,
                        JPanel box1, JPanel box2, JPanel box3, JPanel box4, JPanel box5, JPanel box6,JPanel box7, JPanel box8,
                       JLabel pepsiText, JLabel pepsiDietText, JLabel orangeText, JLabel orangeDietText, JLabel beerText, JLabel beerDietText, JLabel starryText, JLabel lemonadeText,
                       JLabel pepsiImg, JLabel pepsiDietImg, JLabel orangeImg, JLabel orangeDietImg, JLabel beerImg, JLabel beerDietImg, JLabel starryImg, JLabel lemonadeImg,
                       JButton addPepsi,JButton addPepsiDiet, JButton addOrange, JButton addOrangeDiet, JButton addBeer, JButton addBeerDiet, JButton addStarry, JButton addLemonade,
                       JPanel whiteBox1, JPanel whiteBox2, JPanel whiteBox3, JPanel whiteBox4, JPanel whiteBox5, JPanel whiteBox6, JPanel whiteBox7, JPanel whiteBox8,JLabel drinksText) {
            this.header = header;
            this.lwrSection = lwrSection;
            this.headLogo = headLogo;
            this.backButton = backButton;
            this.pizzaButton = pizzaButton;
            this.sidesButton = sidesButton;
            this.drinksButton = drinksButton;
            this.box1 = box1;
            this.box2 = box2;
            this.box3 = box3;
            this.box4 = box4;
            this.box5 = box5;
            this.box6 = box6;
            this.box7 = box7;
            this.box8 = box8;
            this.pepsiText = pepsiText;
            this.pepsiDietText = pepsiDietText;
            this.orangeText = orangeText;
            this.orangeDietText = orangeDietText;
            this.beerText = beerText;
            this.beerDietText = beerDietText;
            this.starryText = starryText;
            this.lemonadeText = lemonadeText;
            this.pepsiImg = pepsiImg;
            this.pepsiDietImg = pepsiDietImg;
            this.orangeImg = orangeImg;
            this.orangeDietImg = orangeDietImg;
            this.beerImg = beerImg;
            this.beerDietImg = beerDietImg;
            this.starryImg = starryImg;
            this.lemonadeImg = lemonadeImg;
            this.addPepsi = addPepsi;
            this.addPepsiDiet = addPepsiDiet;
            this.addOrange = addOrange;
            this.addOrangeDiet = addOrangeDiet;
            this.addBeer = addBeer;
            this.addBeerDiet = addBeerDiet;
            this.addStarry = addStarry;
            this.addLemonade = addLemonade;
            this.whiteBox1 = whiteBox1;
            this.whiteBox2 = whiteBox2;
            this.whiteBox3 = whiteBox3;
            this.whiteBox4 = whiteBox4;
            this.whiteBox5 = whiteBox5;
            this.whiteBox6 = whiteBox6;
            this.whiteBox7 = whiteBox7;
            this.whiteBox8 = whiteBox8;
            this.drinksText = drinksText;

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
            drinksText.setBounds(200, 35,frameWidth/2,frameHeight/6);
            pizzaButton.setBounds(10, 100, (75), 40);
            sidesButton.setBounds(10,150,(75), 40);
            drinksButton.setBounds(50,200,(75), 40);




            //box1
            box1.setBounds(200,100,120, 120);
            box1.add(whiteBox1);
            whiteBox1.setBounds(7,17,105,80);
            box1.add(pepsiText);
            pepsiText.setBounds(50,0,45,20);
            whiteBox1.add(pepsiImg);
            pepsiImg.setBounds(35,5,40,70);
            //box2
            box2.setBounds(340,100,120, 120);
            box2.add(whiteBox2);
            whiteBox2.setBounds(7,17,105,80);
            box2.add(pepsiDietText);
            pepsiDietText.setBounds(40,0,65,20);
            whiteBox2.add(pepsiDietImg);
            pepsiDietImg.setBounds(25,5,40,70);
            //box3
            box3.setBounds(480,100,120, 120);
            box3.add(whiteBox3);
            whiteBox3.setBounds(7,17,105,80);
            box3.add(orangeText);
            orangeText.setBounds(40,0,65,20);
            whiteBox3.add(orangeImg);
            orangeImg.setBounds(35,5,40,70);
            //box4
            box4.setBounds(620,100,120, 120);
            box4.add(whiteBox4);
            whiteBox4.setBounds(7,17,105,80);
            box4.add(orangeDietText);
            orangeDietText.setBounds(30,0,65,20);
            whiteBox4.add(orangeDietImg);
            orangeDietImg.setBounds(35,5,40,70);

            //box5
            box5.setBounds(200,240,120, 120);
            box5.add(whiteBox5);
            whiteBox5.setBounds(7,17,105,80);
            box5.add(beerText);
            beerText.setBounds(40,0,65,20);
            whiteBox5.add(beerImg);
            beerImg.setBounds(35,5,40,70);;
            //box6
            box6.setBounds(340,240,120, 120);
            box6.add(whiteBox6);
            whiteBox6.setBounds(7,17,105,80);
            box6.add(beerDietText);
            beerDietText.setBounds(20,0,85,20);
            whiteBox6.add(beerDietImg);
            beerDietImg.setBounds(35,5,40,70);
            //box7
            box7.setBounds(480,240,120, 120);
            box7.add(whiteBox7);
            whiteBox7.setBounds(7,17,105,80);
            box7.add(starryText);
            starryText.setBounds(45,0,65,20);
            whiteBox7.add(starryImg);
            starryImg.setBounds(35,5,40,70);
            //box8
            box8.setBounds(620,240,120, 120);
            box8.add(whiteBox8);
            whiteBox8.setBounds(7,17,105,80);
            box8.add(lemonadeText);
            lemonadeText.setBounds(35,0,65,20);
            whiteBox8.add(lemonadeImg);
            lemonadeImg.setBounds(35,5,40,70);


            //add Buttons
            box1.add(addPepsi);
            addPepsi.setBounds(20,105,75,10);
            box2.add(addPepsiDiet);
            addPepsiDiet.setBounds(20,105,75,10);
            box3.add(addOrange);
            addOrange.setBounds(20,105,75,10);
            box4.add(addOrangeDiet);
            addOrangeDiet.setBounds(20,105,75,10);
            box5.add(addBeer);
            addBeer.setBounds(20,105,75,10);
            box6.add(addBeerDiet);
            addBeerDiet.setBounds(20,105,75,10);
            box7.add(addStarry);
            addStarry.setBounds(20,105,75,10);
            box8.add(addLemonade);
            addLemonade.setBounds(20,105,75,10);

        }
    }
}
