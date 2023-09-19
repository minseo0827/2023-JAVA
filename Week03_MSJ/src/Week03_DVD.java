
interface Players {
	void play();
	void stop();
}


interface ExPlayers extends Players{
	void slow();
}

class DVDPlayer implements ExPlayers{
	public void play() {
		System.out.println("DVD 재생 시작!");
	}
	
	public void stop() {
		System.out.println("DVD 재생 정지!");
	}
	
	public void slow() {
		System.out.println("DVD 느린 재생 시작!");
	}
}
public class Week03_DVD {
	public static void main(String[] args) {
		DVDPlayer a =new DVDPlayer();
		Players b= new DVDPlayer();
		ExPlayers c= new DVDPlayer();
		
	System.out.println("DVDPlayer형 변수 a");
	a.play();
	a.stop();
	a.slow();
	
	System.out.println("Player형 변수 b");
	b.play();
	b.stop();
	
	System.out.println("ExPlayer형 변수 c");
	c.play();
	c.stop();
	c.slow();
	
	}

}
