import javax.swing.*;
import java.awt.*;
public class CountDownTest2 extends JFrame {
	private JLabel label;

	Thread t;
	class MyThread extends Thread {
		public void run() {

			for (int i = 0; i <=10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
				label.setText(i + "");
			}

		}
	}

	public CountDownTest2() {
		setTitle("카운트다운");
		setSize(400, 150);
		getContentPane().setLayout(null);
		label = new JLabel("0");
		label.setBounds(0, 0, 384, 111);   
		label.setFont(new Font("Serif", Font.BOLD, 100));
		getContentPane().add(label);
		
		JButton btnNewButton=new JButton("카운터 중지");
		btnNewButton.setBounds(247, 25, 125, 23);
		btnNewButton.addActionListener(e->t.interrupt());
		getContentPane().add(btnNewButton);
		
		
		setVisible(true);
		t=new MyThread();
		t.start();
		

	}

	public static void main(String[] args) {
		CountDownTest2 t = new CountDownTest2();
	}
}