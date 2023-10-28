import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class db extends JFrame {
	
	public db() {
		JPanel panel=new JPanel();
		JLabel l1=new JLabel("회원 등록하기"); JLabel l2=new JLabel("이름"); JLabel l3=new JLabel("패스워드"); JLabel l4=new JLabel("이메일 주소"); JLabel l5=new JLabel("전화번호");
		JTextField f1=new JTextField(10); JTextField f2=new JTextField(10); JTextField f3=new JTextField(10); JTextField f4=new JTextField(10);
		JButton b1=new JButton("등록하기"); JButton b2=new JButton("취소");
		
		panel.add(l1); 
		panel.add(l2); panel.add(f1); panel.add(l3); panel.add(f2); panel.add(l4); panel.add(f3); panel.add(l5); panel.add(f4);
		panel.add(b1); panel.add(b2);
		add(panel);
		
		setSize(500, 300);
		setVisible(true);
	}
}
public class 과제0301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		db db=new db();

	}

}
