package view;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;

public class DamagedItemWindow extends javax.swing.JFrame {
	private JTextField lostItemIDTextField;
	private JTextField lostItemNameTextField;
	private ButtonGroup radioButtonGroup;
	public DamagedItemWindow() {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(0,0,306,253);
		
		JButton lostItemAddButton = new JButton("Add");
		lostItemAddButton.setBounds(188, 190, 89, 23);
		getContentPane().add(lostItemAddButton);
		
		lostItemIDTextField = new JTextField();
		lostItemIDTextField.setBounds(116, 28, 136, 23);
		getContentPane().add(lostItemIDTextField);
		lostItemIDTextField.setColumns(10);
		
		lostItemNameTextField = new JTextField();
		lostItemNameTextField.setBounds(116, 122, 136, 23);
		getContentPane().add(lostItemNameTextField);
		lostItemNameTextField.setColumns(10);
		
		JLabel lostItemNameLabel = new JLabel("Damaged Item:");
		lostItemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lostItemNameLabel.setBounds(10, 31, 96, 14);
		getContentPane().add(lostItemNameLabel);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 125, 66, 14);
		getContentPane().add(lblDate);
		
		JRadioButton inProgressButton = new JRadioButton("In progress");
		inProgressButton.setBounds(116, 160, 89, 23);
		getContentPane().add(inProgressButton);
		
		JRadioButton closeButton = new JRadioButton("Close");
		closeButton.setBounds(203, 160, 74, 23);
		getContentPane().add(closeButton);
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(inProgressButton);
		radioButtonGroup.add(closeButton);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(10, 163, 46, 14);
		getContentPane().add(lblStatus);
		
		JLabel lblNote = new JLabel("Note:");
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNote.setBounds(10, 70, 96, 14);
		getContentPane().add(lblNote);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(116, 60, 136, 51);
		getContentPane().add(textArea);
		
		
	}
}
