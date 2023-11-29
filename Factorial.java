import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long fact=1;
		int n;
		
		System.out.printf("정수를 입력하시요:");
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		
		for(int i=1; i<=n; i++)
			fact=fact*i; //이거또실수햇네 1 이 아니라 i 다
		System.out.printf("%d!은 %d입니다.\n", n, fact);
		//형식이씨랑비슷허네 프린트문도그렇고 프린트에픋그렇고///

	}

}
