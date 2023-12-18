import java.util.Scanner;

public class Computerprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x, y;
		String c;
		
		Scanner sc= new Scanner(System.in);
		//스캐너는 거.클래스생성이랑조금다르게 괄호안에 System.in 을써줘야한다...
		System.out.print("연산자를 입력하세요. ");
		c=sc.next();
		System.out.print("피연산자 두개를 입력하세요: ");
		x=sc.nextInt(); y=sc.nextInt();
		System.out.printf("%d %s %d =", x, c, y);
		
		if(c.equals("+")) //하..우리가이런걸햇냐?
			System.out.printf(" %d", x+y);
			
	}

}
