import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Carclick extends JFrame {

    private static boolean[] carWins = {false, false, false, false, false};
    private static boolean winnerDisplayed = false;

    class MyThread extends Thread {
        private JLabel label;
        private int x, y;
        private String carFileName;

        public MyThread(String fname, int x, int y) {
            this.x = x;
            this.y = y;
            this.carFileName = fname;
            label = new JLabel();
            label.setIcon(new ImageIcon(fname + ".gif"));
            label.setBounds(x, y, 100, 100);
            add(label);
        }

        public void run() {
            while (x < 480) {
                x += 10 * Math.random();
                if (x > 480) {
                    x = 480;
                }
                label.setBounds(x, y, 100, 100);
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!carWins[y / 50] && !winnerDisplayed) {
                carWins[y / 50] = true;
                displayWinsMessage();
                winnerDisplayed = true;
            }
        }
    }

    public Carclick() {
        setTitle("CarRace");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(java.awt.Color.GRAY);

        // race.gif 추가
        JLabel raceLabel = new JLabel();
        raceLabel.setIcon(new ImageIcon("race.gif"));
        raceLabel.setBounds(600, 0, 150, 400);
        add(raceLabel);

        // finishLine 추가
        JLabel finishLine = new JLabel();
        finishLine.setBounds(550, 0, 2, 400);
        finishLine.setOpaque(true);
        finishLine.setBackground(java.awt.Color.BLACK);
        add(finishLine);

        // MouseListener 추가
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 클릭한 위치에 자동차 스레드 시작
                new MyThread("car1", e.getX(), e.getY()).start();
            }
        });

        setVisible(true);
    }

    private void displayWinsMessage() {
        JLabel winsLabel = new JLabel("WIN!");
        winsLabel.setBounds(570, 300, 150, 100);
        add(winsLabel);
        repaint();
    }

    public static void main(String[] args) {
        new Carclick();
    }
}
