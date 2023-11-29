/*
 * package test;
 * 
 * import java.applet.Applet; import java.applet.AudioClip; import
 * java.awt.Color; import java.awt.Font; import java.awt.GradientPaint; import
 * java.awt.Graphics; import java.awt.Graphics2D; import java.awt.Point; import
 * java.awt.event.KeyEvent; import java.awt.event.KeyListener; import
 * java.awt.geom.Rectangle2D;
 * 
 * import java.net.URL; import java.util.LinkedList;
 * 
 * import javax.swing.JFrame; import javax.swing.JPanel;
 * 
 * abstract class block_breaker { void draw(Graphics g) {}; }
 * 
 * class Rect//블록 클래스 { Rect(Point p, boolean tf) { pt=p; yellow=tf; } Point
 * pt=new Point(); boolean yellow=false; }
 * 
 * class Ball//공 클래스 { int bx=400; int by=650; int br=10; int
 * ballcenter=(bx+br/2); Point []pt=new Point[4]; int dx=-1; int dy=3;
 * 
 * Ball() { pt[0]=new Point(bx, by+(br/2)); pt[1]=new Point(bx+(br/2), by);
 * pt[2]=new Point(bx+br, by+(br/2)); pt[3]=new Point(bx+(br/2), by+br); }
 * Ball(int x, int y, int _dx, int _dy) { bx=x; by=y; ballcenter=(bx+br/2);
 * dx=_dx; dy=_dy;
 * 
 * pt[0]=new Point(bx, by+(br/2)); pt[1]=new Point(bx+(br/2), by); pt[2]=new
 * Point(bx+br, by+(br/2)); pt[3]=new Point(bx+(br/2), by+br); } }
 * 
 * class Title extends block_breaker//시작 화면 { Font font1=new Font("바탕체",
 * Font.BOLD, 60); Font font2=new Font("stencil", Font.BOLD, 80); Font font3=new
 * Font("바탕체",Font.LAYOUT_LEFT_TO_RIGHT, 25);
 * 
 * String st1=new String("Java Programing"); String st2=new
 * String("Homework #4"); String st3=new String("BLOCK BREAKER"); String st4=new
 * String("PRESS SPACEBAR TO PLAY!");
 * 
 * void draw(Graphics g) { g.setFont(font1);
 * 
 * g.setColor(Color.black); g.drawString(st1, 130, 170); g.drawString(st2, 190,
 * 230);
 * 
 * g.setColor(Color.white); g.drawString(st1, 127, 170); g.drawString(st2, 187,
 * 230);
 * 
 * g.setFont(font2); g.setColor(Color.black); g.drawString(st3, 40, 390);
 * g.setColor(Color.white); g.drawString(st3, 37, 390); } }
 * 
 * class Play extends block_breaker//실행 화면 { LinkedList<Rect> rt=new
 * LinkedList<Rect>();//블록 클래스의 연결리스트 LinkedList<Ball> ball=new
 * LinkedList<Ball>();//공 연결리스트 AudioClip audio2; AudioClip audio3; AudioClip
 * audio4;
 * 
 * int x=350, y=670; int xsize=130, ysize=25;//라켓의 정보 int score=0;//your score
 * 
 * int stage=1;//스테이지
 * 
 * int bx_size, by_size;//라켓 간격
 * 
 * int n=xsize/5;//라켓 5분할 int x1=x+n; int x2=x1+n; int x3=x2+n; int x4=x3+n; int
 * x5=x4+n;
 * 
 * Point []pt = new Point[4];//원의 표면
 * 
 * Play() { Ball b=new Ball(); ball.add(b); bx_size=243; by_size=100; int c1=0;
 * 
 * for (int y=0; y<3; y++)//스테이지 1 { for (int x=0; x<3; x++) { Point c=new
 * Point(25+(bx_size*x)+(5*x),25+(5*y)+(by_size*y)); boolean temp=false; if
 * (c1%5==0) temp=true; else temp=false; Rect r=new Rect(c, temp); rt.add(r);
 * c1++; } }
 * 
 * URL url2 = getClass().getResource("./sounds/attack.wav"); audio2 =
 * Applet.newAudioClip(url2);
 * 
 * URL url3 = getClass().getResource("./sounds/break.wav"); audio3 =
 * Applet.newAudioClip(url3);
 * 
 * URL url4 = getClass().getResource("./sounds/level_up.wav"); audio4 =
 * Applet.newAudioClip(url4); }
 * 
 * void divideRacket()//라켓 5분할 { n=xsize/5; x1=x+n; x2=x1+n; x3=x2+n; x4=x3+n;
 * x5=x4+n; }
 * 
 * void resetball()//공의 속도, 방향 바꿈 { divideRacket();
 * 
 * for (int i=0; i<ball.size(); i++)
 * ball.get(i).ballcenter=(ball.get(i).bx+(ball.get(i).br/2));
 * 
 * for (int i=0; i<ball.size(); i++) { if (ball.size()<=0) break; if
 * (ball.get(i).by+ball.get(i).br>=670 && ball.get(i).by+ball.get(i).br <= 695
 * && ball.get(i).ballcenter>=x && ball.get(i).ballcenter<=x+xsize) {
 * 
 * ball.get(i).by=650; audio2.play(); ball.get(i).dy=-ball.get(i).dy; if (
 * x<=ball.get(i).ballcenter && x1>=ball.get(i).ballcenter) ball.get(i).dx=-3;
 * else if (x1<ball.get(i).ballcenter && ball.get(i).ballcenter<=x2)
 * ball.get(i).dx=-2; else if (x2<ball.get(i).ballcenter &&
 * ball.get(i).ballcenter<=x3) ball.get(i).dx=1; else if
 * (x3<ball.get(i).ballcenter && ball.get(i).ballcenter<=x4) ball.get(i).dx=2;
 * else if (x4<ball.get(i).ballcenter && ball.get(i).ballcenter<=x5)
 * ball.get(i).dx=3; } } for (int i=0; i<ball.size(); i++) { if
 * (ball.get(i).bx<20 || ball.get(i).bx>=780-ball.get(i).br*2)
 * ball.get(i).dx=-ball.get(i).dx; if (ball.get(i).by<20) { ball.get(i).by=20;
 * ball.get(i).dy=-ball.get(i).dy; } } for (int i=0; i<ball.size(); i++) {
 * ball.get(i).bx+=ball.get(i).dx; ball.get(i).pt[0]=new Point(ball.get(i).bx,
 * ball.get(i).by+(ball.get(i).br/2)); ball.get(i).pt[1]=new
 * Point(ball.get(i).bx+(ball.get(i).br/2), ball.get(i).by);
 * ball.get(i).pt[2]=new Point(ball.get(i).bx+ball.get(i).br,
 * ball.get(i).by+(ball.get(i).br/2)); ball.get(i).pt[3]=new
 * Point(ball.get(i).bx+(ball.get(i).br/2), ball.get(i).by+ball.get(i).br); }
 * 
 * collision_block();
 * 
 * if (rt.size()<=0)//블록이 다 부숴지면 다음 스테이지 { stage++; audio4.play(); resetstage();
 * } }
 * 
 * void collision_block() { for (int ij=0; ij<ball.size(); ij++) { for (int i=0;
 * i<4; i++)//블록과의 충돌 검사하고 해당 충돌 벽돌 지우기 { for (int j=0; j<rt.size(); j++) { if
 * (collision(rt.get(j).pt, bx_size, by_size, ball.get(ij).pt[i])) {
 * audio3.play(); score+=10; if (i==1 || i==3) ball.get(ij).dy=-ball.get(ij).dy;
 * else if (i==0 || i==2) ball.get(ij).dx=-ball.get(ij).dx;
 * 
 * if (rt.get(j).yellow==true) { Ball b1=new Ball(ball.get(ij).bx-50,
 * ball.get(ij).by, ball.get(ij).dx, ball.get(ij).dy); Ball b2=new
 * Ball(ball.get(ij).bx+50, ball.get(ij).by, ball.get(ij).dx, ball.get(ij).dy);
 * ball.add(b1); ball.add(b2); } rt.remove(j); } } } } }
 * 
 * void resetstage()//스테이지 변화 { ball.removeAll(ball); Ball b=new Ball();
 * b.bx=x+50; b.by=640; ball.add(b);
 * 
 * n=xsize/5;//라켓 5분할 x1=x+n; x2=x1+n; x3=x2+n; x4=x3+n; x5=x4+n;
 * 
 * if (stage==2) { rt=new LinkedList<Rect>(); int cc2=0; bx_size=119;
 * by_size=50; for (int y=0; y<6; y++) { for (int x=0; x<6; x++) { Point c=new
 * Point(25+(bx_size*x)+(5*x),25+(5*y)+(by_size*y)); boolean temp=false; if
 * (cc2%4==0) temp=true; else temp=false; Rect r=new Rect(c, temp); rt.add(r);
 * cc2++; } } } else if (stage==3) { rt=new LinkedList<Rect>(); bx_size=77;
 * by_size=40; int cc=0; for (int y=0; y<9; y++) { for (int x=0; x<9; x++) {
 * Point c=new Point(25+(bx_size*x)+(5*x),25+(5*y)+(by_size*y)); boolean
 * temp=false; if (cc%7==0) temp=true; else temp=false; Rect r=new Rect(c,
 * temp); rt.add(r); cc++; } } } else if (stage==4) { rt=new LinkedList<Rect>();
 * bx_size=57; by_size=35; int cc=0; for (int y=0; y<12; y++) { for (int x=0;
 * x<12; x++) { Point c=new Point(25+(bx_size*x)+(5*x),25+(5*y)+(by_size*y));
 * boolean temp=false; if (cc%7==0) temp=true; else temp=false; Rect r=new
 * Rect(c, temp); rt.add(r); cc++; } } } }
 * 
 * boolean collision(Point p, int _x, int _y, Point bp)//충돌 검사 { Rectangle2D
 * r=new Rectangle2D.Float(p.x,p.y,_x,_y); if (r.contains(bp)) return true; else
 * return false; }
 * 
 * void draw (Graphics g)//공과 벽돌 그리기 { Graphics2D g2=(Graphics2D)g; for (Rect r:
 * rt) { if (r.yellow) { GradientPaint gp=new
 * GradientPaint(r.pt.x,r.pt.y,Color.YELLOW,r.pt.x+bx_size,r.pt.y+by_size,Color.
 * ORANGE); g2.setPaint(gp); } else { GradientPaint gp=new
 * GradientPaint(r.pt.x,r.pt.y,Color.BLUE,r.pt.x+bx_size,r.pt.y+by_size,Color.
 * CYAN); g.setColor(Color.YELLOW); g2.setPaint(gp); } g2.fillRoundRect(r.pt.x,
 * r.pt.y, bx_size, by_size, 10, 10); } resetball(); g2.setColor(Color.pink);
 * g2.fillRoundRect(x, y, xsize, ysize, 10, 10); g2.setColor(Color.WHITE); for
 * (int i=0; i<ball.size(); i++) g2.fillOval(ball.get(i).bx, ball.get(i).by,
 * ball.get(i).br, ball.get(i).br); } }
 * 
 * class Over extends block_breaker//종료 화면 { int your_score=0; int score=0; Play
 * play;
 * 
 * Font font1=new Font("stencil", Font.BOLD, 110); Font font2=new
 * Font("stencil", Font.BOLD, 40); Font font3=new
 * Font("바탕체",Font.LAYOUT_LEFT_TO_RIGHT, 40);
 * 
 * String st1=new String("GAME OVER"); String st2=new
 * String("HIGH SCORE: "+your_score); String st3=new
 * String("YOUR SCORE: "+score); String st4=new String("PRESS SPACEBAR!");
 * 
 * void draw(Graphics g) { g.setFont(font1);
 * 
 * g.setColor(Color.BLACK); g.drawString(st1, 70, 310); g.setColor(Color.white);
 * g.drawString(st1, 67, 310);
 * 
 * g.setFont(font2); g.setColor(Color.BLACK); g.drawString(st2, 240, 450);
 * g.setColor(Color.white); g.drawString(st2, 237, 450);
 * 
 * g.setColor(Color.BLACK); g.drawString(st3, 240, 490);
 * g.setColor(Color.white); g.drawString(st3, 237, 490); } }
 * 
 * class Game extends JPanel implements KeyListener, Runnable {
 * 
 * Title t = new Title(); Play p = new Play(); Over o = new Over();
 * 
 * int high_score=0;
 * 
 * AudioClip audio; AudioClip audio3;
 * 
 * final static int GAME_START=1; final static int GAME_PLAY=2; final static int
 * GAME_OVER=3;
 * 
 * Thread t_title=new Thread(this); int flag=1; int mode=GAME_START;
 * 
 * Game() { URL url = getClass().getResource("./sounds/bgm.wav"); URL url3 =
 * getClass().getResource("./sounds/over.wav");
 * 
 * audio = Applet.newAudioClip(url); audio3 = Applet.newAudioClip(url3);
 * 
 * mode=GAME_START; flag=1; t_title.start(); audio.play(); requestFocus();
 * setFocusable(true); addKeyListener(this); }
 * 
 * @Override protected void paintComponent(Graphics g) { requestFocus();
 * setFocusable(true); super.paintComponent(g); Graphics2D g2=(Graphics2D)g;
 * GradientPaint gp=new GradientPaint(400,0,Color.BLACK,400,800,Color.GRAY);
 * g2.setPaint(gp); g2.fillRect(0, 0, 800, 800);
 * 
 * if (mode==GAME_START) { o.your_score=0; p.score=0; t.draw(g);
 * g.setFont(t.font3); g.setColor(Color.black); g.drawString(t.st4, 235, 600);
 * g.setColor(Color.red); g.drawString(t.st4, 232, 600); } else if
 * (mode==GAME_PLAY) { flag=1; g2.fillRect(0, 0, 800, 800);
 * g2.setColor(Color.GRAY); g2.fillRect(0, 0, 800, 20); g2.fillRect(0, 25, 20,
 * 800); g2.fillRect(765, 25, 20, 800);
 * 
 * p.draw(g); } else if (mode==GAME_OVER) { g2.fillRect(0, 0, 800, 800);
 * o.your_score=p.score; o.st3="YOUR SCORE: "+o.your_score; if
 * (o.your_score>high_score) high_score=o.your_score;
 * 
 * o.st2="HIGH SCORE: "+high_score; o.draw(g); g.setFont(o.font3);
 * g.setColor(Color.black);
 * 
 * g.drawString(o.st4, 240, 600); g.setColor(Color.red); g.drawString(o.st4,
 * 237, 600); } }
 * 
 * @Override public void keyPressed(KeyEvent e) {
 * 
 * setFocusable(true); if (e.getKeyCode()==KeyEvent.VK_SPACE) { if
 * (mode==GAME_START) { mode=GAME_PLAY; o.your_score=0; audio.stop(); } else if
 * (mode==GAME_OVER)//게임이 끝났을 때 초기화, 스테이지 1로 설정 { for (int i=0; i<p.rt.size();
 * i++) p.rt.remove(i);
 * 
 * p.bx_size=243; p.by_size=100;
 * 
 * p.rt=new LinkedList<Rect>(); int c1=0; for (int y=0; y<3; y++) { for (int
 * x=0; x<3; x++) { Point c=new
 * Point(25+(p.bx_size*x)+(5*x),25+(5*y)+(p.by_size*y)); boolean temp=false; if
 * (c1%5==0) temp=true; else temp=false; Rect r=new Rect(c, temp); p.rt.add(r);
 * c1++; } } p.x=350; p.y=670; p.xsize=130; p.ysize=25;//사각형
 * 
 * p.n=p.xsize/5; p.x1=p.x+p.n; p.x2=p.x1+p.n; p.x3=p.x2+p.n; p.x4=p.x3+p.n;
 * p.x5=p.x4+p.n;
 * 
 * p.ball=new LinkedList<Ball>(); Ball b=new Ball(); p.ball.add(b);
 * 
 * p.x=350; p.y=670;
 * 
 * audio.loop(); p.stage=1; p.bx_size=243; p.by_size=100;
 * 
 * mode=GAME_START; } } if (mode==GAME_PLAY) { if
 * (e.getKeyCode()==KeyEvent.VK_LEFT) { if (p.x-80<=20) p.x=20; else p.x-=80; }
 * else if (e.getKeyCode()==KeyEvent.VK_RIGHT) { if (p.x+p.xsize>=700) p.x=635;
 * else p.x+=80; } } p.divideRacket(); p.resetball(); repaint(); }
 * 
 * @Override public void keyReleased(KeyEvent e) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public void keyTyped(KeyEvent e) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public void run() {
 * 
 * int a=100; setFocusable(true); while(true) { try { Thread.sleep(a); } catch
 * (InterruptedException e) { e.printStackTrace(); } if (mode==GAME_START) {
 * a=100; if (flag==1) {t.st4=""; flag=0;} else if (flag==0) {
 * t.st4="PRESS SPACEBAR TO PLAY!"; flag=1; } } else if (mode==GAME_PLAY) { if
 * (p.stage>=5) { audio3.play(); mode=GAME_OVER; } if (p.stage==1) a=8; else if
 * (p.stage==2) a=7; else if (p.stage==3) a=5; else if (p.stage==4) a=4; for
 * (int i=0; i<p.ball.size(); i++) { p.ball.get(i).by-=p.ball.get(i).dy; } for
 * (int i=0; i<p.ball.size(); i++) { if (p.ball.get(i).by>800) {
 * p.ball.remove(i);
 * 
 * } } if (p.ball.size()<=0) { audio3.play(); mode=GAME_OVER; } } else if
 * (mode==GAME_OVER) { a=100; if (flag==1) {o.st4=""; flag=0;} else if (flag==0)
 * { o.st4="PRESS SPACEBAR!"; flag=1; } a=100; } repaint(); } } } class MyFrame
 * extends JFrame { Game p; MyFrame() { p=new Game(); setSize(800,800);
 * setTitle("Java Homework4"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * setVisible(true); add(p); p.setFocusable(true); } } public class
 * block_breaker1 {
 * 
 * public static void main(String[] args) { MyFrame f = new MyFrame();
 * 
 * }
 * 
 * }
 */