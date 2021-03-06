/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import background.Dorm;
import background.Room;
import database.DBConnection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

import javax.swing.JList;

public class RoomWindow extends javax.swing.JFrame {
	final JComboBox cboxDorm = new JComboBox();
	final JComboBox cboxRoomType = new JComboBox();

	/**
	 * Creates new form StudentWindow
	 */
	public RoomWindow() {
		setTitle("Add Room");
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		dormAddDutton = new javax.swing.JButton();
		roomDormNumberLabel = new javax.swing.JLabel();
		roomRoomNumberLabel = new javax.swing.JLabel();
		roomRoomTypeLabel = new javax.swing.JLabel();
		roomAddButton = new javax.swing.JButton();

		dormAddDutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		dormAddDutton.setText("ADD");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		roomDormNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		roomDormNumberLabel.setText("Dorm :");

		roomRoomNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		roomRoomNumberLabel.setText("Room Type :");

		roomRoomTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		roomRoomTypeLabel.setText("Room No :");

		roomAddButton.setBackground(new java.awt.Color(204, 255, 204));
		roomAddButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		roomAddButton.setText("ADD");
		roomAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					addRoomButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		fillCBoxRoomType();
		cboxRoomType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				displayRoomTypeAction(evt);
			}
		});

		fillCBoxDorm();
		roomNos = new ArrayList<String>();
		cboxDorm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				displayDormBoxAction(evt);
			}
		});

		listModelRoom = new DefaultListModel();
		roomNoLst = new JList(listModelRoom);
		roomNoLst.setFont(new Font("Tahoma", Font.PLAIN, 12));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						roomDormNumberLabel,
																						GroupLayout.DEFAULT_SIZE,
																						143,
																						Short.MAX_VALUE)
																				.addComponent(
																						roomRoomNumberLabel,
																						GroupLayout.DEFAULT_SIZE,
																						143,
																						Short.MAX_VALUE))
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						cboxRoomType,
																						0,
																						120,
																						Short.MAX_VALUE)
																				.addComponent(
																						cboxDorm,
																						Alignment.TRAILING,
																						0,
																						120,
																						Short.MAX_VALUE)))
												.addGroup(
														Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.TRAILING)
																				.addComponent(
																						roomAddButton,
																						GroupLayout.PREFERRED_SIZE,
																						66,
																						GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										roomRoomTypeLabel,
																										GroupLayout.DEFAULT_SIZE,
																										139,
																										Short.MAX_VALUE)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										roomNoLst,
																										GroupLayout.PREFERRED_SIZE,
																										120,
																										GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(
																		ComponentPlacement.RELATED)))
								.addGap(34)));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(22)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														roomDormNumberLabel)
												.addComponent(
														cboxDorm,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(21)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														roomRoomNumberLabel)
												.addComponent(
														cboxRoomType,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED,
										22, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING)
												.addComponent(roomRoomTypeLabel)
												.addComponent(
														roomNoLst,
														GroupLayout.PREFERRED_SIZE,
														22,
														GroupLayout.PREFERRED_SIZE))
								.addGap(28).addComponent(roomAddButton)
								.addGap(45)));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void fillCBoxRoomType() {
		DBConnection conn = new DBConnection();
		ArrayList<Integer> list;
		try {
			list = conn.displayRoomType();
			for (int i = 0; i < list.size(); i++)
				cboxRoomType.addItem(list.get(i));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void fillCBoxDorm() {
		DBConnection conn = new DBConnection();
		ArrayList<String> list = null;
		try {
			list = conn.displayDorm();
			for (int i = 0; i < list.size(); i++)
				cboxDorm.addItem(list.get(i));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void displayRoomTypeAction(ActionEvent evt) {
		iscBoxRoomClicked = true;
		int startId = 0;
		if (cboxRoomType.getSelectedItem().toString().equals("1")) {
			startId = 100;
			generateIdForRooms(startId);
		} else if (cboxRoomType.getSelectedItem().toString().equals("2")) {
			startId = 200;
			generateIdForRooms(startId);
		} else if (cboxRoomType.getSelectedItem().toString().equals("3")) {
			startId = 300;
			generateIdForRooms(startId);
		} else if (cboxRoomType.getSelectedItem().toString().equals("4")) {
			startId = 400;
			generateIdForRooms(startId);
		} else if (cboxRoomType.getSelectedItem().toString().equals("5")) {
			startId = 500;
			generateIdForRooms(startId);
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "Bu ne lan!");
		}
	}

	private void displayDormBoxAction(ActionEvent evt) {
		iscBoxDormClicked = true;
	}

	private void generateIdForRooms(int startId) {
		DBConnection conn = new DBConnection();
		AtomicInteger nextId;
		int id = 0;
		conn.retrieveRoomNo(cboxDorm.getSelectedItem().toString());
		roomNos = conn.getRoomNoList();
		nextId = new AtomicInteger(startId);
		id = nextId.incrementAndGet();
		String idS = Integer.toString(id);
		int i = 0;
		while (roomNos.toString().contains(idS)) {
			id = nextId.incrementAndGet();
			idS = Integer.toString(id);
			i++;
			if (i == roomNos.size())
				break;
		}
		listModelRoom.addElement(id);
	}

	private void addRoomButtonActionPerformed(java.awt.event.ActionEvent evt)
			throws SQLException {
		Room room = new Room();
		Dorm dorm = new Dorm();
		if (iscBoxRoomClicked || iscBoxDormClicked
				|| roomNoLst.getModel().getSize() != 0) {
			String type = cboxRoomType.getSelectedItem().toString();
			int roomType = Integer.parseInt(type);
			room.setTypeName(roomType);
			String dormName = cboxDorm.getSelectedItem().toString();
			dorm.setDormName(dormName);
			int roomNo = (int) roomNoLst.getModel().getElementAt(0);
			room.setRoomNo(roomNo);
			DBConnection connection = new DBConnection();
			checkInsertRoom(room, dorm, connection);
		} else {
			JOptionPane.showMessageDialog(getContentPane(),
					"Please fill the fields!");
		}

	}

	private void checkInsertRoom(Room room, Dorm dorm, DBConnection connection)
			throws SQLException {
		if (connection.insertRoom(room, dorm)) {
			JOptionPane.showMessageDialog(getContentPane(),
					"Registration completed");
			roomNos = null;
			listModelRoom.clear();
		} else {
			JOptionPane.showMessageDialog(getContentPane(),
					"Registration not completed, try again!");
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton roomAddButton;
	private javax.swing.JButton dormAddDutton;
	private javax.swing.JLabel roomDormNumberLabel;
	private javax.swing.JLabel roomRoomNumberLabel;
	private javax.swing.JLabel roomRoomTypeLabel;
	private JList roomNoLst;
	private ArrayList<String> roomNos;
	private DefaultListModel listModelRoom;
	private Boolean iscBoxRoomClicked = false;
	private Boolean iscBoxDormClicked = false;
}
