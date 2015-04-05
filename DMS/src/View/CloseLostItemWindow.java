package view;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CloseLostItemWindow extends javax.swing.JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private ButtonGroup radioButtonGroup;
	public CloseLostItemWindow() {
		setBounds(0,0,504,276);
		setTitle("Lost Item Remove");
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Lost Item:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 24, 80, 14);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(85, 18, 136, 29);
		getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("Note:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 68, 89, 14);
		getContentPane().add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(85, 69, 136, 51);
		getContentPane().add(textArea);
		
		JLabel label_2 = new JLabel("Entry Date:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(242, 24, 80, 14);
		getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(327, 18, 136, 29);
		getContentPane().add(textField_1);
		
		JLabel label_3 = new JLabel("Closing Date:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(242, 69, 89, 14);
		getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(327, 66, 136, 29);
		getContentPane().add(textField_2);
		
		JLabel label_4 = new JLabel("Dorm:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(10, 143, 46, 14);
		getContentPane().add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(85, 141, 136, 29);
		getContentPane().add(comboBox);
		
		JLabel label_5 = new JLabel("Student:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(10, 193, 80, 14);
		getContentPane().add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(85, 187, 136, 29);
		getContentPane().add(textField_3);
		
		JLabel label_6 = new JLabel("Status:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(242, 128, 46, 14);
		getContentPane().add(label_6);
		
		JRadioButton inProgressButton = new JRadioButton("In progress");
		inProgressButton.setBounds(327, 125, 89, 23);
		getContentPane().add(inProgressButton);
		
		JRadioButton closeButton = new JRadioButton("Close");
		closeButton.setBounds(418, 125, 56, 23);
		getContentPane().add(closeButton);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(307, 190, 77, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(inProgressButton);
		radioButtonGroup.add(closeButton);
		button_1.setBounds(397, 190, 77, 23);
		getContentPane().add(button_1);
	}
}
