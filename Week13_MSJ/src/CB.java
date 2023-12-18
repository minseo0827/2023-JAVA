//디비건드리기 .일단 잼에서 생성 CREATE 해놓고 코드작성하고... 디비이름변경해줘야함 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CB {

	public static Connection makeConnection() {
		String url="jdbc:mysql://localhost:3306/boards";
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
		try {
			 
			String sql= "" +
			"SELECT userid, username, userpassword, userage, useremail " +
					"FROM users " + 
			"WHERE userid=?";
			
			PreparedStatement psmt=con.prepareStatement(sql); 
			psmt.setString(1, "winter");
			
			ResultSet rs=psmt.executeQuery();
			
			if(rs.next()) {
				User user=new User();
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				user.setUserAge(rs.getInt(4));
				user.setUserEmail(rs.getString(5));
				System.out.print(user);
			}
			else {
				System.out.print("사용자 아이디가 존재하지 않음");
			}
			
			rs.close();
			psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {}
			 
			 
			}
		
		}
	}
}
