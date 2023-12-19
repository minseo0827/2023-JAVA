/*
 * import java.awt.GridLayout; import java.awt.event.ActionEvent; import
 * java.awt.event.ActionListener; import java.sql.Connection; import
 * java.sql.DriverManager; import java.sql.ResultSet; import
 * java.sql.SQLException; import java.sql.Statement;
 * 
 * import javax.swing.JButton; import javax.swing.JFrame; import
 * javax.swing.JLabel; import javax.swing.JTextField;
 * 
 * class MyFrame extends JFrame { JTextField id, title, publisher, year, price,
 * search; JButton previousButton, nextButton, InsertButton, deleteButton,
 * searchButton, ClearButton; ResultSet rs; Statement stmt;
 * 
 * 
 * public MyFrame() throws SQLException {
 * 
 * 
 * super("Database Viewer"); Connection con = makeConnection();
 * 
 * stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
 * ResultSet.CONCUR_UPDATABLE); //ResultsSet이 처음부터 끝까지 이동하면서 데이터를 순회할 수 있음 rs =
 * stmt.executeQuery("SELECT * FROM books"); //모든 데이터를 가져옴
 * 
 * setLayout(new GridLayout(0, 2)); add(new JLabel("ID", JLabel.CENTER)); add(id
 * = new JTextField());
 * 
 * add(new JLabel("TITLE", JLabel.CENTER)); add(title = new JTextField());
 * 
 * add(new JLabel("PUBLISHER", JLabel.CENTER)); add(publisher = new
 * JTextField());
 * 
 * add(new JLabel("YEAR", JLabel.CENTER)); add(year = new JTextField());
 * 
 * add(new JLabel("PRICE", JLabel.CENTER)); add(price = new JTextField());
 * 
 * add(new JLabel("출판사 검색", JLabel.CENTER)); add(search = new JTextField());
 * 
 * previousButton = new JButton("Previous");
 * previousButton.addActionListener(new ActionListener() { public void
 * actionPerformed(ActionEvent event) { try { rs.previous(); id.setText("" +
 * rs.getInt("book_id")); title.setText("" + rs.getString("title"));
 * publisher.setText("" + rs.getString("publisher")); year.setText("" +
 * rs.getString("year")); price.setText("" + rs.getInt("price")); } catch
 * (SQLException e) { e.printStackTrace(); } } });
 * 
 * nextButton = new JButton("Next"); nextButton.addActionListener(new
 * ActionListener() { public void actionPerformed(ActionEvent event) { try {
 * rs.next(); id.setText("" + rs.getInt("book_id")); title.setText("" +
 * rs.getString("title")); publisher.setText("" + rs.getString("publisher"));
 * year.setText("" + rs.getString("year")); price.setText("" +
 * rs.getInt("price"));
 * 
 * } catch (SQLException e) { e.printStackTrace(); } } });
 * 
 * InsertButton = new JButton("Insert"); InsertButton.addActionListener(new
 * ActionListener() { public void actionPerformed(ActionEvent event) { try { //
 * 사용자가 GUI에 입력한 값을 가져옴 int bookId = Integer.parseInt(id.getText()); String
 * bookTitle = title.getText(); String publisherValue = publisher.getText(); //
 * 수정: 출판사 변수명 변경 String bookYear = year.getText(); int bookPrice =
 * Integer.parseInt(price.getText());
 * 
 * // 데이터베이스에 새로운 레코드 삽입 String insertQuery =
 * String.format("INSERT INTO books VALUES (%d, '%s', '%s', '%s', %d)", bookId,
 * bookTitle, publisherValue, bookYear, bookPrice);
 * stmt.executeUpdate(insertQuery);
 * 
 * // 삽입 후에는 결과셋을 다시 가져와야 함 rs = stmt.executeQuery("SELECT * FROM books");
 * rs.last(); // 마지막 행으로 이동
 * 
 * // GUI 업데이트 id.setText("" + rs.getInt("book_id")); title.setText("" +
 * rs.getString("title")); publisher.setText("" + rs.getString("publisher"));
 * year.setText("" + rs.getString("year")); price.setText("" +
 * rs.getInt("price")); } catch (SQLException | NumberFormatException e) {
 * e.printStackTrace(); } } });
 * 
 * 
 * 
 * 
 * deleteButton = new JButton("Delete"); deleteButton.addActionListener(new
 * ActionListener() { public void actionPerformed(ActionEvent event) { try { //
 * 검색 결과에 따라 다르게 현재 행의 book_id를 가져옴 int currentBookId = (rs != null &&
 * !rs.isClosed()) ? rs.getInt("book_id") : Integer.parseInt(id.getText());
 * 
 * // 데이터베이스에서 현재 행 삭제 String deleteQuery =
 * String.format("DELETE FROM books WHERE book_id = %d", currentBookId);
 * stmt.executeUpdate(deleteQuery);
 * 
 * // 삭제 후에는 결과셋을 다시 가져와야 함 rs = stmt.executeQuery("SELECT * FROM books");
 * 
 * // GUI 업데이트 if (rs.first()) { id.setText("" + rs.getInt("book_id"));
 * title.setText("" + rs.getString("title")); publisher.setText("" +
 * rs.getString("publisher")); year.setText("" + rs.getString("year"));
 * price.setText("" + rs.getInt("price")); } else { // 결과셋이 비어있으면 GUI를 초기화하거나
 * 사용자에게 메시지 출력 id.setText(""); title.setText(""); publisher.setText("");
 * year.setText(""); price.setText(""); System.out.println("데이터가 더 이상 없습니다."); }
 * } catch (SQLException | NumberFormatException e) { e.printStackTrace(); } }
 * });
 * 
 * searchButton = new JButton("Search"); searchButton.addActionListener(new
 * ActionListener() { public void actionPerformed(ActionEvent event) { String
 * searchKeyword = search.getText();
 * 
 * try { // 출판사 검색 쿼리 수정 String query =
 * "SELECT * FROM books WHERE publisher LIKE '%" + searchKeyword + "%'";
 * ResultSet searchResult = stmt.executeQuery(query);
 * 
 * if (searchResult.next()) { id.setText("" + searchResult.getInt("book_id"));
 * title.setText("" + searchResult.getString("title")); publisher.setText("" +
 * searchResult.getString("publisher")); year.setText("" +
 * searchResult.getString("year")); price.setText("" +
 * searchResult.getInt("price")); } else { System.out.println("검색 결과가 없습니다."); }
 * 
 * } catch (SQLException e) { e.printStackTrace(); } } });
 * 
 * ClearButton = new JButton("Clear"); ClearButton.addActionListener(new
 * ActionListener() { public void actionPerformed(ActionEvent event) { // GUI의
 * JTextField를 모두 비움 id.setText(""); title.setText(""); publisher.setText("");
 * year.setText(""); price.setText(""); search.setText(""); // 추가: search 필드도 비움
 * } });
 * 
 * add(previousButton); add(nextButton); add(InsertButton); add(deleteButton);
 * add(searchButton); add(ClearButton);
 * 
 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setSize(350, 200);
 * setVisible(true); }
 * 
 * public static Connection makeConnection() { String
 * url="jdbc:mysql://localhost:3306/boards"; String id="root"; String
 * password=""; Connection con=null;
 * 
 * try { Class.forName("com.mysql.cj.jdbc.Driver");
 * System.out.print("드라이버 적재 성공\n"); con=DriverManager.getConnection(url, id,
 * password); System.out.print("데이터베이스 연결 성공\n"); } catch
 * (ClassNotFoundException e) { System.out.print("드라이버 찾을 수 없음"); } catch
 * (SQLException e) { System.out.print("연결 실패"); } return con; }
 * 
 * 
 * 
 * 
 * public static void main(String[] args) throws SQLException { new MyFrame(); }
 * }
 */