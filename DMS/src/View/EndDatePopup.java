package view;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;
import java.awt.Toolkit;

public class EndDatePopup extends javax.swing.JFrame {

	public EndDatePopup() {

		final JFrame endDateFrame = new JFrame();
		endDateFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u0130smetcan Herg\u00FCn\u015Fen\\Desktop\\dorm.png"));
		endDateFrame.setBounds(117, 27, 246, 229);
		endDateFrame.setVisible(false);
		JCalendar calendar = new JCalendar();
		calendar.setBounds(117, 27, 246, 214);
		endDateFrame.getContentPane().add(calendar);
	}
}
