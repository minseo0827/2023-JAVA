class Pizza10{
	int radius;
	
	Pizza10(int r){
		radius=r;
	}
	
	Pizza10 whosLargest(Pizza10 p1, Pizza10 p2) {
		if (p1.radius > p2.radius)
			return p1;
		else
			return p2;
	}
	
}
public class Pizzaprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza10 obj1=new Pizza10(15);
		Pizza10 obj2=new Pizza10(18);
		
		Pizza10 largest=obj1.whosLargest(obj1, obj2);
		System.out.println(largest.radius + "인치 피자가 더 큼.");
		
		
	}

}
