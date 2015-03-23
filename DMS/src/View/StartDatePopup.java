package view;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;

public class StartDatePopup extends javax.swing.JFrame {

	public StartDatePopup() {

		final JFrame startDateFrame = new JFrame();
		startDateFrame.setBounds(117, 27, 246, 229);
		startDateFrame.setVisible(false);
		JCalendar calendar = new JCalendar();
		calendar.setBounds(117, 27, 246, 214);
		startDateFrame.getContentPane().add(calendar);
	}
}
