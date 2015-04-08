package view;

import javax.swing.JLabel;

import java.awt.TextField;
import java.awt.Button;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import background.DamagedItem;
import database.DBConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

public class DamagedItemWindow extends javax.swing.JFrame {
	private JTextField damagedItemTextField;
	private ButtonGroup radioButtonGroup;
	private JRadioButton inProgressButton, closeButton;
	private JComboBox cBoxDorm;
	private boolean isDormSelected;
	private JTextArea noteTextArea;
	private JDateChooser entryDateChooser;
	private DBConnection conn = new DBConnection();

	public DamagedItemWindow() {
		initComponents();
	}

	private void initComponents() {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(0, 0, 298, 317);

		JButton damagedItemAddButton = new JButton("Add");
		damagedItemAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clickAddButton(evt);
			}
		});
		damagedItemAddButton.setBounds(188, 254, 89, 23);
		getContentPane().add(damagedItemAddButton);

		damagedItemTextField = new JTextField();
		damagedItemTextField.setBounds(116, 28, 136, 29);
		getContentPane().add(damagedItemTextField);
		damagedItemTextField.setColumns(10);

		JLabel lostItemNameLabel = new JLabel("Damaged Item:");
		lostItemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lostItemNameLabel.setBounds(10, 31, 96, 14);
		getContentPane().add(lostItemNameLabel);

		JLabel lblDate = new JLabel("Entry Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 136, 96, 14);
		getContentPane().add(lblDate);

		inProgressButton = new JRadioButton("In progress");
		inProgressButton.setSelected(true);
		inProgressButton.setBounds(116, 212, 89, 23);
		getContentPane().add(inProgressButton);

		closeButton = new JRadioButton("Close");
		closeButton.setBounds(207, 212, 74, 23);
		closeButton.setEnabled(false);
		getContentPane().add(closeButton);
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(inProgressButton);
		radioButtonGroup.add(closeButton);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(10, 215, 46, 14);
		getContentPane().add(lblStatus);

		JLabel lblNote = new JLabel("Note:");
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNote.setBounds(10, 67, 96, 14);
		getContentPane().add(lblNote);

		noteTextArea = new JTextArea();
		noteTextArea.setBounds(116, 68, 136, 51);
		getContentPane().add(noteTextArea);

		JLabel lblDorm = new JLabel("Dorm:");
		lblDorm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDorm.setBounds(10, 180, 46, 14);
		getContentPane().add(lblDorm);

		cBoxDorm = new JComboBox();
		cBoxDorm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				actionCBoxDorm(evt);
			}

			private void actionCBoxDorm(ActionEvent evt) {
				isDormSelected = true;

			}
		});
		cBoxDorm.setBounds(116, 170, 136, 29);
		fillCBoxDorm();
		getContentPane().add(cBoxDorm);

		entryDateChooser = new JDateChooser();
		entryDateChooser.setBounds(116, 130, 136, 29);
		entryDateChooser.setDateFormatString("dd/MM/yyyy");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		dateFormat.format(date);
		entryDateChooser.setDate(date);
		getContentPane().add(entryDateChooser);
	}

	private void fillCBoxDorm() {
		ArrayList<String> dormList = null;
		try {
			dormList = conn.displayDorm();
			for (int i = 0; i < dormList.size(); i++)
				cBoxDorm.addItem(dormList.get(i));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void clickAddButton(ActionEvent evt) {
		DamagedItem item = new DamagedItem();
		if (damagedItemTextField.getText().isEmpty()
				|| entryDateChooser.getDate() == null
				|| noteTextArea.getText().isEmpty() || !isDormSelected) {
			JOptionPane.showMessageDialog(getContentPane(),
					"Please fill the empty fields");
		} else {
			item.setDamagedName(damagedItemTextField.getText());
			Date entryDate = new java.sql.Date(entryDateChooser.getDate()
					.getTime());
			item.setDamagedDate(entryDate);
			item.setDamagedNote(noteTextArea.getText());
			item.setDamagedDorm(cBoxDorm.getSelectedItem().toString());
			item.setDamagedStatus(inProgressButton.getText().toString());

			if (conn.insertDamagedItem(item)) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Registration completed");
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Registration not completed, try again!");
			}
		}
	}
}
