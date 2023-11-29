class Shape1{
	public double getArea() { return 0;}
		public Shape1() {super();}
	}
	


class Rectangle extends Shape1{
	private double width, height;
	public Rectangle(double width, double height) {
		super();
		this.width=width;
		this.height=height;
		
	}
	public double getArea() {return width*height;}
}

class Triangle extends Shape1{
	private double base, height;
	public double getArea() {return 0.5*base*height;}
	public Triangle(double base, double height) {
		super();
		this.base=base;
		this.height=height;
	}	
	
}


public class ShapeAreaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape1 obj1=new Rectangle(10.0, 20.0);
		Shape1 obj2=new Triangle(10.0, 20.0);
		
		System.out.println("Rectangle: "+obj1.getArea());
		System.out.println("Triangle: "+obj1.getArea());

	}

}
