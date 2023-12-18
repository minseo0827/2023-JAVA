import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
	
public class SQL {

		public static Connection makeConnection() {
			String url="jdbc:mysql://localhost:3306/book_db";
			String id="root";
			String password="";
			Connection con=null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.print("드라이버 적재 성공\n");
				con=DriverManager.getConnection(url, id, password);
				System.out.print("데이터베이스 연결 성공\n");
			}
			catch (ClassNotFoundException e) {
				System.out.print("드라이버 찾을 수 없음");
			}
			catch (SQLException e) {
				System.out.print("연결 실패");
			}
			return con;
			
		}
		public static void main(String arg[]) throws SQLException {
			addBook("Artificial Intellegence", "Addison Welsey", "2002", 35000);
		}
			
		private static void addBook(String title, String publisher, String year, int price) {
			Connection con=makeConnection();
		
		try {
			Statement stmt=con.createStatement();
			String s="INSERT INTO books(title, publisher, year, price) VALUES";
			s+="('"+title+"','"+publisher+"','"+year+"','"+price+"')";
			
			System.out.println(s);
			int i=stmt.executeUpdate(s);
			if(i==1)
				System.out.println("레코드 추가 성공");
			else
				System.out.println("레코드 추가 실패");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
			
			
		}
	}

