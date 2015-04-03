package view;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.UIManager;
import javax.swing.JTable;

import database.DBConnection;
import background.LostItem;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ItemsListWindow extends javax.swing.JFrame {
	private JTable lostItemTable;
	private DBConnection conn = new DBConnection();
	private JTable damagedItemTable;

	// private Object[][] lostTableData = new Object[8][8];

	public ItemsListWindow() {
		initComponents();

	}

	private void initComponents() {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(0, 0, 500, 290);
		JScrollPane lostItemScrollPane = new JScrollPane();
		lostItemScrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(102, 102, 102), new Color(0, 0, 51)));
		lostItemScrollPane.setBounds(0, 37, 246, 224);
		getContentPane().add(lostItemScrollPane);
		String[] lostItemColumns = { "ItemNo", "Item", "Status" };
		fillLostTable();
		lostItemTable = new JTable();
		lostItemTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { {}, {}, {}, {} }, new String[] {
				}));
		
		lostItemTable.setModel(fillLostTable());
		lostItemScrollPane.setViewportView(lostItemTable);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(102, 102, 102), new Color(0, 0, 51)));
		scrollPane_1.setBounds(248, 37, 246, 224);
		getContentPane().add(scrollPane_1);
		
		damagedItemTable = new JTable();
		damagedItemTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { {}, {}, {}, {} }, new String[] {
				}));
		damagedItemTable.setModel(fillDamagedTable());
		scrollPane_1.setViewportView(damagedItemTable);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(153, 102, 102)));
		panel.setBounds(0, 0, 246, 36);
		getContentPane().add(panel);

		JLabel lblLostItems = new JLabel("Lost Items");
		lblLostItems.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblLostItems);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(248, 0, 246, 36);
		getContentPane().add(panel_1);

		JLabel lblDamagedItems = new JLabel("Damaged Items");
		lblDamagedItems.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(lblDamagedItems);
	}

	private TableModel fillLostTable() {
		conn.retrieveLostItems();
		DefaultTableModel lostModel = new DefaultTableModel();
		lostModel.addColumn("Item ID");
		lostModel.addColumn("Item");
		lostModel.addColumn("Status");
		for (int i = 0; i < conn.getLostId().size(); i++) {
			lostModel.addRow(new Object[] { conn.getLostId().get(i),
					conn.getLostName().get(i), conn.getLostStatus().get(i) });
		}
		return lostModel;
	}
	
	private TableModel fillDamagedTable() {
		conn.retrieveDamagedItems();
		DefaultTableModel dmgModel = new DefaultTableModel();
		dmgModel.addColumn("Item ID");
		dmgModel.addColumn("Item");
		dmgModel.addColumn("Status");
		for (int i = 0; i < conn.getDamagedId().size(); i++) {
			dmgModel.addRow(new Object[] { conn.getDamagedId().get(i),
					conn.getDamagedName().get(i), conn.getDamagedStatus().get(i) });
		}
		return dmgModel;
	}
}
