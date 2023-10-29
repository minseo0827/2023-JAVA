import java.awt.Graphics;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
	
class mypanel extends JPanel {
	
		ImageIcon icon;
		
		public mypanel() {
			icon=new ImageIcon("C://dog1.jpg");
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(icon.getImage(), 20, 20, 80, 80, this);		
			g.drawString("김덕성", 150, 40);
			g.drawString("프로젝트 매니저", 150, 60);
			g.drawString("덕성주식회사", 150, 80);
		}
	}
	
class namecard extends JFrame {
	public namecard() {
		
//		JLabel nameJLabel=new JLabel("김덕성");
//		JLabel jobLabel=new JLabel("프로젝트 매니저");
//		JLabel comLabel=new JLabel("덕성주식회사");
		/* ImageIcon icon=new ImageIcon("C:/dog2.jpg"); */
		//사진을레이벨에넣는게아니고 그래픽활용..이겟지?
		//레이벨이라면
		//Jlabel label=new jlabel();
		//Label.setIcon(icon); 이거던가?
		
		setSize(600,180);
		setTitle("BusinessCard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new mypanel()); //패널을상속받은 저 위에서 다 집어너놓고 여기서는 그 애만 애드. 애드 뉴 00()의 형식.
		setVisible(true);
	}
	
}
public class namecardtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		namecard namecard=new namecard();
		//생성되는건 프레임을상속받은앵야..하고.

	}

}
