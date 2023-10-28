package Array;

public class Book {
	private String bookName;
	private String author;
	private int BookId;
	
	public Book() {} //디폴드 생성자

	public Book(int BookId, String BookName) {
		this.BookId=BookId;
		this.bookName=BookName;
		
	}
	
public Book(String bookName, String author) {
	this.bookName=bookName;
	//this.author=author;
}


public int getBookId() {
	return BookId;
}

public void setBookId(int BookId) {
	this.BookId=BookId;
	
}

public String getBookName() {
	return bookName;
}

public void setBookName(String bookName) {
	this.bookName=bookName;
}

/*
 * public String getAuthor() { return author; }
 * 
 * public void setAuthor(String author) { this.author=author; }
 */

public void showBookInfo() {
	System.out.println(bookName + "," + author);
	} // 책 정보를 출력해주는 메서드


public String toString() {
	return bookName + "도서의 아이디는 " + BookId + "입니다";
}
}