import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bubble15sec extends BubbleGameFrame {
    public Bubble15sec() {
        super();
        TenSecondThread th = new TenSecondThread();
        th.start();
    }

    class TenSecondThread extends Thread {
        public void run() {
            setTitle("실행 시작");
            getContentPane().setBackground(Color.YELLOW);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                return;
            }
            setTitle("버블 게임 실행 종료");
            getContentPane().setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        new Bubble15sec();
    }
}
