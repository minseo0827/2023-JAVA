/*import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class carcheckbox extends JFrame{
	int sum=0;
	JPanel panel;
	JLabel label;
	JCheckBox b1; JCheckBox b2; JCheckBox b3; JCheckBox b4;
	
	public carcheckbox() {
		panel=new JPanel();
		label= new JLabel();
		b1=new JCheckBox("엔진오일 교환"); b2=new JCheckBox("자동변속기오일 교환"); b3=new JCheckBox("에어컨 필터 교환"); b4=new JCheckBox("타이어 교환");
		panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4); panel.add(label); 
		add(panel);
		
		b1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				sum=sum+45000;
				label.setText("현재까지의 가격은 "+sum+"입니다.");	
			}
		});
		
		//오.좋긴한데 한번더선택해서해제되엇는데도가격이더추가됨..이건 e.getchanged어쩌구가 2면 돈 빼면될듯?
		b2.addItemListener(e-> {sum=sum+80000;
				label.setText("현재까지의 가격은 "+sum+"입니다.");});
		b3.addItemListener(e-> {sum=sum+30000;
				label.setText("현재까지의 가격은 "+sum+"입니다.");});
		b4.addItemListener(e-> {sum=sum+100000;
				label.setText("현재까지의 가격은 "+sum+"입니다.");});
		
		setSize(500, 300);
		setVisible(true);
	}
}

*
*public class carcheckboxtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		carcheckbox carcheckbox=new carcheckbox();
	}

}
*/

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class repaircar extends JPanel implements ItemListener {
	JCheckBox[] buttons = new JCheckBox[4]; //배열을이용하겟다... 얘도배ㅕ열로만들겟다...
	String[] items= {"엔진오일", "자동변속기", "에어컨필터", "타이어"};
	int[] prices= {45, 80, 30, 100};
	int money=0;
	JLabel label;
	
	public repaircar() {
		super();
		//배열...을쓰느건어렵네... 하나씩갖고오는걸포문돌려도되나?가격은또왜배열이지...아이템리스너는또머고....
		for (int i = 0; i < 4; i++) { //포문되네..하나씩갖고와서체크박스에집어넣기
			buttons[i] = new JCheckBox(items[i]); //버튼1에 엔진오일을넣것다
			buttons[i].addItemListener(this);
		}
		for (int i = 0; i < 4; i++)
			add(buttons[i]); //버튼을추가하고.
		label = new JLabel("현재까지의 가격은"+money+"입니다.");
//		label.setFont(new Font("Serif", 	// 레이블에 폰트를 설정한다. 
//				Font.BOLD | Font.ITALIC, 30)); //그닥큰의미없
		add(label);
	}

	/** 체크 박스의 아이템 이벤트를 처리한다. */
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		for (int i = 0; i < 4; i++) {
			if (source == buttons[i]) {
				if (e.getStateChange() == ItemEvent.DESELECTED)
					money -= prices[i];
				else
					money += prices[i];
				label.setText("현재까지의 가격은"+money+"입니다.");
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new Repair();
		newContentPane.setVisible(true); 
		frame.setContentPane(newContentPane);
		frame.setSize(500, 200);
		frame.setVisible(true);
	}
}
