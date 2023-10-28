//버튼을클릭하면 카운트가 올라가게하기

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class buttoncount extends JFrame {
	JPanel panel;
	JButton button;
	JLabel label;
	int count=0;
	
	//전역변수로만들기
	
	//생성자
	public buttoncount() {
		panel=new JPanel();
		button=new JButton("누르면 숫자 올라감");
		button.addActionListener(new lis()); //뉴!!!!!!!!!!!!1를자꾸빼먹느다 뉴 마이리스너
		label=new JLabel("현재의 카운트: "+count);
		
		panel.add(button);
		panel.add(label);
		add(panel);
		
		setSize(500, 300);
		setVisible(true);
	}
	
	//리스너
	class lis implements ActionListener {
		//우리가하는거는메소드를완성짓는거
		public void actionPerformed(ActionEvent e) { //이거 대문자까지다맞아야실행된다!!!!!!!!!
			count++;
			label.setText("현재의 카운트: "+count); //텍스트랑도이어주고....
		}
	}
	
}

public class 내부클래스응용 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buttoncount buttoncount=new buttoncount();

	}


}
