class Movie1{
	String title, director, actor;
	int year;
	double score;
	
	public Movie1(String title, double score, String director, String actor, int year) {
		this.title=title; this.score=score; this.director=director; this.actor=actor; this.year=year;}
	
	public String tostring() {
		return "제목: "+title+"\n감독: "+director+"\n연도: "+year+"\n주연배우: "+actor+"\n평점: "+score;
	}
}
public class Movieprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie1 mov=new Movie1("티파니에서 아침을", 8.43, "블레이크 에드워즈", "오드리 헵번",  1962);
		System.out.print(mov.tostring());
	}

}
