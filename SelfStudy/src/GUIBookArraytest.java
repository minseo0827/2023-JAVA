import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

//오...성공. 한번에 어레이리스트랑 gui를 같이 하기 힘들다면 일단 지유아이구현후에 액션리스너만들면서 메소드추가해도괜춘
//아님 메소드먼저 다 생각해두고 액션리스너안에서어케행할지생각하고 지유아이만들더낙

class Book1 {
//북클래스를만들어서 변수기본메소드 다 만들어서 이 객체째로 어레이리스트에저장할수잇게하고. toString 메소드는필수!!!!!!
//기본적으로 Java에서는 객체를 출력할 때 Object 클래스의 toString 메서드를 호출하게 됩니다
	private String BookName;
	private int BookId;

public Book1(String BookName, int BookId) {
	this.BookName=BookName;
	this.BookId=BookId; }

public String getBookName() {return BookName; }

public void setBookName(String BookName) {this.BookName=BookName;}

public int getBookId() {return BookId;}

public void setBookId(int BookId) {this.BookId=BookId;}

public String toString() {
	return BookName+"도서의 아이디는 "+BookId+"입니다."; //와..애가없으면 내가만든showallbook메소드가주솟값을갖고온다고...신기허네몰랏당
	}
}

class BookArray2 extends JFrame { //도서정보출력프로그램 . 리스트에저장해야함
//실제쓸애들. 어레이리스트를만들고 쓸 메소드들을구현.
	ArrayList<Book1> Booklist=new ArrayList(); //북형태의자료를받겟다.한거고지금은.
	//메소드정의..인가? (String name) 입력받는걸이렇게쓰듯 앞에거가 형태.객체고 뒤에거나 그 대상이니까 Book book으로 써주는거..
	
	JPanel panel1; JPanel panel2;
	JTextField nameField; JTextField idField; JButton b1; 
	JTextField indexField; JButton b2;
	JLabel label;
	
	public BookArray2() {
		panel1=new JPanel(); panel2=new JPanel();
		nameField=new JTextField(5); idField=new JTextField(5); b1=new JButton("등록");
		indexField=new JTextField(5); b2=new JButton("삽입"); label=new JLabel("rksk");
		
		panel1.add(nameField); panel1.add(idField); panel1.add(b1);
		panel2.add(indexField); panel2.add(b2);
		add(panel1, BorderLayout.NORTH); add(panel2, BorderLayout.CENTER); add(label, BorderLayout.SOUTH);
		
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//일반적으로등록할거란말야? 텍스트필드에서가져와서 객체만들고 add메소드에넣나..
				String name=nameField.getText();
				String id=idField.getText(); //어..객체생성이안된다.......
				int ID=Integer.parseInt(id);
				addBook(new Book1(name, ID));
				label.setText(name+" "+ID); //다만축적은안됨.... 뭐...보이긴한다.
				showAllBook();
			}
		});
		
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//지정된위치에삽입시키는얘엿지. 일단 텍스트필드에서갖고오고 메소드돌려서 레이벨에 표시하는수밖에.. 어ㅣㄷ에 삽입되엇음이런.진짜됏는지보고위해프린트도해저얗ㅁ
				String name=nameField.getText();
				String id=idField.getText();
				String index=indexField.getText();
				int ID=Integer.parseInt(id);
				int Index=Integer.parseInt(index);
				Book1 book1=new Book1(name, ID);
				insertBook(Index, book1);
				label.setText(name+id+"가 "+index+"에 잘 삽입되었음");
				showAllBook();
			
			}
		});
		
		
		setSize(500, 500);
		setVisible(true);
	}
	
	public void addBook(Book1 book) {Booklist.add(book);} //북클래스의 객체 북을 받아서 리스트에 집언허겟다
	
	public boolean removeBook(int BookId) { //입력받은걸찾고나서삭제헤야지
		for(int i=0; i<Booklist.size(); i++) {
			Book1 book= Booklist.get(i);
			int tempid=book.getBookId();
			if(tempid==BookId) {
				Booklist.remove(i);
				return true; }
		}
		return false;
	}
	
	public void showAllBook() {
		for(Book1 book : Booklist) {
			System.out.println(book); //북리스트에잇는 북개체 북에 대해서 그 개체를 프린트한다 
} }
	
	public void insertBook(int i, Book1 book) {
		Booklist.add(i, book); //이게맞나??싶네 맞댄다!
	}	
}

public class GUIBookArraytest {

	public static void main(String[] args) {
		//진짜실행부분이지머...
		
		BookArray2 bookArray=new BookArray2(); //두번째로만든클래스갖고오고. 그래야 거기서만든메소드를써먹지
		//만든 클래스로 객체생성해줘야 이제 작업이 가능하고.
		
		
	}

}
