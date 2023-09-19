import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Week03_02 extends JFrame implements ActionListener {
    private final double MileToKilometer = 1.609344;
    private JTextField mileTextField;
    private JTextField kilometerTextField;

    public Week03_02() {
        JPanel panel = new JPanel();
        add(panel);

        JLabel mileLabel = new JLabel("마일을 입력하시오");
        mileTextField = new JTextField(10);
        JButton convertButton = new JButton("변환");
        JLabel resultLabel = new JLabel("킬로미터:");

        kilometerTextField = new JTextField(10);
        kilometerTextField.setEditable(false);

        panel.add(mileLabel);
        panel.add(mileTextField);
        panel.add(convertButton);
        panel.add(resultLabel);
        panel.add(kilometerTextField);

        convertButton.addActionListener(this);

        pack();
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("변환")) {
            try {
                double mile = Double.parseDouble(mileTextField.getText());
                double kilometer = mile * MileToKilometer;
                kilometerTextField.setText(String.format("%.6f", kilometer));
            } catch (NumberFormatException ex) {
                kilometerTextField.setText("유효하지 않은 입력");
            }
        }
    }

    public static void main(String[] args) {
        new Week03_02();
    }
}
