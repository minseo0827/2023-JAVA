interface Controllable {
	void play();
	void stop();
	
}

class VideoPlayer implements Controllable {
	public void play() { System.out.print("재생 시작\n");}
	public void stop() { System.out.print("재생 종료\n");}
}

public class interfacetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VideoPlayer v1=new VideoPlayer();
		v1.play();
		v1.stop();

	}

}
