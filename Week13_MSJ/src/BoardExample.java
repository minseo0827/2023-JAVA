import java.util.Scanner;

public class BoardExample {
    // 게시물 목록 출력 메소드
    public void list() {
        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s \n",
                "1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
        System.out.printf("%-6s%-12s%-16s%-40s \n",
                "2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");
        mainMenu();  // 메인 메뉴 호출
    }

    // 메인 메뉴 출력 메소드
    public void mainMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴선택: ");

        // 사용자로부터 메뉴 선택을 받기 위한 코드
        Scanner scanner = new Scanner(System.in);
        String menuNo = scanner.nextLine();

        // 사용자 선택에 따라 해당하는 메소드 호출
        switch (menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
            default -> System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
        }
    }

    // 게시물 작성 메소드
    public void create() {
        System.out.print("** create 메소드 실행");
        list();  // 게시물 목록 다시 출력
    }

    // 게시물 조회 메소드
    public void read() {
        System.out.print("** read 메소드 실행");
        list();  // 게시물 목록 다시 출력
    }

    // 게시물 초기화 메소드
    public void clear() {
        System.out.print("** clear 메소드 실행");
        list();  // 게시물 목록 다시 출력
    }

    // 프로그램 종료 메소드
    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        BoardExample boardExample = new BoardExample();
        boardExample.list();  // 프로그램 시작 시 게시물 목록 출력
    }
}
