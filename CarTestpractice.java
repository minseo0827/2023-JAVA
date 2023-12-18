class car{
	String color; 
	int gear, speed;
	
	void changeGear(int g) {gear=g;}
	void speedUP() {speed=speed++;}
	void speeddown() {speed=speed--;}
	
	car()
	{color="red";
		gear=2;
		speed=80;
	}
	
	car(String color, int gear, int speed) {
		this.color=color;
		this.gear=gear;
		this.speed=speed;		
	}
}
public class CarTestpractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		car mycar= new car("blue", 2, 70);
		System.out.println("The color of mycar is "+ mycar.color+", gear is on "+mycar.gear+", speed is "+mycar.speed);
		mycar.changeGear(1);
		System.out.println("The color of mycar is "+ mycar.color+", gear is on "+mycar.gear+", speed is "+mycar.speed);
		mycar.speedUP();
		System.out.println("The color of mycar is "+ mycar.color+", gear is on "+mycar.gear+", speed is "+mycar.speed);
	}
}
