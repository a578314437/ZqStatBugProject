package cn.lixing.servlet.object;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dataObject=new DataSetObject();
		String type = req.getParameter("type");
		System.out.println(type);
		if(type.equals("module")||
		   type.equals("slevel")||
		   type.equals("priority")||
		   type.equals("bugstatus")||
		   type.equals("activatecount")||
		   type.equals("solver")
				) {
			data=dataObject.getPieDataset(type);
			chart=getPieChar(data, type);
			ChartUtilities.writeChartAsPNG(resp.getOutputStream(), chart, 800, 600);
		}
	}
}
