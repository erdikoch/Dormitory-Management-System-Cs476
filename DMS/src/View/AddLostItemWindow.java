package view;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AddLostItemWindow extends javax.swing.JFrame {
	public AddLostItemWindow() {
		setTitle("Add Lost Item");
		
		JLabel lostItemLabel = new JLabel("Lost Item ID:");
		lostItemLabel.setBounds(10, 43, 104, 22);
		lostItemLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lostItemNameLabel = new JLabel("Lost Item Name:");
		lostItemNameLabel.setBounds(10, 91, 104, 22);
		lostItemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		TextField lostItemIDTextField = new TextField();
		lostItemIDTextField.setBounds(120, 43, 83, 22);
		
		TextField lostItemNameTextField = new TextField();
		lostItemNameTextField.setBounds(120, 91, 83, 22);
		
		Button lostItemAddButton = new Button("Add");
		lostItemAddButton.setBounds(155, 133, 70, 22);
		getContentPane().setLayout(null);
		getContentPane().add(lostItemLabel);
		getContentPane().add(lostItemNameLabel);
		getContentPane().add(lostItemIDTextField);
		getContentPane().add(lostItemNameTextField);
		getContentPane().add(lostItemAddButton);
		getContentPane().setBounds(0, 0, 100, 100);
		
		
	}

}
