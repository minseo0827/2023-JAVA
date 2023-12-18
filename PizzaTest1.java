class Pizza2
{
	int size;
	String type;
	
	public Pizza2() {
		size= 12;
		type ="슈퍼슈프림";
		
	}
	
	public Pizza2(int s, String t) {
		size= s;
		type =t;
		
	}
	
}
public class PizzaTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza2 obj1=new Pizza2();
		System.out.println("("+obj1.type+ " , "+obj1.size+", )");
		
		Pizza2 obj2=new Pizza2(24, "포테이토");
		System.out.println("("+obj2.type+ " , "+obj2.size+", )");
		

	}

}
