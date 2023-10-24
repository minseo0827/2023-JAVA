import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

//왜....... 오류하나를없애면하나가생기지..?
public class UserInform {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int num2;
		String search;
		String num, name, tel, email;
		//Scanner scanner = null;
		PrintWriter in = new PrintWriter(new FileWriter("user.txt"));
		Scanner s=new Scanner(System.in);
	
            
		while(true) {
			System.out.println("번호 :"); num=s.next();
			System.out.println("이름 :"); name=s.next();
			System.out.println("전화번호 :"); tel=s.next();
			System.out.println("이메일 :"); email=s.next();
			System.out.println("입력 끝났으면 1, 계속하려면 0:"); num2=s.nextInt();
			//임서저장을하고해당하는걸출력...??
			in.print(num + ","+name+","+tel+","+email+".");
			in.flush();
			if(num2==1)
				break;
		
               in.close();
            }
        }
}   
