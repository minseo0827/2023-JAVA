/*
 * import javax.swing.ImageIcon; import javax.swing.JButton; import
 * javax.swing.JFrame; import javax.swing.JLabel;
 * 
 * public class CarGameButton extends JFrame {
 * 
 * private static boolean[] carWins = {false, false, false, false, false};
 * private static boolean winnerDisplayed = false; private MyThread[] carThreads
 * = new MyThread[5]; private JLabel winsLabel;
 * 
 * class MyThread extends Thread { private JLabel label; private int x, y;
 * private String carFileName;
 * 
 * public MyThread(String fname, int x, int y) { this.x = x; this.y = y;
 * this.carFileName = fname; label = new JLabel(); label.setIcon(new
 * ImageIcon(fname + ".gif")); label.setBounds(x, y, 100, 100); add(label); }
 * 
 * public void run() { while (x < 485) { x += 10 * Math.random(); if (x > 485) {
 * x = 485; } label.setBounds(x, y, 100, 100); repaint(); try {
 * Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
 * }
 * 
 * label.setBounds(x, y, 100, 100); repaint();
 * 
 * if (!carWins[y / 50] && !winnerDisplayed) { carWins[y / 50] = true;
 * displayWinsMessage(carFileName); winnerDisplayed = true; } }
 * 
 * public void resetX() { x = 0; label.setBounds(x, y, 100, 100); repaint(); } }
 * 
 * public CarGame() { setTitle("CarRace"); setSize(800, 400);
 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLayout(null);
 * 
 * // 배경 이미지(bg.jpg) 추가 getContentPane().setBackground(java.awt.Color.GRAY);
 * 
 * // 다섯 대의 차량 생성 carThreads[0] = new MyThread("car1", 100, 0); carThreads[1] =
 * new MyThread("car2", 100, 50); carThreads[2] = new MyThread("car3", 100,
 * 100); carThreads[3] = new MyThread("car4", 100, 150); carThreads[4] = new
 * MyThread("car5", 100, 200);
 * 
 * JLabel finishLine = new JLabel(); finishLine.setBounds(550, 0, 2, 400);
 * finishLine.setOpaque(true); finishLine.setBackground(java.awt.Color.BLACK);
 * add(finishLine);
 * 
 * // race.gif 추가 JLabel raceLabel = new JLabel(); raceLabel.setIcon(new
 * ImageIcon("race.gif")); raceLabel.setBounds(600, 0, 150, 400);
 * add(raceLabel);
 * 
 * // 시작 버튼 JButton startButton = new JButton("시작"); startButton.setBounds(550,
 * 50, 100, 30); startButton.addActionListener(e -> startRace());
 * add(startButton);
 * 
 * // 종료 버튼 JButton stopButton = new JButton("종료"); stopButton.setBounds(550,
 * 100, 100, 30); stopButton.addActionListener(e -> stopRace());
 * add(stopButton);
 * 
 * // 재시작 버튼 //JButton restartButton = new JButton("재시작");
 * //restartButton.setBounds(550, 150, 100, 30);
 * //restartButton.addActionListener(e -> restartRace()); //add(restartButton);
 * 
 * setVisible(true); }
 * 
 * private void startRace() { for (MyThread thread : carThreads) { if
 * (!thread.isAlive()) { thread.start(); } } }
 * 
 * private void stopRace() { for (MyThread thread : carThreads) {
 * thread.suspend(); } }
 * 
 * private void restartRace() { for (MyThread thread : carThreads) {
 * thread.resetX(); if (!thread.isAlive()) { thread.start(); } }
 * 
 * for (int i = 0; i < carWins.length; i++) { carWins[i] = false; }
 * 
 * winnerDisplayed = false; removeWinsMessage(); }
 * 
 * private void displayWinsMessage(String carFileName) { winsLabel = new
 * JLabel(carFileName + "이 우승했습니다!"); winsLabel.setBounds(550, 200, 200, 30);
 * add(winsLabel); repaint(); }
 * 
 * private void removeWinsMessage() { if (winsLabel != null) {
 * remove(winsLabel); repaint(); } }
 * 
 * public static void main(String[] args) { CarGame t = new CarGame(); } }
 */