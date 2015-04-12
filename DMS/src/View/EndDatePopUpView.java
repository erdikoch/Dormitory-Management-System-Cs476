package view;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;

public class EndDatePopUpView extends javax.swing.JFrame {


		private JCalendar calendar;
		
		public EndDatePopUpView() {
		
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
