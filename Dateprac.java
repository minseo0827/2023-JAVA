class Date{
	
	int year, month1, day;
	String month2;
	
	public Date(int year, int month1, int day) { this.year=year; this.month1=month1; this.day=day;}
	public Date(int year, String month2, int day) { this.year=year; this.month2=month2; this.day=day;}
	
	public void print1() {
	System.out.print(year+"."+month1+"."+day);}
	
	public void print2() {
		System.out.print(month2+" "+day+", "+year);	
	}
}
public class Dateprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date1=new Date(2022, 9, 5);
		Date date2=new Date(2022, "August", 27);
		date1.print1();
		System.out.print("\n");
		date2.print2();
	}
}
