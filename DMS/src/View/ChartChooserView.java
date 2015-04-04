package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.jfree.ui.RefineryUtilities;

import background.Dorm;
import database.DBConnection;
import javax.swing.JRadioButton;

public class ChartChooserView extends javax.swing.JFrame {
	public ChartChooserView() {
		setTitle("Choose Chart Data Type");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JLabel lblDorm = new JLabel("Dorm");
		GridBagConstraints gbc_lblDorm = new GridBagConstraints();
		gbc_lblDorm.insets = new Insets(0, 0, 5, 5);
		gbc_lblDorm.gridx = 1;
		gbc_lblDorm.gridy = 4;
		getContentPane().add(lblDorm, gbc_lblDorm);

		final JComboBox<String> comboBox = new JComboBox<String>();
		DBConnection connection = new DBConnection();
		ArrayList<String> list;
		try {
			comboBox.removeAllItems();
			list = connection.displayDorm();
			for (int i = 0; i < list.size(); i++)
				comboBox.addItem(list.get(i));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		getContentPane().add(comboBox, gbc_comboBox);



		JLabel lblChartType = new JLabel("Chart Type");
		GridBagConstraints gbc_lblChartType = new GridBagConstraints();
		gbc_lblChartType.insets = new Insets(0, 0, 5, 5);
		gbc_lblChartType.gridx = 1;
		gbc_lblChartType.gridy = 6;
		getContentPane().add(lblChartType, gbc_lblChartType);

		ButtonGroup group = new ButtonGroup();
		
		final JRadioButton dormCapacityRadioButton = new JRadioButton("Dorm Capacity");
		GridBagConstraints gbc_dormCapacityRadioButton = new GridBagConstraints();
		gbc_dormCapacityRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_dormCapacityRadioButton.gridx = 2;
		gbc_dormCapacityRadioButton.gridy = 6;
		getContentPane().add(dormCapacityRadioButton, gbc_dormCapacityRadioButton);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 8;
		JButton btnNewButton = new JButton("Get Chart");
		
		final JRadioButton genderRadioButton = new JRadioButton("Gender Rate");
		GridBagConstraints gbc_genderRadioButton = new GridBagConstraints();
		gbc_genderRadioButton.anchor = GridBagConstraints.WEST;
		gbc_genderRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_genderRadioButton.gridx = 2;
		gbc_genderRadioButton.gridy = 7;
		getContentPane().add(genderRadioButton, gbc_genderRadioButton);
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		group.add(dormCapacityRadioButton);
		group.add(genderRadioButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dormCapacityRadioButton.isSelected())
					try {
						
							Dorm dorm = new Dorm();
							dorm.setDormName(comboBox.getSelectedItem().toString());
							CapacityWindow dormCapacity = new CapacityWindow(dorm);

						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else if(genderRadioButton.isSelected()){
					final MaleFemaleCapacityWindow capacity = new MaleFemaleCapacityWindow("Dorm Male/Female Capacity");
					capacity.pack();
					RefineryUtilities.centerFrameOnScreen(capacity);
					capacity.setVisible(true);
				}
			}
		});
		
		
	}

}
