import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bubblebutton extends JFrame {
    private GamePanel1 gamePanel;

    public Bubblebutton() {
        setTitle("버블 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel1();
        setContentPane(gamePanel);

        // 시작 버튼
        JButton startButton = new JButton("시작");
        startButton.setBounds(10, 250, 80, 30);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.startBubbleThread();
            }
        });
        gamePanel.add(startButton);

        // 종료 버튼
        JButton stopButton = new JButton("종료");
        stopButton.setBounds(100, 250, 80, 30);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.stopBubbleThread();
            }
        });
        gamePanel.add(stopButton);

        setSize(300, 350);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bubblebutton();
    }
}

class GamePanel1 extends JPanel {
    private BubbleThread bubbleThread;

    public GamePanel1() {
        setLayout(null);
        bubbleThread = null;

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (bubbleThread != null) {
                    bubbleThread.stopBubble();
                }
                new BubbleThread((int) (Math.random() * getWidth()), 200).start();
            }
        });
    }

    public void startBubbleThread() {
        if (bubbleThread != null) {
            bubbleThread.stopBubble();
        }
        bubbleThread = new BubbleThread((int) (Math.random() * getWidth()), 200);
        bubbleThread.start();
    }

    public void stopBubbleThread() {
        if (bubbleThread != null) {
            bubbleThread.stopBubble();
        }
    }

    class BubbleThread extends Thread {
        private JLabel bubble;
        private boolean running;

        public BubbleThread(int bubbleX, int bubbleY) {
            ImageIcon img = new ImageIcon("bubble.jpg");
            bubble = new JLabel(img);
            bubble.setSize(img.getIconWidth(), img.getIconWidth());
            bubble.setLocation(bubbleX, bubbleY);
            add(bubble);
            repaint();

            running = true;
        }

        public void stopBubble() {
            running = false;
        }

        public void run() {
            try {
                while (running) {
                    // 20ms마다 5픽셀씩 위로 이동
                    Thread.sleep(20);
                    bubble.setLocation(bubble.getX(), bubble.getY() - 5);

                    // 프레임을 벗어나면 스레드 종료 및 버블 제거
                    if (bubble.getY() + bubble.getHeight() < 0) {
                        remove(bubble);
                        repaint();
                        running = false;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
