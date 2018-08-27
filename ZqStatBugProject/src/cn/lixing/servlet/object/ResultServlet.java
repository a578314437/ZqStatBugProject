package cn.lixing.servlet.object;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static cn.lixing.stat.db.uilts.SelectResultDataUilts.*;

public class ResultServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<Object, List<List<Object>>>resultMap=new HashMap<>();
		String s1=req.getParameter("s1");
		String s2=req.getParameter("s2");
		System.out.println("s1:"+s1+" s2:"+s2);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		PrintWriter out = new PrintWriter(resp.getWriter());
		resultMap=select("zq_bug_info", s1, s2);
		out.print("<html>");
		out.print("<head>");
		out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		out.print("<style type=\"text/css\"> \r\n" + 
				".table \r\n" + 
				"{ \r\n" + 
				"width: 100%; \r\n" + 
				"padding: 0; \r\n" + 
				"margin: 0; \r\n" + 
				"} \r\n" + 
				"th { \r\n" + 
				"font: bold 12px \"Trebuchet MS\", Verdana, Arial, Helvetica, sans-serif; \r\n" + 
				"color: #4f6b72; \r\n" + 
				"border-right: 1px solid #C1DAD7; \r\n" + 
				"border-bottom: 1px solid #C1DAD7; \r\n" + 
				"border-top: 1px solid #C1DAD7; \r\n" + 
				"letter-spacing: 2px; \r\n" + 
				"text-transform: uppercase; \r\n" + 
				"text-align: left; \r\n" + 
				"padding: 6px 6px 6px 12px; \r\n" + 
				"background: #CAE8EA no-repeat; \r\n" + 
				"} \r\n" + 
				"td { \r\n" + 
				"border-right: 1px solid #C1DAD7; \r\n" + 
				"border-bottom: 1px solid #C1DAD7; \r\n" + 
				"background: #fff; \r\n" + 
				"font-size:14px; \r\n" + 
				"padding: 6px 6px 6px 12px; \r\n" + 
				"color: #4f6b72; \r\n" + 
				"} \r\n" + 
				"td.alt { \r\n" + 
				"background: #F5FAFA; \r\n" + 
				"color: #797268; \r\n" + 
				"} \r\n" + 
				"th.spec,td.spec { \r\n" + 
				"border-left: 1px solid #C1DAD7; \r\n" + 
				"} \r\n" + 
				"/*---------for IE 5.x bug*/ \r\n" + 
				"html>body td{ font-size:14px;} \r\n" + 
				"tr.select th,tr.select td \r\n" + 
				"{ \r\n" + 
				"background-color:#CAE8EA; \r\n" + 
				"color: #797268; \r\n" + 
				"} \r\n" + 
				"</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1 align=\"center\">筛选结果</h1>");
		out.print("<hr color=\"yellow\">");
		out.print("<table align=\"center\">");
		out.println("<tr>");
		out.println("<td>bug标题</td>");
		out.println("<td>指派给</td>");
		out.println("<td>指派时间</td>");
		out.println("<td>严重程度</td>");
		out.println("<td>优先级</td>");
		out.println("</tr>");
		for(Object objKey:resultMap.keySet()) {
			for(int i=0;i<resultMap.get(objKey).size();i++) {
				for(int j=0;j<resultMap.get(objKey).get(i).size();) {
					out.println("<td><p>"+resultMap.get(objKey).get(i).get(0)+"</td>");
					out.println("<td><p>"+resultMap.get(objKey).get(i).get(1)+"</td>");
					out.println("<td><p>"+resultMap.get(objKey).get(i).get(2)+"</td>");
					out.println("<td><p>"+resultMap.get(objKey).get(i).get(3)+"</td>");
					out.println("<td><p>"+resultMap.get(objKey).get(i).get(4)+"</td>");
					out.println("</tr>");
					break;
				}
			}
		}
		out.print("</table>");
		out.print("<a href=\"index.jsp\">返回首页</a>");
		out.print("</body>");
		out.print("</html>");
	}
}
