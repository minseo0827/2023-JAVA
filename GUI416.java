import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FontMetrics;

public class GUI416 extends JFrame {
	
	public GUI416() {
		
		JPanel panel = new JPanel(new GridLayout(5, 1));
		JLabel label = new JLabel("Red Yellow Green Blue");
		JButton buttonRed = new JButton();
		JButton buttonYellow = new JButton();
		JButton buttonGreen = new JButton();
		JButton buttonBlue = new JButton();
		
		buttonRed.setBackground(Color.red);
		buttonYellow.setBackground(Color.yellow);
		buttonGreen.setBackground(Color.green);
		buttonBlue.setBackground(Color.blue);
		
		// 라벨의 크기를 기준으로 버튼의 크기 설정
		FontMetrics metrics = label.getFontMetrics(label.getFont());
		int labelWidth = metrics.stringWidth(label.getText());
		int labelHeight = metrics.getHeight();
		Dimension buttonSize = new Dimension(labelWidth, labelHeight);
		
		buttonRed.setPreferredSize(buttonSize);
		buttonYellow.setPreferredSize(buttonSize);
		buttonGreen.setPreferredSize(buttonSize);
		buttonBlue.setPreferredSize(buttonSize);
		
		panel.add(label);
		panel.add(buttonRed);
		panel.add(buttonYellow);
		panel.add(buttonGreen);
		panel.add(buttonBlue);
		
		add(panel);
		setSize(400, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GUI416 gui = new GUI416();
	}
}
