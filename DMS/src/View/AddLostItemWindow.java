package view;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Font;

public class AddLostItemWindow extends javax.swing.JFrame {
	public AddLostItemWindow() {
		setTitle("Add Lost Item");
		getContentPane().setLayout(null);
		
		JLabel lostItemLabel = new JLabel("Lost Item ID:");
		lostItemLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lostItemLabel.setBounds(10, 43, 104, 22);
		getContentPane().add(lostItemLabel);
		
		JLabel lostItemNameLabel = new JLabel("Lost Item Name:");
		lostItemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lostItemNameLabel.setBounds(10, 91, 104, 22);
		getContentPane().add(lostItemNameLabel);
		
		TextField lostItemIDTextField = new TextField();
		lostItemIDTextField.setBounds(120, 43, 83, 22);
		getContentPane().add(lostItemIDTextField);
		
		TextField lostItemNameTextField = new TextField();
		lostItemNameTextField.setBounds(120, 91, 83, 22);
		getContentPane().add(lostItemNameTextField);
		
		Button lostItemAddButton = new Button("Add");
		lostItemAddButton.setBounds(155, 133, 70, 22);
		getContentPane().add(lostItemAddButton);
	}

}
