//배경색이 하늘색이고 버튼이 세개인 프레임만들기

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame; //오..자동생성되네

//!!!!!!!!!!!!!!!괄호는 클래스젤윗줄작성시를 제외하고는 항상필요하다...!!!!!!!!!!!!!!!
class Myframe extends JFrame {
	public Myframe() { //생성자를만들어주는거!!고 생성자를만들어줄때는 생성시인자를주게할수도잇어서 괄호필요
		setSize(300, 200);
		setTitle("first");
		getContentPane().setBackground(Color.cyan); //그 컴포넌트들을붙이는유리판인 콘텐트페인의 백그라운드를 색조정
		
		setLayout(new FlowLayout()); //삽입할 컴포넌트의 레이아웃을어케할건가
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		add(b1);
		add(b2);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //프레임을 닫을 때 애플리케이션을 종료 즉, 윈도우를 닫으면 애플리케이션이 종료. 일종의옵션인듯
		//다 만드엇으면 마지막에 비지블 트루로해줘야하는거고.
	}
	
	
	
	
}
public class Framepractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myframe myframe=new Myframe();

	}

}
