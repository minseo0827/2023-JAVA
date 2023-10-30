import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class getimageandcopy {

	public static void main(String[] args) throws IOException {
		//스캐너만들고 파일명.복사할파일면받아서 .바이트단위니까 인풋파일네임에넣기
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("원본 파일 명 입력: ");
		String inputFileName=scanner.next();
		
		System.out.print("복사할 파일 명 입력: ");
		String outputFileName=scanner.next();
		
		try (InputStream inputStream=new FileInputStream(inputFileName);
				OutputStream outputStream=new FileOutputStream(outputFileName);) 
		{ int c;
		while((c=inputStream.read())!=-1)
			outputStream.write(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub

	}

}
