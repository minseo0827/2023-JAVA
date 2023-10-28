//일단 리스너자체는간단할지라도 많이해서 익수갷져야한다
//버튼1을 클릭하면 패널색이 버튼2를클릭하면 버튼색이변하는예제

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class pb extends JFrame {
	
	JPanel panel;
	JButton b1;
	JButton b2;
	
	public pb() {
		panel=new JPanel();
		b1=new JButton("패널 색 바꾸기");
		b2=new JButton("버튼 색 바꾸기");
		b1.addActionListener(e-> {if(e.getSource()==b1) { panel.setBackground(Color.yellow); }
		else if(e.getSource()==b2) { b2.setBackground(Color.orange);}}); //뉴마이리스너괄호!!!!!!!!!!!!
		b2.addActionListener(e-> {if(e.getSource()==b1) { panel.setBackground(Color.yellow); }
		else if(e.getSource()==b2) { b2.setBackground(Color.orange);}});
		
		panel.add(b1); panel.add(b2); add(panel);
		setSize(500, 300); setVisible(true);
	}
	
	//내부클래스니까일단클래스생성
//	class mylis implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			
//			//버튼같은거일때는 e.getsource 인가봐...
//		}
//	}
}
	
public class 버튼클릭하면패널색변함 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pb pb=new pb();
		


}

}