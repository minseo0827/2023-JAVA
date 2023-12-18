class car10{
	String model, make;
	static int numberofcars;
	
	public static int getnumberofcars() {
		return numberofcars;
	}
	
	public car10(String model, String make) {
		this.model=model;
		this.make=make;
		numberofcars++; //생성자가하나호출되었다는건 차가하나생성되었다는거니까 여기하단에얘를붙이는구나
	}
	
}
public class Carprac {
	public static void main(String[] args) {
		
		
	}
}
