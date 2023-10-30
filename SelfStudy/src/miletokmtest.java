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
		
		
		button.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//텍스트필드에입력된스트링을갖고옥 더블로형변환하고 텍필2에표현
				String inputString=textField1.getText();
				double output=Double.parseDouble(inputString);
				//자료형.parse자료형(바꿀대상)
				Double resultDouble=output*1.609;
				textField2.setText(resultDouble+"km"); //문자열만가능하니까 +""해주기	
			}
			
			});	
	
		setSize(500,300);
		setVisible(true);
	
	
}
	
}
public class miletokmtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		miletras miletras=new miletras();

	}

}