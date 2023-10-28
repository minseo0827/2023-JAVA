package Array;
import java.util.ArrayList;
import java.util.Scanner;

//GUI로의연계.,...?
public class BookArrayListTest {

    public static void main(String[] args) {
        BookArrayList bookArrayList = new BookArrayList();
        //리스트를만들고집어넣기

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
        //받은.다음의정수를 인서트인덱스에다가넣고
        scanner.nextLine(); // Enter 처리

        System.out.print("도서 ID를 입력하세요: ");
        int bookId = scanner.nextInt();
        //받은 아이디를 북아이디에넣고
        scanner.nextLine(); // Enter 처리

        System.out.print("도서 제목을 입력하세요: ");
        String title = scanner.nextLine();
        //받은다음의줄을제목에다가넣고

        Book newBook = new Book(bookId, title);
        //그 받아서 아이디 제목에다가넣은애들을 가지고새로운북이라는객체를만들고
        bookArrayList.insertBook(insertIndex, newBook); // insertBook 메서드 호출 시 인자 전달
        /*인서트북이라는 메소드에다가 그 인덱스랑 새 책을 집어넣어서 이걸 리스트에 추가.리스트에메소드이용
        public void insertBook(int index, Book newBook) arraylist.add(index, newBook); 이런거하는게 인서트북이라는 메소드. 인덱스랑 책(아이디+제목) 받아서 그걸 리스트에애드하는애. 
        인서트인덱스인건 걍 집어넣을인덱스라서그런이름일뿐...하여튼 집어넣고.
		 * 그냥 애드면 내용인 북만 있었겟지만 얘는 원하는위치에삽입하는거라서 인덱스를같이받는거야. index라고 쓴 순간부터 애는 인덱스로가는건가?
		 * 괄호안에 두개가 들어간다면 첫번째는 인덱스인걸로? index말고 i number이런거여도되나???추후고민 하여튼 그렇게 집어넣고
		 *
		 *public void insertBook(int index, Book newBook) 
        if (index >= 0 && index <= arraylist.size()) {
            arraylist.add(index, newBook);
          else {
            System.out.println("유효하지 않은 위치입니다. 도서가 추가되지 않았습니다.");
        }
    } 이 메소드에서  arraylist.add(index, newBook); 이 부분이 없엇다면 사용자로부터 받은 인자 중 정수인것이 인덱스라는것을 모르는거야?


네, arraylist.add(index, newBook); 부분이 없다면 메소드 내에서 사용자로부터 받은 인자 중 정수인 것이 인덱스로 사용되는지에 대한 정보가 없으며, 메소드가 도서를 어떤 위치에 추가해야 하는지 결정할 수 없습니다.
인자와 관련된 정보와 로직이 없다면 메소드는 아무 작업도 수행하지 않으며, 입력된 인자들에 대한 처리나 유효성 검사가 이루어지지 않습니다. 따라서 메소드 내에서 실제 작업을 수행하려면 인자를 기반으로 처리해야 합니다.
arraylist.add(index, newBook); 부분은 메소드의 핵심 로직으로, 실제로 도서를 주어진 index 위치에 추가하는 부분입니다. 이 코드가 없으면 메소드는 인자로 전달된 index와 newBook을 사용하여 어떤 작업도 수행하지 않으며, 메소드가 책을 추가하라는 역할을 수행하지 않습니다.
따라서 arraylist.add(index, newBook); 부분이 메소드의 핵심이며, 이 부분이 없다면 메소드는 아무런 작업을 수행하지 않습니다.
		 *
		 */
        
        bookArrayList.showAllBook();

        scanner.close();
        
       
    }
}
