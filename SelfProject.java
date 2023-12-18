//동물을 나타내는 Animal클래스를 상속받아서 새를 나타내는 Bird클래스를 작성해보자.

class Animal5{
     void walk(){
    	 System.out.println("걸을수 있음");} }

class Bird extends Animal5{
   public void fly() {System.out.println("날을 수 있음");}
   public void sing() {System.out.println("노래 부를 수 있음");}
   
}

public class SelfProject {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Bird bird = new Bird();
		 bird.walk();
		 bird.fly();
		 bird.sing();
	}
}
