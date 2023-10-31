import java.util.ArrayList;
import java.util.Scanner;

class Book {
//북클래스를만들어서 변수기본메소드 다 만들어서 이 객체째로 어레이리스트에저장할수잇게하고. toString 메소드는필수!!!!!!
//기본적으로 Java에서는 객체를 출력할 때 Object 클래스의 toString 메서드를 호출하게 됩니다
	private String BookName;
	private int BookId;

public Book(String BookName, int BookId) {
	this.BookName=BookName;
	this.BookId=BookId; }

public String getBookName() {return BookName; }

public void setBookName(String BookName) {this.BookName=BookName;}

public int getBookId() {return BookId;}

public void setBookId(int BookId) {this.BookId=BookId;}

public String toString() { //애가지정되어야한다고..
	return BookName+"도서의 아이디는 "+BookId+"입니다."; //와..애가없으면 내가만든showallbook메소드가주솟값을갖고온다고...신기허네몰랏당
	}
}


class BookArray{ //도서정보출력프로그램 . 리스트에저장해야함
//실제쓸애들. 어레이리스트를만들고 쓸 메소드들을구현.
	ArrayList<Book> Booklist=new ArrayList(); //북형태의자료를받겟다.한거고지금은.
	//메소드정의..인가? (String name) 입력받는걸이렇게쓰듯 앞에거가 형태.객체고 뒤에거나 그 대상이니까 Book book으로 써주는거..
	public void addBook(Book book) {Booklist.add(book);} //북클래스의 객체 북을 받아서 리스트에 집언허겟다
	
	public boolean removeBook(int BookId) { //입력받은걸찾고나서삭제헤야지
		for(int i=0; i<Booklist.size(); i++) {
			Book book= Booklist.get(i);
			int tempid=book.getBookId();
			if(tempid==BookId) {
				Booklist.remove(i);
				return true; }
		}
		return false;
	}
	
	public void showAllBook() {
		for(Book book : Booklist) {
			System.out.println(book); //북리스트에잇는 북개체 북에 대해서 그 개체를 프린트한다 
} }
	
	public void insertBook(int i, Book book) {
		Booklist.add(i, book); //이게맞나??싶네 맞댄다!
	}	
}

public class BookArrayTest {

	public static void main(String[] args) {
		//진짜실행부분이지머...
		
		BookArray bookArray=new BookArray(); //두번째로만든클래스갖고오고. 그래야 거기서만든메소드를써먹지
		//만든 클래스로 객체생성해줘야 이제 작업이 가능하고.
		
		Book b1 = new Book("파우스트", 0001); //객체생성~
		Book b2 = new Book("황무지",0002);
		Book b3 = new Book("변신",0003);
		Book b4 = new Book("픽션들",0004);
		Book b5 = new Book("톨스토이",0005);
		
		bookArray.addBook(b1);//내가만든클래스의메소드로책집어넣기하는중. 이미 addBook메소드를 리스트에집어넣는형태로짰기때문에 여기서또리스트만들거없고걍메소드만사용해도됨
		bookArray.addBook(b2);bookArray.addBook(b3); bookArray.addBook(b4); bookArray.addBook(b5);
		bookArray.showAllBook();
		
		//키보드로 직접 입력받기
		Scanner scanner=new Scanner(System.in);
		System.out.print("책의 이름을 입력");
		String name=scanner.next();
		System.out.print("책의 아이디를 입력");
		int ID=scanner.nextInt();
		//받은걸리스트에추가.하려면익ㄹ갖고북개체를만들어야하낟
		Book b6=new Book(name, ID);
		bookArray.addBook(b6);
		//알듯말듯하네... 리스트에직접추가하는형식이아닌건 그런 메소드를 대신 만들었기때문에 간단해져서그런거고.
		bookArray.showAllBook();
		
		//키보드로 위치도 입력받기. 	public void insertBook(int i, Book book) { Booklist.add(i, book); //이게맞나??싶네 맞댄다! 이거쓰라는거지
		System.out.print("위치를 입력");
		int i=scanner.nextInt();
		System.out.print("책의 이름을 입력");
		String name2=scanner.next();
		System.out.print("책의 아이디를 입력");
		int ID2=scanner.nextInt();
		Book book7=new Book(name2, ID2);
		bookArray.insertBook(i, book7);
		bookArray.showAllBook();
		//오. 해냇어.	
	}

}
