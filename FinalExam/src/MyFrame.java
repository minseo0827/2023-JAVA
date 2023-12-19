
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame extends JFrame {
	JTextField id, name, tel, dept;
//id, title, publisher, year, price, search;
//테이블명 Student로 다 바꿔야함. books->Student
	JButton previousButton, nextButton, InsertButton, deleteButton,
			searchButton, ClearButton;
	ResultSet rs;
	Statement stmt;
	
	
	public MyFrame() throws SQLException {
		
		
		super("Student Viewer");
		Connection con = makeConnection();
		
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		//ResultsSet이 처음부터 끝까지 이동하면서 데이터를 순회할 수 있음
		rs = stmt.executeQuery("SELECT * FROM Student");
		//모든 데이터를 가져옴
		
		setLayout(new GridLayout(0, 2));
		add(new JLabel("ID", JLabel.CENTER));
		add(id = new JTextField());
		
		add(new JLabel("Name", JLabel.CENTER));
		add(name = new JTextField());
		
		add(new JLabel("Tel", JLabel.CENTER));
		add(tel = new JTextField());
		
		add(new JLabel("Dept", JLabel.CENTER));
		add(dept = new JTextField());
		

		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.previous();
					id.setText("" + rs.getString("stuId"));
					name.setText("" + rs.getString("name"));
					tel.setText("" + rs.getString("tel"));
					dept.setText("" + rs.getString("dept"));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.next();
					id.setText("" + rs.getString("stuId"));
					name.setText("" + rs.getString("name"));
					tel.setText("" + rs.getString("tel"));
					dept.setText("" + rs.getString("dept"));
					

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		InsertButton = new JButton("Insert");
		InsertButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        try {
		            // 사용자가 GUI에 입력한 값을 가져옴
		            String bookId = id.getText();
		            String bookname = name.getText();
		            String telValue = tel.getText();  // 수정: 출판사 변수명 변경
		            String Studept = dept.getText();
		           

		            // 데이터베이스에 새로운 레코드 삽입
		            String insertQuery = String.format("INSERT INTO Student VALUES ('%s', '%s', '%s', '%s')",
		                    bookId, bookname, telValue, Studept);
		            stmt.executeUpdate(insertQuery);

		            // 삽입 후에는 결과셋을 다시 가져와야 함
		            rs = stmt.executeQuery("SELECT * FROM Student");
		            rs.last(); // 마지막 행으로 이동

		            // GUI 업데이트
		            id.setText("" + rs.getString("stuId"));
		            name.setText("" + rs.getString("name"));
		            tel.setText("" + rs.getString("tel"));
		            dept.setText("" + rs.getString("dept"));
		            
		        } catch (SQLException | NumberFormatException e) {
		            e.printStackTrace();
		        }
		    }
		});


		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		    	 String searchKeyword = name.getText();
			        try {
			            // 출판사 검색 쿼리 수정
			        	 String deleteQuery = String.format("DELETE FROM Student WHERE name ='%s'", searchKeyword);
				            stmt.executeUpdate(deleteQuery);

			        } catch (SQLException | NumberFormatException e) {
			            e.printStackTrace();
			        }
			    }
			});

		
		

		
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        String searchKeyword = name.getText();

		        try {
		            // 출판사 검색 쿼리 수정
		            String query = "SELECT * FROM Student WHERE name LIKE '%" + searchKeyword + "%'";
		            ResultSet searchResult = stmt.executeQuery(query);

		            if (searchResult.next()) {
		                id.setText("" + searchResult.getString("stuId"));
		                name.setText("" + searchResult.getString("name"));
		                tel.setText("" + searchResult.getString("tel"));
		                dept.setText("" + searchResult.getString("dept"));
		               
		            } else {
		                System.out.println("검색 결과가 없습니다.");
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		});
		
		ClearButton = new JButton("Clear");
		ClearButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        // GUI의 JTextField를 모두 비움
		        id.setText("");
		        name.setText("");
		        tel.setText("");
		        dept.setText("");
		       
		    }
		});
		
		add(previousButton);
		add(nextButton);
		add(InsertButton);
		add(deleteButton);
		add(searchButton);
		add(ClearButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);
	}
	
	public static Connection makeConnection() {
		String url="jdbc:mysql://localhost:3306/Duksung";
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




    public static void main(String[] args) throws SQLException {
        new MyFrame();
    }
}
