import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class myframeandlabel extends JFrame {
	public myframeandlabel() {
		JPanel p1= new JPanel();
		JLabel l1=new JLabel("레이블1");
		JLabel l2=new JLabel("그냥화면에표시만돼요");
		l1.setForeground(Color.red);
		l2.setForeground(Color.blue);
		//add하는순서가 실제로영햐을미침! 먼저애드되는게먼저들어간다..즉 더 앞쪽, 왼쪽인거.
		p1.add(l1);
		p1.add(l2);
		add(p1);
		
		setSize(500, 300);
		setVisible(true); //얘만해줘도되는듯..함
		
	}
}
public class labeltest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myframeandlabel m1=new myframeandlabel();

	}

}
