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

public class LostItemWindow extends javax.swing.JFrame {
	private JTextField lostItemIDTextField;
	private JTextField lostItemNameTextField;
	private ButtonGroup radioButtonGroup;
	public LostItemWindow() {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(0,0,293,210);
		
		JButton lostItemAddButton = new JButton("Add");
		lostItemAddButton.setBounds(188, 147, 89, 23);
		getContentPane().add(lostItemAddButton);
		
		lostItemIDTextField = new JTextField();
		lostItemIDTextField.setBounds(98, 28, 136, 23);
		getContentPane().add(lostItemIDTextField);
		lostItemIDTextField.setColumns(10);
		
		lostItemNameTextField = new JTextField();
		lostItemNameTextField.setBounds(98, 66, 136, 23);
		getContentPane().add(lostItemNameTextField);
		lostItemNameTextField.setColumns(10);
		
		JLabel lostItemNameLabel = new JLabel("Lost Item:");
		lostItemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lostItemNameLabel.setBounds(10, 31, 80, 14);
		getContentPane().add(lostItemNameLabel);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 69, 66, 14);
		getContentPane().add(lblDate);
		
		JRadioButton inProgressButton = new JRadioButton("In progress");
		inProgressButton.setBounds(94, 110, 89, 23);
		getContentPane().add(inProgressButton);
		
		JRadioButton closeButton = new JRadioButton("Close");
		closeButton.setBounds(188, 110, 80, 23);
		getContentPane().add(closeButton);
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(inProgressButton);
		radioButtonGroup.add(closeButton);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(10, 113, 46, 14);
		getContentPane().add(lblStatus);
		
		
	}
}
