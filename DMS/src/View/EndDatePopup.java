package view;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;
import java.awt.Toolkit;

public class EndDatePopup  extends javax.swing.JFrame {

	public EndDatePopup() {

		JCalendar endCalendar = new JCalendar();
		endCalendar.setBounds(117, 27, 246, 214);
		endCalendar.setVisible(true);
	
	}
}
