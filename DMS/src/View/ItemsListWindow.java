package view;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;

public class ItemsListWindow extends javax.swing.JFrame {
	public ItemsListWindow() {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(0, 0, 440, 290);
		JScrollPane lostItemScrollPane = new JScrollPane();
		lostItemScrollPane.setBounds(0, 37, 217, 224);
		getContentPane().add(lostItemScrollPane);
		
		JList lostItemJList = new JList();
		lostItemJList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 51, 153), new Color(0, 153, 204)));
		lostItemScrollPane.setViewportView(lostItemJList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(217, 37, 217, 224);
		getContentPane().add(scrollPane_1);
		
		JList damagedItemJList = new JList();
		damagedItemJList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 51, 153), new Color(0, 153, 204)));
		scrollPane_1.setViewportView(damagedItemJList);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(153, 102, 102)));
		panel.setBounds(0, 0, 217, 36);
		getContentPane().add(panel);
		
		JLabel lblLostItems = new JLabel("Lost Items");
		lblLostItems.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblLostItems);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(217, 0, 217, 36);
		getContentPane().add(panel_1);
		
		JLabel lblDamagedItems = new JLabel("Damaged Items");
		lblDamagedItems.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(lblDamagedItems);
		
	}
}
