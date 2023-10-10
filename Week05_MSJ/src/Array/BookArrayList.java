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
    	//특정 위치를 입력받아 책 정보를 추가하는거란말야? 그럼 위치랑 정보를 받아야하고. 그래서 두개를받아.
    	//얘는 그냥 메소드니까 별거해줄거없어 그냥 넣기만하는거야대신 오류막으려고 위치인 인덱스가 양수인지는확인
    	
        if (index >= 0 && index <= arraylist.size()) {
        	//정상범위. 인덱스가 0보다크면서 사이즈보다 작거나같을때는
        	//어레이리스트에 추가를하는거지 넣을위치와 새 책을. 나중에 출력만 이게추가되었습니다 하고 보여주는거니까 그걸 어레이에집어넣는거.모든책들을..
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
