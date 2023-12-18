import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class CarGame extends JFrame {

    class MyThread extends Thread {
        private JLabel label;
        private int x, y;

        public MyThread(String fname, int x, int y) {
            this.x = x;
            this.y = y;
            label = new JLabel();
            label.setIcon(new ImageIcon(fname));
            label.setBounds(x, y, 100, 100);
            add(label);
        }

        public void run() {
            for (int i = 0; i < 200; i++) {
                x += 10 * Math.random();
                label.setBounds(x, y, 100, 100);
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (x >= getWidth() - 100) {
                showWinner(label);
            }
        }
    }

    private JLabel finishLine;
    private JLabel winnerLabel;

    public CarGame() {
        setTitle("CarRace");
        setSize(800, 200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Add a background label with an image
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("background.jpg")); // Replace "background.jpg" with your image file
        background.setBounds(0, 0, getWidth(), getHeight());
        add(background);

        // Create and add finish line to the right side
        finishLine = new JLabel("FINISH");
        finishLine.setFont(new Font("Arial", Font.BOLD, 20));
        finishLine.setBounds(getWidth() - 100, 0, 100, getHeight());
        add(finishLine);

        // Create and add winner label
        winnerLabel = new JLabel("");
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        winnerLabel.setBounds(getWidth() / 2 - 100, getHeight() / 2 - 50, 200, 100);
        add(winnerLabel);

        // Create and start threads for cars with adjusted initial positions
        (new MyThread("car1.gif", 50, 20)).start();
        (new MyThread("car2.gif", 50, 70)).start();
        (new MyThread("car3.gif", 50, 120)).start();
        (new MyThread("car4.gif", 50, 170)).start();
        (new MyThread("car5.gif", 50, 220)).start();

        setVisible(true);
    }

    private synchronized void showWinner(JLabel winner) {
        if (winnerLabel.getText().isEmpty()) {
            winnerLabel.setText(winner.getIcon() + " wins!");
        }
    }
    
    public static void main(String[] args) {
        CarGame t = new CarGame();
    }
}
