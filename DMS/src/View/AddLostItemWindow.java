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
		setBounds(0,0,248,159);
		JLabel lostItemIDLabel = new JLabel("Item ID:");
		lostItemIDLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lostItemIDLabel.setBounds(10, 31, 66, 14);
		getContentPane().add(lostItemIDLabel);
		
		JButton lostItemAddButton = new JButton("Add");
		lostItemAddButton.setBounds(136, 92, 89, 23);
		getContentPane().add(lostItemAddButton);
		
		lostItemIDTextField = new JTextField();
		lostItemIDTextField.setBounds(96, 28, 86, 20);
		getContentPane().add(lostItemIDTextField);
		lostItemIDTextField.setColumns(10);
		
		lostItemNameTextField = new JTextField();
		lostItemNameTextField.setBounds(96, 61, 86, 20);
		getContentPane().add(lostItemNameTextField);
		lostItemNameTextField.setColumns(10);
		
		JLabel lostItemNameLabel = new JLabel("Item Name:");
		lostItemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lostItemNameLabel.setBounds(10, 64, 66, 14);
		getContentPane().add(lostItemNameLabel);
		
		
	}
}
