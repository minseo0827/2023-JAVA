import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class copytextest {

    public static void main(String[] args) {
        try (FileReader inFileReader = new FileReader("Text.txt");
             FileWriter outFileWriter = new FileWriter("copyresult.txt")) 
        //형태주의! try(파일리더 ㅁ = 어쩌구; 파일라이터 ㅁ=어쩌구;)
        //{int c; while 어쩌구의 형태}
        
        {

            int c;
            while ((c = inFileReader.read()) != -1) {
                outFileWriter.write(c);
            }

            System.out.println("파일 복사 완료");
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
