import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//중도포기!안나올것같애

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class combo extends JFrame {
	JLabel label;
	JComboBox animallist;
	
	public combo() {
		label=new JLabel();
		String[] animals= {"dog", "cat", "bird"}; //배열을만들고.
		animallist=new JComboBox(animals); //애네들을집어넣을거고.
		animallist.setSelectedIndex(0);
		animallist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//콤보박스에서받아오면그거에해당하는사진을띄워줘야한다..
				JComboBox cBox=(JComboBox)e.getSource(); //콤보박스에서가져온객체를콤보박스의형태로싸서콤보박스에넣어주고
				String name=(String)cBox.getSelectedItem(); //머.이런게잇다...
				
				
			}
		});
		
		
		//(comboBox);
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
