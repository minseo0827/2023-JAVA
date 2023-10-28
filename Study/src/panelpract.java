import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.TextUI;


class Mypanel extends JFrame {
	public Mypanel() { //클래스생성젤윗줄만빼고괄호다들어감!!!!!!!
		setSize(1000, 700);
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.pink);
		
		setLayout(new FlowLayout()); //버튼생성전에 항상 레이아웃을 만들어줘야함
		//음..이건 옆으로나란히가네
		
		JButton b1=new JButton("위에거");
		JButton b2=new JButton("아래거");
		b1.setBackground(Color.green);
		b2.setBackground(Color.cyan);
		p1.add(b1);
		p2.add(b2);
		add(p1); //젤상위의것에 애드할때는 딱히 어디에넣는건지 안써줘도된다
		add(p2);
	
		//얘넨 항상 젤 마지막에.
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class panelpract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mypanel p=new Mypanel();

	}

}
