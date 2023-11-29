import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//416ㅠㅔ이지 프레임레이블버튼등... 원하는화면을직접마들수있어야한다
public class ImageLabelTest1 extends JFrame {
	private JPanel panel, panel2;
	private JLabel label;
	private JButton button1, button2, button3, button4;
	
	public ImageLabelTest1() {
		setTitle("image viewer");
		setSize(400, 250);
		
		panel=new JPanel();
		panel2=new JPanel();
		label=new JLabel("이름: ");
		ImageIcon icon=new ImageIcon("d://puppy.jpg");
		label.setIcon(icon);
		panel2.add(label);
		button1=new JButton("<<");
		button2=new JButton("<");
		button3=new JButton(">");
		button4=new JButton(">>");
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		add(panel2, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		ImageLabelTest1 t=new ImageLabelTest1();
	}
}
