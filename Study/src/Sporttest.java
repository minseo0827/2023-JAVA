class Sports{
	//추상메소드를포함하면추상클래스가되기때문에변수를가질수없음
	String getName() {return "아직 결정되지 않음";} //추상메
	int getPlayers() {return 0;} //마찬가지로추상메

}

/*
 * class Soccer extends Sports { String name; int player;
 * 
 * public String getName() { return "경기 이름: "+name; } //추상메소드의오버라이딩. 리턴해줄때 문자열도
 * +로 연결해주면가능 public int getPlayers() { System.out.print("경기자수: "); return
 * player; } //얜 인트를반환해서 이것만가능..프린트문을앞에붙여줘도되나? //이게왜돼????
 * System.out.print("경기자수: "); 부분은 단순히 화면에 문자열을 출력, 반환 값은 return player;에서 반환되는
 * 정수 값 //이렇게 메서드 내에서 문자열 출력과 반환 값 반환을 동시에 수행할 수 있습니다. //메서드 getPlayers는 반환 값이
 * int 형식이기 때문에 int p = sc.getPlayers(); 코드에서는 반환된 정수 값만을 변수 p에 저장하고 출력됩니다. 문자열
 * 출력은 메서드 내에서만 화면에 출력되고, 반환 값은 외부에서 사용할 수 있습니다.
 * 
 * public Soccer(String name, int player) { this.name=name; this.player=player;
 * //이래도되고..아예 값을정해버려도되고... }
 * 
 * } public class Sporttest {
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * Soccer sc=new Soccer("축구", 11); String n=sc.getName();
 * System.out.print(n+"\n"); //아하..반환만해주는거라 어딘가에저장해야만출력해줄수잇구나 int p=
 * sc.getPlayers(); //반환된정수만이 여기 저장되고 저 위의 경기자수부분은 이걸 실행할때 먼저 화면에 출력된다..이런건가
 * System.out.print(p);
 * 
 * 
 * }
 * 
 * }
 */

//아예값을입력해버릴래 클래스이름도 축구겟다
class Soccer extends Sports {
	String name="축구";
	int player=11;
	
	public String getName() { return "경기 이름: "+name; } //추상메소드의오버라이딩. 리턴해줄때 문자열도 +로 연결해주면가능
	public int getPlayers() { /*System.out.print("경기자수: ");*/ return player; } //얜 인트를반환해서 이것만가능..프린트문을앞에붙여줘도되나?

//생성자없어도되나?
/*매개변수가 없는 기본 생성자를 가지고 있지 않기 때문에 기본 생성자가 자동으로 생성. 따라서 생성자를 명시적으로 정의하지 않아도 됨. 
 Soccer 클래스에서 name과 player를 클래스 멤버 변수로 초기화하고 있으므로 객체가 생성될 때 이러한 변수들이 기본 값으로 초기화/name은 "축구"로, player는 11*/
	
}
//public class Sporttest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Soccer sc=new Soccer();
//		String n=sc.getName();
//		System.out.print(n+"\n"); //아하..반환만해주는거라 어딘가에저장해야만출력해줄수잇구나
//		int p= sc.getPlayers(); //반환된정수만이 여기 저장되고 저 위의 경기자수부분은 이걸 실행할때 먼저 화면에 출력된다..이런건가
//		System.out.print(p);
//		
//
//	}
//
//}


//객체생성후 메소드호출할때앞에붙여주기
public class Sporttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Soccer sc=new Soccer();
		System.out.println("경기이름: "+sc.getName());
		System.out.println("경기자수: "+sc.getPlayers()); //소괄호빼먹지말기...
	}

}
