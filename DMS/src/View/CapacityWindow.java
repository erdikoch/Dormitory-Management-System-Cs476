package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import background.Dorm;

public class CapacityWindow  {
	private Dorm dorm;
	
	public CapacityWindow(Dorm dorm) {
		this.dorm = dorm;
		JFrame capacityFrame = new JFrame("Dorm Capacity");
		capacityFrame.setContentPane(createDemoPanel(dorm));
		capacityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		capacityFrame.setVisible(true);
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
	public static void main(String[] args){
		Dorm dorm = new Dorm();
		dorm.setFilledDormSize(100);
		new CapacityWindow(dorm);
		
	}
}
