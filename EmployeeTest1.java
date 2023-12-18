class Date8
{
	int year, month, date;
	
	public Date8(int year, int month, int date)
	{
		this.year=year;
		this.month=month;
		this.date=date;
	}
	
	public String toString() {
		return "Date [year=" + year+ ", month=" + month + ", date="+date+"]";
	}
	
}

class Employee4 {
	String name;
	private Date8 birthdate; //이렇게하는구나...그냥클래스작성은할수잇는데. 천천히..uml과맞추며..해보라하시네
	
	public Employee4(String name, Date8 birthdate) {
		this.name=name;
		this.birthdate=birthdate;
	}
	
	public String toString() {
		return "Employee [name="+name+", birthdate= "+birthdate+"]";
	}
}
public class EmployeeTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date8 birth=new Date8(1990, 1, 1);
		Employee4 employee=new Employee4("홍길동", birth);
		System.out.println(employee);
		
	}

}
