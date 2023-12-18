import java.awt.Color;

import javax.swing.JFrame;

public class TenSecondFrame extends JFrame {
	public TenSecondFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 150);
		setVisible(true);
		TenSecondThread th=new TenSecondThread();
		th.start();
		
	}
	
	class TenSecondThread extends Thread {
		public void run() {
			
			 setTitle("실행 시작");
			 getContentPane().setBackground(Color.YELLOW);
	            try {
	                Thread.sleep(10000);
	            }
	            catch(InterruptedException e) { return; }
	            setTitle("실행 종료");
	            getContentPane().setBackground(Color.BLUE);
	  
		}
	}
	
	public static void main(String[] args) {
		new TenSecondFrame();
	}
	

}

