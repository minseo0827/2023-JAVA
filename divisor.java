import java.util.Scanner;
public class divisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("양의 정수를 입력하시오: ");
		int n=scan.nextInt();
		
		System.out.println(n+"의 약수는 다음과 같습니다.");
		for(int i=1; i<=n; ++i) //뭐가..그리다르지..이자체에서늑크게영향없지않나? +가먼저오는걸첨보는것같기도하고
		{
			if(n%i==0)
				System.out.print(" " + i);
		}

	}

	
}