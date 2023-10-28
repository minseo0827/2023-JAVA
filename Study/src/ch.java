import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CheckboxExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Checkbox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();

        // Create a checkbox
        JCheckBox checkBox = new JCheckBox("피자");
        
        // Create a label
        JLabel label = new JLabel("선택된 항목: ");

        // Add an item listener to the checkbox
        checkBox.addItemListener(e -> {
            if (checkBox.isSelected()) {
                label.setText("선택된 항목: 피자");
            } else {
                label.setText("선택된 항목: ");
            }
        });

        // Add the checkbox and label to the panel
        panel.add(checkBox);
        panel.add(label);

        // Add the panel to the frame
        frame.add(panel);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
