import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class calcul extends JFrame {
	JPanel panel;
	JLabel label1;
	JLabel label2;
	JTextField t1;
	JTextField t2;
	JButton button;
	
	
	public calcul() {
		panel=new JPanel();
		label1=new JLabel("숫자 입력"); label2=new JLabel("제곱한 값");
		t1=new JTextField(5); t2=new JTextField(5);
		button=new JButton("OK");
		//아하.위에서정의햇으면 다시정의하지마ㅏ라.. jlabel label1=new jlabel 이러면안된다
		
		button.addActionListener(new mylistener());
		panel.add(label1); panel.add(t1); panel.add(label2); panel.add(t2); panel.add(button);
		add(panel);
		
		setSize(500, 300);
		setVisible(true);
	}
	
	class mylistener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name=t1.getText(); //아주간단하게 겟텍스트.
			int value=Integer.parseInt(name); //이.. parse애들이 자료형을바꿔주는앤가봐?
			t2.setText(""+value*value); //getText도 setText도 전부 문자열의형태로만빼낼수잇으므로 parseInt, ""+ 등의 방법을 이용해야한다.
			t1.requestFocus(); //이게 있어야 이벤트를읽어올수잇다고.
			
		}
	}
}
public class 제곱계산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calcul calcul= new calcul();
	}

}
