import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile1 {

	public static void main(String[] args)  throws IOException {
		try(FileReader inFileReader = new FileReader("test2.txt");
				//경로중요.... 경로알고 src아래가아니라 src랑 동등하게들어가야함
				FileWriter out=new FileWriter("copy.txt")) {
			int c;
			while ((c=inFileReader.read())!=-1) {
				out.write(c);
			}
		}
				

	}

}
