package view;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import database.DBConnection;
import background.Dorm;

public class CapacityWindow {
	private Dorm dorm;
	private DBConnection connection;

	public CapacityWindow(Dorm dorm) throws SQLException {
		super();
		this.dorm = dorm;
		connection = new DBConnection();
		// connection.connect();
		JFrame capacityFrame = new JFrame("Dorm Capacity");
		String dormName = dorm.getDormName();
		capacityFrame.setBounds(0, 0, 500, 300);
		capacityFrame.setContentPane(createDemoPanel(dorm,
				connection.getDormCapacity(dorm),
				connection.getTotalStudenNumberInDorm(dorm)));
		capacityFrame.setVisible(true);
	}

	private static PieDataset createDataset(Dorm dorm, int capacity,
			int totalStudentNumberInDorm) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Filled Dorm Space", new Double(
				totalStudentNumberInDorm));
		dataset.setValue("Dorm Empty Spaces", new Double(capacity));
		return dataset;
	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("Dorm Capacity", // chart
				// title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}

	public static JPanel createDemoPanel(Dorm dorm, int capacity,
			int totalStudentNumberInDorm) {
		JFreeChart chart = createChart(createDataset(dorm, capacity,
				totalStudentNumberInDorm));
		return new ChartPanel(chart);
	}
}