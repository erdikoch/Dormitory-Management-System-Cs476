package view;
import javax.swing.JTable;

public class RemoveLostItemWindow extends javax.swing.JFrame {
	private JTable lostItemRemoveTable;
	public RemoveLostItemWindow() {
		setTitle("Lost Item Remove");
		getContentPane().setLayout(null);
		
		lostItemRemoveTable = new JTable();
		lostItemRemoveTable.setBounds(10, 11, 414, 337);
		getContentPane().add(lostItemRemoveTable);
	}

}
