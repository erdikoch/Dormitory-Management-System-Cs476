package view;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import database.DBConnection;
import background.Dorm;
import background.EmergencyContact;
import background.Hostel;
import background.Room;
import background.School;
import background.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

public class StudentWindow extends javax.swing.JFrame {
	final JComboBox cboxRoomType = new JComboBox();

	public StudentWindow() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		studentWindowMainPanel = new javax.swing.JPanel();
		studentWindowSubPanel = new javax.swing.JPanel();
		personalInfoPanel = new javax.swing.JPanel();
		personalInfoLabel = new javax.swing.JLabel();
		personalInfoNameLabel = new javax.swing.JLabel();
		personalInfoSurnameLabel = new javax.swing.JLabel();
		personalInfoNationalIDLabel = new javax.swing.JLabel();
		personalInfoGenderLabel = new javax.swing.JLabel();
		personalInfoPhoneLabel = new javax.swing.JLabel();
		personalInfoMailLabel = new javax.swing.JLabel();
		personalInfoBirthdayLabel = new javax.swing.JLabel();
		personalInfoNameText = new javax.swing.JTextField();
		personalInfoSurnameText = new javax.swing.JTextField();
		personalInfoTCText = new javax.swing.JTextField();
		personalInfoPhoneText = new javax.swing.JTextField();
		personalInfoMailText = new javax.swing.JTextField();
		personalInfoGenderComboBox = new javax.swing.JComboBox();
		emergencyContactPanel = new javax.swing.JPanel();
		emergencyContactLabel = new javax.swing.JLabel();
		emergencyContactNameLabel = new javax.swing.JLabel();
		emergencyContactSurnameLabel = new javax.swing.JLabel();
		emergencyContactPhoneLabel = new javax.swing.JLabel();
		emergencyContactNameText = new javax.swing.JTextField();
		emergencyContactSurnameText = new javax.swing.JTextField();
		emergencyContactPhoneText = new javax.swing.JTextField();
		schoolInfoPanel = new javax.swing.JPanel();
		schoolInfoLabel = new javax.swing.JLabel();
		schoolInfoUniversityLabel = new javax.swing.JLabel();
		schoolInfoDepartmentLabel = new javax.swing.JLabel();
		schoolInfoGradeLabel = new javax.swing.JLabel();
		schoolInfoUniversityText = new javax.swing.JTextField();
		schoolInfoDepartmentText = new javax.swing.JTextField();
		schoolInfoGradeText = new javax.swing.JTextField();
		accoInfoPanel = new javax.swing.JPanel();
		accoInfoLabel = new javax.swing.JLabel();
		accoInfoDormLabel = new javax.swing.JLabel();
		accoInfoRoomLabel = new javax.swing.JLabel();
		accoInfoDormComboBox = new javax.swing.JComboBox();
		accoInfoDormComboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				displayDormcombo(me);
			}

			private void displayDormcombo(MouseEvent me) {
				DBConnection conn = new DBConnection();

				try {
					accoInfoDormComboBox.removeAllItems();
					ArrayList<String> list = conn.displayDorm();
					for (int i = 0; i < list.size(); i++)
						accoInfoDormComboBox.addItem(list.get(i));
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

		});

		accoInfoRoomComboBox = new javax.swing.JComboBox();
		accoInfoRoomComboBox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				displayRoomNoMouseClicked(e);
			}

			private void displayRoomNoMouseClicked(MouseEvent e) {
				DBConnection conn = new DBConnection();
				Dorm dorm = new Dorm();
				dorm.setDormName(accoInfoDormComboBox.getSelectedItem()
						.toString());
				Room room = new Room();
				room.setTypeName(Integer.parseInt(cboxRoomType
						.getSelectedItem().toString()));
				try {
					ArrayList<Integer> list = new ArrayList<Integer>();
					accoInfoRoomComboBox.removeAllItems();
					list = conn.displayRoomNo(dorm, room);
					for (int i = 0; i < list.size(); i++) {

						accoInfoRoomComboBox.addItem(list.get(i));
					}
				} catch (SQLException ev) {
					ev.printStackTrace();
				}
			}
		});
		accoInfoStartDateLabel = new javax.swing.JLabel();
		accoInfoEndDateLabel = new javax.swing.JLabel();
		accoInfoAddButton = new javax.swing.JButton();
		accoInfoAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					addActionPerformed(evt);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		studentWindowSubPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED,
						new java.awt.Color(51, 204, 0), new java.awt.Color(51,
								153, 0), new java.awt.Color(0, 153, 0),
						new java.awt.Color(51, 153, 0)));

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

		personalInfoGenderComboBox
				.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
						"Female", "Male" }));

		birthdayDateChooser = new JDateChooser();
		birthdayDateChooser.setDateFormatString("dd/MM/yyyy");
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
																																personalInfoSurnameText)
																														.addComponent(
																																personalInfoTCText)
																														.addGroup(
																																gl_personalInfoPanel
																																		.createSequentialGroup()
																																		.addComponent(
																																				personalInfoGenderComboBox,
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
																												personalInfoNameText)))
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
																								birthdayDateChooser,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								personalInfoPhoneText,
																								GroupLayout.DEFAULT_SIZE,
																								223,
																								Short.MAX_VALUE)
																						.addComponent(
																								personalInfoMailText))))
										.addContainerGap(44, Short.MAX_VALUE)));
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
																personalInfoNameText,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																personalInfoPhoneText,
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
																personalInfoSurnameText,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																personalInfoMailText,
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
																								personalInfoTCText,
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
																								personalInfoGenderComboBox,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																birthdayDateChooser,
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
		emergencyContactNameLabel.setText("Name:");

		emergencyContactSurnameLabel
				.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		emergencyContactSurnameLabel.setText("Surname:");

		emergencyContactPhoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		emergencyContactPhoneLabel.setText("Phone:");

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
																								emergencyContactSurnameText)
																						.addComponent(
																								emergencyContactNameText)
																						.addComponent(
																								emergencyContactPhoneText,
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
																emergencyContactNameText,
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
																emergencyContactSurnameText,
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
																emergencyContactPhoneText,
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
																								schoolInfoUniversityText)
																						.addComponent(
																								schoolInfoDepartmentText)
																						.addComponent(
																								schoolInfoGradeText,
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
																schoolInfoUniversityText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												gl_schoolInfoPanel
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																schoolInfoDepartmentText,
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
																schoolInfoGradeText,
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
		accoInfoDormLabel.setText("Dorm:");

		accoInfoRoomLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		accoInfoRoomLabel.setText("Room:");

		accoInfoDormComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "" }));

		accoInfoRoomComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "" }));

		accoInfoStartDateLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		accoInfoStartDateLabel.setText("Start Date:");

		accoInfoEndDateLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		accoInfoEndDateLabel.setText("End Date:");

		accoInfoAddButton.setBackground(new java.awt.Color(204, 255, 204));
		accoInfoAddButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		accoInfoAddButton.setText("ADD");

		JLabel lblType = new JLabel();
		lblType.setText("Type :");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));

		cboxRoomType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				displayCBoxRoomType(me);
			}

			private void displayCBoxRoomType(MouseEvent me) {
				DBConnection conn = new DBConnection();
				try {
					cboxRoomType.removeAllItems();

					ArrayList<Integer> list = conn.displayRoomType();
					for (int i = 0; i < list.size(); i++)
						cboxRoomType.addItem(list.get(i));
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		startDateChooser = new JDateChooser();
		startDateChooser.setDateFormatString("dd/MM/yyyy");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		dateFormat.format(date);
		startDateChooser.setDate(date);
		endDateChooser = new JDateChooser();
		endDateChooser.setDateFormatString("dd/MM/yyyy");
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
																																55,
																																GroupLayout.PREFERRED_SIZE))
																										.addGap(29))
																						.addGroup(
																								gl_accoInfoPanel
																										.createSequentialGroup()
																										.addComponent(
																												accoInfoRoomLabel,
																												GroupLayout.DEFAULT_SIZE,
																												80,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)))
																		.addGroup(
																				gl_accoInfoPanel
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addGroup(
																								gl_accoInfoPanel
																										.createSequentialGroup()
																										.addComponent(
																												accoInfoDormComboBox,
																												GroupLayout.PREFERRED_SIZE,
																												92,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(78)
																										.addComponent(
																												accoInfoStartDateLabel,
																												GroupLayout.PREFERRED_SIZE,
																												83,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_accoInfoPanel
																										.createSequentialGroup()
																										.addGroup(
																												gl_accoInfoPanel
																														.createParallelGroup(
																																Alignment.TRAILING,
																																false)
																														.addComponent(
																																accoInfoRoomComboBox,
																																Alignment.LEADING,
																																0,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																cboxRoomType,
																																Alignment.LEADING,
																																0,
																																92,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												accoInfoEndDateLabel,
																												GroupLayout.PREFERRED_SIZE,
																												83,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_accoInfoPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								endDateChooser,
																								GroupLayout.DEFAULT_SIZE,
																								214,
																								Short.MAX_VALUE)
																						.addComponent(
																								startDateChooser,
																								GroupLayout.DEFAULT_SIZE,
																								214,
																								Short.MAX_VALUE))
																		.addGap(41)
																		.addComponent(
																				accoInfoAddButton,
																				GroupLayout.PREFERRED_SIZE,
																				86,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(20)));
		gl_accoInfoPanel
				.setVerticalGroup(gl_accoInfoPanel
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
																		.addComponent(
																				accoInfoLabel)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_accoInfoPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_accoInfoPanel
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												accoInfoDormLabel)
																										.addComponent(
																												accoInfoDormComboBox,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												accoInfoStartDateLabel))
																						.addComponent(
																								startDateChooser,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(8)
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
																																Alignment.BASELINE)
																														.addComponent(
																																cboxRoomType,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblType,
																																GroupLayout.PREFERRED_SIZE,
																																15,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																accoInfoEndDateLabel))
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addGroup(
																												gl_accoInfoPanel
																														.createParallelGroup(
																																Alignment.BASELINE)
																														.addComponent(
																																accoInfoRoomComboBox,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																accoInfoRoomLabel)))
																						.addComponent(
																								endDateChooser,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_accoInfoPanel
																		.createSequentialGroup()
																		.addGap(0,
																				105,
																				Short.MAX_VALUE)
																		.addComponent(
																				accoInfoAddButton,
																				GroupLayout.PREFERRED_SIZE,
																				32,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		accoInfoPanel.setLayout(gl_accoInfoPanel);

		javax.swing.GroupLayout gl_studentWindowSubPanel = new javax.swing.GroupLayout(
				studentWindowSubPanel);
		gl_studentWindowSubPanel
				.setHorizontalGroup(gl_studentWindowSubPanel
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_studentWindowSubPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_studentWindowSubPanel
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
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																Alignment.LEADING,
																gl_studentWindowSubPanel
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
																				361,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		gl_studentWindowSubPanel
				.setVerticalGroup(gl_studentWindowSubPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_studentWindowSubPanel
										.createSequentialGroup()
										.addComponent(personalInfoPanel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_studentWindowSubPanel
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
												GroupLayout.DEFAULT_SIZE, 163,
												Short.MAX_VALUE)
										.addContainerGap()));
		studentWindowSubPanel.setLayout(gl_studentWindowSubPanel);

		javax.swing.GroupLayout gl_studentWindowMainPanel = new javax.swing.GroupLayout(
				studentWindowMainPanel);
		gl_studentWindowMainPanel.setHorizontalGroup(gl_studentWindowMainPanel
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_studentWindowMainPanel
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(studentWindowSubPanel,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		gl_studentWindowMainPanel.setVerticalGroup(gl_studentWindowMainPanel
				.createParallelGroup(Alignment.TRAILING).addGroup(
						gl_studentWindowMainPanel
								.createSequentialGroup()
								.addContainerGap(41, Short.MAX_VALUE)
								.addComponent(studentWindowSubPanel,
										GroupLayout.PREFERRED_SIZE, 512,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		studentWindowMainPanel.setLayout(gl_studentWindowMainPanel);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(studentWindowMainPanel, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(studentWindowMainPanel,
										GroupLayout.PREFERRED_SIZE, 543,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}

	private void addActionPerformed(java.awt.event.ActionEvent evt)
			throws ParseException {
		if (checkPersonalInfoEmpty()) {
			JOptionPane.showMessageDialog(getContentPane(),
					"The mandatory fields empty, please fill");
		} else {
			Student student = getStudentInfoFromText();
			EmergencyContact emgContact = getContactInfoFromText();
			School school = getSchoolInfoFromText();
			Dorm dorm = new Dorm();
			dorm.setDormName(accoInfoDormComboBox.getSelectedItem().toString());
			Room room = getRoomFromText();

			Hostel hostel = getStartEndDateFromText();
			DBConnection conn = new DBConnection();
			try {
				int type = Integer.parseInt(cboxRoomType.getSelectedItem()
						.toString());
				int studentNumber = conn.GetStudentNumber(hostel, dorm, room);
				if (studentNumber < type) {
					if (conn.insertStudent(student, emgContact, school, dorm,
							room, hostel)) {
						JOptionPane.showMessageDialog(getContentPane(),
								"Registration completed");
					} else {
						JOptionPane.showMessageDialog(getContentPane(),
								"Registration not completed");
					}
				} else {
					JOptionPane.showMessageDialog(getContentPane(),
							"This room is full");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
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
		int roomNo = Integer.parseInt(accoInfoRoomComboBox.getSelectedItem()
				.toString());
		room.setRoomNo(roomNo);
		return room;
	}

	private School getSchoolInfoFromText() {
		School school = new School();
		school.setUniName(schoolInfoUniversityText.getText());
		school.setDepartment(schoolInfoDepartmentText.getText());
		if (schoolInfoGradeText.getText().isEmpty()) {
			school.setGrade(0);
		} else {
			int grade = Integer.parseInt(schoolInfoGradeText.getText());
			school.setGrade(grade);
		}
		return school;
	}

	private EmergencyContact getContactInfoFromText() {
		EmergencyContact emgContact = new EmergencyContact();
		emgContact.setName(emergencyContactNameText.getText());
		emgContact.setSurname(emergencyContactSurnameText.getText());
		emgContact.setPhone(emergencyContactPhoneText.getText());
		return emgContact;
	}

	private Student getStudentInfoFromText() throws ParseException {
		Student student = new Student();
		if (birthdayDateChooser.getDate() == null) {
			student.setBirthday(null);
		} else {
			Date birthdate = new java.sql.Date(birthdayDateChooser.getDate()
					.getTime());
			student.setBirthday(birthdate);
		}
		student.setName(personalInfoNameText.getText());
		student.setSurname(personalInfoSurnameText.getText());
		student.setEmail(personalInfoMailText.getText());
		student.setGender(personalInfoGenderComboBox.getSelectedItem()
				.toString());
		student.setTC(personalInfoTCText.getText());
		student.setPhone(personalInfoPhoneText.getText());

		return student;
	}

	private boolean checkPersonalInfoEmpty() {
		return personalInfoNameText.getText().isEmpty()
				|| personalInfoSurnameText.getText().isEmpty()
				|| personalInfoPhoneText.getText().isEmpty()
				|| schoolInfoDepartmentText.getText().isEmpty()
				|| emergencyContactNameText.getText().isEmpty()
				|| emergencyContactSurnameText.getText().isEmpty()
				|| emergencyContactPhoneText.getText().isEmpty()
				|| startDateChooser.getDate() == null
				|| endDateChooser.getDate() == null;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JComboBox personalInfoGenderComboBox;
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
	private javax.swing.JPanel studentWindowMainPanel;
	private javax.swing.JPanel studentWindowSubPanel;
	private javax.swing.JPanel personalInfoPanel;
	private javax.swing.JPanel emergencyContactPanel;
	private javax.swing.JPanel schoolInfoPanel;
	private javax.swing.JPanel accoInfoPanel;
	private javax.swing.JTextField schoolInfoUniversityText;
	private javax.swing.JTextField schoolInfoDepartmentText;
	private javax.swing.JTextField schoolInfoGradeText;
	private javax.swing.JTextField emergencyContactNameText;
	private javax.swing.JTextField emergencyContactSurnameText;
	private javax.swing.JTextField emergencyContactPhoneText;
	private javax.swing.JComboBox accoInfoDormComboBox;
	private javax.swing.JTextField personalInfoMailText;
	private javax.swing.JTextField personalInfoNameText;
	private javax.swing.JTextField personalInfoPhoneText;
	private javax.swing.JComboBox accoInfoRoomComboBox;
	private javax.swing.JButton accoInfoAddButton;
	private javax.swing.JTextField personalInfoSurnameText;
	private javax.swing.JTextField personalInfoTCText;
	private JDateChooser birthdayDateChooser, startDateChooser, endDateChooser;
}
