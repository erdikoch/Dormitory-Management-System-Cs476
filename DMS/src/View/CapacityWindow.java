package view;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import background.Dorm;

public class CapacityWindow extends ApplicationFrame {
	private Dorm dorm;

	public CapacityWindow(String title, Dorm dorm) {
		super(title);
		this.dorm = dorm;

		setTitle("Dorm Capacity");
		setContentPane(createDemoPanel(dorm));
	}

	private static PieDataset createDataset(Dorm dorm) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Filled Dorm Space", new Double(
				getFilledStudentsSize(dorm)));
		dataset.setValue("Dorm Empty Spaces", new Double(getEmptySpaces(dorm)));
		return dataset;
	}

	private static String getEmptySpaces(Dorm dorm) {
		int emptySpace = dorm.getDormSize() - dorm.getFilledDormSize();

		return Integer.toString(emptySpace);
	}

	private static String getFilledStudentsSize(Dorm dorm) {

		return Integer.toString(dorm.getFilledDormSize());
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
