
  import java.sql.Connection; 
  import java.sql.DriverManager; 
  import java.sql.ResultSet; 
  import java.sql.SQLException; 
  import java.sql.Statement;
  
  public class Stusys {
  
  public static Connection makeConnection() 
  { 
	  String url="jdbc:mysql://localhost:3306/Duksung"; 
	  String id="root"; 
	  String password=""; 
	  Connection con=null;
  
  try { 
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  System.out.print("드라이버 적재 성공\n"); 
	  con=DriverManager.getConnection(url, id,password); 
	  System.out.print("데이터베이스 연결 성공\n"); 
	  } 
  catch	(ClassNotFoundException e) 
  { 
	  System.out.print("드라이버 찾을 수 없음"); } 
  catch
  (SQLException e) 
  { 
	  System.out.print("연결 실패"); 
	  } 
  return con;
  
  } 
  


//stuId 문자열. name 문자열. tel 문자열. dept문자열.
  public static void main(String arg[]) throws SQLException 
  {
	  addstu("2022001", "Minji Lee", "000-0000-0001", "Cyber Security"); 
	  addstu("2022002", "Hanni park", "000-0000-0002", "Computer"); 
	  addstu("2022003", "Danielle Chung", "000-0000-0003", "IT media"); 
	  addstu("2022004", "Hyein choi", "000-0000-0004", "software"); 
	  
  }
  
  private static void addstu(String StuId, String name, String tel, String dept) 
  { 
	  Connection con=makeConnection();
  
  try 
  { 
	  Statement stmt=con.createStatement(); 
  String s="INSERT INTO Student (StuId, name, tel, dept) VALUES";
  s+="('"+StuId+"','"+name+"','"+tel+"','"+dept+"')";
  
  System.out.println(s); 
  int i=stmt.executeUpdate(s); 
  if(i==1)
  System.out.println("레코드 추가 성공"); 
  else System.out.println("레코드 추가 실패"); 
  }
  catch(SQLException e) 
  { 
	  System.out.println(e.getMessage()); System.exit(0); }
  
  
  } 
  
  }
 