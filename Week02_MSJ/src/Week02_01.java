class Circle {
	protected int radius;
	public Circle(int r) {radius=r;}
	public Circle() {
	System.out.println("Circle의 생성자");
	}
		
	
}

class Pizza extends Circle {
	private int amount;
	private String taste;
	
	public void Pizza() {
		System.out.println("피자입니다");
	}
	
	public Pizza(String taste, int amount) {
		this.amount=amount;
		this.taste=taste;
		System.out.println("이 피자의 맛은 "+taste+", 개수는 "+amount+" 판");
	}
	
}
public class Week02_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza p=new Pizza("페퍼로니", 2);

	}

}
