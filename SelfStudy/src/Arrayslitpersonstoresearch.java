//왜...주소.라고나오는ㄱ어ㅑ??
/*
 * import java.awt.BorderLayout; import java.awt.event.ActionEvent; import
 * java.awt.event.ActionListener; import java.util.ArrayList;
 * 
 * import javax.swing.JButton; import javax.swing.JFrame; import
 * javax.swing.JLabel; import javax.swing.JPanel; import javax.swing.JTextArea;
 * import javax.swing.JTextField;
 * 
 * class student {
 * 
 * String name; String tel; String address;
 * 
 * //그리고 메소드들. 설정할수잇는 셋과 겟 각각필요함 public String getname() { return name; } public
 * String gettel() { return tel; } public String getaddress() { return address;
 * }
 * 
 * //반환앙ㄴ해주니 보이드. 그리고 받는것의자료형도반드시써줘야한다!! public void setname(String name) {
 * this.name=name;} public void settel(String tel) { this.tel=tel;} public void
 * setaddress(String address) { this.address=address;}
 * 
 * //생성자. public student(String name, String tel, String address) { super();
 * //얜..머지 this.name=name; this.tel=tel; this.address=address; } }
 * 
 * class guistudent extends JFrame {
 * 
 * JPanel p1, p2, p3; JLabel name, tel, address; JTextField nameField, telField;
 * JTextArea addressArea; JButton save, search, exit; ArrayList<student>
 * mylist=new ArrayList<student>(); //스투던츠객체를담을어레이리스트생성.
 * 
 * public guistudent() { p1=new JPanel(); p2=new JPanel(); p3=new JPanel();
 * name=new JLabel("이름"); tel=new JLabel("전화번호"); address=new JLabel("주소");
 * nameField=new JTextField(10); telField=new JTextField(10); addressArea=new
 * JTextArea(30,30); save=new JButton("저장"); search=new JButton("검색"); exit=new
 * JButton("종료");
 * 
 * setLayout(new BorderLayout()); //지정하고 p1.add(name); p1.add(nameField);
 * p1.add(tel); p1.add(telField); p2.add(address); p2.add(addressArea);
 * p3.add(save); p3.add(search); p3.add(exit); add(p1, BorderLayout.NORTH);
 * add(p2, BorderLayout.CENTER); add(p3, BorderLayout.SOUTH);
 * 
 * save.addActionListener(new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) { //어레이리스트에객체형태로저장할거란말야.
 * 텍스트필드에입력한걸갖고와서 어레이리스트에저장해야지. String name=nameField.getText(); String
 * tel=telField.getText(); String add=address.getText(); student s1=new
 * student(name, tel, add); mylist.add(s1);
 * //System.out.print("이름은 "+student.name+", 전화번호는 "+student.tel+", 주소는 "
 * +student.address+"\n");
 * 
 * } });
 * 
 * 
 * search.addActionListener(new ActionListener() { public void
 * actionPerformed(ActionEvent e) { //이름 r익어와서 주소와 전번을 텍필에 표시해준다 String
 * name=nameField.getText(); //일단가져와서담아 //있는지찾어..어케찾는데. for (student p: mylist)
 * { if(p.getname().equals(name)) { //객체에저장된피의이름을갖고온게 받은네임과같다면
 * telField.setText(p.gettel()); //어레이리스트에들어있는 객체p중에 같은게있다면 개네를 가져온다.. 이걸위한
 * get메소드엿군아 addressArea.setText(p.getaddress()); //텍스트필드에띄워주는거니까
 * tf.setText("")인거지 } } } });
 * 
 * 
 * exit.addActionListener(e->System.exit(0)); //애드엑션리스너에바로...대고...
 * 
 * setSize(500, 500); setVisible(true);
 * 
 * } } //학생의정보를관리하는프로그램만들기. public class Arrayslitpersonstoresearch {
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * guistudent guistudent=new guistudent();
 * 
 * }
 * 
 * }
 */