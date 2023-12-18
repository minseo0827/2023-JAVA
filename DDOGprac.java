class Dog3 {
    
    private String name;
    public String breed;
    private int age;
    
    public Dog3(String breed, String name, int age) {
        this.breed = breed;
        this.setName(name);
        this.setAge(age);
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}


public class DDOGprac {
	public static void main(String[] args) {
	Dog3 myDog = new Dog3("Golden Retriever", "Max", 3);
	System.out.println("품종: " + myDog.breed);
	System.out.println("이름: " + myDog.getName());
	System.out.println("나이: " + myDog.getAge());
	}
}
