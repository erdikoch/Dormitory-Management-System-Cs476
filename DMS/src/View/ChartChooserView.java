package view;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.jfree.ui.RefineryUtilities;

import background.Dorm;
import database.DBConnection;

public class ChartChooserView extends javax.swing.JFrame {
	private JCheckBox maleFemaleCapacity;
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
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clickDormAction(evt);
			}

			private void clickDormAction(ActionEvent evt) {
				DBConnection connection = new DBConnection();
				ArrayList<Dorm> dorms = connection.getDorms();
				
				
				for (int i = 0; i < dorms.size(); i++) {
					comboBox.addItem(dorms.get(i));
				}
			}
		});
		
		
		
		
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
		
		final JCheckBox dormCapacityCheckBox = new JCheckBox("Dorm Capacity");
		GridBagConstraints gbc_dormCapacityCheckBox = new GridBagConstraints();
		gbc_dormCapacityCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_dormCapacityCheckBox.gridx = 2;
		gbc_dormCapacityCheckBox.gridy = 6;
		group.add(dormCapacityCheckBox);
		getContentPane().add(dormCapacityCheckBox, gbc_dormCapacityCheckBox);
		
		maleFemaleCapacity = new JCheckBox("Male/Female Capacity");
		GridBagConstraints gbc_maleFemaleCapacity = new GridBagConstraints();
		gbc_maleFemaleCapacity.gridwidth = 2;
		gbc_maleFemaleCapacity.insets = new Insets(0, 0, 5, 5);
		gbc_maleFemaleCapacity.gridx = 2;
		gbc_maleFemaleCapacity.gridy = 7;
		group.add(maleFemaleCapacity);
		getContentPane().add(maleFemaleCapacity, gbc_maleFemaleCapacity);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 8;
		JButton btnNewButton = new JButton("Get Chart");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dormCapacityCheckBox.isSelected()){
					final CapacityWindow dormCapacity = new CapacityWindow("Dorm Capacity",(Dorm) comboBox.getSelectedItem());
					dormCapacity.pack();
			        RefineryUtilities.centerFrameOnScreen(dormCapacity);
			        dormCapacity.setVisible(true);
				}else if(maleFemaleCapacity.isSelected()){
					final MaleFemaleCapacityWindow capacity = new MaleFemaleCapacityWindow("Dorm Male/Female Capacity");
					capacity.pack();
			        RefineryUtilities.centerFrameOnScreen(capacity);
			        capacity.setVisible(true);
				}
			}
		});
		getContentPane().add(btnNewButton, gbc_btnNewButton);
	}

}
