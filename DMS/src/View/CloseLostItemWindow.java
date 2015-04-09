package view;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import background.ClosedItem;
import background.LostItem;
import database.DBConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class CloseLostItemWindow extends javax.swing.JFrame {
	private JTextField lostItemTxtField;
	private JTextField studentNameTxtField;
	private ButtonGroup radioButtonGroup;
	private JTextArea noteTxtArea;
	private JComboBox cBoxDorm;
	JRadioButton inProgressButton, closeButton;
	JDateChooser closingDateChooser, entryDateChooser;
	private DBConnection conn = new DBConnection();
	private Object id;

	public CloseLostItemWindow(Object id) {
		this.id = id;
		initComponents();
	}

	private void initComponents() {
		setBounds(0, 0, 504, 276);
		setTitle("Lost Item Remove");
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Lost Item:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 24, 80, 14);
		getContentPane().add(label);

		lostItemTxtField = new JTextField();
		lostItemTxtField.setEditable(false);
		lostItemTxtField.setColumns(10);
		lostItemTxtField.setBounds(85, 18, 136, 29);
		getContentPane().add(lostItemTxtField);

		JLabel label_1 = new JLabel("Note:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 68, 89, 14);
		getContentPane().add(label_1);

		noteTxtArea = new JTextArea();
		noteTxtArea.setEditable(false);
		noteTxtArea.setBounds(85, 69, 136, 51);
		getContentPane().add(noteTxtArea);

		JLabel label_2 = new JLabel("Entry Date:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(242, 24, 80, 14);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Closing Date:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(242, 69, 89, 14);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Dorm:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(10, 143, 46, 14);
		getContentPane().add(label_4);

		cBoxDorm = new JComboBox();
		cBoxDorm.setEnabled(false);
		cBoxDorm.setBounds(85, 141, 136, 29);
		getContentPane().add(cBoxDorm);

		JLabel label_5 = new JLabel("Student:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(10, 193, 80, 14);
		getContentPane().add(label_5);

		studentNameTxtField = new JTextField();
		studentNameTxtField.setColumns(10);
		studentNameTxtField.setBounds(85, 187, 136, 29);
		getContentPane().add(studentNameTxtField);

		JLabel label_6 = new JLabel("Status:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(242, 128, 46, 14);
		getContentPane().add(label_6);

		inProgressButton = new JRadioButton("In progress");
		inProgressButton.setSelected(true);
		inProgressButton.setBounds(327, 125, 89, 23);
		getContentPane().add(inProgressButton);

		closeButton = new JRadioButton("Close");
		closeButton.setBounds(418, 125, 56, 23);
		getContentPane().add(closeButton);

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clickSaveButton();
			}
		});
		saveButton.setBounds(307, 190, 77, 23);
		getContentPane().add(saveButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(inProgressButton);
		radioButtonGroup.add(closeButton);
		cancelButton.setBounds(397, 190, 77, 23);
		getContentPane().add(cancelButton);

		entryDateChooser = new JDateChooser();
		entryDateChooser.setBounds(327, 24, 136, 29);
		entryDateChooser.setDateFormatString("dd/MM/yyyy");
		getContentPane().add(entryDateChooser);

		closingDateChooser = new JDateChooser();
		closingDateChooser.setBounds(327, 68, 136, 29);
		closingDateChooser.setDateFormatString("dd/MM/yyyy");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		dateFormat.format(date);
		closingDateChooser.setDate(date);
		getContentPane().add(closingDateChooser);
		fillFields();

	}

	private void fillFields() {
		LostItem item = new LostItem();
		item = conn.retreiveLostItemInfo(id);
		lostItemTxtField.setText(item.getLostName());
		noteTxtArea.setText(item.getLostNote());
		entryDateChooser.setDate(item.getLostDate());
		cBoxDorm.addItem(item.getLostDorm());
	}

	private void clickSaveButton() {
		ClosedItem item = new ClosedItem();
		LostItem it = new LostItem();
		String[] nameSurnameSplit = new String[2];
		if (!closeButton.isSelected() || closingDateChooser.getDate() == null
				|| entryDateChooser.getDate() == null
				|| studentNameTxtField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(getContentPane(),
					"Please fill the fields!");
		} else {
			String nameSurname = studentNameTxtField.getText();
			nameSurnameSplit = nameSurname.split("\\s+");
			item.setcName(nameSurnameSplit[0]);
			item.setcSurname(nameSurnameSplit[1]);
			Date closingDate = new java.sql.Date(closingDateChooser.getDate()
					.getTime());
			item.setClosingDate(closingDate);
			item.setLostItemId((int) id);
			conn.updateStatus((int) id);
			if (conn.insertClosedItem(item)) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Lost item closed");
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Lost item not closed, please try again!");
			}

		}

	}
}
