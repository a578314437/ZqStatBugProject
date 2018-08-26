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
		chart.getTitle().setFont(new Font("隶书", Font.BOLD, 25));
		chart.getLegend().setItemFont(new Font("隶书", Font.BOLD, 10));
		PiePlot3D plot=(PiePlot3D)chart.getPlot();
		plot.setLabelFont(new Font("隶书", Font.BOLD, 10));
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));
		return chart;
	}
	
	public static JFreeChart getLineChart(CategoryDataset data,String title,String x,String y) {
		// ����JFreeChart����ChartFactory.createLineChart
		JFreeChart chart = ChartFactory.createLineChart(title, // ����
				x, // categoryAxisLabel ��category�ᣬ���ᣬX���ǩ��
				y, // valueAxisLabel��value�ᣬ���ᣬY��ı�ǩ��
				data, // dataset
				PlotOrientation.VERTICAL, true, // legend
				false, // tooltips
				false); // URLs
		chart.getTitle().setFont(new Font("隶书", Font.BOLD, 10));
		chart.getLegend().setItemFont(new Font("隶书", Font.BOLD, 10));
		// ʹ��CategoryPlot���ø��ֲ������������ÿ���ʡ�ԡ�
		CategoryPlot plot = (CategoryPlot)chart.getPlot();
		plot.setNoDataMessageFont(new Font("隶书", Font.BOLD, 10));
		// ����ɫ ͸����
		plot.setBackgroundAlpha(0.5f);
		// ǰ��ɫ ͸����
		plot.setForegroundAlpha(0.5f);
		// ����X��
		CategoryAxis domainAxis = plot.getDomainAxis();   
        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 15)); // ���ú�������
        domainAxis.setTickLabelFont(new Font("����", Font.PLAIN, 15));// ������������ֵ����
        domainAxis.setLowerMargin(0.01);// ��߾� �߿����
        domainAxis.setUpperMargin(0.06);// �ұ߾� �߿����,��ֹ���ߵ�һ�����ݿ����������ᡣ
        domainAxis.setMaximumCategoryLabelLines(10);
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);// ���� lable ��λ�� �����ϵ� Lable 45����б DOWN_45
		
        // ����Y��
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("����", Font.PLAIN, 15)); 
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//Y����ʾ����
        rangeAxis.setAutoRangeMinimumSize(1);   //��С���
        rangeAxis.setUpperMargin(0.18);//�ϱ߾�,��ֹ����һ�����ݿ����������ᡣ   
        rangeAxis.setLowerBound(0);   //��Сֵ��ʾ0
        rangeAxis.setAutoRange(false);   //���Զ�����Y������
        rangeAxis.setTickMarkStroke(new BasicStroke(1.6f));     // ���������Ǵ�С
        rangeAxis.setTickMarkPaint(Color.BLACK);     // ������������ɫ
        rangeAxis.setTickUnit(new NumberTickUnit(1));//ÿ10���̶���ʾһ���̶�ֵ
        
		// �������� �ο� CategoryPlot��
		LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();
		
		renderer.setBaseShapesVisible(true); // series �㣨�����ݵ㣩�ɼ�
		renderer.setBaseLinesVisible(true); // series �㣨�����ݵ㣩�������߿ɼ�
		renderer.setUseSeriesOffset(true); // ����ƫ����
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		return chart;
	}
}
