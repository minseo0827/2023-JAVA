class Dog1{
	
	private String name;
	public String breed;
	private int age;
	
	public Dog1(String name, String breed, int age) { this.breed=breed;//이런애를입력받을건데요걔는breed예요
		this.setname(name); //아...이런것도잇다고...오......
        this.setname(name);} 
	
	//이런걸,,하래네 이게그건가개수달라지면그걸로쳐준다는거. 이건메소드라기보단생성자인데도?흠....
	public Dog1(String name, int age) { this.setname(name); this.setage(age);}
	
	public String toString() {return "강아지의 이름은 "+name+"이고 강아지의 종류는 "+breed+", 강아지의 나이는 "+age+"살 이예요.\n";} //이렇게바로따옴표안에쓰면가는거고	
	public String barking() {return "멍!\n";}
	
	public void setname(String name) {this.name=name;}
	public void setage(int age) {this.age=age;}
	
	public String getname() {return name;}
	public int getage() {return age;}
}
public class Dogprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog1 mydog1=new Dog1("두부", "말티즈", 6);
		System.out.print(mydog1.toString());
		System.out.print(mydog1.barking());
		Dog1 mydog2=new Dog1("겨울이", 6);
		System.out.print(mydog2.getname()+" "+mydog2.getage());		
	}
}
