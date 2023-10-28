import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class ByteStreamsLab {

	public static void main(String[] args)  throws IOException {
		Scanner scan=new Scanner(System.in);
		System.out.print("원본 파일 명 입력: ");
		
		String inputFileName=scan.next();
		System.out.print("복사 파일 명 입력: ");
		String outputFileName=scan.next();
		
		try(InputStream inputStream = new FileInputStream(inputFileName);
				//경로중요.... 경로알고 src아래가아니라 src랑 동등하게들어가야함
				//왜나는...git 파일명 week07애있는거지
				OutputStream outputStream =new FileOutputStream(outputFileName)) {
			int c;
			while ((c=inputStream.read())!=-1) {
				outputStream.write(c);
			}
		}
				
		System.out.print(inputFileName + "을 "+outputFileName + "로 복사하였습니다.");
	}

}
