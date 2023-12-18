class Person1 {
	private String regnumber;
	private double weight;
	protected int age;
	String name;
	
	public double getweight() {
		return weight;
	}
	

public void setWeight(double weight) {
	this.weight=weight;
	
	}
}

class Student extends Person1 {
	int id;
}
public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student obj=new Student();
		obj.age=21;
		obj.name="Kim";
		obj.setWeight(75.0);

	}

}
