//버튼을클릭하면 카운트가 올라가게하기

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class buttoncount1 extends JFrame {
	JPanel panel;
	JButton button;
	JLabel label;
	int count=0;
	
	//전역변수로만들기
	
	//생성자
	public buttoncount1() {
		panel=new JPanel();
		button=new JButton("누르면 숫자 올라감");
		button.addActionListener(e-> { //뉴 마이리스너() 들어가던자리에 e->{괄호안 그대로} 들어가는느낌..내부클래스방식을할줄안다면 람다도가능
			count++;
			label.setText("현재의 카운트: "+count);//레이벨에표시해줄때 setText를 같이 써줘야한다고!
		});
		label=new JLabel("현재의 카운트: "+count);
		
		panel.add(button);
		panel.add(label);
		add(panel);
		
		setSize(500, 300);
		setVisible(true);
	}
	
}
public class 람다로하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buttoncount1 buttoncount=new buttoncount1();
}
}
