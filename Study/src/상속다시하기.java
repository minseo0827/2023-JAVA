class livingThing {
	
	String name;
	int average;
	String habitat;
	int leg;
	
	public livingThing(String name, int average, String habitat, int leg) {
		this.name=name;
		this.average=average;
		this.habitat=habitat;
		this.leg=leg;
		//위 클래스로 객체생성시이렇게초기화하겟다는거지	
	}
	
	//메소드도만들래.
	public void print() {
		System.out.print("이름: "+name);
		System.out.print(" 평균 수명: "+average);
		System.out.print(" 서식지: "+habitat);
		System.out.print(" 다리 개수: "+leg);
	}
}

class cat extends livingThing {
	String birth;
	
	public cat(String name, int average, String habitat, int leg, String birth) {
		super(name, average, habitat, leg);
		this.birth=birth;	//이렇게받아서초기화를할거고.
	}
	public void print() {
		super.print();
	 	System.out.print(" 번식 형태: "+birth);	}
}


class Human extends livingThing {
	String house;
	
	public Human(String name, int average, String habitat, int leg, String house) {
		super(name, average, habitat, leg);
		this.house=house;
	}
	public void print() {
		super.print();
	 	System.out.print(" 사는 곳: "+house);	}
}

class mushroom extends livingThing { //여기에는 괄호가안붙고!
	String type;
	public mushroom(String name, int average, String habitat, int leg, String type) {
		super(name, average, habitat, leg); 
		this.type=type;
	}
	
	public void print() {
		super.print();
		System.out.print(" 형태: "+type);
	}
}
public class 상속다시하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat migo=new cat("미고", 10, "길거리", 4, "포유류");
		Human bob=new Human("밥", 85, "사회", 2, "아파트");
		mushroom sesong=new mushroom("새송이", 4, "음지", 0, "포자");
		
		System.out.print("미고의 정보: ");
		migo.print();
		System.out.print("\n밥의 정보: ");
		bob.print();
		System.out.print("\n새송이의 정보: ");
		sesong.print();
		System.out.print("\n");
		migo.name="미친듯이먹는고로케"; //접근하여변경도가능.이엇지
		migo.print();
		
	}

}

//공통되는건그대로 super(); super.메소드이름; 으로 갖다 쓸 수 잇고 따로필요한경우만생성해줄수잇다 효율적!
