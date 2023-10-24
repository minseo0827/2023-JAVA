import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.WriteAbortedException;

public class Test {

	public static void main(String[] args) throws IOException {
		File file1= new File("input.txt");
		File file2= new File ("output.txt");
		
				
		char CharCounter=0;
		BufferedReader in= (new BufferedReader(new FileReader(file1)));
		PrintWriter out=(new PrintWriter(new FileWriter(file2)));
		int ch;
		while ((ch=in.read())!=-1) {
			if (Character.isUpperCase(ch)) { // 변경: 대문자인 경우 그대로 출력
                out.write(ch);
            } else if (ch == ' ') { // 변경: 띄어쓰기도 그대로 출력
                out.write(ch);
            } else { // 그 외의 경우에는 소문자를 대문자로 변경하여 출력
                ch = Character.toUpperCase(ch);
                out.write(ch);
            }
		}		
		in.close();
		out.close();
	}
}
