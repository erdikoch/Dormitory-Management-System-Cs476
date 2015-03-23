package view;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;

public class EndDatePopup extends javax.swing.JFrame {

	public EndDatePopup() {

		final JFrame endDateFrame = new JFrame();
		endDateFrame.setBounds(117, 27, 246, 229);
		endDateFrame.setVisible(false);
		JCalendar calendar = new JCalendar();
		calendar.setBounds(117, 27, 246, 214);
		endDateFrame.getContentPane().add(calendar);
	}
}
