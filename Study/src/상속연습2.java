//아예생성시부터입력받게만들거야
import java.util.ArrayList;


class Book {
	String title, author;
	int isbn, price;
	
	public Book(String title, String author, int isbn, int price) {
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.price=price;
	}
	
	//get..을만ㄷ르어줘야힌다....
	
	public String gettitle() {	return title;	}
	public String getauthor() {	return author;	}
	public int getisbn() {	return isbn;	}
	public int getprice() {	return price;	}
	
}

class EBook extends Book {
	int filesize;
	String format;
	
	public EBook(String title, String author, int isbn, int price, int filesize, String format) {
		super(title, author, isbn, price);
		this.filesize=filesize;
		this.format=format;
	}
	
	public int getfilesize() {	return filesize;	}
	public String getformat() {	return format;	}
}

class Library {

    private ArrayList<Book> booklist = new ArrayList<>(); //리스트를내가생성
    //이게...뭔의미냐? 제네릭?????
    //ArrayList<>는 제네릭을 사용하여 Book 객체만을 저장할 수 있는 리스트를 만듭니다.
    //Book 객체의 리스트를 저장하는 동적 배열. 이것만저장하겟다..?제네릭이뭐드라
    //코드의안정성. 북이라고해놧는데 북말고다른게들어오면 오류라고 알려준다...
    
	public void addBook(Book book) { //이거뭐엿더라???
		//도서를 도서 목록에 추가. 무..뭔데
		booklist.add(book);
	}
	
	public void removeBook(int isbn) {
		//주어진 숫자를 가진 애를 목록에서 제거. 목록이란게..먼ㄷ?
		for (Book book : booklist) {
            if (book.getisbn()==(isbn)) {
                booklist.remove(book);
                break;
            }
        }
	}
	
	public void listBooks() {
		//현재 도서 목록 출력. 흠.
		
		 for (Book book : booklist) {
	            System.out.println("Title: " + book.gettitle());
	            System.out.println("Author: " + book.getauthor());
	            System.out.println("ISBN: " + book.getisbn());
	            System.out.println("Price: " + book.getprice());
	            if (book instanceof EBook) {
	                EBook eBook = (EBook) book;
	                System.out.println("File Size: " + eBook.getfilesize());
	                System.out.println("Format: " + eBook.getformat());
	            }
	            System.out.println();
	        }
	    }
	}
public class 상속연습2 {

	public static void main(String[] args) {
		Book book=new Book("내스급", "근서", 3893109, 100);
		EBook eBook=new EBook("전독시", "싱숑", 22221111, 100, 20, "pdf");
		Library library = new Library();
		library.addBook(book);
		library.addBook(eBook);
		library.listBooks();
		library.removeBook(22221111);
		library.listBooks();

	}

}
