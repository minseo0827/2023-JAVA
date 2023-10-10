package Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BookArrayList {
	
    private ArrayList<Book> arraylist;
    
    public BookArrayList() {
        arraylist = new ArrayList<Book>();
    }
    
    public void addBook(Book book) {
        arraylist.add(book);
    }
    
    public boolean removeBook(int bookId) {
        for (int i = 0; i < arraylist.size(); i++) {
            Book book = arraylist.get(i);
            int tempId = book.getBookId();
            if (tempId == bookId) {
                arraylist.remove(i);
                return true;
            }
        }
        
        System.out.println(bookId + "가 존재하지 않습니다.");
        return false;
    }
    
    public void showAllBook() {
        for (Book book : arraylist)
            System.out.println(book);
        System.out.println();
    }
    
    public void insertBook(int index, Book newBook) {
        if (index >= 0 && index <= arraylist.size()) {
            arraylist.add(index, newBook);
            System.out.println("도서가 성공적으로 추가되었습니다.");
        } else {
            System.out.println("유효하지 않은 위치입니다. 도서가 추가되지 않았습니다.");
        }
    }
    
    public static void main(String[] args) {
        BookArrayList library = new BookArrayList();
        library.insertBook(0, new Book(1, "파우스트")); // 예시로 도서 하나 추가
        library.showAllBook();
    }
}
