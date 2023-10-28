interface Animal { //인터페이스고..추상메만들어가던가..디폴메까지. 마찬가지로변수선언불가. 다중상속하고싶은데이미상속하나한경우스타일..
	void walk();
	void fly();
	void sing();
	
}

class Bird implements Animal {
	public void walk() {System.out.print("걸을 수 있음\n");}
//public을 안써주고 냅두면. 인터페이스의 경우 기본접근제한이 퍼블릭인데 일반 클래스에서 안쓰면 디폴트가 되어서 오류! Cannot reduce the visibility of the inherited method from Animal
//인터페이스의 메서드는 기본이 publi, 클래스에서 이를 구현할 때 반드시 동일한 또는 더 넓은(public) 가시성을 가져야함. 근데 아무것도안쓰면 기본적으로 default 가시성이 적용, 오류 발생
	public void fly() {System.out.print("날을 수 있음\n");}
	public void sing() {System.out.print("노래 부를 수 있음\n");}
}
public class Animaltest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bird chamsaeBird=new Bird();
		chamsaeBird.walk();
		chamsaeBird.fly();
		chamsaeBird.sing();
	}

}
