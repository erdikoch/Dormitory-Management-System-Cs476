/* WS
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.sql.ConnectionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.jfree.ui.RefineryUtilities;

import background.Dorm;
import background.EmergencyContact;
import background.Hostel;
import background.Payment;
import background.Room;
import background.School;
import background.Student;
import database.DBConnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import com.toedter.calendar.JDateChooser;

public class MainWindow extends javax.swing.JFrame {

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainWindow().setVisible(true);
			}
		});
	}

	public MainWindow() {
		setTitle("Dormitory Management System");
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jMenuBar2 = new javax.swing.JMenuBar();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jMenuBar3 = new javax.swing.JMenuBar();
		jMenu6 = new javax.swing.JMenu();
		jMenu7 = new javax.swing.JMenu();
		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup2 = new javax.swing.ButtonGroup();
		jSeparator1 = new javax.swing.JSeparator();
		mainSearchPanel = new javax.swing.JPanel();
		searchStudentLabel = new javax.swing.JLabel();
		searchScrollPane = new javax.swing.JScrollPane();
		studentSearchList = new javax.swing.JList();
		searchModel = new DefaultListModel();
		fillStudentList();
		studentSearchList = new JList(searchModel);
		studentSearchList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				clickStudentSearchList(evt);
			}
		});
		searchStudentText = new javax.swing.JTextField();
		searchStudentText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if (fieldLength > searchStudentText.getText().length()) {
					studentSearchList.setModel(searchModel);
					filterList();
				} else {
					filterList();
				}
			}

			public void keyPressed(KeyEvent evt) {
				fieldLength = searchStudentText.getText().length();
			}
		});
		searchButton = new javax.swing.JButton();
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				clickSearchButton(evt);
			}
		});

		mainPanePanel = new javax.swing.JPanel();
		tabbedPane = new javax.swing.JTabbedPane();
		mainPaneSubPanel = new javax.swing.JPanel();
		personalInfoPanel = new javax.swing.JPanel();
		personalInfoLabel = new javax.swing.JLabel();
		personalInfoNameLabel = new javax.swing.JLabel();
		personalInfoSurnameLabel = new javax.swing.JLabel();
		personalInfoNationalIDLabel = new javax.swing.JLabel();
		personalInfoGenderLabel = new javax.swing.JLabel();
		personalInfoPhoneLabel = new javax.swing.JLabel();
		personalInfoMailLabel = new javax.swing.JLabel();
		personalInfoBirthdayLabel = new javax.swing.JLabel();
		stdNameText = new javax.swing.JTextField();
		stdSurnameText = new javax.swing.JTextField();
		stdTCText = new javax.swing.JTextField();
		stdPhoneText = new javax.swing.JTextField();
		stdMailText = new javax.swing.JTextField();
		stdGenderCBox = new javax.swing.JComboBox();
		emergencyContactPanel = new javax.swing.JPanel();
		emergencyContactLabel = new javax.swing.JLabel();
		emergencyContactNameLabel = new javax.swing.JLabel();
		emergencyContactSurnameLabel = new javax.swing.JLabel();
		emergencyContactPhoneLabel = new javax.swing.JLabel();
		emgNameText = new javax.swing.JTextField();
		emgSurnameText = new javax.swing.JTextField();
		emgPhoneText = new javax.swing.JTextField();
		schoolInfoPanel = new javax.swing.JPanel();
		schoolInfoLabel = new javax.swing.JLabel();
		schoolInfoUniversityLabel = new javax.swing.JLabel();
		schoolInfoDepartmentLabel = new javax.swing.JLabel();
		schoolInfoGradeLabel = new javax.swing.JLabel();
		schUniNameText = new javax.swing.JTextField();
		schDeptNameText = new javax.swing.JTextField();
		schGradeText = new javax.swing.JTextField();
		accoInfoPanel = new javax.swing.JPanel();
		accoInfoLabel = new javax.swing.JLabel();
		accoInfoDormLabel = new javax.swing.JLabel();
		accoInfoRoomLabel = new javax.swing.JLabel();
		accDormCBox = new javax.swing.JComboBox();
		accRoomCBox = new javax.swing.JComboBox();
		accRoomCBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				getRoomMoClicked(me);
			}

		});
		accoInfoStartDateLabel = new javax.swing.JLabel();
		accoInfoEndDateLabel = new javax.swing.JLabel();
		saveButton = new javax.swing.JButton();
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					clickSaveButton(evt);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		paymentPanel = new javax.swing.JPanel();
		menuBar = new javax.swing.JMenuBar();
		homeMenu = new javax.swing.JMenu();
		addStudentMenuItem = new javax.swing.JMenuItem();
		dormMenu = new javax.swing.JMenu();
		addDormMenuItem = new javax.swing.JMenuItem();
		roomMenu = new javax.swing.JMenu();
		addRoomMenuItem = new javax.swing.JMenuItem();
		otherMenu = new javax.swing.JMenu();
		addOtherChartMenuItem = new javax.swing.JMenuItem();

		setEditableFalse();

		jMenu3.setText("File");
		jMenuBar2.add(jMenu3);

		jMenu4.setText("Edit");
		jMenuBar2.add(jMenu4);

		jMenu6.setText("File");
		jMenuBar3.add(jMenu6);

		jMenu7.setText("Edit");
		jMenuBar3.add(jMenu7);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jSeparator1.setBackground(new java.awt.Color(255, 51, 0));
		jSeparator1.setForeground(new java.awt.Color(255, 51, 0));
		jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

		searchStudentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		searchStudentLabel.setText("             Search Student");
		studentSearchList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		searchScrollPane.setViewportView(studentSearchList);
		searchStudentText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		searchButton.setBackground(new java.awt.Color(204, 255, 204));
		searchButton.setText("Q");

		javax.swing.GroupLayout gl_mainSearchPanel = new javax.swing.GroupLayout(
				mainSearchPanel);
		mainSearchPanel.setLayout(gl_mainSearchPanel);
		gl_mainSearchPanel
				.setHorizontalGroup(gl_mainSearchPanel
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_mainSearchPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_mainSearchPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																searchScrollPane)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																gl_mainSearchPanel
																		.createSequentialGroup()
																		.addComponent(
																				searchStudentText)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				searchButton))
														.addComponent(
																searchStudentLabel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																212,
																Short.MAX_VALUE))
										.addContainerGap(22, Short.MAX_VALUE)));
		gl_mainSearchPanel
				.setVerticalGroup(gl_mainSearchPanel
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_mainSearchPanel
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												searchStudentLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												27,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												gl_mainSearchPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																searchStudentText)
														.addComponent(
																searchButton,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																34,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(searchScrollPane)
										.addContainerGap()));

		tabbedPane.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		mainPaneSubPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51,
						204, 0), new java.awt.Color(51, 153, 0),
				new java.awt.Color(0, 153, 0), new java.awt.Color(51, 153, 0)));

		personalInfoPanel.setBorder(javax.swing.BorderFactory
				.createEtchedBorder());

		personalInfoLabel.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
		personalInfoLabel.setText("Personal Information");

		personalInfoNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		personalInfoNameLabel.setText("Name:");

		personalInfoSurnameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		personalInfoSurnameLabel.setText("Surname:");

		personalInfoNationalIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		personalInfoNationalIDLabel.setText("TC ID No:");

		personalInfoGenderLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		personalInfoGenderLabel.setText("Gender:");

		personalInfoPhoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		personalInfoPhoneLabel.setText("Phone:");

		personalInfoMailLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		personalInfoMailLabel.setText("E-mail:");

		personalInfoBirthdayLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		personalInfoBirthdayLabel.setText("Birthday:");

		birthDateChooser = new JDateChooser();
		birthDateChooser.setDateFormatString("dd/MM/yyyy");
		javax.swing.GroupLayout gl_personalInfoPanel = new javax.swing.GroupLayout(
				personalInfoPanel);
		gl_personalInfoPanel
				.setHorizontalGroup(gl_personalInfoPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_personalInfoPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_personalInfoPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																personalInfoLabel,
																GroupLayout.PREFERRED_SIZE,
																123,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_personalInfoPanel
																		.createSequentialGroup()
																		.addGroup(
																				gl_personalInfoPanel
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addGroup(
																								gl_personalInfoPanel
																										.createSequentialGroup()
																										.addGroup(
																												gl_personalInfoPanel
																														.createParallelGroup(
																																Alignment.TRAILING,
																																false)
																														.addComponent(
																																personalInfoGenderLabel,
																																Alignment.LEADING,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																personalInfoNationalIDLabel,
																																Alignment.LEADING,
																																GroupLayout.DEFAULT_SIZE,
																																63,
																																Short.MAX_VALUE)
																														.addComponent(
																																personalInfoSurnameLabel,
																																Alignment.LEADING,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE))
																										.addGap(18)
																										.addGroup(
																												gl_personalInfoPanel
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																stdSurnameText)
																														.addComponent(
																																stdTCText)
																														.addGroup(
																																gl_personalInfoPanel
																																		.createSequentialGroup()
																																		.addComponent(
																																				stdGenderCBox,
																																				GroupLayout.PREFERRED_SIZE,
																																				97,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(0,
																																				115,
																																				Short.MAX_VALUE))))
																						.addGroup(
																								gl_personalInfoPanel
																										.createSequentialGroup()
																										.addComponent(
																												personalInfoNameLabel,
																												GroupLayout.PREFERRED_SIZE,
																												63,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(18)
																										.addComponent(
																												stdNameText)))
																		.addGap(61)
																		.addGroup(
																				gl_personalInfoPanel
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								personalInfoPhoneLabel,
																								GroupLayout.DEFAULT_SIZE,
																								50,
																								Short.MAX_VALUE)
																						.addComponent(
																								personalInfoMailLabel,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								personalInfoBirthdayLabel))
																		.addGap(37)
																		.addGroup(
																				gl_personalInfoPanel
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								birthDateChooser,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								stdPhoneText,
																								GroupLayout.DEFAULT_SIZE,
																								223,
																								Short.MAX_VALUE)
																						.addComponent(
																								stdMailText))))
										.addContainerGap(88, Short.MAX_VALUE)));
		gl_personalInfoPanel
				.setVerticalGroup(gl_personalInfoPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_personalInfoPanel
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(personalInfoLabel)
										.addGap(11)
										.addGroup(
												gl_personalInfoPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																personalInfoNameLabel,
																GroupLayout.PREFERRED_SIZE,
																15,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																personalInfoPhoneLabel)
														.addComponent(
																stdNameText,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																stdPhoneText,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_personalInfoPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																personalInfoSurnameLabel)
														.addComponent(
																personalInfoMailLabel)
														.addComponent(
																stdSurnameText,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																stdMailText,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_personalInfoPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_personalInfoPanel
																		.createSequentialGroup()
																		.addGroup(
																				gl_personalInfoPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								personalInfoNationalIDLabel)
																						.addComponent(
																								personalInfoBirthdayLabel)
																						.addComponent(
																								stdTCText,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				18,
																				Short.MAX_VALUE)
																		.addGroup(
																				gl_personalInfoPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								personalInfoGenderLabel)
																						.addComponent(
																								stdGenderCBox,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																birthDateChooser,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		personalInfoPanel.setLayout(gl_personalInfoPanel);

		emergencyContactPanel.setBorder(javax.swing.BorderFactory
				.createEtchedBorder());

		emergencyContactLabel.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
		emergencyContactLabel.setText("Emergency Contact");

		emergencyContactNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		emergencyContactNameLabel.setText("Name(*):");

		emergencyContactSurnameLabel
				.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		emergencyContactSurnameLabel.setText("Surname(*):");

		emergencyContactPhoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		emergencyContactPhoneLabel.setText("Phone(*):");

		javax.swing.GroupLayout gl_emergencyContactPanel = new javax.swing.GroupLayout(
				emergencyContactPanel);
		emergencyContactPanel.setLayout(gl_emergencyContactPanel);
		gl_emergencyContactPanel
				.setHorizontalGroup(gl_emergencyContactPanel
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_emergencyContactPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_emergencyContactPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																emergencyContactLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																125,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_emergencyContactPanel
																		.createSequentialGroup()
																		.addGroup(
																				gl_emergencyContactPanel
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								emergencyContactPhoneLabel,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								emergencyContactSurnameLabel,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								62,
																								Short.MAX_VALUE)
																						.addComponent(
																								emergencyContactNameLabel,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				gl_emergencyContactPanel
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								emgSurnameText)
																						.addComponent(
																								emgNameText)
																						.addComponent(
																								emgPhoneText,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								214,
																								Short.MAX_VALUE))))
										.addContainerGap(47, Short.MAX_VALUE)));
		gl_emergencyContactPanel
				.setVerticalGroup(gl_emergencyContactPanel
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_emergencyContactPanel
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(emergencyContactLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												gl_emergencyContactPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																emergencyContactNameLabel)
														.addComponent(
																emgNameText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												gl_emergencyContactPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																emergencyContactSurnameLabel)
														.addComponent(
																emgSurnameText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												gl_emergencyContactPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																emergencyContactPhoneLabel)
														.addComponent(
																emgPhoneText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		schoolInfoPanel.setBorder(javax.swing.BorderFactory
				.createEtchedBorder());

		schoolInfoLabel.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
		schoolInfoLabel.setText("School Information");

		schoolInfoUniversityLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		schoolInfoUniversityLabel.setText("University:");

		schoolInfoDepartmentLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		schoolInfoDepartmentLabel.setText("Department:");

		schoolInfoGradeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		schoolInfoGradeLabel.setText("Grade:");

		javax.swing.GroupLayout gl_schoolInfoPanel = new javax.swing.GroupLayout(
				schoolInfoPanel);
		schoolInfoPanel.setLayout(gl_schoolInfoPanel);
		gl_schoolInfoPanel
				.setHorizontalGroup(gl_schoolInfoPanel
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_schoolInfoPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_schoolInfoPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																schoolInfoLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																114,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_schoolInfoPanel
																		.createSequentialGroup()
																		.addGroup(
																				gl_schoolInfoPanel
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								schoolInfoGradeLabel,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								schoolInfoDepartmentLabel,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								79,
																								Short.MAX_VALUE)
																						.addComponent(
																								schoolInfoUniversityLabel,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				gl_schoolInfoPanel
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								schUniNameText)
																						.addComponent(
																								schDeptNameText)
																						.addComponent(
																								schGradeText,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								220,
																								Short.MAX_VALUE))))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		gl_schoolInfoPanel
				.setVerticalGroup(gl_schoolInfoPanel
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_schoolInfoPanel
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(schoolInfoLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												gl_schoolInfoPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																schoolInfoUniversityLabel)
														.addComponent(
																schUniNameText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												gl_schoolInfoPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																schDeptNameText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																schoolInfoDepartmentLabel))
										.addGap(18, 18, 18)
										.addGroup(
												gl_schoolInfoPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																schGradeText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																schoolInfoGradeLabel))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		accoInfoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		accoInfoLabel.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
		accoInfoLabel.setText("Accomadation Information");

		accoInfoDormLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		accoInfoDormLabel.setText("Dorm(*):");

		accoInfoRoomLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		accoInfoRoomLabel.setText("Room(*):");

		accoInfoStartDateLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		accoInfoStartDateLabel.setText("Start Date(*):");

		accoInfoEndDateLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		accoInfoEndDateLabel.setText("End Date(*):");

		saveButton.setBackground(new Color(204, 255, 204));
		saveButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		saveButton.setText("SAVE");

		JButton editButton = new JButton("EDIT");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clickEditButton(evt);
			}
		});
		editButton.setBackground(new Color(204, 255, 204));
		editButton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblType = new JLabel();
		lblType.setText("Type(*):");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));

		accRoomTypeCBox = new JComboBox();
		accRoomTypeCBox.setEnabled(false);

		startDateChooser = new JDateChooser();
		startDateChooser.setDateFormatString("dd/MM/yyyy");
		endDateChooser = new JDateChooser();
		endDateChooser.setDateFormatString("dd/MM/yyyy");

		JButton btnUndo = new JButton();
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clickUndoButton(evt);
			}

		});
		btnUndo.setText("UNDO");
		btnUndo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUndo.setBackground(new Color(204, 255, 204));

		javax.swing.GroupLayout gl_accoInfoPanel = new javax.swing.GroupLayout(
				accoInfoPanel);
		gl_accoInfoPanel
				.setHorizontalGroup(gl_accoInfoPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_accoInfoPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_accoInfoPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_accoInfoPanel
																		.createSequentialGroup()
																		.addGroup(
																				gl_accoInfoPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								accoInfoLabel,
																								GroupLayout.PREFERRED_SIZE,
																								165,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_accoInfoPanel
																										.createSequentialGroup()
																										.addGroup(
																												gl_accoInfoPanel
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																accoInfoDormLabel)
																														.addComponent(
																																lblType,
																																GroupLayout.PREFERRED_SIZE,
																																82,
																																GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_accoInfoPanel
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_accoInfoPanel
																																		.createParallelGroup(
																																				Alignment.TRAILING,
																																				false)
																																		.addComponent(
																																				accRoomCBox,
																																				Alignment.LEADING,
																																				0,
																																				GroupLayout.DEFAULT_SIZE,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				accDormCBox,
																																				Alignment.LEADING,
																																				0,
																																				92,
																																				Short.MAX_VALUE))
																														.addComponent(
																																accRoomTypeCBox,
																																GroupLayout.PREFERRED_SIZE,
																																92,
																																GroupLayout.PREFERRED_SIZE))
																										.addGap(70)
																										.addGroup(
																												gl_accoInfoPanel
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																accoInfoStartDateLabel,
																																GroupLayout.PREFERRED_SIZE,
																																83,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																accoInfoEndDateLabel,
																																GroupLayout.PREFERRED_SIZE,
																																83,
																																GroupLayout.PREFERRED_SIZE))
																										.addGap(18)
																										.addGroup(
																												gl_accoInfoPanel
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addComponent(
																																endDateChooser,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																startDateChooser,
																																GroupLayout.DEFAULT_SIZE,
																																212,
																																Short.MAX_VALUE))
																										.addGap(66)
																										.addGroup(
																												gl_accoInfoPanel
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																btnUndo,
																																GroupLayout.PREFERRED_SIZE,
																																105,
																																GroupLayout.PREFERRED_SIZE)
																														.addGroup(
																																gl_accoInfoPanel
																																		.createParallelGroup(
																																				Alignment.TRAILING,
																																				false)
																																		.addComponent(
																																				editButton,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				saveButton,
																																				GroupLayout.DEFAULT_SIZE,
																																				105,
																																				Short.MAX_VALUE)))))
																		.addGap(20))
														.addGroup(
																gl_accoInfoPanel
																		.createSequentialGroup()
																		.addComponent(
																				accoInfoRoomLabel,
																				GroupLayout.DEFAULT_SIZE,
																				113,
																				Short.MAX_VALUE)
																		.addGap(639)))));
		gl_accoInfoPanel
				.setVerticalGroup(gl_accoInfoPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_accoInfoPanel
										.createSequentialGroup()
										.addGroup(
												gl_accoInfoPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_accoInfoPanel
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				accoInfoLabel)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_accoInfoPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								accoInfoDormLabel)
																						.addComponent(
																								accDormCBox,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								accoInfoStartDateLabel)
																						.addComponent(
																								startDateChooser,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_accoInfoPanel
																		.createSequentialGroup()
																		.addGap(41)
																		.addComponent(
																				editButton)))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_accoInfoPanel
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_accoInfoPanel
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				accoInfoEndDateLabel)
																		.addComponent(
																				saveButton,
																				GroupLayout.PREFERRED_SIZE,
																				23,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_accoInfoPanel
																		.createSequentialGroup()
																		.addGroup(
																				gl_accoInfoPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblType,
																								GroupLayout.PREFERRED_SIZE,
																								15,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								accRoomTypeCBox,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(6))
														.addComponent(
																endDateChooser,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(5)
										.addGroup(
												gl_accoInfoPanel
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_accoInfoPanel
																		.createSequentialGroup()
																		.addGroup(
																				gl_accoInfoPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								accoInfoRoomLabel)
																						.addComponent(
																								accRoomCBox,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(22))
														.addGroup(
																gl_accoInfoPanel
																		.createSequentialGroup()
																		.addComponent(
																				btnUndo)
																		.addContainerGap()))));
		accoInfoPanel.setLayout(gl_accoInfoPanel);

		javax.swing.GroupLayout gl_mainPaneSubPanel = new javax.swing.GroupLayout(
				mainPaneSubPanel);
		gl_mainPaneSubPanel
				.setHorizontalGroup(gl_mainPaneSubPanel
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_mainPaneSubPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_mainPaneSubPanel
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																accoInfoPanel,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																personalInfoPanel,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																759,
																Short.MAX_VALUE)
														.addGroup(
																Alignment.LEADING,
																gl_mainPaneSubPanel
																		.createSequentialGroup()
																		.addComponent(
																				emergencyContactPanel,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				schoolInfoPanel,
																				GroupLayout.DEFAULT_SIZE,
																				398,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		gl_mainPaneSubPanel
				.setVerticalGroup(gl_mainPaneSubPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_mainPaneSubPanel
										.createSequentialGroup()
										.addComponent(personalInfoPanel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_mainPaneSubPanel
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																emergencyContactPanel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																schoolInfoPanel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(accoInfoPanel,
												GroupLayout.DEFAULT_SIZE, 153,
												Short.MAX_VALUE)));
		mainPaneSubPanel.setLayout(gl_mainPaneSubPanel);

		tabbedPane.addTab("Profile", mainPaneSubPanel);

		tabbedPane.addTab("Payment", paymentPanel);
		paymentPanel.setLayout(null);

		lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPayment.setBounds(165, 11, 155, 25);
		paymentPanel.add(lblPayment);

		label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\user\\Desktop\\workspace\\DMS\\url.jpg"));
		label.setBounds(405, 11, 46, 469);
		paymentPanel.add(label);

		lblNewLabel = new JLabel("Room Price:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 90, 91, 14);
		paymentPanel.add(lblNewLabel);

		JLabel lblTotalDebt = new JLabel("Total Debt:");
		lblTotalDebt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalDebt.setBounds(10, 223, 91, 14);
		paymentPanel.add(lblTotalDebt);

		JLabel lblDisbursement = new JLabel("Disbursement:");
		lblDisbursement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDisbursement.setBounds(10, 178, 111, 14);
		paymentPanel.add(lblDisbursement);

		JLabel lblAccomodationTimemonthly = new JLabel("Time Interval(Month):");
		lblAccomodationTimemonthly.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAccomodationTimemonthly.setBounds(10, 135, 202, 14);
		paymentPanel.add(lblAccomodationTimemonthly);

		JLabel lblPayment_1 = new JLabel("Details");
		lblPayment_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPayment_1.setBounds(569, 11, 155, 25);
		paymentPanel.add(lblPayment_1);

		JLabel lblPaymentType = new JLabel("Payment Type(*):");
		lblPaymentType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaymentType.setBounds(10, 268, 122, 25);
		paymentPanel.add(lblPaymentType);

		rdbtnCash = new JRadioButton("Cash");
		rdbtnCash.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnCash.setBounds(165, 271, 101, 25);
		paymentPanel.add(rdbtnCash);

		rdbtnCreditCard = new JRadioButton("Credit Card");
		rdbtnCreditCard.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnCreditCard.setBounds(268, 271, 109, 23);
		paymentPanel.add(rdbtnCreditCard);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnCreditCard);
		group.add(rdbtnCash);

		JLabel lblRemainingDebt = new JLabel("Remaining Debt(*):");
		lblRemainingDebt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRemainingDebt.setBounds(423, 85, 135, 25);
		paymentPanel.add(lblRemainingDebt);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clickEnterButton(evt);
			}
		});
		btnEnter.setBounds(288, 389, 89, 23);
		paymentPanel.add(btnEnter);

		txtRoomPrice = new JTextField();
		txtRoomPrice.setBounds(165, 87, 184, 25);
		paymentPanel.add(txtRoomPrice);
		txtRoomPrice.setColumns(10);

		txtTimeInterval = new JTextField();
		txtTimeInterval.setColumns(10);
		txtTimeInterval.setBounds(165, 132, 184, 25);
		paymentPanel.add(txtTimeInterval);

		txtDisbursement = new JTextField();
		txtDisbursement.setColumns(10);
		txtDisbursement.setBounds(165, 175, 184, 25);
		paymentPanel.add(txtDisbursement);

		txtTotalDebt = new JTextField();
		txtTotalDebt.setColumns(10);
		txtTotalDebt.setBounds(165, 220, 184, 25);
		paymentPanel.add(txtTotalDebt);

		txtRemainingDebt = new JTextField();
		txtRemainingDebt.setColumns(10);
		txtRemainingDebt.setBounds(572, 85, 184, 25);
		paymentPanel.add(txtRemainingDebt);

		javax.swing.GroupLayout gl_mainPanePanel = new javax.swing.GroupLayout(
				mainPanePanel);
		gl_mainPanePanel.setHorizontalGroup(gl_mainPanePanel
				.createParallelGroup(Alignment.TRAILING).addGroup(
						Alignment.LEADING,
						gl_mainPanePanel
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(tabbedPane,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_mainPanePanel.setVerticalGroup(gl_mainPanePanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_mainPanePanel
						.createSequentialGroup()
						.addGap(20)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
								520, Short.MAX_VALUE)));
		mainPanePanel.setLayout(gl_mainPanePanel);

		homeMenu.setText("Home");

		addStudentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.SHIFT_MASK));
		addStudentMenuItem.setText("Add Student");
		addStudentMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						addStudentActionPerformed(evt);
					}
				});
		homeMenu.add(addStudentMenuItem);

		menuBar.add(homeMenu);

		dormMenu.setText("Dorm");

		addDormMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_D,
				java.awt.event.InputEvent.SHIFT_MASK));
		addDormMenuItem.setText("Add Dorm");
		addDormMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addDormActionPerformed(evt);
			}
		});
		dormMenu.add(addDormMenuItem);

		menuBar.add(dormMenu);

		viewDormMenuItem = new JMenuItem("View Dorm List");
		viewDormMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewDormActionPerformed(evt);
			}
		});
		dormMenu.add(viewDormMenuItem);

		roomMenu.setText("Room");

		addRoomMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_R,
				java.awt.event.InputEvent.SHIFT_MASK));
		addRoomMenuItem.setText("Add Room");
		addRoomMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addRoomActionPerformed(evt);
			}
		});
		roomMenu.add(addRoomMenuItem);

		menuBar.add(roomMenu);
		mntmAddRoomType = new JMenuItem("Add Room Type");
		mntmAddRoomType.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addRoomTypeActionPerformed(evt);
			}

			private void addRoomTypeActionPerformed(ActionEvent evt) {
				new RoomTypeWindow().setVisible(true);

			}
		});
		roomMenu.add(mntmAddRoomType);

		searchMenu = new JMenu("Search");
		menuBar.add(searchMenu);

		searchAllMenuItem = new JMenuItem("Search All   Ctrl+F");
		searchMenu.add(searchAllMenuItem);
		searchAllMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchAllWindow = new SearchAllWindow();
				searchAllWindow.setVisible(true);
			}
		});

		otherMenu.setText("Other");
		menuBar.add(otherMenu);

		lostItems = new JMenuItem("Add Lost Item");
		lostItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LostItemWindow().setVisible(true);
			}
		});
		otherMenu.add(lostItems);

		addRoomMenuItem = new JMenuItem("Show Capacity of Dorms");
		addRoomMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ChartChooserView chooser = new ChartChooserView();
				chooser.pack();
				RefineryUtilities.centerFrameOnScreen(chooser);
				chooser.setVisible(true);

			}
		});

		damagedItems = new JMenuItem("Add Damaged Item");
		damagedItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new DamagedItemWindow().setVisible(true);
			}
		});
		otherMenu.add(damagedItems);

		viewItemListMenu = new JMenuItem("View Item List");
		viewItemListMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new ItemsListWindow().setVisible(true);
			}
		});
		otherMenu.add(viewItemListMenu);
		otherMenu.add(addRoomMenuItem);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(mainSearchPanel,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jSeparator1,
																		GroupLayout.PREFERRED_SIZE,
																		15,
																		GroupLayout.PREFERRED_SIZE)
																.addContainerGap(
																		781,
																		Short.MAX_VALUE))
												.addComponent(
														mainPanePanel,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(mainSearchPanel, GroupLayout.DEFAULT_SIZE, 540,
						Short.MAX_VALUE)
				.addComponent(mainPanePanel, GroupLayout.DEFAULT_SIZE, 540,
						Short.MAX_VALUE));
		getContentPane().setLayout(layout);

		pack();
	}

	private void filterList() {
		System.out.println(studentSearchList.getModel());

		int start = 0;
		int itemIx = 0;
		Set resultSet = new HashSet();
		filteredModel = new DefaultListModel();
		String prefix = searchStudentText.getText();
		javax.swing.text.Position.Bias direction = javax.swing.text.Position.Bias.Forward;
		for (int i = 0; i < studentSearchList.getModel().getSize(); i++) {
			itemIx = studentSearchList.getNextMatch(prefix, start, direction);

			try {
				resultSet
						.add(studentSearchList.getModel().getElementAt(itemIx));
			} catch (ArrayIndexOutOfBoundsException e) {
				searchStudentText.setText("");
				return;
			}
			start++;
		}
		Iterator itr = resultSet.iterator();
		while (itr.hasNext()) {
			filteredModel.addElement(itr.next());
		}
		studentSearchList.setModel(filteredModel);
	}

	public void fillStudentList() {
		DBConnection conn = new DBConnection();
		String studentArray[] = null;
		try {
			ArrayList<String> studenNameSurname = conn
					.displayStudentNameSurname();
			studentArray = new String[studenNameSurname.size()];
			for (int i = 0; i < studentArray.length; i++) {
				studentArray[i] = studenNameSurname.get(i);
				searchModel.addElement(studenNameSurname.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clickStudentSearchList(MouseEvent evt) {
		removeItems();
		DBConnection conn = new DBConnection();
		Student std = new Student();
		EmergencyContact emg = new EmergencyContact();
		Payment pymt = new Payment();
		School sch = new School();
		Hostel host = new Hostel();
		Dorm dorm = new Dorm();
		Room room = new Room();
		Room room1 = new Room();
		name = new String[2];
		for (int j = 0; j < name.length; j++) {
			name = studentSearchList.getSelectedValue().toString()
					.split("\\s+");
		}
		if (!name[0].equals(null) && !name[1].equals(null)) {
			std = conn.retrieveStudentInfo(name[0], name[1]);
			emg = conn.retrieveEmergencyInfo(name[0], name[1]);
			sch = conn.retrieveSchoolInfo(name[0], name[1]);
			dorm = conn.retrieveDormInfo(name[0], name[1]);
			room = conn.retrieveRoomInfo(name[0], name[1]);
			host = conn.retrieveHostelInfo(name[0], name[1]);
			room1 = conn.getPaymentInfo(name[0], name[1]);
			pymt = conn.getRemainingDebt(name[0], name[1]);
		}

		if (evt.getClickCount() == 2) {
			fillStudentInfo(std);
			fillEmergencyContact(emg);
			fillSchoolInfo(sch);
			fillAccInfo(dorm, room, host);
			fillPayment(room1, pymt);

		}
	}

	private void removeItems() {
		accDormCBox.removeAllItems();
		accRoomCBox.removeAllItems();
		stdGenderCBox.removeAllItems();
		accRoomTypeCBox.removeAllItems();
	}

	private void fillAccInfo(Dorm dorm, Room room, Hostel host) {
		accDormCBox.addItem(dorm.getDormName());
		accRoomTypeCBox.addItem(room.getTypeName());
		accRoomCBox.addItem(room.getRoomNo());
		startDateChooser.setDate(host.getStartDate());
		endDateChooser.setDate(host.getEndDate());
	}

	private void fillSchoolInfo(School sch) {
		schUniNameText.setText(sch.getUniName());
		if (sch.getGrade() != 0)
			schGradeText.setText(Integer.toString(sch.getGrade()));
		else
			schGradeText.setText(null);
		schDeptNameText.setText(sch.getDepartment());
	}

	private void fillStudentInfo(Student std) {
		stdNameText.setText(std.getName());
		stdSurnameText.setText(std.getSurname());
		stdMailText.setText(std.getEmail());
		stdGenderCBox.addItem(std.getGender());
		birthDateChooser.setDate(std.getBirthday());
		if (!std.getTC().equals("0"))
			stdTCText.setText(std.getTC());
		stdPhoneText.setText(std.getPhone());
	}

	private void fillPayment(Room room, Payment pymt) {
		txtRoomPrice.setText(Double.toString(room.getRoomPrice()));
		txtTimeInterval.setText(Integer.toString(room.getMonthDiff()));
		txtTotalDebt.setText(Double.toString(room.getTotalDebt()));
		System.out.println(pymt.getRemainingDebt());
		if (pymt.getRemainingDebt() == 0) {
			txtRemainingDebt.setText(Double.toString(room.getTotalDebt()));
		} else {
			txtRemainingDebt.setText(Double.toString(pymt.getRemainingDebt()));
		}
	}

	private void fillEmergencyContact(EmergencyContact emg) {
		emgNameText.setText(emg.getName());
		emgSurnameText.setText(emg.getSurname());
		emgPhoneText.setText(emg.getPhone());
	}

	private void clickSearchButton(MouseEvent evt) {
		searchModel.clear();
		fillStudentList();

	}

	private void clickEditButton(ActionEvent evt) {
		setEditableTrue();
		fillCBoxDorm();
		fillCBoxRoomType();
	}

	private void getRoomMoClicked(MouseEvent me) {
		displayRoomNo();

	}

	private void fillCBoxRoomType() {
		DBConnection conn = new DBConnection();
		ArrayList<Integer> list;
		try {
			list = conn.displayRoomType();
			for (int i = 0; i < list.size(); i++)
				accRoomTypeCBox.addItem(list.get(i));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void fillCBoxDorm() {
		DBConnection conn = new DBConnection();
		ArrayList<String> list = null;
		try {
			list = conn.displayDorm();
			for (int i = 0; i < list.size(); i++)
				accDormCBox.addItem(list.get(i));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void displayRoomNo() {
		DBConnection conn = new DBConnection();
		Dorm dorm = new Dorm();

		dorm.setDormName(accDormCBox.getSelectedItem().toString());
		Room room = new Room();
		room.setTypeName(Integer.parseInt(accRoomTypeCBox.getSelectedItem()
				.toString()));
		try {
			ArrayList<Integer> list = new ArrayList<Integer>();
			accRoomCBox.removeAllItems();
			list = conn.displayRoomNo(dorm, room);

			for (int i = 0; i < list.size(); i++) {
				accRoomCBox.addItem(list.get(i));
			}

		} catch (SQLException ev) {

			ev.printStackTrace();
		}
	}

	private void clickSaveButton(ActionEvent evt) throws ParseException {
		DBConnection db = new DBConnection();
		Student student = getStudentInfoFromText();
		EmergencyContact emgContact = getContactInfoFromText();
		School school = getSchoolInfoFromText();
		Dorm dorm = new Dorm();
		dorm.setDormName(accDormCBox.getSelectedItem().toString());
		Room room = getRoomFromText();

		Hostel hostel = getStartEndDateFromText();
		String Name = name[0];

		String Surname = name[1];
		if (!student.equals(null) && !emgContact.equals(null)
				&& !Name.equals(null) && !Surname.equals(null)
				&& !school.equals(null) && !dorm.equals(null)
				&& !hostel.equals(null) && !room.equals(null)) {

			int type1 = Integer.parseInt(accRoomTypeCBox.getSelectedItem()
					.toString());
			int studentNumber;
			try {
				Dorm dorm1 = db.retrieveDormInfo(name[0], name[1]);
				Room room1 = db.retrieveRoomInfo(name[0], name[1]);
				Hostel host1 = db.retrieveHostelInfo(name[0], name[1]);
				studentNumber = db.GetStudentNumber(hostel, dorm, room);
				if (!(dorm1.getDormName().equals(accDormCBox))
						|| room1.getRoomNo() != Integer.parseInt(accRoomCBox
								.getSelectedItem().toString())
						|| room1.getTypeName() != Integer
								.parseInt(accRoomTypeCBox.getSelectedItem()
										.toString()))
					if (studentNumber < type1) {

						if (db.updateStudent(student, emgContact, dorm, room,
								hostel, school, Name, Surname)
								&& db.updateHostel(student, dorm, room, hostel)) {
							JOptionPane.showMessageDialog(getContentPane(),
									"Changes saved");

						} else {
							JOptionPane.showMessageDialog(getContentPane(),
									"Changes not saved, please try again!");
						}
					} else {

						JOptionPane.showMessageDialog(getContentPane(),
								"This Room is Full");

					}
				else {
					if (db.updateStudent(student, emgContact, dorm, room,
							hostel, school, Name, Surname)) {
						JOptionPane.showMessageDialog(getContentPane(),
								"Changes saved");

					} else {
						JOptionPane.showMessageDialog(getContentPane(),
								"Changes not saved, please try again!");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(getContentPane(),
					"Changes not saved, please try again!");
		}
		setEditableFalse();

	}

	private Hostel getStartEndDateFromText() throws ParseException {
		Hostel hostel = new Hostel();
		Date startDate = new java.sql.Date(startDateChooser.getDate().getTime());
		hostel.setStartDate(startDate);
		Date endDate = new java.sql.Date(endDateChooser.getDate().getTime());
		hostel.setEndDate(endDate);
		return hostel;
	}

	private Room getRoomFromText() {
		Room room = new Room();
		int roomNo = Integer.parseInt(accRoomCBox.getSelectedItem().toString());
		room.setTypeName(Integer.parseInt(accRoomTypeCBox.getSelectedItem()
				.toString()));
		room.setRoomNo(roomNo);
		return room;
	}

	private School getSchoolInfoFromText() {
		School school = new School();
		school.setUniName(schUniNameText.getText());
		school.setDepartment(schDeptNameText.getText());
		if (schGradeText.getText().isEmpty()) {
			school.setGrade(0);
		} else {
			int grade = Integer.parseInt(schGradeText.getText());
			school.setGrade(grade);
		}
		return school;
	}

	private EmergencyContact getContactInfoFromText() {
		EmergencyContact emgContact = new EmergencyContact();
		emgContact.setName(emgNameText.getText());
		emgContact.setSurname(emgSurnameText.getText());
		emgContact.setPhone(emgPhoneText.getText());
		return emgContact;
	}

	private Student getStudentInfoFromText() throws ParseException {
		Student student = new Student();
		if (birthDateChooser.getDate() == null) {
			student.setBirthday(null);
		} else {
			Date birthdate = new java.sql.Date(birthDateChooser.getDate()
					.getTime());
			student.setBirthday(birthdate);
		}
		student.setName(stdNameText.getText());
		student.setSurname(stdSurnameText.getText());
		student.setEmail(stdMailText.getText());
		student.setGender(stdGenderCBox.getSelectedItem().toString());
		student.setTC(stdTCText.getText());
		student.setPhone(stdPhoneText.getText());

		return student;
	}

	private void clickUndoButton(ActionEvent evt) {
		DBConnection conn = new DBConnection();
		accDormCBox.removeAllItems();
		accRoomCBox.removeAllItems();
		accRoomTypeCBox.removeAllItems();
		Dorm dorm = conn.retrieveDormInfo(name[0], name[1]);
		Room room = conn.retrieveRoomInfo(name[0], name[1]);
		Hostel host = conn.retrieveHostelInfo(name[0], name[1]);
		fillAccInfo(dorm, room, host);

	}

	private void clickEnterButton(ActionEvent evt) {
		double totalDebt, disbursement = 0;
		DBConnection con = new DBConnection();
		Student std = new Student();
		Room room = new Room();
		Dorm drm = new Dorm();
		std.setName(stdNameText.getText());
		std.setSurname(stdSurnameText.getText());
		room.setRoomNo(Integer.parseInt(accRoomCBox.getSelectedItem()
				.toString()));
		drm.setDormName(accDormCBox.getSelectedItem().toString());
		Payment pymt = new Payment();
		if (rdbtnCash.isSelected()) {
			String cash = "Cash";
			pymt.setPaymentType(cash);
			totalDebt = Double.parseDouble(txtTotalDebt.getText());
			if (txtDisbursement.getText().isEmpty()) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Please enter disbursement");
			} else {
				disbursement = Double.parseDouble(txtDisbursement.getText());
			}
			double remaining = totalDebt - disbursement;
			txtRemainingDebt.setText(Double.toString(remaining));
			pymt.setRemainingDebt(remaining);
			if (con.insertPayment(drm, room, std, pymt)) {
				JOptionPane.showMessageDialog(getContentPane(), "Payment done");
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Payment not done, try again!");
			}
		} else if (rdbtnCreditCard.isSelected()) {
			String creditcard = "Credit Card";
			txtRemainingDebt.setText("0");
			pymt.setRemainingDebt(0);
			pymt.setPaymentType(creditcard);
			if (con.insertPayment(drm, room, std, pymt)) {
				JOptionPane.showMessageDialog(getContentPane(), "Payment done");
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Payment not done, try again!");
			}
		} else {
			JOptionPane.showMessageDialog(getContentPane(),
					"Please, Choose Payment Type");
		}
	}

	private void addStudentActionPerformed(java.awt.event.ActionEvent evt) {
		new StudentWindow().setVisible(true);
	}

	private void addDormActionPerformed(java.awt.event.ActionEvent evt) {
		new DormWindow().setVisible(true);
	}

	private void addRoomActionPerformed(java.awt.event.ActionEvent evt) {
		new RoomWindow().setVisible(true);
	}

	private void viewDormActionPerformed(java.awt.event.ActionEvent evt) {
		new DormListWindow().setVisible(true);
	}

	private void setEditableFalse() {
		stdNameText.setEditable(false);
		stdSurnameText.setEditable(false);
		stdTCText.setEditable(false);
		// birthDateChooser.getDateEditor().setEnabled(false);
		stdPhoneText.setEditable(false);
		stdMailText.setEditable(false);
		stdGenderCBox.setEnabled(false);
		emgNameText.setEditable(false);
		emgSurnameText.setEditable(false);
		emgPhoneText.setEditable(false);
		schUniNameText.setEditable(false);
		schDeptNameText.setEditable(false);
		schGradeText.setEditable(false);
		accDormCBox.setEnabled(false);
		accRoomCBox.setEnabled(false);
		// accRoomTypeCBox.setEnabled(false);
	}

	private void setEditableTrue() {
		stdNameText.setEditable(true);
		stdSurnameText.setEditable(true);
		stdTCText.setEditable(true);
		stdPhoneText.setEditable(true);
		stdMailText.setEditable(true);
		stdGenderCBox.setEnabled(true);
		emgNameText.setEditable(true);
		emgSurnameText.setEditable(true);
		emgPhoneText.setEditable(true);
		schUniNameText.setEditable(true);
		schDeptNameText.setEditable(true);
		schGradeText.setEditable(true);
		accDormCBox.setEnabled(true);
		accRoomCBox.setEnabled(true);
		accRoomTypeCBox.setEnabled(true);
		// accStartDateText.setEditable(true);
		// accEndDateText.setEditable(true);
		accRoomTypeCBox.setEnabled(true);
		// birthDateChooser.getDateEditor().setEnabled(true);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private javax.swing.JButton searchButton;
	private javax.swing.JComboBox stdGenderCBox;
	private javax.swing.JList studentSearchList;
	private javax.swing.JMenu homeMenu;
	private javax.swing.JMenu dormMenu;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu roomMenu;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenu jMenu7;
	private javax.swing.JMenu otherMenu;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuBar jMenuBar3;
	private javax.swing.JMenuItem addStudentMenuItem;
	private javax.swing.JMenuItem addDormMenuItem;
	private javax.swing.JMenuItem addRoomMenuItem;
	private javax.swing.JMenuItem addOtherChartMenuItem;
	private javax.swing.JScrollPane searchScrollPane;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTabbedPane tabbedPane;
	private javax.swing.JTextField schUniNameText;
	private javax.swing.JTextField schDeptNameText;
	private javax.swing.JTextField schGradeText;
	private javax.swing.JTextField emgNameText;
	private javax.swing.JTextField emgSurnameText;
	private javax.swing.JTextField emgPhoneText;
	private javax.swing.JTextField stdMailText;
	private javax.swing.JTextField stdNameText;
	private javax.swing.JTextField stdPhoneText;
	private javax.swing.JComboBox accDormCBox, accRoomCBox, accRoomTypeCBox;
	private javax.swing.JButton saveButton;
	private JMenuItem mntmAddRoomType;
	private javax.swing.JTextField stdSurnameText;
	private javax.swing.JTextField stdTCText;
	private javax.swing.JTextField searchStudentText;
	private JMenuItem viewDormMenuItem;
	private JMenu searchMenu;
	private JMenuItem searchAllMenuItem;
	private JMenuItem lostItems;
	private javax.swing.JPanel mainSearchPanel;
	private javax.swing.JPanel mainPanePanel;
	private javax.swing.JPanel mainPaneSubPanel;
	private javax.swing.JPanel paymentPanel;
	private javax.swing.JPanel personalInfoPanel;
	private javax.swing.JPanel emergencyContactPanel;
	private javax.swing.JPanel schoolInfoPanel;
	private javax.swing.JPanel accoInfoPanel;
	private javax.swing.JLabel personalInfoLabel;
	private javax.swing.JLabel personalInfoPhoneLabel;
	private javax.swing.JLabel personalInfoMailLabel;
	private javax.swing.JLabel personalInfoBirthdayLabel;
	private javax.swing.JLabel emergencyContactNameLabel;
	private javax.swing.JLabel emergencyContactSurnameLabel;
	private javax.swing.JLabel emergencyContactPhoneLabel;
	private javax.swing.JLabel schoolInfoUniversityLabel;
	private javax.swing.JLabel schoolInfoDepartmentLabel;
	private javax.swing.JLabel schoolInfoGradeLabel;
	private javax.swing.JLabel accoInfoDormLabel;
	private javax.swing.JLabel searchStudentLabel;
	private javax.swing.JLabel accoInfoRoomLabel;
	private javax.swing.JLabel accoInfoStartDateLabel;
	private javax.swing.JLabel accoInfoEndDateLabel;
	private javax.swing.JLabel emergencyContactLabel;
	private javax.swing.JLabel schoolInfoLabel;
	private javax.swing.JLabel accoInfoLabel;
	private javax.swing.JLabel personalInfoNameLabel;
	private javax.swing.JLabel personalInfoSurnameLabel;
	private javax.swing.JLabel personalInfoNationalIDLabel;
	private javax.swing.JLabel personalInfoGenderLabel;
	private ArrayList<String> studentList;
	private DefaultListModel searchModel = null;
	private String[] name;
	private SearchAllWindow searchAllWindow;
	private DefaultListModel filteredModel = null;
	private int fieldLength = 0;
	private JMenuItem damagedItems;
	private JMenuItem viewItemListMenu;
	private JLabel lblPayment;
	private JLabel label;
	private JLabel lblNewLabel;
	private JDateChooser birthDateChooser, startDateChooser, endDateChooser;
	private JTextField textField;;
	private DBConnection conn;
	JRadioButton rdbtnCreditCard, rdbtnCash;
	private JTextField txtRoomPrice;
	private JTextField txtTimeInterval;
	private JTextField txtDisbursement;
	private JTextField txtTotalDebt;
	private JTextField txtRemainingDebt;
}
