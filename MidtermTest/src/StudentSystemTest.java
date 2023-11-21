/*
 * import java.awt.BorderLayout; import java.awt.event.ActionEvent; import
 * java.awt.event.ActionListener; import java.io.FileWriter; import
 * java.io.PrintWriter; import java.util.ArrayList; import java.util.List;
 * import java.util.Scanner;
 * 
 * import javax.swing.JButton; import javax.swing.JFrame; import
 * javax.swing.JLabel; import javax.swing.JPanel; import javax.swing.JTextField;
 * 
 * class Student {
 * 
 * String name; int id; double grade;
 * 
 * //그리고 메소드들. 설정할수잇는 셋과 겟 각각필요함 public String getname() { return name; } public
 * int getid() { return id; } public double getgrade() { return grade; }
 * 
 * //반환앙ㄴ해주니 보이드. 그리고 받는것의자료형도반드시써줘야한다!! public void setname(String name) {
 * this.name=name;} public void setid(int id) { this.id=id;} public void
 * setgrade(double grade) { this.grade=grade;}
 * 
 * //생성자. public Student(String name, int id, double grade) { super(); //얜..머지
 * this.name=name; this.id=id; this.grade=grade; } }
 * 
 * class GradeBook extends JFrame {
 * 
 * List<Student> studentlist=new ArrayList<Student>(); JPanel panel1, panel2,
 * panel3; JLabel l1, l2, l3, l4, l5; JTextField nameField, idField, gradeField,
 * sField, resField; JButton in, end; int state; int count=0;
 * 
 * public GradeBook() { panel1=new JPanel(); panel2=new JPanel(); panel3=new
 * JPanel(); l1=new JLabel("학생 등록하기"); l2=new JLabel("이름"); l3=new JLabel("학번");
 * l4=new JLabel("성적"); l5=new JLabel("검색할 학번"); nameField=new JTextField(10);
 * idField=new JTextField(10); gradeField=new JTextField(10); resField=new
 * JTextField(10); sField=new JTextField(10); in=new JButton("등록"); end=new
 * JButton("검색");
 * 
 * setLayout(new BorderLayout()); panel1.add(l1); panel2.add(l2);
 * panel2.add(nameField); panel2.add(l3); panel2.add(idField); panel2.add(l4);
 * panel2.add(gradeField); panel3.add(resField); panel3.add(in);
 * panel3.add(end); panel3.add(sField); panel3.add(l5); add(panel2,
 * BorderLayout.CENTER); add(panel3, BorderLayout.SOUTH);
 * 
 * 
 * in.addActionListener(new ActionListener() { public void
 * actionPerformed(ActionEvent e) { String name=nameField.getText(); String
 * idString=idField.getText(); String gradeString=gradeField.getText();
 * System.out.print("이름: "+name+" 학번: "+idString+" 성적: "+gradeString+"\n");
 * 
 * } });
 * 
 * end.addActionListener(new ActionListener() { public void
 * actionPerformed(ActionEvent e) { String idString=sField.getText();
 * search(idString);
 * 
 * } });
 * 
 * 
 * 
 * 
 * setTitle("덕성여대 화이팅"); setSize(500, 300); setVisible(true);
 * 
 * }
 * 
 * public double Average() { double res=0; double sum=0;
 * 
 * for(Student s: studentlist) { sum=sum+s.grade; count++; } res=sum/count;
 * return res;
 * 
 * }
 * 
 * //모든학생의정보출력..이게맞나? public void showAllInfo() { for(Student s : studentlist) {
 * //파일에쓰게해야한다...인거지? System.out.print(s); try {
 * 
 * 
 * } catch (Exception e) { // TODO: handle exception }
 * 
 * 
 * } }
 * 
 * 
 * 
 * public void search(int id) { for(Student student : studentlist) {
 * if(student.getid()==id) {
 * resField.setText("\n이름: "+student.name+" 성적: "+student.grade+"\n");
 * 
 * } }
 * 
 * 
 * 
 * } }
 * 
 * public class StudentSystemTest {
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * Scanner scanner=new Scanner(System.in); GradeBook gradeBook=new GradeBook();
 * 
 * // studentlist.add(new Student("C", 2313, 3.8)); // studentlist.add(new
 * Student("P", 2314, 3.9)); // studentlist.add(new Student("B", 2315, 4.2));
 * 
 * //이게겹치네. 입력이끝나면 받아야하나? 입력이끝나면검색을받아야하는데... // 파일출력도..
 * 
 * System.out.print("검색할 학생의 학번을 입력:"); int inputid=scanner.nextInt();
 * gradeBook.search(inputid);
 * 
 * gradeBook.showAllInfo();
 * System.out.print("전체 학생은 총"+gradeBook.count+"명이고 평균 점수는 +"+gradeBook.Average(
 * )+"점입니다.");
 * 
 * 
 * }
 * 
 * }
 */