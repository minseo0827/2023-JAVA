import java.util.Scanner;

public class CalTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("초를 입력하시오:");
		int time = sc.nextInt();
		int sec = (time%60);
		int min= (time/60);
		
		System.out.println(time + "초는 " + min + "분 " + sec + "초입니다.");
		
		//오백원몇개뭐자판기로바꾸어보라시는??? 교재 85페지같다는

		
	}

}
