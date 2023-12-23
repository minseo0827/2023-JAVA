import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SantaGame extends JFrame {
    private SantaPanel p1Panel, p2Panel, p3Panel;
    private JLabel SantaLabel;
    private int presentCount = 0;
    private JLabel presentCountLabel;
    private JProgressBar progressBar;
    private JLabel infoLabel; 


    private static final int PRESENT_INTERVAL = 1000;
    private static final int GAME_DURATION = 120000;
    private static final int E1_PRESENT_PENALTY = 10;

    public SantaGame() {
        setTitle("산타 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1Panel = new SantaPanel("p1.jpg", 50, 60);
        p2Panel = new SantaPanel("p2.jpg", 50, 60);
        p3Panel = new SantaPanel("p3.png", 50, 60);

        ImageIcon SantaImageIcon = new ImageIcon(
                new ImageIcon("santa.png").getImage().getScaledInstance(250, 125, java.awt.Image.SCALE_SMOOTH));
        SantaLabel = new JLabel(SantaImageIcon);
        SantaLabel.setSize(250, 125);
        SantaLabel.setLocation(250, 800);

        setContentPane(p1Panel);
        getContentPane().add(SantaLabel);
        getContentPane().setBackground(Color.BLACK);
        setSize(700, 1000);
        setVisible(true);

        presentCountLabel = new JLabel("Present: 0");
        presentCountLabel.setForeground(Color.WHITE);
        presentCountLabel.setSize(150, 30);
        presentCountLabel.setLocation(getWidth() - 170, 20);
        presentCountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        getContentPane().add(presentCountLabel);

        progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
        progressBar.setValue(100);
        progressBar.setForeground(Color.RED);
        progressBar.setSize(550, 50);
        progressBar.setLocation((getWidth() - progressBar.getWidth()) / 2, 50);
        getContentPane().add(progressBar);

        infoLabel = new JLabel("");
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setSize(300, 30);
        infoLabel.setLocation((getWidth() - infoLabel.getWidth()) / 2, 20);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        getContentPane().add(infoLabel);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                moveSanta(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        setFocusable(true);

        Timer presentTimer = new Timer(PRESENT_INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomPresent();
            }
        });
        presentTimer.start();

        Timer progressBarTimer = new Timer(1000, new ActionListener() {
            private int elapsedTime = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                updateProgressBar();
                elapsedTime += 1000;

                if (elapsedTime >= GAME_DURATION) {
                	System.out.print("산타가 " + presentCount +"개의 선물을 가지고 출발!");
                	System.exit(0);
                }
            }
        });
        progressBarTimer.start();

       
     }

    private void generateRandomPresent() {
        Random rand = new Random();

        generateSanta(p1Panel, 50, 50, rand.nextInt(getWidth()), rand.nextInt(51) + 150, getRandomPresent());
        generateSanta(p2Panel, 50, 50, rand.nextInt(getWidth()), rand.nextInt(51) + 150, getRandomPresent());
        generateSanta(p3Panel, 50, 50, rand.nextInt(getWidth()), rand.nextInt(51) + 150, getRandomPresent());
    }

    private void generateSanta(SantaPanel santaPanel, int width, int height, int x, int y, String presentImage) {
        SantaThread santaThread = new SantaThread(santaPanel, presentImage, width, height, x, y);
        new Thread(() -> checkCollision(santaThread, SantaLabel)).start();
        SwingUtilities.invokeLater(() -> {
            santaThread.start();
        });
    }

    private String getRandomPresent() {
        Random rand = new Random();
        int randomNum = rand.nextInt(4) + 1;

        switch (randomNum) {
            case 1:
                return "p1.jpg";
            case 2:
                return "p2.jpg";
            case 3:
                return "p3.png";
            case 4:
                return "e1.png";
            default:
                return "p1.jpg";
        }
    }

   
    
    private void updateProgressBar() {
        int remainingTime = GAME_DURATION - progressBar.getValue();
        progressBar.setValue(progressBar.getValue() - 1);

        if (remainingTime <= 0) {
        	System.out.print("산타가 " + presentCount +"개의 선물을 가지고 출발!");
        	System.exit(0);
        }
        
        if (progressBar.getValue() == 0) {
        	System.out.print("산타가 " + presentCount +"개의 선물을 가지고 출발!");
        	System.exit(0); 
        }
    }

    

    private void moveSanta(int keyCode) {
        int x = SantaLabel.getX();
        int y = SantaLabel.getY();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                x -= 5;
                break;
            case KeyEvent.VK_RIGHT:
                x += 5;
                break;
            case KeyEvent.VK_UP:
                y -= 5;
                break;
            case KeyEvent.VK_DOWN:
                y += 5;
                break;
        }

        x = Math.max(0, Math.min(getWidth() - SantaLabel.getWidth(), x));
        y = Math.max(300, Math.min(1000 - SantaLabel.getHeight(), y));

        SantaLabel.setLocation(x, y);
    }

    private void checkCollision(SantaThread santaThread, JLabel santaLabel) {
        while (true) {
            Rectangle santaBounds = santaLabel.getBounds();
            Rectangle presentBounds = santaThread.getSantaBounds();

            if (santaBounds.intersects(presentBounds)) {
                String presentImage = santaThread.getPresentImage();

                if ("e1.png".equals(presentImage)) {
                    progressBar.setValue(Math.max(0, progressBar.getValue() - E1_PRESENT_PENALTY));
                } else {
                    presentCount++;
                    SwingUtilities.invokeLater(() -> presentCountLabel.setText("Present: " + presentCount));
                }

                santaThread.removeSanta();
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SantaGame();
        });
    }
}

class SantaPanel extends JPanel {
    private String imageName;
    private int width;
    private int height;

    public SantaPanel(String imageName, int width, int height) {
        this.imageName = imageName;
        this.width = width;
        this.height = height;
        setLayout(null);
    }
}

class SantaThread extends Thread {
    private JPanel panel;
    private JLabel santa;
    private String presentImage;

    public SantaThread(JPanel panel, String imageName, int width, int height, int santaX, int santaY) {
        this.panel = panel;
        this.santa = new JLabel(
                new ImageIcon(new ImageIcon(imageName).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH)));
        santa.setSize(width, height);
        santa.setLocation(santaX, santaY);
        presentImage = imageName;
        panel.add(santa);
        panel.repaint();
    }

    public Rectangle getSantaBounds() {
        return santa.getBounds();
    }

    public void removeSanta() {
        panel.remove(santa);
        panel.repaint();
    }

    public String getPresentImage() {
        return presentImage;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                santa.setLocation(santa.getX(), santa.getY() + 5);

                if (santa.getY() > panel.getHeight()) {
                    removeSanta();
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}