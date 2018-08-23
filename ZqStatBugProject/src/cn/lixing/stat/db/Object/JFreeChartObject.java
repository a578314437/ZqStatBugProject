package cn.lixing.stat.db.Object;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartObject {
	private static JFreeChart chart;
	
	public static JFreeChart getPieChar(DefaultPieDataset data,String title) {
		chart=ChartFactory.createPieChart3D(title,data,true,false,false);
		chart.getTitle().setFont(new Font("隶书", Font.BOLD, 25));
		chart.getLegend().setItemFont(new Font("隶书", Font.BOLD, 10));
		PiePlot3D plot=(PiePlot3D)chart.getPlot();
		plot.setLabelFont(new Font("隶书", Font.BOLD, 10));
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));
		return chart;
	}
}
