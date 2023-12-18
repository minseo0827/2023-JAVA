//4.4예제. 틀을만든건데 틀에대한변수가세개고 생성자가만들어진건데 메소드가 프린트. 39까지틸레베전클래스고 그아래론 데스트인데. 파일명이텔레비젠테스트라고되어야한다
//public 지우라네.맞네......메인메소드가잇는명이파일명이어야명확히돌아간다..그리고 괄호짝맞는지도주의.
class Television1 {

	private int channel;
	private int volume;
	private boolean onOff;
	
	Television1(int c, int v, boolean o) {
		channel =c;
		volume=v;
		onOff=o;		
	}
//	
//	Television1() {
//		channel =12;
//		volume=6;
//		onOff=true;		
//	}
	
	
//	Television1(int c, int v, boolean o){
//		this(c, v, o);
//	}
	//음.반대는안되나본데

	
//	Television1(){
//		this(13, 10, true);
//	}	
	void print() {
		System.out.println("채널은 " + channel + "이고 볼륨은 "+volume+"입니다.");				
	}
}
	
public class TelevisionTest{
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Television1 myTv=new Television1(7, 10, true);
		myTv.print();
//		Television1 myTv=new Television1();
//		myTv.print();
		
		Television1 yourTv=new Television1(11, 20, true);
		yourTv.print();
	}
}
