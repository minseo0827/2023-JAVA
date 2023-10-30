import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FIlereaderupper {

	public static void main(String[] args) throws IOException {
		File file1=new File("input.txt");
		File file2=new File("output.txt");
		char counter=0;
		
		try (BufferedReader in=new BufferedReader(new FileReader(file1));
				BufferedWriter out=new BufferedWriter(new FileWriter(file2));){
			int ch;
			
			while((ch=in.read())!=-1)
			{
				if(Character.isLowerCase(ch)) 
				{
					ch=Character.toUpperCase(ch);
					out.write(ch);
				}
				else
					out.write(ch);
			}	
		} catch (IOException e) {
            e.printStackTrace();
			
		

	}

}
}