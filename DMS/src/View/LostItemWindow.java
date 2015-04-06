package view;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import database.DBConnection;
import automata.Note;
import background.LostItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class LostItemWindow extends javax.swing.JFrame {
	private JTextField lostItemTextField;
	private JTextField entryDateTextField;
	private ButtonGroup radioButtonGroup;
	private JRadioButton inProgressButton, closeButton;
	private JTextArea noteTextArea;
	private JComboBox cBoxDorm;
	private boolean isDormSelected = false;
	private DBConnection conn = new DBConnection();

	public LostItemWindow() {
		initComponents();
	}

	private void initComponents() {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(0, 0, 299, 308);

		JButton lostItemAddButton = new JButton("Add");
		lostItemAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clickAddButton(evt);
			}
		});
		lostItemAddButton.setBounds(180, 243, 89, 23);
		getContentPane().add(lostItemAddButton);

		lostItemTextField = new JTextField();
		lostItemTextField.setBounds(98, 28, 136, 29);
		getContentPane().add(lostItemTextField);
		lostItemTextField.setColumns(10);

		entryDateTextField = new JTextField();
		entryDateTextField.setBounds(98, 133, 136, 29);
		getContentPane().add(entryDateTextField);
		entryDateTextField.setColumns(10);

		JLabel lostItemNameLabel = new JLabel("Lost Item(*):");
		lostItemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lostItemNameLabel.setBounds(10, 31, 89, 14);
		getContentPane().add(lostItemNameLabel);

		JLabel lblDate = new JLabel("Entry Date(*)");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 139, 90, 14);
		getContentPane().add(lblDate);

		inProgressButton = new JRadioButton("In progress");
		inProgressButton.setSelected(true);
		inProgressButton.setBounds(98, 213, 89, 23);
		getContentPane().add(inProgressButton);

		closeButton = new JRadioButton("Close");
		closeButton.setBounds(189, 213, 80, 23);
		closeButton.setEnabled(false);
		getContentPane().add(closeButton);
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(inProgressButton);
		radioButtonGroup.add(closeButton);

		JLabel lblStatus = new JLabel("Status (*):");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(10, 216, 80, 14);
		getContentPane().add(lblStatus);

		JLabel lblNewLabel = new JLabel("Note (*):");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 68, 89, 14);
		getContentPane().add(lblNewLabel);

		noteTextArea = new JTextArea();
		noteTextArea.setBounds(98, 68, 136, 51);
		getContentPane().add(noteTextArea);

		cBoxDorm = new JComboBox();
		cBoxDorm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				actionCBoxDorm(evt);
			}

			private void actionCBoxDorm(ActionEvent evt) {
				isDormSelected = true;

			}
		});

		fillCBoxDorm();
		cBoxDorm.setBounds(98, 173, 136, 29);
		getContentPane().add(cBoxDorm);

		JLabel lblDorm = new JLabel("Dorm(*):");
		lblDorm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDorm.setBounds(10, 179, 80, 14);
		getContentPane().add(lblDorm);
	}

	private void clickAddButton(ActionEvent evt) {
		LostItem item = new LostItem();
		try {

			if (entryDateTextField.getText().isEmpty()
					|| lostItemTextField.getText().isEmpty()
					|| noteTextArea.getText().isEmpty() || !isDormSelected) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Please fill the empty fields");
			} else {
				item.setLostName(lostItemTextField.getText());
				item.setLostNote(noteTextArea.getText());
				Date entryDate = convertStringToDatetime(entryDateTextField
						.getText());
				item.setLostDate(entryDate);
				item.setLostStatus(inProgressButton.getText());
				item.setLostDorm(cBoxDorm.getSelectedItem().toString());
				if (conn.insertLostItem(item)) {
					JOptionPane.showMessageDialog(getContentPane(),
							"Registration is completed");
				} else {
					JOptionPane.showMessageDialog(getContentPane(),
							"Registration is not completed, try again!");
				}

			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Date convertStringToDatetime(String dt) throws ParseException {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		date = sdf.parse(dt);
		Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
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
}
