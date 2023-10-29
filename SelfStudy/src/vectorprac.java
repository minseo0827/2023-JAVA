import java.util.Vector;

class monster {
	String name;
	double power;
	
	
	//생성자
	public monster(String name, double power) {
		this.name=name;
		this.power=power;
	}
	
}
public class vectorprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<monster> v=new Vector<>();
		v.add(new monster("mon1", 100.0)); //객체생성과 add()를 동시에하고싶다면 new monster써주기. 당연한거깅ㅁ함
		v.add(new monster("mon2", 200.0));
		v.add(new monster("mon3", 300.0));
		//monster m1=new monster(); 이게객체생성이고 add(m1)인데 한줄로쓸거니까 우변전체가들어가야지머
	
		 for (monster m : v) { //벡터에잇는 몬스터객체에 대하여.
	            System.out.println("이름은 " + m.name + ", 힘은 " + m.power); //그객체의이름이니까 m.name!!!!!!!
	        }
		
		//벡터가 인덱스에접근가능하다는건 이런 뜻
		 //monster firstMonster = v.get(0);
		 //System.out.println("이름은 " + firstMonster.name + ", 힘은 " + firstMonster.power);
		 
		 //v.add(1, "apple")
	}

}
