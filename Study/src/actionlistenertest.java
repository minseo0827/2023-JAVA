import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class altest extends JFrame {
    public altest() {
        JPanel panel = new JPanel();
        JButton b1 = new JButton("노란색");
        JButton b2 = new JButton("핑크색");

        b1.addActionListener(e -> panel.setBackground(Color.yellow)); // 람다 표현식 사용
        //b1에 액션리스너를달고. 이벤트를받으면 패널의색을바꾼다... 이거는할수잇는데이제...다른건어카냐?
        b2.addActionListener(e -> panel.setBackground(Color.pink));   // 람다 표현식 사용
        //이렇게간단하게..처리할수잇다.... 

        panel.add(b1);
        panel.add(b2);

        add(panel);
        setSize(500, 300);
        setVisible(true);
    }

} 
     
public class actionlistenertest { 	
    public static void main(String[] args) {
        altest frame = new altest();
    }
}



//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.net.http.WebSocket.Listener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//class altest extends JFrame implements ActionListener {
//	public altest() {
//		
//		JPanel panel=new JPanel();
//		JButton b1=new JButton("노란색");
//		JButton b2=new JButton("핑크색");
//		b1.addActionListener(this);
//		b2.addActionListener(this);
//
//		
//		panel.add(b1);
//		panel.add(b2);
//		
//		add(panel);
//		setVisible(true);
//		
//	}
//	
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()==b1) {panel.setBackgrounf(Color.yellow); }
//		else if(e.getSource()==b2) {panel.setBackgrounf(Color.pink); 
//}
//public class actionlistenertest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
