import javax.swing.*;
import java.awt.*;
public class CountDownTest3 extends JFrame {
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

	public CountDownTest3() {
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
		JButton btnNewButton2=new JButton("카운터 다시 시작");
		btnNewButton2.setBounds(247, 60, 125, 23);
		btnNewButton2.addActionListener(e -> {
		    if (t.getState() == Thread.State.TERMINATED) {
		        t = new MyThread();
		    }
		    t.start();
		});
		
		getContentPane().add(btnNewButton);
		getContentPane().add(btnNewButton2);
		
		
		setVisible(true);
		t=new MyThread();
		t.start();
		

	}
	
	

	public static void main(String[] args) {
		CountDownTest3 t = new CountDownTest3();
	}
}