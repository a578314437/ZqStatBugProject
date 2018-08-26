package cn.lixing.stat.db.Object;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class JFreeChartObject {
	private static JFreeChart chart;
	
	public static JFreeChart getPieChar(DefaultPieDataset data,String title) {
		chart=ChartFactory.createPieChart3D(title,data,true,false,false);
		chart.getTitle().setFont(new Font("闅朵功", Font.BOLD, 25));
		chart.getLegend().setItemFont(new Font("闅朵功", Font.BOLD, 10));
		PiePlot3D plot=(PiePlot3D)chart.getPlot();
		plot.setLabelFont(new Font("闅朵功", Font.BOLD, 10));
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));
		return chart;
	}
	
	public static JFreeChart getLineChart(CategoryDataset data,String title,String x,String y) {
		// 创建JFreeChart对象：ChartFactory.createLineChart
		JFreeChart chart = ChartFactory.createLineChart(title, // 标题
				x, // categoryAxisLabel （category轴，横轴，X轴标签）
				y, // valueAxisLabel（value轴，纵轴，Y轴的标签）
				data, // dataset
				PlotOrientation.VERTICAL, true, // legend
				false, // tooltips
				false); // URLs
		chart.getTitle().setFont(new Font("闅朵功", Font.BOLD, 10));
		chart.getLegend().setItemFont(new Font("闅朵功", Font.BOLD, 10));
		// 使用CategoryPlot设置各种参数。以下设置可以省略。
		CategoryPlot plot = (CategoryPlot)chart.getPlot();
		plot.setNoDataMessageFont(new Font("闅朵功", Font.BOLD, 10));
		// 背景色 透明度
		plot.setBackgroundAlpha(0.5f);
		// 前景色 透明度
		plot.setForegroundAlpha(0.5f);
		// 设置X轴
		CategoryAxis domainAxis = plot.getDomainAxis();   
        domainAxis.setLabelFont(new Font("宋书", Font.PLAIN, 15)); // 设置横轴字体
        domainAxis.setTickLabelFont(new Font("宋书", Font.PLAIN, 15));// 设置坐标轴标尺值字体
        domainAxis.setLowerMargin(0.01);// 左边距 边框距离
        domainAxis.setUpperMargin(0.06);// 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。
        domainAxis.setMaximumCategoryLabelLines(10);
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);// 横轴 lable 的位置 横轴上的 Lable 45度倾斜 DOWN_45
		
        // 设置Y轴
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("宋书", Font.PLAIN, 15)); 
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//Y轴显示整数
        rangeAxis.setAutoRangeMinimumSize(1);   //最小跨度
        rangeAxis.setUpperMargin(0.18);//上边距,防止最大的一个数据靠近了坐标轴。   
        rangeAxis.setLowerBound(0);   //最小值显示0
        rangeAxis.setAutoRange(false);   //不自动分配Y轴数据
        rangeAxis.setTickMarkStroke(new BasicStroke(1.6f));     // 设置坐标标记大小
        rangeAxis.setTickMarkPaint(Color.BLACK);     // 设置坐标标记颜色
        rangeAxis.setTickUnit(new NumberTickUnit(1));//每10个刻度显示一个刻度值
        
		// 其他设置 参考 CategoryPlot类
		LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();
		
		renderer.setBaseShapesVisible(true); // series 点（即数据点）可见
		renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
		renderer.setUseSeriesOffset(true); // 设置偏移量
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		return chart;
	}
}
