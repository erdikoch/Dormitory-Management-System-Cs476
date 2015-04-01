package view;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
// import org.jdatepicker.impl.UtilDateModel;

public class SearchAllWindow extends javax.swing.JFrame {
	private JTable searchTable;
	private JTextField endDateTextField;
	private Button enterButton;
	private JTextField startDateLabel;

	/**
	 * Creates new form DormWindow
	 */
	public SearchAllWindow() {
		setTitle("Search");
		getContentPane().setLayout(null);
		setBounds(0,0,525,368);
		
		Button endDateButton = new Button("End Date");
		endDateButton.setBounds(202, 10, 70, 22);
		getContentPane().add(endDateButton);
		
		Button startDateButton = new Button("Start Date");
		startDateButton.setBounds(10, 10, 70, 22);
		getContentPane().add(startDateButton);
		
		searchTable = new JTable();
		searchTable.setCellSelectionEnabled(true);
		searchTable.setBounds(10, 52, 462, 237);
		getContentPane().add(searchTable);
		
		endDateTextField = new JTextField();
		endDateTextField.setBounds(278, 10, 108, 22);
		getContentPane().add(endDateTextField);
		endDateTextField.setColumns(10);
		
		enterButton = new Button("ENTER");
		enterButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		enterButton.setBounds(392, 10, 80, 22);
		getContentPane().add(enterButton);
		
		startDateLabel = new JTextField();
		startDateLabel.setColumns(10);
		startDateLabel.setBounds(86, 10, 110, 22);
		getContentPane().add(startDateLabel);
		
		startDateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				StartDatePopUpView startdate = new StartDatePopUpView();
				startdate.setVisible(true);
				startDateLabel.setText(startdate.getCalendar());
				
				
				
			}
		});
		
		endDateButton.addActionListener(new ActionListener() {
			EndDatePopUpView endDatePopup = new EndDatePopUpView();
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EndDatePopUpView endDate = new EndDatePopUpView();
				endDate.setVisible(true);
				endDateTextField.setText(endDate.getCalendar());
				
				
			}
		});
		
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

	}
}
