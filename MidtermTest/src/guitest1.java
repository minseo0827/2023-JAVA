import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

class student0 extends JFrame {
	
	JPanel panel1, panel2, panel3;
	JLabel l1, l2, l3, l4;
	JTextField nameField, idField, gradeField;
	JButton in, cancle;
	
	public student0() {
		panel1=new JPanel(); panel2=new JPanel(); panel3=new JPanel();
		l1=new JLabel("학생 등록하기"); l2=new JLabel("이름"); l3=new JLabel("학번"); l4=new JLabel("성적");
		nameField=new JTextField(10); idField=new JTextField(10); gradeField=new JTextField(10);
		in=new JButton("등록"); cancle=new JButton("취소");
		
		setLayout(new BorderLayout());
		panel1.add(l1);
		panel2.add(l2); panel2.add(nameField); panel2.add(l3); panel2.add(idField); panel2.add(l4); panel2.add(gradeField);
		panel3.add(in); panel3.add(cancle);
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER); 
		add(panel3, BorderLayout.SOUTH);
		
		
		in.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=nameField.getText();
				String idString=idField.getText();
				String gradeString=gradeField.getText();
				System.out.print("이름: "+name+" 학번: "+idString+" 성적: "+gradeString);
				
			}
		});
		
		
		setTitle("덕성여대 화이팅");
		setSize(500, 300);
		setVisible(true);
	}
	
	
}
public class guitest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		student0 student=new student0();
	}

}
