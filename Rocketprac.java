class Rocket{
	
	int x, y;
	
	//그.클래스 구조 메소드구조 그건정리했느데 생성자는정리를못했네
	public Rocket(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	//문자열로반환하라는건...반환?이단어맞나하여튼해줄거니까 그 자료형적엊고 그냥문자열안에은근슬쩍넣어버리는것..인듯
	public String toString()
	{
		return "문자열로 반환한 로켓의 X좌표: "+x+" 문자열로 반환한 로켓의 y좌표: "+y;
	}
	
	public void moveUp() {
		y+=1;
	}
}
public class Rocketprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rocket naro=new Rocket(1250, 8250); //자꾸객체생성할때괄호를빼먹는다..그리고생성자만든형태를따라가줘야만한다
		String changed=naro.toString();
		System.out.println(changed);
		naro.moveUp();
		System.out.println(naro.x+","+naro.y);

	}

}
