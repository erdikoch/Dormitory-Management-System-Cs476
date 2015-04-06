package view;

import javax.swing.JLabel;

import java.awt.TextField;
import java.awt.Button;
import java.awt.Font;
import java.sql.SQLException;
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

public class DamagedItemWindow extends javax.swing.JFrame {
	private JTextField damagedItemTextField;
	private JTextField entryDateTextField;
	private ButtonGroup radioButtonGroup;
	private JRadioButton inProgressButton, closeButton;
	private JComboBox cBoxDorm;
	private boolean isDormSelected;
	private JTextArea noteTextArea;
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

		entryDateTextField = new JTextField();
		entryDateTextField.setBounds(116, 130, 136, 29);
		getContentPane().add(entryDateTextField);
		entryDateTextField.setColumns(10);

		JLabel lostItemNameLabel = new JLabel("Damaged Item:");
		lostItemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lostItemNameLabel.setBounds(10, 31, 96, 14);
		getContentPane().add(lostItemNameLabel);

		JLabel lblDate = new JLabel("Entry Date(*):");
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

		JLabel lblStatus = new JLabel("Status (*):");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(10, 215, 74, 14);
		getContentPane().add(lblStatus);

		JLabel lblNote = new JLabel("Note (*):");
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
				|| entryDateTextField.getText().isEmpty()
				|| noteTextArea.getText().isEmpty() || !isDormSelected) {
			JOptionPane.showMessageDialog(getContentPane(),
					"Please fill the empty fields");
		} else {
			try {
				item.setDamagedName(damagedItemTextField.getText());
				item.setDamagedDate(convertStringToDatetime(entryDateTextField
						.getText()));
				item.setDamagedNote(noteTextArea.getText());
				item.setDamagedDorm(cBoxDorm.getSelectedItem().toString());
				item.setDamagedStatus(inProgressButton.getText().toString());

				if (conn.insertDamagedItem(item)) {
					JOptionPane.showMessageDialog(getContentPane(),
							"Registration is completed");
				} else {
					JOptionPane.showMessageDialog(getContentPane(),
							"Registration is not completed, try again!");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	private Date convertStringToDatetime(String dt) throws ParseException {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		date = sdf.parse(dt);
		Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
}
