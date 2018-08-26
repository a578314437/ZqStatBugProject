package cn.lixing.servlet.object;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import cn.lixing.stat.db.Object.DataSetObject;
import static cn.lixing.stat.db.Object.JFreeChartObject.*;
public class SkipSatServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataSetObject dataObject;
	private JFreeChart chart;
	private DefaultPieDataset data;
	private CategoryDataset createdata;
	private String[] pramas;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dataObject=new DataSetObject();
		String type = req.getParameter("type");
		String prama=(String) this.getServletContext().getAttribute("params");
		pramas=prama.split(",");
		for(int i=0;i<pramas.length;i++) {
			if(type.equals(pramas[i])&&!type.contains("time")) {
				data=dataObject.getPieDataset(type);
				chart=getPieChar(data, type);
				ChartUtilities.writeChartAsPNG(resp.getOutputStream(), chart, 800, 600);
			}else if(type.contains("time")) {
				createdata=dataObject.createDataset(type);
				chart=getLineChart(createdata,type+"统计","日期","bug数量");
				ChartUtilities.writeChartAsPNG(resp.getOutputStream(), chart, 1000, 1000);
			}
		}
	}
}
