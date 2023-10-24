import java.io.*;
import java.util.*;

public class UserInform {

    public static void main(String[] args) throws IOException {
        String num, name, tel, email;
        PrintWriter in = new PrintWriter(new FileWriter("user.txt"));
        Scanner s = new Scanner(System.in);
        Scanner reader = null;
        
        while (true) {
            System.out.println("번호 :");
            num = s.next();
            System.out.println("이름 :");
            name = s.next();
            System.out.println("전화번호 :");
            tel = s.next();
            System.out.println("이메일 :");
            email = s.next();

            in.print(num + "," + name + "," + tel + "," + email + ".");
            in.flush();

            System.out.println("입력을 계속하려면 0을 입력하고, 종료하려면 1을 입력하세요:");
            int num2 = s.nextInt();
            if (num2 == 1)
                break;
        }
        in.close();

        // 검색 기능
        try {
            reader = new Scanner(new File("user.txt"));
            reader.useDelimiter("\\.|,");
            Scanner searchScanner = new Scanner(System.in);
            System.out.println("특정 번호로 검색하려면 해당 번호를 입력하세요:");
            String search = searchScanner.next();

            while (reader.hasNext()) {
                String entryNum = reader.next();
                String entryName = reader.next();
                String entryTel = reader.next();
                String entryEmail = reader.next();

                if (entryNum.equals(search)) {
                    System.out.println("번호: " + entryNum);
                    System.out.println("이름: " + entryName);
                    System.out.println("전화번호: " + entryTel);
                    System.out.println("이메일: " + entryEmail);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
                
                //왜출력이안되는거야................한개이상입력하면출력이안되네
            }
        }
    }
}
