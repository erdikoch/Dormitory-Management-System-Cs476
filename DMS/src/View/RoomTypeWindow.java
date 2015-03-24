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
	private JTextField txtTypeName;
	private JTextField txtPrice;



	/**
	 * Create the frame.
	 */
	public RoomTypeWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u0130smetcan Herg\u00FCn\u015Fen\\Desktop\\dorm.png"));
		setTitle("Add Room Type");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 262, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTypeName = new JLabel("Type Name :");
		
		JLabel lblPrice = new JLabel("Price :");
		
		txtTypeName = new JTextField();
		txtTypeName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAddRoomTypeActionPerformed(evt);
			}

			private void btnAddRoomTypeActionPerformed(ActionEvent evt) {
				Room room = new Room();
				room.setTypeName(Integer.parseInt(txtTypeName.getText()));
				Double roomPrice=Double.parseDouble(txtPrice.getText());
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
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblTypeName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTypeName, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPrice, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
					.addGap(52))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTypeName)
						.addComponent(txtTypeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice)
						.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAdd)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
