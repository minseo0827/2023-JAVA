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
	private GamePanel gamePanel;
    public Bubblebutton() {
        setTitle("버블 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel p = new GamePanel();
        
        JButton startButton = new JButton("시작");
        startButton.setBounds(210, 400, 80, 30);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        p.add(startButton);

        // 종료 버튼
        JButton stopButton = new JButton("종료");
        stopButton.setBounds(300, 400, 80, 30);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //삭제를..어케하냐
            	System.exit(0);
            	
            	
            }
        });
        p.add(stopButton);
        
        
        setContentPane(p);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bubblebutton();
    }
}

class GamePanel extends JPanel {
    public GamePanel() {
        setLayout(null);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                new BubbleThread(e.getX(), e.getY()).start();
            }
        });
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
