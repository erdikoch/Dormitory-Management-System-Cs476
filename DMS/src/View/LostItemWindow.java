package view;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import database.DBConnection;
import background.LostItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class LostItemWindow extends javax.swing.JFrame {
	private JTextField lostItemTextField;
	private ButtonGroup radioButtonGroup;
	private JRadioButton inProgressButton, closeButton;
	private JTextArea noteTextArea;
	private JComboBox cBoxDorm;
	private JDateChooser entryDateChooser;
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

		JLabel lostItemNameLabel = new JLabel("Lost Item:");
		lostItemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lostItemNameLabel.setBounds(10, 31, 80, 14);
		getContentPane().add(lostItemNameLabel);

		JLabel lblDate = new JLabel("Entry Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 139, 80, 14);
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

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(10, 216, 46, 14);
		getContentPane().add(lblStatus);

		JLabel lblNewLabel = new JLabel("Note:");
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

		JLabel lblDorm = new JLabel("Dorm:");
		lblDorm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDorm.setBounds(10, 179, 46, 14);
		getContentPane().add(lblDorm);

		entryDateChooser = new JDateChooser();
		entryDateChooser.setBounds(98, 133, 136, 29);
		entryDateChooser.setDateFormatString("dd/MM/yyyy");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		dateFormat.format(date);
		entryDateChooser.setDate(date);
		getContentPane().add(entryDateChooser);
	}

	private void clickAddButton(ActionEvent evt) {
		LostItem item = new LostItem();
		if (entryDateChooser.getDate() == null
				|| lostItemTextField.getText().isEmpty()
				|| noteTextArea.getText().isEmpty() || !isDormSelected) {
			JOptionPane.showMessageDialog(getContentPane(),
					"Please fill the empty fields");
		} else {
			item.setLostName(lostItemTextField.getText());
			item.setLostNote(noteTextArea.getText());
			Date entryDate = new java.sql.Date(entryDateChooser.getDate()
					.getTime());
			item.setLostDate(entryDate);
			item.setLostStatus(inProgressButton.getText());
			item.setLostDorm(cBoxDorm.getSelectedItem().toString());
			if (conn.insertLostItem(item)) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Registration completed");
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Registration not completed, try again!");
			}
		}
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
