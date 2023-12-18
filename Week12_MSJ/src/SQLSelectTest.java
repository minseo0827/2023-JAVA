import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
	
public class SQLSelectTest {

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
			Connection con=makeConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM books"); 
			
			while(rs.next())
			{
				int id=rs.getInt("book_id");
				String title=rs.getString("title");
				System.out.println(id+" "+title);
			}
			
			con.close();
		}
	}

