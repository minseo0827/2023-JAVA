import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Post {
    private static int count = 0;
    private int bno;
    private String title;
    private String content;
    private String writer;
    private Date date;

    public Post(String title, String content, String writer) {
        this.bno = ++count;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = new Date();
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
        System.out.println("보조 메뉴: 1. ok | 2. cancel");
        int subMenuChoice = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        if (subMenuChoice == 1) {
            Post post = new Post(title, content, writer);
            posts.add(post);
            System.out.println("게시글이 등록되었습니다.");
        } else if (subMenuChoice != 2) {
            System.out.println("잘못된 메뉴 선택입니다. 초기 화면으로 돌아갑니다.");
        } else {
            System.out.println("게시글 작성이 취소되었습니다.");
        }
    }
    public void readPosts() {
        System.out.println("===== 게시판 목록 =====");
        System.out.printf("%-5s%-20s%-30s%-15s%-20s\n", "No", "Title", "Content", "Writer", "Date");
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            System.out.printf("%-5d%-20s%-30s%-15s%-20s\n", post.getBno(), post.getTitle(), post.getContent(), post.getWriter(), post.getDate());
        }
        System.out.println("=======================");
    }

    public void readPost() {
        System.out.print("읽을 게시물의 No를 입력하세요: ");
        int bno = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        boolean found = false;
        for (Post post : posts) {
            if (post.getBno() == bno) {
                System.out.println("===== 게시물 읽기 =====");
                System.out.println("번호: " + post.getBno());
                System.out.println("제목: " + post.getTitle());
                System.out.println("내용: " + post.getContent());
                System.out.println("작성자: " + post.getWriter());
                System.out.println("날짜: " + post.getDate());
                System.out.println("=======================");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("해당 번호의 게시물이 없습니다.");
        }
    }

    public void deletePost() {
        System.out.print("삭제할 게시물의 No를 입력하세요: ");
        int bno = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        boolean found = false;
        for (Post post : posts) {
            if (post.getBno() == bno) {
                posts.remove(post);
                System.out.println("게시물이 삭제되었습니다.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("해당 번호의 게시물이 없습니다.");
        }
    }

    public void clearPosts() {
        posts.clear();
        System.out.println("게시판이 초기화되었습니다.");
    }

    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

    public void mainMenu() {
        System.out.println("메인 메뉴: 1. Create | 2. Read | 3. Delete | 4. Clear(초기화) | 5. Exit");
        System.out.print("메뉴 선택: ");
    }

    public static void main(String[] args) {
        BulletinBoard bulletinBoard = new BulletinBoard();
        while (true) {
            bulletinBoard.mainMenu();

            int choice = bulletinBoard.scanner.nextInt();
            bulletinBoard.scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    bulletinBoard.createPost();
                    break;
                case 2:
                    bulletinBoard.readPosts();
                    bulletinBoard.readPost();
                    break;
                case 3:
                    bulletinBoard.deletePost();
                    break;
                case 4:
                    bulletinBoard.clearPosts();
                    break;
                case 5:
                    bulletinBoard.exit();
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
            }
        }
    }
}
