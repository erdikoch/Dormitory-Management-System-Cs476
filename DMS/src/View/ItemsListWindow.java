package view;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.JTable;

import database.DBConnection;
import background.LostItem;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItemsListWindow extends javax.swing.JFrame {
	private JTable lostItemTable;
	private DBConnection conn = new DBConnection();
	private JTable damagedItemTable;
	private JTable closedItemTable;
	private JMenuItem deletedLostItem, deletedDamagedItem;
	private JPopupMenu popupMenu, popupMenuForD;

	public ItemsListWindow() {
		initComponents();

	}

	private void initComponents() {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(0, 0, 750, 290);
		JScrollPane lostItemScrollPane = new JScrollPane();

		lostItemScrollPane.setViewportBorder(new EtchedBorder(
				EtchedBorder.LOWERED, new Color(102, 102, 102), new Color(0, 0,
						51)));
		lostItemScrollPane.setBounds(0, 37, 246, 224);
		getContentPane().add(lostItemScrollPane);
		String[] lostItemColumns = { "ItemNo", "Item", "Status" };
		fillLostTable();
		lostItemTable = new JTable();
		popupMenu = new JPopupMenu();
		deletedLostItem = new JMenuItem("Closed");
		deletedLostItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				Object id = lostItemTable.getValueAt(
						lostItemTable.getSelectedRow(), 0);
				lostItemTable.getSelectedRow();
				new CloseLostItemWindow(id).setVisible(true);
			}
		});
		popupMenu.add(deletedLostItem);
		lostItemTable.setComponentPopupMenu(popupMenu);
		lostItemTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				clickLostItems(evt);
			}
		});

		lostItemTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { {}, {}, {}, {} }, new String[] {}));

		lostItemTable.setModel(fillLostTable());
		lostItemScrollPane.setViewportView(lostItemTable);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED,
				new Color(102, 102, 102), new Color(0, 0, 51)));
		scrollPane_1.setBounds(498, 37, 246, 224);
		getContentPane().add(scrollPane_1);

		damagedItemTable = new JTable();
		damagedItemTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				clickOnDmgTable(evt);
			}
		});
		popupMenuForD = new JPopupMenu();

		deletedDamagedItem = new JMenuItem("Closed");
		deletedDamagedItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!damagedItemTable.getValueAt(
						damagedItemTable.getSelectedRow(), 2).equals("Closed")) {
					conn.updateDmgItemStatus(damagedItemTable.getValueAt(
							damagedItemTable.getSelectedRow(), 0));
					damagedItemTable.setValueAt("Closed",
							damagedItemTable.getSelectedRow(), 2);
				}
			}
		});

		popupMenuForD.add(deletedDamagedItem);
		damagedItemTable.setComponentPopupMenu(popupMenuForD);
		damagedItemTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { {}, {}, {}, {} }, new String[] {}));
		damagedItemTable.setModel(fillDamagedTable());
		scrollPane_1.setViewportView(damagedItemTable);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED,
				new Color(102, 102, 102), new Color(0, 0, 51)));
		scrollPane.setBounds(248, 37, 246, 224);
		getContentPane().add(scrollPane);

		closedItemTable = new JTable();
		closedItemTable.setModel(fillClosedTable());
		scrollPane.setViewportView(closedItemTable);

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

		JLabel lblDamagedItems = new JLabel("Closed Lost Items");
		lblDamagedItems.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(lblDamagedItems);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager

		.getBorder("TitledBorder.border"), "", TitledBorder.CENTER,

		TitledBorder.TOP, null, null));
		panel_2.setBounds(498, 0, 246, 36);
		getContentPane().add(panel_2);

		JLabel label = new JLabel("Damaged Items");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(label);
	}

	private TableModel fillLostTable() {
		conn.retrieveLostItems();
		DefaultTableModel lostModel = new DefaultTableModel();
		lostModel.addColumn("Item ID");
		lostModel.addColumn("Item");
		lostModel.addColumn("Status");
		for (int i = 0; i < conn.getLostId().size(); i++) {
			if (conn.getLostStatus().get(i).equals("In progress")) {
				lostModel
						.addRow(new Object[] { conn.getLostId().get(i),
								conn.getLostName().get(i),
								conn.getLostStatus().get(i) });
			}
		}
		return lostModel;
	}

	private TableModel fillClosedTable() {
		DefaultTableModel closedModel = new DefaultTableModel();
		closedModel.addColumn("Item ID");
		closedModel.addColumn("Item");
		closedModel.addColumn("Status");
		for (int i = 0; i < conn.getLostId().size(); i++) {
			if (conn.getLostStatus().get(i).equals("Closed")) {
				closedModel
						.addRow(new Object[] { conn.getLostId().get(i),
								conn.getLostName().get(i),
								conn.getLostStatus().get(i) });
			}
		}
		return closedModel;
	}

	private TableModel fillDamagedTable() {
		conn.retrieveDamagedItems();
		DefaultTableModel dmgModel = new DefaultTableModel();
		dmgModel.addColumn("Item ID");
		dmgModel.addColumn("Item");
		dmgModel.addColumn("Status");
		for (int i = 0; i < conn.getDamagedId().size(); i++) {
			dmgModel.addRow(new Object[] { conn.getDamagedId().get(i),
					conn.getDamagedName().get(i),
					conn.getDamagedStatus().get(i) });
		}
		return dmgModel;
	}

	private void clickLostItems(MouseEvent evt) {
		if (lostItemTable.getSelectedColumn() == 2) {

		}
		if (lostItemTable.getSelectedColumn() == 0 && evt.getClickCount() == 2) {
			System.out.println(lostItemTable.getSelectedRow());
		}
	}

	private void clickOnDmgTable(MouseEvent evt) {
		if (damagedItemTable.getSelectedColumn() == 0
				&& evt.getClickCount() == 1) {
			System.out.println("napalim napalim");
		}

	}
}
