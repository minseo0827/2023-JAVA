import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class altest1 extends JFrame {
	//아하....생성자밖에서정의해서 지역변수범위를좀늘리려고한거구나
	private JPanel panel;
    private JButton b1;
    private JButton b2;
    
    public altest1() {
    	 panel = new JPanel();
         b1 = new JButton("노란색");
         b2 = new JButton("핑크색");
         MyListener listener = new MyListener();
        
        b1.addActionListener(listener);
        b2.addActionListener(listener); //받은 액션을 이 리스너라는애안에다가담고..
        panel.add(b1);
        panel.add(b2);

        add(panel);
        setSize(500, 300);
        setVisible(true);
    } //여기까지가생성자
    
    
    //얘도 altest클래스안에있는거지 클래스안에서클래스정의..
    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {panel.setBackground(Color.yellow);} 
            else if (e.getSource() == b2) { panel.setBackground(Color.pink);}
        }
    }
}
     
public class 람다말고다른방법 { 	
    public static void main(String[] args) {
        altest1 frame = new altest1();
    }
}

