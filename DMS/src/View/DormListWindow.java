package view;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;

import database.DBConnection;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.event.MouseMotionAdapter;
import javax.swing.JScrollBar;

public class DormListWindow extends javax.swing.JFrame {
	private JList dormList;
	private JList roomList;
	public static String selectedDorm;
	DefaultListModel listModelRooms;

	/**
	 * Creates new form DormWindow
	 */
	public DormListWindow() {

		setTitle("Dorm List");
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		dormListWindowPanel = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		JLabel label = new JLabel("Dorm List");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));

		scrollPane = new JScrollPane();

		listModelRooms = new DefaultListModel();

		JLabel lblRooms = new JLabel("Rooms");
		lblRooms.setFont(new Font("Tahoma", Font.BOLD, 12));

		scrollPane_1 = new JScrollPane();

		javax.swing.GroupLayout gl_dormWindowPanel = new javax.swing.GroupLayout(
				dormListWindowPanel);
		gl_dormWindowPanel
				.setHorizontalGroup(gl_dormWindowPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_dormWindowPanel
										.createSequentialGroup()
										.addGap(35)
										.addGroup(
												gl_dormWindowPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																label,
																GroupLayout.PREFERRED_SIZE,
																69,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																scrollPane,
																GroupLayout.PREFERRED_SIZE,
																194,
																GroupLayout.PREFERRED_SIZE))
										.addGap(41)
										.addGroup(
												gl_dormWindowPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblRooms,
																GroupLayout.PREFERRED_SIZE,
																51,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																scrollPane_1,
																GroupLayout.PREFERRED_SIZE,
																176,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(76, Short.MAX_VALUE)));
		gl_dormWindowPanel
				.setVerticalGroup(gl_dormWindowPanel
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_dormWindowPanel
										.createSequentialGroup()
										.addGap(18)
										.addGroup(
												gl_dormWindowPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																label,
																GroupLayout.PREFERRED_SIZE,
																15,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblRooms))
										.addGap(13)
										.addGroup(
												gl_dormWindowPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane_1,
																GroupLayout.DEFAULT_SIZE,
																202,
																Short.MAX_VALUE)
														.addComponent(
																scrollPane,
																GroupLayout.DEFAULT_SIZE,
																202,
																Short.MAX_VALUE))
										.addContainerGap()));
		roomList = new JList(listModelRooms);
		scrollPane_1.setViewportView(roomList);
		roomList.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent evt) {
				// moveMouseOnList(evt);
			}
		});
		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				clickRoomList(evt);
			}
		});

		roomList.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0,
				128), new Color(176, 224, 230), new Color(0, 0, 128),
				new Color(176, 224, 230)));
		roomList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		roomList.setForeground(Color.BLACK);
		DBConnection conn = new DBConnection();
		fillDormList(conn);
		dormList.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0,
				128), new Color(176, 224, 230), new Color(176, 224, 230),
				new Color(176, 224, 230)));
		dormList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dormList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				clickDormList(evt);
			}
		});
		scrollPane.setViewportView(dormList);
		dormListWindowPanel.setLayout(gl_dormWindowPanel);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				dormListWindowPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				dormListWindowPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Belki bunu kullanýrým, silmedim o yüzden -Nazli (silmeyin)
	private void moveMouseOnList(MouseEvent evt) {
		String info = null;
		DBConnection conn = new DBConnection();
		String rNo = (String) roomList.getSelectedValue();
		String room = rNo.substring(7);
		int roomNo = Integer.parseInt(room);
		try {
			ArrayList<Integer> studentsinRooms = conn.retrieveStudentsinRooms(
					selectedDorm, roomNo);
			roomList = (JList) evt.getSource();
			for (int i = 0; i < studentsinRooms.size(); i++) {
				info += studentsinRooms.get(i) + ", ";
			}
			int index = roomList.locationToIndex(evt.getPoint());
			if (index > -1) {
				roomList.setToolTipText(null);
				String text = (String) listModelRooms.getElementAt(index);
				roomList.setToolTipText(text);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void clickDormList(MouseEvent evt) {
		listModelRooms.clear();
		if (evt.getClickCount() == 2) {
			String sel = (String) dormList.getSelectedValue();
			selectedDorm = sel.substring(0, sel.indexOf(" -"));
			DBConnection conn = new DBConnection();
			fillRooms(conn, selectedDorm);
		}
	}

	private void clickRoomList(MouseEvent evt) {
		String info = "";
		DBConnection conn = new DBConnection();
		String rNo = (String) roomList.getSelectedValue();
		String room = rNo.substring(7);
		int roomNo = Integer.parseInt(room);
		try {
			ArrayList<Integer> studentsinRooms = conn.retrieveStudentsinRooms(
					selectedDorm, roomNo);
			if (studentsinRooms.size() > 1) {
				for (int i = 0; i < studentsinRooms.size() - 1; i++) {
					info += studentsinRooms.get(i) + ", ";
				}
				info += studentsinRooms.get(studentsinRooms.size() - 1);
			} else if (studentsinRooms.size() == 1) {
				info += studentsinRooms.get(0);
			}

			if (evt.getClickCount() == 1) {
				if (studentsinRooms.isEmpty()) {
					roomList.setToolTipText("No student enrolled in this room");

				} else {
					roomList.setToolTipText("Enrolled students: " + info);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void fillRooms(DBConnection conn, String selectedDorm) {
		conn.retrieveRoomNo(selectedDorm);
		String rooms[] = new String[conn.getRoomNoList().size()];
		for (int i = 0; i < conn.getRoomNoList().size(); i++) {
			rooms[i] = (String) conn.getRoomNoList().get(i);
			listModelRooms.addElement("Room - " + rooms[i]);
		}
	}

	private void fillDormList(DBConnection conn) {
		conn.retrieveDormInfo();
		String dorms[] = new String[conn.getDorms().size()];
		for (int i = 0; i < conn.getDorms().size(); i++) {
			dorms[i] = (String) conn.getDorms().get(i);
		}
		dormList = new JList(dorms);
	}

	public JList getList() {
		return dormList;
	}

	private javax.swing.JPanel dormListWindowPanel;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;

	public JList getDormList() {
		return dormList;
	}

	public JList getRoomList() {
		return roomList;
	}

	public static String getSelectedDorm() {
		return selectedDorm;
	}
}
