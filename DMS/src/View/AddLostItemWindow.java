package view;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AddLostItemWindow extends javax.swing.JFrame {
	private JTextField lostItemIDTextField;
	private JTextField lostItemNameTextField;
	public AddLostItemWindow() {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(0,0,278,176);
		JLabel lostItemIDLabel = new JLabel("Item ID:");
		lostItemIDLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lostItemIDLabel.setBounds(10, 31, 66, 14);
		getContentPane().add(lostItemIDLabel);
		
		JButton lostItemAddButton = new JButton("Add");
		lostItemAddButton.setBounds(157, 100, 89, 23);
		getContentPane().add(lostItemAddButton);
		
		lostItemIDTextField = new JTextField();
		lostItemIDTextField.setBounds(86, 27, 89, 23);
		getContentPane().add(lostItemIDTextField);
		lostItemIDTextField.setColumns(10);
		
		lostItemNameTextField = new JTextField();
		lostItemNameTextField.setBounds(86, 66, 89, 23);
		getContentPane().add(lostItemNameTextField);
		lostItemNameTextField.setColumns(10);
		
		JLabel lostItemNameLabel = new JLabel("Item Name:");
		lostItemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lostItemNameLabel.setBounds(10, 70, 66, 14);
		getContentPane().add(lostItemNameLabel);
		
		
	}
}
