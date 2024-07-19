package inputUtility;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ChartMaker {

	public static JFreeChart createChart(String ChartTitle, String Sentakushi_A, String Sentakushi_B, String Sentakushi_C, String Sentakushi_D, int Vote_A, int Vote_B, int Vote_C, int Vote_D){
		//このメソッドは使わない
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue(Sentakushi_A, Vote_A);
		data.setValue(Sentakushi_B, Vote_B);
		data.setValue(Sentakushi_C, Vote_C);
		data.setValue(Sentakushi_D, Vote_D);
		
		JFreeChart chart = ChartFactory.createPieChart(ChartTitle, data, true, false, false);
		return chart;
	}
}
