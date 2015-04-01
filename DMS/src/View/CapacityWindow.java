package view;

import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.text.html.HTMLEditorKit.Parser;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.xml.sax.helpers.ParserFactory;

import background.Dorm;
import background.EmergencyContact;
import background.Hostel;
import background.Room;
import background.School;
import background.Student;
import database.DBConnection;

public class CapacityWindow extends ApplicationFrame {
	private Dorm dorm;
	
	public CapacityWindow(String title,Dorm dorm) {
		super(title);
		
		setTitle("Dorm Capacity");
		setContentPane(createDemoPanel(dorm));
	}

	private static PieDataset createDataset(Dorm dorm) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Filled Dorm Space", new Double(getFilledDormSize(dorm)));
		dataset.setValue("Dorm Empty Spaces", new Double(getDormSize(dorm)));
		return dataset;
	}

	private static String getDormSize(Dorm dorm) {
		// TODO Auto-generated method stub
		String dormSize = Integer.toString(dorm.getDormSize());
		return dormSize;
	}

	private static String getFilledDormSize(Dorm dorm) {
		// TODO Auto-generated method stub
		String filledDormSize = Integer.toString(dorm.getFilledDormSize());
		return filledDormSize;
	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("Dorm Capacity", // chart
				// title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}

	public static JPanel createDemoPanel(Dorm dorm) {
		JFreeChart chart = createChart(createDataset(dorm));
		return new ChartPanel(chart);
	}
}
