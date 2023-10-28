import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ButtonClick extends JFrame implements ActionListener { 
//내부클래스로서 생성자 아래에 집어넣던가. 클래스선언시 리스너도 같이 구현하던가. 람다거나. 
    JPanel panel;
    JButton button;

    public ButtonClick() {
        panel = new JPanel();
        button = new JButton("클릭");

        button.addActionListener(this); // 현재 객체 (ButtonClick)를 ActionListener로 등록
        panel.add(button);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("버튼이 클릭되었습니다.");
        }
    }

    public static void main(String[] args) {
        ButtonClick frame = new ButtonClick();
        frame.setTitle("액션 리스너 연습");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
