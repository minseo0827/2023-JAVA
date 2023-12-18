import java.util.Scanner;//왜쓰지를않니....

class Movie{
	String title, director;
	static int count;
	public Movie(String title, String director) {
		this.title=title;
		this.director=director;
		count++;
	}
	
}
public class MovieArrayTest {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		Movie [] list=new Movie[10];
		list[0]=new Movie("백튜더퓨쳐", "로버트 저메키스");
		list[1]=new Movie("티파니에서 아침을", "에드워드 블레이크");
		
//		for(int i=2; i<Movie.count; i++)
//		{
//			System.out.print("영화의 제목과 감독을 추가하세요. (제목, 감독)");
//			list[i]=scanner.next00();
//		}
//		
//		넥스트라인..args.?
//				접근자를찾아서해야한다..args.
		
		
		for(int i=0; i<Movie.count; i++) {
			System.out.println("==================");
			System.out.println("제목: "+list[i].title);
			System.out.println("감독:"+list[i].director);
			System.out.println("==================");
		}
	
	}

}
