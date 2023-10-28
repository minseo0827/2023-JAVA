import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class panelinpanel extends JFrame {
	public panelinpanel() {
		JPanel panel1=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		
		JLabel label=new JLabel("자바 피자에 어서오세요! 피자 종류 선택");
		p1.add(label);
		
		JButton b1=new JButton("콤보피자");
		JButton b2=new JButton("포테이토피자");
		JButton b3=new JButton("불고기피자");
		JLabel l1=new JLabel("개수");
		JTextField textField=new JTextField(10);
		p2.add(b1); p2.add(b2); p2.add(b3); p2.add(l1); p2.add(textField);
		
		panel1.add(p1);
		panel1.add(p2);
		add(panel1);
		
		setSize(500, 300);
		setVisible(true);
		
		
		
		
	}
}
public class 패널안에패널연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		panelinpanel panelinpanel= new panelinpanel();

	}

}
