class shape {
	int x, y;
	String name;
	
	public void introduce() {
		System.out.print("이름은 "+name+"\n");
		System.out.print("좌표는 "+x+", "+y+"\n");
	}
}

class Circle extends shape {
	int radius;
	
	//지름은 생성시 입력받고싶다면
	public Circle(int radius) {
		this.radius=radius;
	}
	
	public void calcul() { //이런메소드를만들거고. 반환없으니 보이드고.
		System.out.print("둘레는 "+3.14*2*radius+"\n");
		System.out.print("넓이는 "+ 3.14*radius*radius+"\n");
	}
	
	public void introduce() {
		System.out.print("좌표는 사실상 큰 의미는 없어요\n");
		//오버라이딩. 아예 내용을 새걸로 만들어버리는거. 부모클래스안의 메소드는 나오지않음, 이 클래스안에서 새로쓰여진애가나오는거.
		
	}
}
public class 상속연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Circle c1=new Circle();
		Circle c1=new Circle(4);
		c1.name="원";
		c1.x=2;
		c1.y=2;
		c1.introduce();
//		c1.radius=4;
		c1.calcul();
		

	}

}
