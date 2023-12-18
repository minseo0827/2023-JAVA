//디비건드리기 .일단 잼에서 생성 CREATE 해놓고 코드작성하고... 디비이름변경해줘야함 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Blob;

public class CBB {

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
			"SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " + //띄어쓰기미친것아.
					"FROM boards " + 
			"WHERE bwriter=?";
			
			PreparedStatement psmt=con.prepareStatement(sql); 
			psmt.setString(1, "winter");
			
			ResultSet rs=psmt.executeQuery();
			
			while(rs.next()) {
				Board board=new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				System.out.print(board);
			
			Blob blob=board.getBfiledata();
			if(blob!=null) {
				try (InputStream is=blob.getBinaryStream();
						OutputStream os=new FileOutputStream("C:/Temp/" + board.getBfilename())) { //여기다갖다놓는거
					is.transferTo(os);
					os.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
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
