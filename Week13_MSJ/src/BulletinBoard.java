import java.util.ArrayList;
import java.util.Scanner;

class Post {
    private String title;
    private String content;
    private String writer;

    public Post(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    
    public String getwriter() {
        return writer;
    }
}

public class BulletinBoard {
    private ArrayList<Post> posts;
    private Scanner scanner;

    public BulletinBoard() {
        posts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void createPost() {
    	System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        System.out.print("작성자: ");
        String writer = scanner.nextLine();
        Post post = new Post(title, content, writer);
        posts.add(post);
        System.out.println("게시글이 작성되었습니다.");
    }

    public void readPosts() {
        System.out.println("===== 게시판 목록 =====");
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            System.out.println("[" + (i + 1) + "] " + post.getTitle());
            System.out.println(post.getContent());
            System.out.println("-----------------------");
        }
        System.out.println("=======================");
    }

    public void clearPosts() {
        posts.clear();
        System.out.println("게시판이 초기화되었습니다.");
    }

    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

    public static void main(String[] args) {
        BulletinBoard bulletinBoard = new BulletinBoard();
        while (true) {
            System.out.println("메인 메뉴: 1. Create | 2. Read | 3. Clear(초기화) | 4. Exit");
            System.out.print("메뉴 선택: ");

            int choice = bulletinBoard.scanner.nextInt();
            bulletinBoard.scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    bulletinBoard.createPost();
                    break;
                case 2:
                    bulletinBoard.readPosts();
                    break;
                case 3:
                    bulletinBoard.clearPosts();
                    break;
                case 4:
                    bulletinBoard.exit();
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
            }
        }
    }
}
