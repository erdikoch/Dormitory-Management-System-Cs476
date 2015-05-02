package database;

import java.sql.CallableStatement;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//I hate imports
import view.DormListWindow;
import view.DormWindow;
import background.ClosedItem;
import background.DamagedItem;
import background.Dorm;
import background.EmergencyContact;
import background.Hostel;
import background.LostItem;
import background.Payment;
import background.Room;
import background.School;
import background.Student;

public class DBConnection {
	Connection con = null;
	CallableStatement proc_stmt;
	ResultSet rs = null;
	PreparedStatement ps;
	DormWindow dormWin;
	private ArrayList dorms, roomNoList, studentsInRooms;
	private DormListWindow dormListW;
	private ArrayList<String> student;
	ArrayList<String> lostName = null, lostStatus = null, damagedName = null,
			damagedStatus = null;
	ArrayList<Integer> lostId = null, damagedId = null;

	public DBConnection() {

	}

	public Connection connect() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:sqlserver://192.168.230.1:1433;instance=MSSQLSERVER;DatabaseName=DormManagement";
		con = DriverManager.getConnection(url, "sa", "123456");
		return con;
	}

	public int getDormCapacity(Dorm dorm) throws SQLException {
		int capacity = 0;
		connect();
		proc_stmt = con.prepareCall("{ call Get_DormCapacity(?) }");

		proc_stmt.setString(1, dorm.getDormName());

		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			capacity = rs.getInt(1);
		}

		return capacity;
	}

	public int getFemaleNumber(Dorm dorm) throws SQLException {
		int female = 0;
		connect();
		proc_stmt = con.prepareCall("{ call Get_FemaleNumber(?) }");

		proc_stmt.setString(1, dorm.getDormName());

		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			female = rs.getInt(1);
		}

		return female;
	}

	public int getMaleNumber(Dorm dorm) throws SQLException {
		int male = 0;
		connect();
		proc_stmt = con.prepareCall("{ call Get_MaleNumber(?) }");

		proc_stmt.setString(1, dorm.getDormName());

		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			male = rs.getInt(1);
		}

		return male;
	}

	public boolean insertRoomType(Room room) {
		try {
			proc_stmt = connect().prepareCall("{ call Insert_RoomType(?,?) }");
			proc_stmt.setInt(1, room.getTypeName());
			proc_stmt.setDouble(2, room.getRoomPrice());

			proc_stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateStudentStatusPassive(Student std){
		try {
			proc_stmt = connect().prepareCall("{ call Update_StudentStatus(?,?) }");
			proc_stmt.setString(1, std.getName());
			proc_stmt.setString(2, std.getSurname());

			proc_stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	

	public boolean insertDorm(Dorm dorm) throws SQLException {

		try {
			proc_stmt = connect().prepareCall("{ call Insert_Dorm(?,?) }");
			proc_stmt.setString(1, dorm.getDormName());
			proc_stmt.setString(2, dorm.getLocation());

			proc_stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean insertPayment(Dorm drm, Room room, Student std, Payment pymt) {
		try {
			proc_stmt = connect().prepareCall(
					"{ call Insert_Payment(?,?,?,?,?,?,?) }");
			proc_stmt.setString(1, std.getName());
			proc_stmt.setString(2, std.getSurname());
			proc_stmt.setInt(3, room.getRoomNo());
			proc_stmt.setString(4, drm.getDormName());
			proc_stmt.setString(5, pymt.getPaymentType());
			proc_stmt.setDouble(6, pymt.getRemainingDebt());
			proc_stmt.setDouble(7, pymt.getDisbursement());
			proc_stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int checkStudentIDCounter(Student std) throws SQLException {
		int counter = 0;

		proc_stmt = connect().prepareCall(
				"{ call Get_StudentIDCountForPayment (?,?) }");
		proc_stmt.setString(1, std.getName());
		proc_stmt.setString(2, std.getSurname());

		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			counter = rs.getInt(1);
		}

		return counter;

	}

	public double getRemainingDebt(Student std) throws SQLException {
		double rDebt = 0;

		proc_stmt = connect().prepareCall("{ call Get_RemainingDebt (?,?) }");
		proc_stmt.setString(1, std.getName());
		proc_stmt.setString(2, std.getSurname());

		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			rDebt = rs.getDouble(1);

		}

		return rDebt;

	}

	public ArrayList<String> displayDorm() throws SQLException {
		ArrayList<String> dormList = new ArrayList<String>();
		proc_stmt = connect().prepareCall("{ call Get_Dorm() }");
		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			dormList.add(rs.getString("DormName"));

		}
		return dormList;

	}

	public ArrayList<Integer> displayRoomType() throws SQLException {
		ArrayList<Integer> typeList = new ArrayList<Integer>();
		proc_stmt = connect().prepareCall("{ call Get_RoomType() }");
		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			typeList.add(rs.getInt("TypeName"));

		}
		return typeList;

	}

	public ArrayList<Integer> displayRoomNo(Dorm dorm, Room room)
			throws SQLException {
		ArrayList<Integer> roomNoList = new ArrayList<Integer>();

		proc_stmt = connect().prepareCall("{ call Get_Room(?,?) }");
		proc_stmt.setString(1, dorm.getDormName());
		proc_stmt.setInt(2, room.getTypeName());
		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			roomNoList.add(rs.getInt("RoomNo"));

		}
		return roomNoList;

	}

	public boolean insertRoom(Room room, Dorm dorm) throws SQLException {

		try {
			proc_stmt = connect().prepareCall("{ call Insert_Room(?,?,?) }");
			proc_stmt.setInt(1, room.getRoomNo());
			proc_stmt.setInt(2, room.getTypeName());
			proc_stmt.setString(3, dorm.getDormName());

			proc_stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertLostItem(LostItem item) {
		try {
			proc_stmt = connect().prepareCall(
					"{ call Insert_LostItem(?,?,?,?,?) }");
			proc_stmt.setString(1, item.getLostName());
			proc_stmt.setString(2, item.getLostNote());
			proc_stmt.setDate(3, (Date) item.getLostDate());
			proc_stmt.setString(4, item.getLostStatus());
			proc_stmt.setString(5, item.getLostDorm());
			proc_stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertDamagedItem(DamagedItem item) {
		try {
			proc_stmt = connect().prepareCall(
					"{ call Insert_DamagedItem(?,?,?,?,?) }");
			proc_stmt.setString(1, item.getDamagedName());
			proc_stmt.setString(2, item.getDamagedNote());
			proc_stmt.setDate(3, (Date) item.getDamagedDate());
			proc_stmt.setString(4, item.getDamagedStatus());
			proc_stmt.setString(5, item.getDamagedDorm());
			proc_stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean insertClosedItem(ClosedItem item) {
		try {
			proc_stmt = connect().prepareCall(
					"{ call Insert_ClosedItem(?,?,?,?) }");
			proc_stmt.setString(1, item.getcName());
			proc_stmt.setString(2, item.getcSurname());
			proc_stmt.setInt(3, item.getLostItemId());
			proc_stmt.setDate(4, (Date) item.getClosingDate());
			proc_stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<String> displayStudentNameSurname() throws SQLException {
		ArrayList<String> studentList = new ArrayList<String>();
		Statement st = connect().createStatement();
		String sql = "select StudentName,StudentSurname from Student where Status='Active'";
		rs = st.executeQuery(sql);
		while (rs.next()) {
			String name = rs.getString("StudentName");
			String surname = rs.getString("StudentSurname");
			studentList.add(name + " " + surname);

		}
		return studentList;

	}

	public TableModel getPaymentHistory(Student std) {
		DefaultTableModel paymentModel = new DefaultTableModel();
		paymentModel.fireTableDataChanged();
		fillPaymentModelColumn(paymentModel);
		try {
			proc_stmt = connect().prepareCall("{ call Get_PaymentHistory(?,?) }");
			proc_stmt.setString(1, std.getName());
			proc_stmt.setString(2, std.getSurname());
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
			
				paymentModel.addRow(new Object[] { rs.getObject(1),
						rs.getObject(2), rs.getObject(3), rs.getObject(4),
						rs.getObject(5) });
				
		
				
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return paymentModel;
	}

	private void fillPaymentModelColumn(DefaultTableModel paymentModel) {
		paymentModel.addColumn("Dorm Name");
		paymentModel.addColumn("Room Type");
		paymentModel.addColumn("Payment Type");
		paymentModel.addColumn("Disbursement");
		paymentModel.addColumn("Paid Date");
		
	}

	public TableModel getStudentsForDate(Hostel hostel, Object dorm,
			Object roomNo, Object roomType) {
		DefaultTableModel searchModel = new DefaultTableModel();
		fillModelColumn(searchModel);
		try {
			proc_stmt = connect().prepareCall(
					"{ call Get_StudentsForDate(?,?) }");
			proc_stmt.setDate(1, (Date) hostel.getStartDate());
			proc_stmt.setDate(2, (Date) hostel.getEndDate());
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				if (rs.getObject(1).equals(dorm) && roomNo == null
						&& roomType == null) {
					searchModel.addRow(new Object[] { rs.getObject(1),
							rs.getObject(2), rs.getObject(3), rs.getObject(4),
							rs.getObject(5), rs.getObject(6) });
				}
				if (rs.getObject(7).equals(roomType)
						&& rs.getObject(1).equals(dorm) && roomNo == null) {
					searchModel.addRow(new Object[] { rs.getObject(1),
							rs.getObject(2), rs.getObject(3), rs.getObject(4),
							rs.getObject(5), rs.getObject(6) });
				}
				if (rs.getObject(7).equals(roomType) && roomNo == null
						&& dorm == null) {
					searchModel.addRow(new Object[] { rs.getObject(1),
							rs.getObject(2), rs.getObject(3), rs.getObject(4),
							rs.getObject(5), rs.getObject(6) });
				}
				if (rs.getObject(2).equals(roomNo)) {
					searchModel.addRow(new Object[] { rs.getObject(1),
							rs.getObject(2), rs.getObject(3), rs.getObject(4),
							rs.getObject(5), rs.getObject(6) });
				}
				if (dorm == null && roomType == null) {
					searchModel.addRow(new Object[] { rs.getObject(1),
							rs.getObject(2), rs.getObject(3), rs.getObject(4),
							rs.getObject(5), rs.getObject(6) });
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchModel;
	}

	private void fillModelColumn(DefaultTableModel searchModel) {
		searchModel.addColumn("Dorm");
		searchModel.addColumn("Room");
		searchModel.addColumn("Name");
		searchModel.addColumn("Surname");
		searchModel.addColumn("Start Date");
		searchModel.addColumn("End Date");
	}

	public int GetStudentNumber(Hostel hostel, Dorm dorm, Room room)
			throws SQLException {
		int studentNumber = 0;
		connect();
		proc_stmt = con
				.prepareCall("{ call Get_StudentBetweenStartEndDate(?,?,?,?) }");
		proc_stmt.setDate(1, (Date) hostel.getStartDate());
		proc_stmt.setDate(2, (Date) hostel.getEndDate());
		proc_stmt.setString(3, dorm.getDormName());
		proc_stmt.setInt(4, room.getRoomNo());
		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			studentNumber = rs.getInt(1);
		}
		return studentNumber;
	}

	public boolean insertStudent(Student st, EmergencyContact ec, School sc,
			Dorm dorm, Room room, Hostel hostel) throws SQLException {
		connect();
		try {
			proc_stmt = con
					.prepareCall("{ call Insert_Student(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			proc_stmt.setString(1, sc.getUniName());
			proc_stmt.setString(2, sc.getDepartment());
			proc_stmt.setInt(3, sc.getGrade());
			proc_stmt.setString(4, ec.getName());
			proc_stmt.setString(5, ec.getSurname());
			proc_stmt.setString(6, ec.getPhone());
			proc_stmt.setString(7, st.getName());
			proc_stmt.setString(8, st.getSurname());
			proc_stmt.setString(9, st.getEmail());
			proc_stmt.setString(10, st.getPhone());
			proc_stmt.setString(11, st.getGender());
			proc_stmt.setString(13, st.getTC());
			proc_stmt.setDate(12, (Date) st.getBirthday());
			proc_stmt.setString(14, dorm.getDormName());
			proc_stmt.setInt(15, room.getRoomNo());
			proc_stmt.setDate(16, (Date) hostel.getStartDate());
			proc_stmt.setDate(17, (Date) hostel.getEndDate());

			proc_stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Room getPaymentInfo(String name, String surname) {
		Room room = new Room();
		try {
			connect();
			proc_stmt = con.prepareCall("{ call Get_PaymentInfo(?,?) }");
			proc_stmt.setString(1, name);
			proc_stmt.setString(2, surname);
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				room.setRoomPrice(rs.getDouble(1));
				room.setMonthDiff(rs.getInt(2));
				room.setTotalDebt(rs.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return room;
	}

	public Payment getRemainingDebt(String name, String surname) {
		Payment pymt = new Payment();
		try {
			proc_stmt = con.prepareCall("{ call Get_RemainingDebt(?,?) }");
			proc_stmt.setString(1, name);
			proc_stmt.setString(2, surname);
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				pymt.setRemainingDebt(rs.getDouble(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pymt;
	}

	public void getRemainingDebt() {

	}

	public boolean updateStudent(Student std, EmergencyContact emg, Dorm dorm,
			Room room, Hostel host, School sch, String Name, String Surname) {

		try {
			connect();

			proc_stmt = con
					.prepareCall("{ call Update_StudentPersonalInfo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			proc_stmt.setString(1, std.getName());
			proc_stmt.setString(2, std.getSurname());
			proc_stmt.setString(3, Name);
			proc_stmt.setString(4, Surname);
			proc_stmt.setString(5, std.getEmail());
			proc_stmt.setString(6, std.getPhone());
			proc_stmt.setString(7, std.getGender());
			proc_stmt.setDate(8, (Date) std.getBirthday());
			proc_stmt.setString(9, std.getTC());
			proc_stmt.setString(10, emg.getName());
			proc_stmt.setString(11, emg.getSurname());
			proc_stmt.setString(12, emg.getPhone());
			proc_stmt.setString(13, sch.getDepartment());
			proc_stmt.setString(14, sch.getUniName());
			proc_stmt.setInt(15, sch.getGrade());
			proc_stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateHostel(Student std, Dorm dorm, Room room, Hostel host) {

		try {
			connect();

			proc_stmt = con
					.prepareCall("{ call Update_Hostel(?,?,?,?,?,?,?) }");

			proc_stmt.setString(1, std.getName());
			proc_stmt.setString(2, std.getSurname());
			proc_stmt.setDate(3, (Date) host.getStartDate());
			proc_stmt.setDate(4, (Date) host.getEndDate());
			proc_stmt.setString(5, dorm.getDormName());
			proc_stmt.setInt(6, room.getTypeName());
			proc_stmt.setInt(7, room.getRoomNo());

			proc_stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void retrieveDormInfo() {
		PreparedStatement pstmt = null;
		try {
			dorms = new ArrayList<>();
			pstmt = connect().prepareStatement("select * from Dorm");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				dorms.add(rs.getString("DormName") + " - "
						+ rs.getString("Location"));
			}

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void retrieveRoomNo(String selectedDorm) {
		try {
			PreparedStatement pstmt = null;
			pstmt = connect().prepareStatement(
					"select RoomNo from Room where (select Dorm_ID from Dorm where DormName = '"
							+ selectedDorm + "') = Dorm_ID");
			ResultSet rs = pstmt.executeQuery();
			roomNoList = new ArrayList<>();
			while (rs.next()) {
				roomNoList.add(rs.getString("RoomNo"));
			}
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Integer> retrieveStudentsinRooms(String dormName,
			int roomNo) throws SQLException {
		studentsInRooms = new ArrayList<String>();
		proc_stmt = connect().prepareCall("{ call Get_StudentsinRoom(?, ?) }");
		proc_stmt.setString(1, dormName);
		proc_stmt.setInt(2, roomNo);
		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			String stdName = rs.getString("StudentName");
			String stdSurname = rs.getString("StudentSurname");
			studentsInRooms.add(stdName + " " + stdSurname);
		}
		return studentsInRooms;
	}

	public Student retrieveStudentInfo(String name, String surname) {

		student = new ArrayList<String>();

		Student std = new Student();
		try {
			proc_stmt = connect().prepareCall("{ call Get_StudentInfo(?, ?) }");
			proc_stmt.setString(1, name);
			proc_stmt.setString(2, surname);
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				String sName = rs.getString("StudentName");
				String sSurname = rs.getString("StudentSurname");
				student.add(sName + " " + sSurname);
				std.setName(rs.getString("StudentName"));
				std.setSurname(rs.getString("StudentSurname"));
				std.setGender(rs.getString("Gender"));
				std.setEmail(rs.getString("Mail"));
				std.setPhone(rs.getString("Phone"));
				std.setTC(rs.getString("TC_ID"));
				std.setBirthday(rs.getDate("Birthdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return std;
	}

	public EmergencyContact retrieveEmergencyInfo(String name, String surname) {
		EmergencyContact emg = new EmergencyContact();
		try {
			proc_stmt = connect().prepareCall("{ call Get_StudentInfo(?, ?) }");
			proc_stmt.setString(1, name);
			proc_stmt.setString(2, surname);
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				emg.setName(rs.getString("Name"));
				emg.setSurname(rs.getString("Surname"));
				emg.setPhone(rs.getString("Phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emg;
	}

	public School retrieveSchoolInfo(String name, String surname) {
		School sch = new School();
		try {
			proc_stmt = connect().prepareCall("{ call Get_StudentInfo(?, ?) }");
			proc_stmt.setString(1, name);
			proc_stmt.setString(2, surname);
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				sch.setUniName(rs.getString("University"));
				sch.setDepartment(rs.getString("DepName"));
				sch.setGrade(rs.getInt("Grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sch;
	}

	public Hostel retrieveHostelInfo(String name, String surname) {
		Hostel host = new Hostel();
		try {
			proc_stmt = connect().prepareCall("{ call Get_StudentInfo(?, ?) }");
			proc_stmt.setString(1, name);
			proc_stmt.setString(2, surname);
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				host.setStartDate(rs.getDate("StartDate"));
				host.setEndDate(rs.getDate("EndDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return host;
	}

	public int getTotalStudenNumberInDorm(Dorm dorm) throws SQLException {
		int totalStudent = 0;
		connect();
		proc_stmt = con.prepareCall("{ call Get_StudentNumberInDorm(?) }");

		proc_stmt.setString(1, dorm.getDormName());

		rs = proc_stmt.executeQuery();
		while (rs.next()) {
			totalStudent = rs.getInt(1);
		}

		return totalStudent;
	}

	public Dorm retrieveDormInfo(String name, String surname) {
		Dorm dorm = new Dorm();
		try {
			proc_stmt = connect().prepareCall("{ call Get_StudentInfo(?, ?) }");
			proc_stmt.setString(1, name);
			proc_stmt.setString(2, surname);
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				dorm.setDormName(rs.getString("DormName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dorm;
	}

	public Room retrieveRoomInfo(String name, String surname) {
		Room room = new Room();
		try {
			proc_stmt = connect().prepareCall("{ call Get_StudentInfo(?, ?) }");
			proc_stmt.setString(1, name);
			proc_stmt.setString(2, surname);
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				room.setTypeName(rs.getInt("TypeName"));
				room.setRoomNo(rs.getInt("RoomNo"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}


	public ArrayList<String> getStudentsInDorm(String dorm) {
		String name, surname = null;
		ArrayList<String> std = new ArrayList<>();
		try {
			proc_stmt = connect().prepareCall("{ call Get_StudentsInDorm(?) }");
			proc_stmt.setString(1, dorm);
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("StudentName");
				surname = rs.getString("StudentSurname");
				std.add(name + " " + surname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return std;
	}

	public void retrieveLostItems() {
		lostId = new ArrayList<Integer>();
		lostName = new ArrayList<String>();
		lostStatus = new ArrayList<String>();
		try {
			proc_stmt = connect().prepareCall("{ call Get_LostItems() }");
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				lostId.add(rs.getInt("LostItem_ID"));
				lostName.add(rs.getString("ItemName"));
				lostStatus.add(rs.getString("Status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void retrieveDamagedItems() {
		damagedId = new ArrayList<Integer>();
		damagedName = new ArrayList<String>();
		damagedStatus = new ArrayList<String>();
		try {
			proc_stmt = connect().prepareCall("{ call Get_DamagedItems() }");
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				damagedId.add(rs.getInt("DamagedItem_ID"));
				damagedName.add(rs.getString("ItemName"));
				damagedStatus.add(rs.getString("Status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDmgItemStatus(Object status) {
		int std = (int) status;
		try {
			proc_stmt = connect().prepareCall(
					"{ call Update_DamagedItemStatus(?) }");
			proc_stmt.setInt(1, std);
			proc_stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public LostItem retreiveLostItemInfo(Object lostId) {
		int id = (int) lostId;
		LostItem item = new LostItem();
		try {
			proc_stmt = connect().prepareCall("{ call Get_LostInfo(?) }");
			proc_stmt.setInt(1, id);
			rs = proc_stmt.executeQuery();
			while (rs.next()) {
				item.setLostName(rs.getString("ItemName"));
				item.setLostNote(rs.getString("Note"));
				item.setLostDate(rs.getDate("Date"));
				item.setLostDorm(rs.getString("DormName"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	public void updateStatus(int id) {
		try {
			proc_stmt = connect().prepareCall(
					"{ call Update_LostItemStatus(?) }");
			proc_stmt.setInt(1, id);
			proc_stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement statement) {

	}

	public static void closeConnection(Connection connection) {

	}

	public ArrayList getDorms() {
		return dorms;
	}

	public ArrayList<String> getRoomNoList() {
		return roomNoList;
	}

	public ArrayList<String> getStudent() {
		return student;
	}

	public ArrayList<String> getLostName() {
		return lostName;
	}

	public ArrayList<String> getLostStatus() {
		return lostStatus;
	}

	public ArrayList<Integer> getLostId() {
		return lostId;
	}

	public ArrayList<String> getDamagedName() {
		return damagedName;
	}

	public ArrayList<String> getDamagedStatus() {
		return damagedStatus;
	}

	public ArrayList<Integer> getDamagedId() {
		return damagedId;
	}

}
