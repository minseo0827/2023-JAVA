class song{
	String title, artist;
	int length;
	
	public song(String title, String artist, int length) {
		this.title=title;
		this.artist=artist;
		this.length=length;
	}
	
}
public class Songprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		song song1=new song("마음", "아이유", 188);
		song song2=new song("오르트구름", "윤하", 201);
		song song3=new song("차지연", "defying gravity", 432);
		System.out.printf(song1.title+" "+song2.artist+" "+song3.length);
	}

}
