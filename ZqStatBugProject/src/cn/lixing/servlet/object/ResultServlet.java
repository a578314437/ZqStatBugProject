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
		out.print("</head>");
		out.print("<body>");
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
					out.println("<td>"+resultMap.get(objKey).get(i).get(0)+"</td>");
					out.println("<td>"+resultMap.get(objKey).get(i).get(1)+"</td>");
					out.println("<td>"+resultMap.get(objKey).get(i).get(2)+"</td>");
					out.println("<td>"+resultMap.get(objKey).get(i).get(3)+"</td>");
					out.println("<td>"+resultMap.get(objKey).get(i).get(4)+"</td>");
					out.println("</tr>");
					break;
				}
			}
		}
		out.print("</table>");
		out.print("<a href=\"index.jsp\">返回</a>");
		out.print("</body>");
		out.print("</html>");
	}
}
