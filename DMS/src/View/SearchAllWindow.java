package view;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;

import background.Hostel;

import com.toedter.calendar.JDateChooser;

import database.DBConnection;

import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
// import org.jdatepicker.impl.UtilDateModel;

import javax.swing.table.TableModel;

import org.apache.batik.svggen.font.table.Table;

import java.awt.event.ActionListener;
import java.util.Date;

public class SearchAllWindow extends javax.swing.JFrame {
	private JTable searchTable;
	private DBConnection conn = new DBConnection();
	private JDateChooser startdateChooser, enddateChooser;

	/**
	 * Creates new form DormWindow
	 */
	public SearchAllWindow() {
		initComponents();

	}

	private void initComponents() {
		setTitle("Search");
		getContentPane().setLayout(null);
		setBounds(0, 0, 603, 327);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(0, 0, 346, 49);
		getContentPane().add(panel);

		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblStartDate.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblStartDate);
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 12));

		startdateChooser = new JDateChooser();
		panel.add(startdateChooser);
		startdateChooser.setDateFormatString("dd/MM/yyyy");

		JLabel label = new JLabel("End Date:");
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));

		enddateChooser = new JDateChooser();
		panel.add(enddateChooser);
		enddateChooser.setDateFormatString("dd/MM/yyyy");

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignOnBaseline(true);
		panel_1.setBounds(452, 0, 135, 49);
		getContentPane().add(panel_1);

		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				getStudentInfoDateAction(evt);
			}
		});
		btnEnter.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(btnEnter);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(

		EtchedBorder.LOWERED, new Color(102, 102, 102), new Color(0, 0,

		51)));
		scrollPane.setBounds(0, 66, 587, 222);
		getContentPane().add(scrollPane);

		searchTable = new JTable();
		scrollPane.setViewportView(searchTable);
	}

	private void getStudentInfoDateAction(ActionEvent evt) {
		Hostel host = new Hostel();
		Date startDate = new java.sql.Date(startdateChooser.getDate().getTime());
		Date endDate = new java.sql.Date(enddateChooser.getDate().getTime());
		host.setEndDate(endDate);
		host.setStartDate(startDate);
		searchTable.setModel(conn.getStudentsForDate(host));
	}

}
