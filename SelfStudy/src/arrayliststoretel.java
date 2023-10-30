import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

//어레이리스트에 객체형태로저장하기위해선 그 객체,클래스를 추가로 만들어줘야한다
//펄슨객체생성할수잇게 클래스만듬. 그럼이제.. 텍스트필드에서읽오언것들로 객체를생성하고 그걸 어레이리스트에넣으면되려냐.
class person {
	
	String name;
	String tel;
	String address;
	
	//그리고 메소드들. 설정할수잇는 셋과 겟 각각필요함
	public String getname() { return name; }
	public String gettel() { return tel; }
	public String getaddress() { return address; }
	
	//반환앙ㄴ해주니 보이드. 그리고 받는것의자료형도반드시써줘야한다!!
	public void setname(String name) { this.name=name;}
	public void settel(String tel) { this.tel=tel;}
	public void setaddress(String address) { this.address=address;}
	
	//생성자.
	public person(String name, String tel, String address) {
		super(); //얜..머지
		this.name=name;
		this.tel=tel;
		this.address=address;
	}	
}

class addressbook extends JFrame {
	
	JPanel panel1; JPanel panel2; JPanel panel3;
	JLabel nameLabel; JLabel telLabel; JLabel addresslaJLabel;
	JTextField nameTextField; JTextField telField; JTextArea addressArea;
	JButton storeButton; JButton searchButton; JButton exitButton;
	
	//ArrayList<person> mylist=new ArrayList<person>(); //최초크기를정해놓지않고그때그때추가할거면어레이리스트의형태여야한다
	//mylist.add(new person(a,a,a));이거고. 텍스트필드에서 갖고와야하니까 getText쓰는거고. 그대로집어넣고객체생성하면되는거고.
	//ArrayList<person> infoList1; //펄슨객체만받는 어레이리스트생성, 이름은 인포리스트1.
	//어레이리스트는완벽하게선언해도되는듯?. 어쨌든.
	ArrayList<person> infoList1=new ArrayList<>();
	
	public addressbook() {
		//setBounds는 딱히 안 해줌. contentpane말고 다 다른 패널에담음.
		panel1=new JPanel(); panel2=new JPanel(); panel3=new JPanel(); 
		nameLabel=new JLabel("이름"); telLabel =new JLabel("전화번호"); addresslaJLabel=new JLabel("주소");
		nameTextField=new JTextField(10); telField=new JTextField(10); addressArea=new JTextArea(6, 30); //텍스트에리어는 (n,n)을 써줘야함
		storeButton=new JButton("저장"); searchButton=new JButton("검색"); exitButton=new JButton("종료");
		
		panel1.add(nameLabel); panel1.add(nameTextField); panel1.add(telLabel); panel1.add(telField);
		panel2.add(addresslaJLabel); panel2.add(addressArea); 
		panel3.add(storeButton); panel3.add(searchButton); panel3.add(exitButton);
		
		//레이아웃을해줘야하나본데...그래야 화면에 다 뜬다
		add(panel1, BorderLayout.NORTH); add(panel2, BorderLayout.CENTER); add(panel3, BorderLayout.SOUTH);
		
		storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//펄슨객체생성할수잇게 클래스만듬. 그럼이제.. 텍스트필드에서읽오언것들로 객체를생성하고 그걸 어레이리스트에넣으면되려냐.
				String name=nameTextField.getText();
				String tel=telField.getText();
				String address=addressArea.getText(); //읽어오고!
				person person=new person(name, tel, address); //새객체생성
				infoList1.add(person); //이러면들어가지나??
				//infoList1.add(new person(name, tel, address)); 한줄로도 가능!
				System.out.print("이름은 "+person.name+", 전화번호는 "+person.tel+", 주소는 "+person.address+"\n");
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//서치는...뭘...해줘야하냐? 있는지없는지 확인하기? 이름을받으면전번과 주소가뜨게한다.
			String name=nameTextField.getText(); //일단가져와서담아
			//있는지찾어..어케찾는데.
			for (person p: infoList1) {
				if(p.getname().equals(name)) { //객체에저장된피의이름을갖고온게 받은네임과같다면
					telField.setText(p.gettel()); //어레이리스트에들어있는 객체p중에 같은게있다면 개네를 가져온다.. 이걸위한 get메소드엿군아
					addressArea.setText(p.getaddress()); //텍스트필드에띄워주는거니까 tf.setText("")인거지
				}
			}	
			}
		});
		
		exitButton.addActionListener(e->{System.exit(0);});
		
		setSize(500, 400);
		setVisible(true);
	}
}
public class arrayliststoretel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addressbook addressbook=new addressbook();
	}

}
