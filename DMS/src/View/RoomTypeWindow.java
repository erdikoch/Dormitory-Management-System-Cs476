package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import database.DBConnection;
import background.Room;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoomTypeWindow extends JFrame {

	private JPanel contentPane;
	private JTextField typeNameTextField;
	private JTextField priceTextField;



	/**
	 * Create the frame.
	 */
	public RoomTypeWindow() {
		setTitle("Add Room Type");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 262, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel typeNameLabel = new JLabel("Type Name :");
		
		JLabel priceLabel = new JLabel("Price :");
		
		typeNameTextField = new JTextField();
		typeNameTextField.setColumns(10);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAddRoomTypeActionPerformed(evt);
			}

			private void btnAddRoomTypeActionPerformed(ActionEvent evt) {
				Room room = new Room();
				room.setTypeName(typeNameTextField.getText());
				Double roomPrice=Double.parseDouble(priceTextField.getText());
				room.setRoomPrice(roomPrice);
				DBConnection conn=new DBConnection();
				if(conn.insertRoomType(room)){
					System.out.println("Kayit Basarili");
				}else{
					System.out.println("Kayit Basarili Degil");
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(typeNameLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(typeNameTextField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(priceLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(priceTextField, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
					.addGap(52))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(typeNameLabel)
						.addComponent(typeNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(priceLabel)
						.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(addButton)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
