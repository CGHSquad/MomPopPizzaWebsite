import javax.swing.*;
import java.awt.*;
public class FrontEnd {
    public void CreateWindow(){
        JFrame frame = new JFrame("Mom and Pops Pizzeria");

        JPanel header = new JPanel();
        header.setBackground(new Color(58, 34, 32));
        header.setPreferredSize(new Dimension(800, 150));


        JPanel lwrSection = new JPanel();
        lwrSection.setBackground(Color.WHITE);

        frame.setLayout(new BorderLayout());
        frame.add(header, BorderLayout.NORTH);
        frame.add(lwrSection, BorderLayout.SOUTH);

        JLabel label = new JLabel();
        label.setText("This is a test");
        label.setFont(new Font(null, Font.PLAIN,24));
        label.setBounds(400,250,150,50);

        frame.add(label);
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
