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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CloseLostItemWindow extends javax.swing.JFrame {
	private JTextField lostItemTxtField;
	private JTextField entryDateTxtField;
	private JTextField closingDateTxtField;
	private JTextField studentNameTxtField;
	private ButtonGroup radioButtonGroup;
	private JTextArea noteTxtArea;
	private JComboBox cBoxDorm;
	JRadioButton inProgressButton, closeButton;
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

		entryDateTxtField = new JTextField();
		entryDateTxtField.setEditable(false);
		entryDateTxtField.setColumns(10);
		entryDateTxtField.setBounds(327, 18, 136, 29);
		getContentPane().add(entryDateTxtField);

		JLabel label_3 = new JLabel("Closing Date:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(242, 69, 89, 14);
		getContentPane().add(label_3);

		closingDateTxtField = new JTextField();
		closingDateTxtField.setColumns(10);
		closingDateTxtField.setBounds(327, 66, 136, 29);
		getContentPane().add(closingDateTxtField);

		JLabel label_4 = new JLabel("Dorm:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(10, 143, 46, 14);
		getContentPane().add(label_4);

		cBoxDorm = new JComboBox();
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
		fillFields();

	}

	private void fillFields() {
		LostItem item = new LostItem();
		item = conn.retreiveLostItemInfo(id);
		lostItemTxtField.setText(item.getLostName());
		noteTxtArea.setText(item.getLostNote());
		entryDateTxtField.setText(convertDateToString(item.getLostDate()));
		cBoxDorm.addItem(item.getLostDorm());
	}

	private String convertDateToString(Date sqlDate) {
		String dt = null;
		if (sqlDate != null) {
			java.sql.Date date = new java.sql.Date(sqlDate.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dt = sdf.format(date);
		}
		return dt;
	}

	private void clickSaveButton() {
		ClosedItem item = new ClosedItem();
		LostItem it = new LostItem();
		String[] nameSurnameSplit = new String[2];
		if (!closeButton.isSelected()
				|| closingDateTxtField.getText().isEmpty()
				|| studentNameTxtField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(getContentPane(),
					"Please fill the fields!");
		} else {
			try {
				String nameSurname = studentNameTxtField.getText();
				nameSurnameSplit = nameSurname.split("\\s+");
				item.setcName(nameSurnameSplit[0]);
				item.setcSurname(nameSurnameSplit[1]);
				item.setClosingDate(convertStringToDatetime(closingDateTxtField.getText()));
				item.setLostItemId((int)id);
				conn.updateStatus((int)id);
				if(conn.insertClosedItem(item)) {
					JOptionPane.showMessageDialog(getContentPane(), "Lost item closed");
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "Lost item not closed, please try again!");
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
