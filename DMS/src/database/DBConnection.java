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

import view.DormListWindow;
import view.DormWindow;
import background.Dorm;
import background.EmergencyContact;
import background.Hostel;
import background.Room;
import background.School;
import background.Student;

public class DBConnection {
	Connection con = null;
	CallableStatement proc_stmt;
	ResultSet rs = null;
	PreparedStatement ps;
	DormWindow dormWin;
	private ArrayList dorms;
	private ArrayList roomNoList;
	private DormListWindow dormListW;
	private ArrayList studentsInRooms;

	public DBConnection() {

	}

	public Connection connect() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:sqlserver://192.168.113.1:1433;instance=MSSQLSERVER;DatabaseName=DormManagement";

		con = DriverManager.getConnection(url, "sa", "cenkerdi752");
		return con;
	}

	public boolean insertRoomType(Room room) {
		try {
			proc_stmt = connect().prepareCall("{ call Insert_RoomType(?,?) }");
			proc_stmt.setInt(1, room.getTypeName());
			proc_stmt.setDouble(2, room.getRoomPrice());
		
			proc_stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

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

	public ArrayList<Integer> displayRoomNo(Dorm dorm,Room room) throws SQLException {
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

	public ArrayList<String> displayStudentNameSurname() throws SQLException {
		ArrayList<String> studenList = new ArrayList<String>();
		Statement st = connect().createStatement();
		String sql = "select StudentName,StudentSurname from Student";
		rs = st.executeQuery(sql);
		while (rs.next()) {
			String name = rs.getString("StudentName");
			String surname = rs.getString("StudentSurname");
			studenList.add(name + " " + surname);

		}
		return studenList;

	}
	public int GetStudentNumber(Hostel hostel,Dorm dorm,Room room) throws SQLException {
		int studentNumber=0;
		connect();
		proc_stmt=con.prepareCall("{ call Get_StudentBetweenStartEndDate(?,?,?,?) }");
		proc_stmt.setDate(1, (Date) hostel.getStartDate() );
		proc_stmt.setDate(2, (Date) hostel.getEndDate());
		proc_stmt.setString(3, dorm.getDormName());
		proc_stmt.setInt(4, room.getRoomNo());
		rs=proc_stmt.executeQuery();
			while(rs.next()){
				studentNumber=rs.getInt(1);
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
			// TODO Auto-generated catch block
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
				dorms.add(rs.getString("DormName") + " - "+ rs.getString("Location"));
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
		for (int i = 0; i < studentsInRooms.size(); i++) {
			System.out.println(studentsInRooms.get(i));
		}
		return studentsInRooms;
	}

	public static void closeStatement(Statement statement) {
		// TODO Auto-generated method stub

	}

	public static void closeConnection(Connection connection) {
		// TODO Auto-generated method stub

	}

	public ArrayList getDorms() {
		return dorms;
	}

	public ArrayList<String> getRoomNoList() {
		return roomNoList;
	}

}
