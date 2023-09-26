import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Card extends JFrame {
    public Card() {
        setTitle("businessCard");
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER); // 패널을 중앙에 배치

        // 이미지 파일 경로를 수정하여 ImageIcon을 생성
        ImageIcon icon = new ImageIcon("C:\\Users\\DS\\git\\2023-JAVA\\Week04_MSJ\\src\\peng.jpg");
        // 이미지 크기를 150x100으로 조정
        Image img = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel imageLabel = new JLabel(scaledIcon, SwingConstants.CENTER); // 이미지 중앙 정렬
        panel.add(imageLabel, BorderLayout.WEST); // 그림을 서쪽에 배치

        JLabel label1 = new JLabel("조민서");
        JLabel label2 = new JLabel("대학생");
        JLabel label3 = new JLabel("덕성여자대학교");

        // 한글 폰트 사용 (폰트는 시스템에 따라 다를 수 있음)
        Font koreanFont = new Font("Malgun Gothic", Font.PLAIN, 12); // 예: 맑은 고딕
        label1.setFont(koreanFont);
        label2.setFont(koreanFont);
        label3.setFont(koreanFont);

        JPanel labelsPanel = new JPanel(); // 글자들을 가운데로 모으기 위한 패널
        labelsPanel.setLayout(new BorderLayout());
        labelsPanel.add(label1, BorderLayout.NORTH); // 레이블1을 북쪽에 배치
        labelsPanel.add(label2, BorderLayout.CENTER); // 레이블2을 중앙에 배치
        labelsPanel.add(label3, BorderLayout.SOUTH); // 레이블3을 남쪽에 배치

        panel.add(labelsPanel, BorderLayout.CENTER); // labelsPanel을 중앙에 배치

        setSize(350, 160); // 화면 크기 조정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면을 가운데에 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        new Card();
    }
}
