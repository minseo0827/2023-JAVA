
class Animal {
	String name;
	
	public Animal(String name) {
	this.name=name;
}
	
	public void sleep() {
		System.out.println(name+" is sleeping~");
	}
	
	public void eat() {
		System.out.println(name+" is eating chubchub");
	}
	
}
class Dog extends Animal {
	public Dog(String name) {
		super(name);
		
	}
	
	public void bark() {
		System.out.println(name+" is barking mungmung");
		
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
		
	}
	
	public void play() {
		System.out.println(name+" is playing myawmyaw");
		
	}
}

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog("Luka");
		Cat cat=new Cat("Yaong");
		dog.sleep();
		dog.eat();
		dog.bark();
		
		cat.sleep();
		cat.eat();
		cat.play();

	}

}
