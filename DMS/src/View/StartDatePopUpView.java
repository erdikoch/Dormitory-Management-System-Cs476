package view;

import java.awt.Container;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JCalendar;

public class StartDatePopUpView extends javax.swing.JFrame  {
	private JCalendar calendar;
	public StartDatePopUpView() {
	
	calendar = new JCalendar();
	setBounds(117, 27, 450, 450);
	getContentPane().add(calendar);
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	calendar.setDate(calendar.getDate());

	
	}
	public String getCalendar() {
		return calendar.getDate().toString();
	}
	
}
