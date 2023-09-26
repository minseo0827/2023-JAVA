import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Repair extends JPanel implements ItemListener {

    JCheckBox[] buttons = new JCheckBox[4];
    String[] items = { "엔진오일 교환", "자동변속기 오일교환", "에어컨 필터 교환", "타이어 교환" };
    int[] prices = { 45000, 80000, 30000, 100000 };
    int money = 0;
    JLabel label;

    public Repair() {
        super();
        setLayout(new GridLayout(0, 1));
        label = new JLabel("현재까지의 가격은 0 원");
        JCheckBox ck1 = new JCheckBox("엔진오일 교환");
        JCheckBox ck2 = new JCheckBox("자동변속기 오일교환");
        JCheckBox ck3 = new JCheckBox("에어컨 필터 교환");
        JCheckBox ck4 = new JCheckBox("타이어 교환");
        add(ck1);
        add(ck2);
        add(ck3);
        add(ck4);
        add(label);

        ck1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    money += prices[0];
                } else {
                    money -= prices[0];
                }
                updateLabel();
            }
        });

        ck2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    money += prices[1];
                } else {
                    money -= prices[1];
                }
                updateLabel();
            }
        });

        ck3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    money += prices[2];
                } else {
                    money -= prices[2];
                }
                updateLabel();
            }
        });

        ck4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    money += prices[3];
                } else {
                    money -= prices[3];
                }
                updateLabel();
            }
        });
    }

    private void updateLabel() {
        label.setText("현재까지의 가격은 " + money + " 원");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // This method is required to implement the ItemListener interface,
        // but it can be left empty if not needed for the entire panel.
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new Repair();
        frame.setContentPane(newContentPane);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}
