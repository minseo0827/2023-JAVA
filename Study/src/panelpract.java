import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.TextUI;


class Mypanel extends JFrame {
	public Mypanel() { //클래스생성젤윗줄만빼고괄호다들어감!!!!!!!
		setSize(500, 300);
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		/*p1.setSize(500, 150);
		p2.setSize(500, 150);
JPanel은 기본적으로 그리드 레이아웃을 사용하며, 크기를 직접 설정하는 대신 컴포넌트의 내용에 따라 크기가 동적으로 조정됩니다.
따라서 setSize 메서드를 호출하여 JPanel의 크기를 설정하더라도 기본적으로 동작하지 않을 수 있습니다*/
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.pink);
		
		
		//setLayout(new FlowLayout()); //버튼생성전에 항상 레이아웃을 만들어줘야함
		//음..이건 옆으로나란히가네
		setLayout(new BorderLayout()); //음..얘는좀요상하긴한데하여튼위아래다
		
		JButton b1=new JButton("위에거");
		JButton b2=new JButton("아래거");
		b1.setBackground(Color.green);
		b2.setBackground(Color.cyan);
		p1.add(b1);
		p2.add(b2);
		add(p1, "North"); //젤상위의것에 애드할때는 딱히 어디에넣는건지 안써줘도된다
		add(p2, "South");
	
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
