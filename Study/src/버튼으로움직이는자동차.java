import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class buttoncar extends JFrame {
   
   JPanel panel;
   JLabel label;
   //JButton button;
   //JButton b1;
   //JButton b2;
   int img_x=150; int img_y=150;
   
   public buttoncar() {
      panel=new JPanel();
      label=new JLabel(); //레이벨에필요가없나.사진넣을때? 아니다..필요하다
      //button=new JButton("");
   
      ImageIcon icon=new ImageIcon("C:\\dog1.jpg");
      label.setIcon(icon);
      //button.setIcon(icon); //버튼에담는게깔끔할듯....
      
      //panel.setLayout(null); // 레이아웃 관리자를 사용하지 않고 위치를 직접 설정
      //button.setSize(200, 100);
      //b1.setSize(100, 50); b2.setSize(100, 50);

      label.setBounds(img_x, img_y, icon.getIconWidth(), icon.getIconHeight());
       
     JButton b1=new JButton("LEFT"); 
     JButton b2=new JButton("RIGHT");
      b1.setBounds(500, 900, 100, 30);
      b2.setBounds(750, 900, 100, 30);

      //액션리스너문제다.뭐가다르길래?
      b1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              img_x -= 10; // 왼쪽으로 10씩 이동
              //아시발..아!!!!! -=10!!!!!!!
              label.setLocation(img_x, img_y);
          }
      });

      b2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              img_x += 10; // 우측으로 10씩 이동
              label.setLocation(img_x, img_y);
          }
      });

      
      
      panel.setLayout(null);
      panel.add(label); panel.add(b1); panel.add(b2);
      add(panel);
      
      setSize(500, 300);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

   }
   

   
}
public class 버튼으로움직이는자동차 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      buttoncar c=new buttoncar();

   }

}