class student1{
	private int rollno;
	String name;
	int age;
	
	public student1(String name, int age) {
		this.name=name; this.age=age;
	}
	
	public void setrollno(int rollno) {this.rollno=rollno;}
	public int getrollno() {return rollno;}
	
}
public class Studentprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student1 stu=new student1("Kim", 20);
		stu.setrollno(2022);
		System.out.print("학생의 이름: "+stu.name+"\n학생의 학번: "+stu.getrollno()+"\n학생의 나이: "+stu.age+"\nStudent1 객체가 생성되었습니다.");
		//프린트문에서 어떤건 소괄호가 필요하고 아닌것의 차이는... 메소드가 아니면 괄호없음이런건가? 메소드쓰는거면괄호들어감?
	}
}
