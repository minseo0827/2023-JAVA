import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class combo extends JFrame {
	JLabel label;
	JComboBox comboBox;
	
	public combo() {
		label=new JLabel();
		comboBox= new JComboBox(); //아하..제네릭어쩌구.
		comboBox.addItem("pig");
		comboBox.addItem("cat");
		
		add(comboBox);
		setSize(100, 100);
		setVisible(true);
	}
}
public class comboboxtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combo combo=new combo();
	}

}
