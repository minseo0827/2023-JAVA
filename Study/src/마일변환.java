//내부클래스-->람다

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class miletras extends JFrame {
	JPanel panel;
	JButton button;
	JLabel label1;
	JLabel label2;
	JTextField textField1;
	JTextField textField2;
	
	
	public miletras() {
		panel=new JPanel();
		label1=new JLabel("마일을 입력"); label2=new JLabel("->");
		textField1=new JTextField(10); textField2=new JTextField(10);
		button=new JButton("변환");
		panel.add(label1); panel.add(textField1); panel.add(label2); panel.add(textField2); panel.add(button);
		add(panel);
		
		button.addActionListener(new mylisten());
		
		setSize(500,300);
		setVisible(true);
	}
	
	
	class mylisten implements ActionListener { //뭐. 액션리스너만구현할수잇으면된다..
		public void actionPerformed(ActionEvent e) {
			String mileText=textField1.getText(); //근데얘도문자열만가져오는데.. float포기!
			double mile= Double.parseDouble(mileText); //뭔가이런게...잇나봐...
			double km=mile*1.60934;
			textField2.setText(km+"km"); //settext는 항상 문자열만을반환해주는듯...정수를 반환할거면 +"" 해서 암거나써줘야한다 혹은비워놓더라도..
		}
	}
}
public class 마일변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		miletras miletras=new miletras();

	}

}
