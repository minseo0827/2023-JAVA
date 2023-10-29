import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class rbt extends JFrame {
	
	JPanel panel;
	JLabel label1;
	JLabel label2;
	JRadioButton b1;
	JRadioButton b2;
	JRadioButton b3;
	//생성자밖에선이렇게이름만붙여주는거. 이렇게해놧으면 생성자안에서 전체구문다쓰면안됨! 파란글씨로뜨면잘된거
	
	public rbt () {
		panel=new JPanel();
		label1=new JLabel("피자 크기 선택"); label2=new JLabel();
		b1=new JRadioButton("S"); b2=new JRadioButton("M"); b3=new JRadioButton("L");
		
		ButtonGroup bGroup=new ButtonGroup();
		bGroup.add(b1); bGroup.add(b2); bGroup.add(b3); //버튼그룹에집어넣고
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//하나하나달아줄거니까 if쓸것도없지
				label2.setText("S크기가 선택되었습니다.");
				//System.out.print("S크기가 선택되었습니다.");	
				//화면에 레이벨의 형태로 글씨 뜨게 하고싶으면 레이벨1.setText 로하기..문자열만가능! 20+""의 꼼수
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label2.setText("M크기가 선택되었습니다.");		
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label2.setText("L크기가 선택되었습니다.");		
			}
		});
		
		
		//아 add안해줫네
		panel.add(label1); panel.add(b1); panel.add(b2); panel.add(b3); panel.add(label2);
		add(panel);
		setSize(500, 300);
		setVisible(true);
	}
	
}


public class radiobuttontest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rbt rbt=new rbt();

	}

}
