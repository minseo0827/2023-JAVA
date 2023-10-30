import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInform {
	public static void main(String[] args) throws IOException {
		int num2;
		String search;
		String num, name, tel, email;
		//Scanner scanner=null; //넌왜필요한거지?
		PrintWriter in=new PrintWriter(new FileWriter("user.txt"));
		// pw는 다양한 데이터 유형(문자열, 숫자, 객체 등)을 파일에 출력할 수 있는 추가적인 편의 기능을 제공합니다.
		Scanner s=new Scanner(System.in);
		ArrayList<String> userEntries = new ArrayList<>(); //저장할리스트를만들고.
		 
		while(true) {
			System.out.print("번호: "); num=s.next();
			System.out.print("이름: "); name=s.next();
			System.out.print("전화번호: "); tel=s.next();
			System.out.print("이메일: "); email=s.next();
			System.out.print("입력 끝났으면 1, 계속하려면 0");
			num2=s.nextInt(); //얘는정수를받으니까 넥스트인트고.
			
			 String userEntry = num + ", " + name + ", " + tel + ", " + email;
	            userEntries.add(userEntry);
			
			in.print(num+", "+ name+", "+ tel+", "+ email+""); //이런식으로 파일에 쓰고
			in.flush(); //넌또뭐람
			if(num2==1) //종료를받는다면종료하는거고.
				break;
		}
		
		in.close();
		
		//입력이 끝났으면 이제 사용자로부터 번호입력받고, 그 번호에 해당하는 전화번호출력
		//1, 홍길동, 01011111111, h.com2, 김유신, 010222222, kim@com user.txt에 이런식으로저장이된다. 너를.....나눌수도없고...p.tel하기엔 객체도아니고..
		//널객체에집어넣어?그런게되나??
		 Scanner userInput = new Scanner(System.in);
	        while (true) {
	            System.out.print("전화번호를 조회할 번호를 입력하세요 (1부터 " + userEntries.size() + "까지, 0은 종료): ");
	            int searchNumber = userInput.nextInt(); //저스캐너로받은정수를 서치넘버에저장하고.

	            if (searchNumber == 0)
	                break;
	            if (searchNumber < 1 || searchNumber > userEntries.size()) {
	                System.out.println("잘못된 번호를 입력했습니다. 1부터 " + userEntries.size() + " 사이의 번호를 입력하세요.");}
	            
	            else {
	                String userInfo = userEntries.get(searchNumber - 1); 
	                //1번을조회하고싶다는건 [0]을 조사하고싶다는거니까 1빼주고. 어레이리스트에서 그 인덱스에해당하는애를갖고오고. 1, k, 0101111111, k.com 그게이거지
	                String[] infoParts = userInfo.split(", "); //쉼표로나누고 그 부분을 인포파트라는 배열에또담고
	                if (infoParts.length >= 3) { //한명이라도정보가제대로입력됏다면 적어도 4개니까. 
	                    System.out.println("전화번호: " + infoParts[2]); //그리고 세번째인.. 012니까 세번째지 [2]를 출력
	                } else {
	                    System.out.println("정보가 부족합니다.");
	                }
	            }
	        }

	        userInput.close();
		

	}

}
