class box<t> {
	public t content; //보통은 이제 String name int age이런건데 변수이름만두고형식도 미정으로두는거지
}
public class genericprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		box<String> box1=new box();
		box1.content="문자열이들어갑니다";
		String n=box1.content;
		System.out.print(n+"\n");
		
		
		box<Integer> box2=new box();
		box2.content=1234;
		int nn=box2.content;
		System.out.print(nn);
		
		
	}

}
