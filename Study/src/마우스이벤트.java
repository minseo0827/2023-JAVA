import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class mouseeventtest extends JFrame {
	public mouseeventtest() {
		JLabel label=new JLabel("default");
		label.setForeground(Color.orange);
		label.setFont(new Font("Arial", Font.ITALIC, 30));
		label.addMouseListener(new MouseAdapter() {
			public void mouseEntered (MouseEvent e) {
				JLabel second=(JLabel)e.getSource();
//e.getSource(): 이벤트 객체 e의 getSource() 메서드는 이벤트를 발생시킨 컴포넌트(또는 객체)를 반환합니다. 즉, 이벤트가 발생한 컴포넌트에 대한 참조를 얻을 수 있습니다.
//(JLabel) e.getSource(): e.getSource()에서 반환되는 값은 Object 형식, 이것을 JLabel 형식으로 캐스팅. 이를 통해 해당 컴포넌트를 JLabel로 사용할 수 있게 됩니다.
				second.setText("마우스 올리면 이렇고");
			}
		
		public void mouseExited (MouseEvent e) {
			JLabel second=(JLabel)e.getSource();	
			second.setText("마우스 내리면 이럼");
		}
	});
	
		add(label);
		setSize(500, 300);
		setVisible(true);
		
	}
}
public class 마우스이벤트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mouseeventtest mouseeventtest=new mouseeventtest();
	}

}
