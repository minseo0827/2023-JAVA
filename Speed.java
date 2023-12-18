import java.util.Scanner;

public class Speed {

	//어...이중이프문아직일텐데.뭐해보지뭐....
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("속도를 입력하시오:");		
		int speed;
		speed = sc.nextInt();
		
		if(speed>=60)
		{
			if(speed<=100) 
				System.out.println("정상 속도");
			else 
				System.out.println("과속");
		
		}
			
		else 
			System.out.println("저속"); 

	}

}
