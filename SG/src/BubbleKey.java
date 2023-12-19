import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BubbleKey extends JFrame {
    public BubbleKey() {
        setTitle("버블 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel2 p = new GamePanel2();
        setContentPane(p);
        setSize(300, 300);
        setVisible(true);

        // 키보드 이벤트 리스너 추가
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    p.createBubble();
                }
            }
        });
        // 포커스를 받을 수 있도록 설정
        setFocusable(true);
    }

    public static void main(String[] args) {
        new BubbleKey();
    }
}

class GamePanel2 extends JPanel {
    public GamePanel2() {
        setLayout(null);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                removeBubble(e.getX(), e.getY());
            }
        });
    }

    public void createBubble() {
        int bubbleX = (int) (Math.random() * getWidth());
        int bubbleY = getHeight();
        new BubbleThread(bubbleX, bubbleY).start();
    }

    public void removeBubble(int x, int y) {
        Component[] components = getComponents();
        for (Component component : components) {
            if (component.getBounds().contains(x, y)) {
                remove(component);
                repaint();
                break;
            }
        }
    }

    class BubbleThread extends Thread {
        private JLabel bubble;

        public BubbleThread(int bubbleX, int bubbleY) {
            ImageIcon img = new ImageIcon("bubble.jpg");
            bubble = new JLabel(img);
            bubble.setSize(img.getIconWidth(), img.getIconWidth());
            bubble.setLocation(bubbleX, bubbleY);
            add(bubble);
            repaint();

            new Thread(() -> {
                try {
                    while (true) {
                        // 20ms마다 5픽셀씩 위로 이동
                        Thread.sleep(20);
                        bubble.setLocation(bubble.getX(), bubble.getY() - 5);

                        // 프레임을 벗어나면 스레드 종료 및 버블 제거
                        if (bubble.getY() + bubble.getHeight() < 0) {
                            remove(bubble);
                            repaint();
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
