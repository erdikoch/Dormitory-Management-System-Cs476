/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;

import background.Dorm;
import database.DBConnection;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

public class DormWindow extends javax.swing.JFrame {

	/**
	 * Creates new form DormWindow
	 */
	public DormWindow() {
		setTitle("Add Dorm");
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		dormWindowPanel = new javax.swing.JPanel();
		dormNumberLabel = new javax.swing.JLabel();
		dormAddressLabel = new javax.swing.JLabel();
		dormNumberText = new javax.swing.JTextField();
		dormAddressScrollPane = new javax.swing.JScrollPane();
		dormAdressTextArea = new javax.swing.JTextArea();
		dormAddButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		dormNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		dormNumberLabel.setText("Dormitory Number: ");

		dormAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		dormAddressLabel.setText("Dormitory Address:");

		dormAdressTextArea.setColumns(20);
		dormAdressTextArea.setRows(5);
		dormAddressScrollPane.setViewportView(dormAdressTextArea);

		dormAddButton.setBackground(new java.awt.Color(204, 255, 204));
		dormAddButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		dormAddButton.setText("ADD");
		dormAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					addDormButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout gl_dormWindowPanel = new javax.swing.GroupLayout(
				dormWindowPanel);
		dormWindowPanel.setLayout(gl_dormWindowPanel);
		gl_dormWindowPanel
				.setHorizontalGroup(gl_dormWindowPanel
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_dormWindowPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_dormWindowPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																gl_dormWindowPanel
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				gl_dormWindowPanel
																						.createSequentialGroup()
																						.addComponent(
																								dormNumberLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								119,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								dormNumberText,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								190,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				gl_dormWindowPanel
																						.createSequentialGroup()
																						.addComponent(
																								dormAddressLabel)
																						.addGap(18,
																								18,
																								18)
																						.addComponent(
																								dormAddressScrollPane,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								191,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																dormAddButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																75,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(20, Short.MAX_VALUE)));
		gl_dormWindowPanel
				.setVerticalGroup(gl_dormWindowPanel
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_dormWindowPanel
										.createSequentialGroup()
										.addGap(20, 20, 20)
										.addGroup(
												gl_dormWindowPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																dormNumberLabel)
														.addComponent(
																dormNumberText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(24, 24, 24)
										.addGroup(
												gl_dormWindowPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																dormAddressLabel)
														.addComponent(
																dormAddressScrollPane,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																105,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addComponent(
												dormAddButton,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												32, Short.MAX_VALUE)
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				dormWindowPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				dormWindowPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void addDormButtonActionPerformed(java.awt.event.ActionEvent evt)
			throws SQLException {
		Dorm dorm = new Dorm();
		String dormName = dormNumberText.getText();
		dorm.setDormName(dormName);
		String location = dormAdressTextArea.getText();
		dorm.setLocation(location);
		System.out.println(dormName);
		DBConnection connection = new DBConnection();
		if (connection.insertDorm(dorm)) {
			JOptionPane.showMessageDialog(getContentPane(), "Registration completed");
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "Registration not completed, please try again");
		}
		
		
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton dormAddButton;
	private javax.swing.JLabel dormAddressLabel;
	private javax.swing.JLabel dormNumberLabel;
	private javax.swing.JPanel dormWindowPanel;
	private javax.swing.JScrollPane dormAddressScrollPane;
	private javax.swing.JTextArea dormAdressTextArea;
	private javax.swing.JTextField dormNumberText;
	// End of variables declaration//GEN-END:variables
}
