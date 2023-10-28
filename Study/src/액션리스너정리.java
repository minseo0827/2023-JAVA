//내부클래스/람다로 구현

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class pushbutton extends JFrame {
	JPanel panel;
	JButton button;
	
	public pushbutton() {
		panel=new JPanel();
		button=new JButton("누르면 색이 변함");
		button.addActionListener(new mylisten()); //뉴 이름() 여기도괄호네진짜....괄호다들어가네.... 객체니까..?
		
		panel.add(button);
		add(panel);
		
		
		setSize(500, 300);
		setVisible(true);
		
	}
	
	class mylisten implements ActionListener {
		//인터페이스를구현하는것이므로 완성하는건메소드!!!!!!!!! 퍼블릭 보이드!!!!!!!!!!!!!! 
		public void actionPerformed(ActionEvent e) {
			panel.setBackground(Color.green);
		}
		
	}
}


public class 액션리스너정리 { 	
    public static void main(String[] args) {
    	pushbutton pushbutton=new pushbutton();
        
    }
}

