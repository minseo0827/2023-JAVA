import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

class Post1 {
	private static int count = 0;
    private int bno;
    private String title;
    private String content;
    private String writer;
    private Date date;

    public Post1(String title, String content, String writer) {
        this.bno = ++count;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = new Date();
    }
    
    public Post1(int bno, String title, String content, String writer, Date date) {
        this.bno = bno;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = date;
    }
    
    

    public int getBno() {
        return bno;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}

public class BoardDB extends JFrame {
    private ArrayList<Post1> posts;
    private JTextField titleField, contentField, writerField, readPostField, deletePostField;
    private JTextArea postsTextArea;
    private JButton createButton, readButton, deleteButton, clearButton;
    private Connection connection;

    private void clearFields() {
        titleField.setText("");
        contentField.setText("");
        writerField.setText("");
        readPostField.setText("");
        deletePostField.setText("");
    }

    
    public BoardDB() {
        posts = new ArrayList<>();

        // 데이터베이스 연결
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bb";
            String id="root";
    		String password="";
    		connection = DriverManager.getConnection(url, id, password);
    		//Connection con=null;
    		
        } catch (Exception e) {
            e.printStackTrace();
        }

        // GUI 구성 요소 초기화
        titleField = new JTextField(20);
        contentField = new JTextField(30);
        writerField = new JTextField(15);
        readPostField = new JTextField(5);
        deletePostField = new JTextField(5);
        postsTextArea = new JTextArea(10, 50);
        createButton = new JButton("Create");
        readButton = new JButton("Read");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");

        // 레이아웃 설정
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Content:"));
        inputPanel.add(contentField);
        inputPanel.add(new JLabel("Writer:"));
        inputPanel.add(writerField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(new JLabel("Read Post No:"));
        buttonPanel.add(readPostField);
        buttonPanel.add(readButton);
        buttonPanel.add(new JLabel("Delete Post No:"));
        buttonPanel.add(deletePostField);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(postsTextArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        
        
        // 이벤트 핸들러 등록
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createPost();
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int postNo = Integer.parseInt(readPostField.getText());
                    readPosts();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BoardDB.this, "올바른 숫자를 입력하세요.");
                }
            }
        });


        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletePost();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearPosts();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    
    public void createPost() {
        String title = titleField.getText();
        String content = contentField.getText();
        String writer = writerField.getText();

        try {
            String sql = "INSERT INTO posts (title, content, writer) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, title);
                pstmt.setString(2, content);
                pstmt.setString(3, writer);
                pstmt.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "게시글이 등록되었습니다.");
            clearFields();
            readPosts();  // 등록 후 목록 갱신
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "게시글 등록 중 오류가 발생했습니다.");
        }
    }


    public void readPosts() {
        try {
            String sql = "SELECT * FROM posts";
            try (PreparedStatement pstmt = connection.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                posts.clear();
                postsTextArea.setText("");  // 텍스트 에어리어 초기화

                while (rs.next()) {
                    int bno = rs.getInt("bno");
                    String title = rs.getString("title");
                    String content = rs.getString("content");
                    String writer = rs.getString("writer");
                    Date date = rs.getTimestamp("date_posted");

                    // Post1 객체 대신 Post 객체 생성
                    Post1 post = new Post1(bno, title, content, writer, date);
                    posts.add(post);

                    // 텍스트 에어리어에 추가
                    postsTextArea.append(post.toString() + "\n");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "게시글 목록 조회 중 오류가 발생했습니다.");
        }
    }



    
    
    public void deletePost() {
        try {
            int bno = Integer.parseInt(deletePostField.getText());

            String sql = "DELETE FROM posts WHERE bno = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, bno);
                int rowCount = pstmt.executeUpdate();

                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "게시글이 삭제되었습니다.");
                    clearFields();
                    readPosts();  // 삭제 후 목록 갱신
                } else {
                    JOptionPane.showMessageDialog(this, "해당 번호의 게시글이 없습니다.");
                }
            }
        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "게시글 삭제 중 오류가 발생했습니다.");
        }
    }

    public void clearPosts() {
        try {
            String sql = "DELETE FROM posts";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "게시판이 초기화되었습니다.");
                clearFields();
                readPosts();  // 초기화 후 목록 갱신
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "게시판 초기화 중 오류가 발생했습니다.");
        }
    }
    
    
    // 나머지 코드는 이전과 동일

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BoardDB();
            }
        });
    }
} 