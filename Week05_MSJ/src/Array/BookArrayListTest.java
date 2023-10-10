package Array;
import java.util.ArrayList;
import java.util.Scanner;

//GUI로의연계.,...?
public class BookArrayListTest {

    public static void main(String[] args) {
        BookArrayList bookArrayList = new BookArrayList();

        Book book1 = new Book(1, "파우스트");
        Book book2 = new Book(2, "황무지");
        Book book3 = new Book(3, "변신");
        Book book4 = new Book(4, "픽션들");
        Book book5 = new Book(5, "톨스토이");

        bookArrayList.addBook(book1);
        bookArrayList.addBook(book2);
        bookArrayList.addBook(book3);
        bookArrayList.addBook(book4);
        bookArrayList.addBook(book5);
        bookArrayList.showAllBook();

        Scanner scanner = new Scanner(System.in);
        System.out.print("추가할 도서의 위치를 입력하세요: ");
        int insertIndex = scanner.nextInt();
        scanner.nextLine(); // Enter 처리

        System.out.print("도서 ID를 입력하세요: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Enter 처리

        System.out.print("도서 제목을 입력하세요: ");
        String title = scanner.nextLine();

        Book newBook = new Book(bookId, title);
        bookArrayList.insertBook(insertIndex, newBook); // insertBook 메서드 호출 시 인자 전달
        bookArrayList.showAllBook();

        scanner.close();
    }
}
