//디비건드리기 .일단 잼에서 생성 CREATE 해놓고 코드작성하고... 디비이름변경해줘야함 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDatabase1 {

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
			

			/*
			 * String sql= "" +
			 * " INSERT INTO users (userid, username, userpassword, userage, useremail) " +
			 * " VALUES (?, ?, ?, ?, ?)";
			 * 
			 * PreparedStatement psmt=con.prepareStatement(sql); psmt.setString(1,
			 * "winter"); psmt.setString(2, "한겨울"); psmt.setString(3, "12345");
			 * psmt.setInt(4, 25); psmt.setString(5, "winter@mycompany.com");
			 *
			 *
			 *int rows=psmt.executeUpdate();
			System.out.print("저장된 행 수: " + rows);
			
			psmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					
				}*/
			
			String sql= "" +
					" INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
								" VALUES (?, ?, ?, now(), ?, ?)";
						
						/*PreparedStatement psmt=con.prepareStatement(sql, new String[] {"bno"});
						psmt.setString(1, "눈 오는 날");
						psmt.setString(2, "함박눈이 내려요");
						psmt.setString(3, "winter");
						psmt.setString(4, "snow.jpg");	*/
			
						/*
						 * PreparedStatement psmt=con.prepareStatement(sql, new String[] {"bno"});
						 * psmt.setString(1, "봄의 정원"); psmt.setString(2, "정원의 꽃이 예쁘네요");
						 * psmt.setString(3, "spring"); psmt.setString(4, "spring.jpg");
						 */
			
			PreparedStatement psmt=con.prepareStatement(sql, new String[] {"bno"});
			psmt.setString(1, "크리스마스");
			psmt.setString(2, "메리 크리스마스~");
			psmt.setString(3, "winter");
			psmt.setString(4, "chrismas.jpg");
						
						try {
							psmt.setBlob(5, new FileInputStream("snow.jpg"));
						} catch (FileNotFoundException e) {
							System.out.print("파일을 찾을 수 없습니다.");
							e.printStackTrace();
						}
			
				int rows=psmt.executeUpdate();
				System.out.print("저장된 행 수: " + rows + "\n");
				
				if(rows==1)
				{
					ResultSet rs=psmt.getGeneratedKeys();
					if(rs.next()) {
						int bno=rs.getInt(1);
						System.out.print("저장된 bno: "+bno);
					}
					rs.close();
			}
				
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
