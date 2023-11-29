class Shape8 {
	int x, y;
}

class Circle7 extends Shape8 {
	int radius;
	public Circle7(int radius) {
		this.radius=radius;
		x=0;
		y=0;
	}
	
	double getArea() {
		return 3.14*radius*radius;
	}
}


class Square8 extends Shape8 {
	int byeon;
	public Square8(int byeon) {
		this.byeon=byeon;
		x=0;
		y=0;
	}
	
	double getArea() {
		return byeon*byeon;
	}
}


class RightTriangle8 extends Shape8 {
	int bottom, height;
	public RightTriangle8(int bottom, int height)
	//위에 int 했는데 괄호안에 또 int를 써야하는이유는... 위에거는 변수고 괄호안의것은 그뭐여그매개변수?새로생성된?참조변수?라서그른가
	{
		this.bottom=bottom; //색깔이다르지
		this.height=height;
		x=0;
		y=0;
	}
	
	double getArea() {
		return 0.5*bottom*height;
	}
}


public class CircleTest2 {

	public static void main(String[] args) {
		Circle7 obj=new Circle7(10);
		System.out.println("원의 중심: (" + obj.x + ","+ obj.y + ")");
		System.out.println("원의 면적: "+obj.getArea());
		
		Square8 obj1=new Square8(5);
		System.out.println("정사각형의 한 변의 길이: "+ obj1.byeon);
		System.out.println("정사각형의 면적: "+obj1.getArea());
		
		RightTriangle8 obj2=new RightTriangle8(3, 4);
		//괄호안에넣는건 내가 위에서클래스정의할때 괄호안에썻던거에그대로받아가는거구나 x y가아니라
		System.out.println("직각삼각형의 밑변의 길이: "+ obj2.bottom);
		System.out.println("직각삼각형의 높이의 길이: "+ obj2.height);
		System.out.println("직각삼각형의 면적: "+obj2.getArea());

	}

}
