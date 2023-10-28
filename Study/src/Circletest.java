//week0201
//원을 나타내는 서클을 상속받아 피자를 나타내는 피자클래스작성

class Circle0 {
	protected int radius;
	public Circle0(int r) {
		radius=r; //생성자
	}
}

class Pizza extends Circle0 {
	String name;
	
	public Pizza(String name, int radius) { //입력받은걸 네임에넣겟다~인거지. 
		//파이썬으로따지면 def print(start): 같은... 그 받은 start는 그냥 값 받는 매개변수인거고. 변수의이름자체에는변화가없다 네임 래디오스 그대로.
		super(radius); //이래도a제대로들어가나..?
		this.name=name; //그냥내가편한...디스.ㅁ=ㅁ; 이래도된다
		//자바에서 생성자의 매개변수 순서가 일치하지 않아도 괜찮
		//매개변수 이름과 순서가 맞지 않는 경우 알아서 찾으려고 시도
		//따라서 생성자의 매개변수 자료형이 일치하는 경우에는 순서가 달라도 정상적으로 동작
	}
	public void print() {
		System.out.print("피자 이름은 "+name+", 피자 크기는 "+radius);
	}
	
}
public class Circletest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza p1=new Pizza("doublemeat", 10);
		p1.print();

	}

}
