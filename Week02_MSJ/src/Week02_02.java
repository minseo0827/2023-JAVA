class Sports{
	String getName() { return "아직 결정되지 않음";}
	int getPlayers() {return 0;}
	
}
	
class Soccer extends Sports {
	public String getName() {
		return "경기이름: 축구";	
	}
	
	public int getPlayers() {
		
		int playerCount = 11;
	    System.out.println("경기자수: " + playerCount);
	    return playerCount;
			
	}
}
	

public class Week02_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Soccer S=new Soccer();
		System.out.println(S.getName());
		S.getPlayers();
	
		

	}

}
