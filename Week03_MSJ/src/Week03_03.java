import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Week03_03 extends JFrame implements ActionListener {
    int img_x = 150, img_y = 150;
    JButton leftButton;  
    JButton rightButton; 
    JButton carButton;

    public Week03_03() {
        setSize(600, 300);

      
        carButton = new JButton("");
        ImageIcon carIcon = new ImageIcon("C://car.png");
        carButton.setIcon(carIcon);
        carButton.setBounds(img_x, img_y, carIcon.getIconWidth(), carIcon.getIconHeight());

      
        leftButton = new JButton("LEFT");
        leftButton.addActionListener(this);
        leftButton.setBounds(50, 200, 100, 30);

       
        rightButton = new JButton("RIGHT");
        rightButton.addActionListener(this);
        rightButton.setBounds(450, 200, 100, 30);
        
        
 
        //사이즈변경해야함
        ImageIcon icon = new ImageIcon("C://car.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        
        carButton = new JButton(icon);
        carButton.setBounds(img_x, img_y, 200, 100);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(leftButton);
        panel.add(rightButton);
        panel.add(carButton);

        add(panel, BorderLayout.CENTER);
        panel.requestFocus();
        panel.setFocusable(true);
        
        
      
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftButton) {
    
            img_x -= 10;
        } else if (e.getSource() == rightButton) {
       
            img_x += 10;
        }

   
        carButton.setBounds(img_x, img_y, carButton.getWidth(), carButton.getHeight());
        repaint();
    }

    public static void main(String[] args) {
        Week03_03 c = new Week03_03();
        c.setVisible(true);
    }
}
