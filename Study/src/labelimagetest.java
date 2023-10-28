import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class labelimage extends JFrame {
//	private JLabel label;
//	private JPanel panel; //이런것도..되기는한다....근데굳이?일더하는느낌
	public labelimage() {
		JButton button1=new JButton("<<");
		JButton button2=new JButton("<");
		JButton button3=new JButton(">");
		JButton button4=new JButton(">>");
		JPanel panel = new JPanel();
		JLabel label=new JLabel();
		//JLabel label2=new JLabel("강아지의 이름 입력");
		
		ImageIcon icon=new ImageIcon("C://dog.jpg"); //제이버튼 제이레이벨처럼 이미지아이콘이라는게잇는거고 그걸하나만들고
		label.setIcon(icon); //레이벨에붙이기ㅣ
		
		JTextField textField=new JTextField(30);
		//textField.setText("한글로 입력");
		panel.add(label);
		//panel.add(label2);
		panel.add(textField);
		
		panel.add(button1); panel.add(button2); panel.add(button3); panel.add(button4);
		add(panel);
		
		System.out.print(textField.getText());
		
		setSize(1000, 700);
		setVisible(true);
		
	}
}
public class labelimagetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		labelimage iLabelimage=new labelimage();

	}

}
