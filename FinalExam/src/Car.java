import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Car extends JFrame {

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
            while (x < 600) {
                x += 10 * Math.random();
                if (x > 600) {
                    x = 600;
                }
                label.setBounds(x, y, 100, 100);
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            label.setBounds(x, y, 100, 100);
            repaint();

            if (!carWins[y / 50] && !winnerDisplayed) {
                carWins[y / 50] = true;
                displayWinsMessage(carFileName);
                winnerDisplayed = true;
            }
        }
    }

    public Car() {
        setTitle("CarRace");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

     
       
        (new MyThread("car1", 100, 0)).start();
        (new MyThread("car2", 100, 50)).start();
        (new MyThread("car3", 100, 100)).start();
        (new MyThread("car4", 100, 150)).start();
        (new MyThread("car5", 100, 200)).start();

        JLabel finishLine = new JLabel();
        finishLine.setBounds(600, 0, 2, 400);
        finishLine.setOpaque(true);
        finishLine.setBackground(java.awt.Color.BLACK);
        add(finishLine);

      
        JLabel raceLabel = new JLabel();
        raceLabel.setIcon(new ImageIcon("race.gif"));
        raceLabel.setBounds(600, 0, 150, 100);
        add(raceLabel);

        setVisible(true);
    }

    private void displayWinsMessage(String carFileName) {
        JLabel winsLabel = new JLabel(carFileName + "이 우승했습니다!");
        winsLabel.setBounds(550, 300, 150, 100);
        add(winsLabel);
        repaint();
    }

    public static void main(String[] args) {
    	Car t = new Car();
    }
}