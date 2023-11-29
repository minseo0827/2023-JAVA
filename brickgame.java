/*
 * import javax.swing.*; import java.awt.*; import java.awt.event.*;
 * 
 * public class brickgame extends JFrame { private static final int WIDTH = 800;
 * private static final int HEIGHT = 600; private static final int PADDLE_WIDTH
 * = 100; private static final int PADDLE_HEIGHT = 20; private static final int
 * BALL_SIZE = 20; private static final int BRICK_WIDTH = 60; private static
 * final int BRICK_HEIGHT = 20; private static final int NUM_BRICKS = 30;
 * 
 * private int paddleX; private int ballX, ballY; private int ballSpeedX,
 * ballSpeedY; private boolean gameRunning;
 * 
 * private Timer timer;
 * 
 * public brickgame() { setTitle("Brick Breaker"); setSize(WIDTH, HEIGHT);
 * setDefaultCloseOperation(EXIT_ON_CLOSE); setResizable(false);
 * setLocationRelativeTo(null);
 * 
 * paddleX = WIDTH / 2 - PADDLE_WIDTH / 2; ballX = WIDTH / 2 - BALL_SIZE / 2;
 * ballY = HEIGHT / 2 - BALL_SIZE / 2; ballSpeedX = 3; ballSpeedY = -3;
 * gameRunning = true;
 * 
 * addKeyListener(new KeyAdapter() {
 * 
 * @Override public void keyPressed(KeyEvent e) { handleKeyPress(e); } });
 * 
 * timer = new Timer(10, new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) { update(); repaint(); }
 * }); }
 * 
 * private void handleKeyPress(KeyEvent e) { int key = e.getKeyCode(); if (key
 * == KeyEvent.VK_LEFT) { paddleX -= 10; } else if (key == KeyEvent.VK_RIGHT) {
 * paddleX += 10; } }
 * 
 * private void update() { if (!gameRunning) { return; }
 * 
 * ballX += ballSpeedX; ballY += ballSpeedY;
 * 
 * // 벽과의 충돌 감지 if (ballX <= 0 || ballX >= WIDTH - BALL_SIZE) { ballSpeedX =
 * -ballSpeedX; } if (ballY <= 0) { ballSpeedY = -ballSpeedY; }
 * 
 * // 패들과의 충돌 감지 if (ballY + BALL_SIZE >= HEIGHT - PADDLE_HEIGHT && ballX +
 * BALL_SIZE >= paddleX && ballX <= paddleX + PADDLE_WIDTH) { ballSpeedY =
 * -ballSpeedY; }
 * 
 * // 벽돌과의 충돌 감지 for (int i = 0; i < NUM_BRICKS; i++) { int brickX = i % 10 *
 * (BRICK_WIDTH + 2) + 2; int brickY = i / 10 * (BRICK_HEIGHT + 2) + 50; if
 * (ballY <= brickY + BRICK_HEIGHT && ballX + BALL_SIZE >= brickX && ballX <=
 * brickX + BRICK_WIDTH) { ballSpeedY = -ballSpeedY;
 * 
 * bricks[i] = null;
 * 
 * break; // 한 번에 하나의 } }
 * 
 * // 게임 오버 처리 if (ballY >= HEIGHT) { gameRunning = false; timer.stop();
 * JOptionPane.showMessageDialog(this, "Game Over", "Game Over",
 * JOptionPane.INFORMATION_MESSAGE); } }
 * 
 * @Override public void paint(Graphics g) { super.paint(g);
 * 
 * // 배경 그리기 g.setColor(Color.BLACK); g.fillRect(0, 0, WIDTH, HEIGHT);
 * 
 * // 패들 그리기 g.setColor(Color.WHITE); g.fillRect(paddleX, HEIGHT -
 * PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
 * 
 * // 공 그리기 g.setColor(Color.WHITE); g.fillOval(ballX, ballY, BALL_SIZE,
 * BALL_SIZE);
 * 
 * // 벽돌 그리기 g.setColor(Color.RED); for (int i = 0; i < NUM_BRICKS; i++) { int
 * brickX = i % 10 * (BRICK_WIDTH + 2) + 2; int brickY = i / 10 * (BRICK_HEIGHT
 * + 2) + 50; g.fillRect(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT); } }
 * 
 * public void startGame() { setVisible(true); timer.start(); }
 * 
 * public static void main(String[] args) { SwingUtilities.invokeLater(new
 * Runnable() { public void run() { brickgame game = new brickgame();
 * game.startGame(); } }); } }
 * 
 * 
 */