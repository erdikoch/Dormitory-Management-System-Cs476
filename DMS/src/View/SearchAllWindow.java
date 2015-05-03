package view;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JLabel;

import background.Dorm;
import background.Hostel;
import background.Room;

import com.toedter.calendar.JDateChooser;

import database.DBConnection;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchAllWindow extends javax.swing.JFrame {
	private JTable searchTable;
	private DBConnection conn = new DBConnection();
	private JDateChooser startdateChooser, enddateChooser;
	private JTable availableRoomsTable;
	private JComboBox cBoxDorm, cBoxRoomType, cBoxRoomNo;

	/**
	 * Creates new form DormWindow
	 */
	public SearchAllWindow() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Search");
		getContentPane().setLayout(null);
		setBounds(0, 0, 603, 610);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 587, 102);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(5, 7, 69, 15);
		lblStartDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblStartDate.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblStartDate);
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 12));

		startdateChooser = new JDateChooser();
		startdateChooser.setBounds(79, 5, 141, 22);
		panel.add(startdateChooser);
		startdateChooser.setDateFormatString("dd/MM/yyyy");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		dateFormat.format(date);
		startdateChooser.setDate(date);
		JLabel label = new JLabel("End Date:");
		label.setBounds(5, 54, 60, 15);
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));

		enddateChooser = new JDateChooser();
		enddateChooser.setBounds(79, 47, 141, 22);
		panel.add(enddateChooser);
		enddateChooser.setDateFormatString("dd/MM/yyyy");

		JButton enterButton = new JButton("ENTER");
		enterButton.setBounds(487, 47, 79, 29);
		panel.add(enterButton);
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				getStudentInfoDateAction(evt);
			}
		});
		enterButton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblAccommodationTimeOf = new JLabel(
				"Accommodation Time of Students");
		lblAccommodationTimeOf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccommodationTimeOf.setBounds(10, 86, 227, 14);
		panel.add(lblAccommodationTimeOf);

		JLabel lblDorm = new JLabel("Dorm:");
		lblDorm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDorm.setBounds(265, 8, 46, 14);
		panel.add(lblDorm);

		JLabel lblRoomType = new JLabel("Room Type:");
		lblRoomType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoomType.setBounds(265, 43, 79, 14);
		panel.add(lblRoomType);

		JLabel lblRoomNo = new JLabel("Room No:");
		lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoomNo.setBounds(265, 78, 60, 14);
		panel.add(lblRoomNo);

		cBoxDorm = new JComboBox();
		cBoxDorm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				fillDormCBox(evt);
			}
		});
		cBoxDorm.setBounds(360, 5, 86, 20);
		panel.add(cBoxDorm);

		cBoxRoomType = new JComboBox();
		cBoxRoomType.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				fillRoomTypes(evt);
			}
		});
		cBoxRoomType.setBounds(360, 38, 86, 20);
		panel.add(cBoxRoomType);

		cBoxRoomNo = new JComboBox();
		cBoxRoomNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				fillRoomCBox(evt);
			}
		});
		cBoxRoomNo.setBounds(360, 68, 86, 20);
		panel.add(cBoxRoomNo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(

		EtchedBorder.LOWERED, new Color(102, 102, 102), new Color(0, 0,

		51)));
		scrollPane.setBounds(0, 101, 587, 222);
		getContentPane().add(scrollPane);

		searchTable = new JTable();
		scrollPane.setViewportView(searchTable);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new EtchedBorder(

		EtchedBorder.LOWERED, new Color(102, 102, 102), new Color(0, 0,

		51)));
		scrollPane_1.setBounds(0, 349, 587, 222);
		getContentPane().add(scrollPane_1);

		availableRoomsTable = new JTable();
		scrollPane_1.setViewportView(availableRoomsTable);

		JLabel label_1 = new JLabel("Available Rooms");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 334, 227, 14);
		getContentPane().add(label_1);
	}

	private void fillDormCBox(MouseEvent evt) {
		cBoxDorm.removeAllItems();
		try {
			ArrayList<String> dorms = conn.displayDorm();
			for (int i = 0; i < dorms.size(); i++)
				cBoxDorm.addItem(dorms.get(i));
			cBoxDorm.addItem(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void fillRoomTypes(MouseEvent evt) {
		cBoxRoomType.removeAllItems();
		try {
			ArrayList<Integer> list = conn.displayRoomType();
			for (int i = 0; i < list.size(); i++)
				cBoxRoomType.addItem(list.get(i));
			cBoxRoomType.addItem(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void fillRoomCBox(MouseEvent evt) {
		Dorm dorm = new Dorm();
		Room room = new Room();
		if (cBoxDorm.getSelectedItem() == null
				|| cBoxRoomType.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(getContentPane(),
					"No Dorm/Room chosen");
		} else {
			try {
				fillNos(dorm, room);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void fillNos(Dorm dorm, Room room) throws SQLException {
		dorm.setDormName(cBoxDorm.getSelectedItem().toString());
		room.setTypeName(Integer.parseInt(cBoxRoomType.getSelectedItem()
				.toString()));
		ArrayList<Integer> list = new ArrayList<Integer>();
		cBoxRoomNo.removeAllItems();
		list = conn.displayRoomNo(dorm, room);
		for (int i = 0; i < list.size(); i++)
			cBoxRoomNo.addItem(list.get(i));
		cBoxRoomNo.addItem(null);
	}

	private void getStudentInfoDateAction(ActionEvent evt) {
		Hostel host = new Hostel();
		try {
			if (enddateChooser.getDate() == null
					&& startdateChooser.getDate() != null) {
				getInfoNoEndDate(host);
			} else if (enddateChooser.getDate() != null
					&& startdateChooser.getDate() != null) {
				getInfo(host);
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Please enter the start date!");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void getInfoNoEndDate(Hostel host) throws ParseException {
		
		String date = "01/01/2050";
		host.setEndDate(convertStringToDatetime(date));
		Date startDate = new java.sql.Date(startdateChooser.getDate().getTime());
		host.setStartDate(startDate);
		fillModel(host);
		fillAvailableModel(host);
	}

	private void getInfo(Hostel host) {
		
		Date startDate = new java.sql.Date(startdateChooser.getDate().getTime());
		Date endDate = new java.sql.Date(enddateChooser.getDate().getTime());
		host.setEndDate(endDate);
		host.setStartDate(startDate);
		fillModel(host);
		fillAvailableModel(host);
	}

	private void fillModel(Hostel host) {
		searchTable.setModel(conn.getStudentsForDate(host,
				cBoxDorm.getSelectedItem(), cBoxRoomNo.getSelectedItem(), cBoxRoomType.getSelectedItem()));
	}
	private void fillAvailableModel(Hostel host) {
		searchTable.setModel(conn.getSearchAvailable(host));
	}

	private Date convertStringToDatetime(String dt) throws ParseException {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		date = sdf.parse(dt);
		Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
}
