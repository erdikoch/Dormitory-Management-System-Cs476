package view;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JLayeredPane;
import java.awt.TextField;
import java.awt.Button;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LostItemView extends javax.swing.JFrame {
	private JTable table;
	public LostItemView() {
		setTitle("Lost Items");
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 32, 603, 346);
		getContentPane().add(table);
		
		final AddLostItemWindow addLostItemWindow = new AddLostItemWindow();
		final RemoveLostItemWindow removeLostItemWindow = new RemoveLostItemWindow();
		
		JMenuBar lostItemsMenuBar = new JMenuBar();
		lostItemsMenuBar.setBounds(0, 0, 623, 21);
		getContentPane().add(lostItemsMenuBar);
		
		JMenu lostItemsMenu = new JMenu("Items");
		lostItemsMenuBar.add(lostItemsMenu);
		
		JMenuItem addLostItemMenuItem = new JMenuItem("Add Lost Item");
		addLostItemMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addLostItemWindow.setVisible(true);
			}
		});
		lostItemsMenu.add(addLostItemMenuItem);
		
		JMenuItem removeLostItemMenuItem = new JMenuItem("Remove Lost Item");
		removeLostItemMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeLostItemWindow.setVisible(true);
			}
		});
		lostItemsMenu.add(removeLostItemMenuItem);
	}
}
