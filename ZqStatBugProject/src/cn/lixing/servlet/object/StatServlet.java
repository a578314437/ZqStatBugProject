package cn.lixing.servlet.object;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StatServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] params;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		String param=req.getParameter("stat");
		PrintWriter out = new PrintWriter(resp.getWriter());
		params=((String) this.getServletContext().getAttribute("params")).split(",");
		
		resp.setContentType("text/html");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>"+param+" bugͳ�ƽ��</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<center><H2>"+param+" bugͳ�ƽ��</H2></center>");
		out.println("<P>");
		out.println(param+" ͳ�ƽ����ͼ��ʾ:");
		out.println("</P>");
		out.println("<center><IMG SRC=\"SkipSatServlet?type="+ param + "\" BORDER=1 WIDTH=800 HEIGHT=600/></center>");
		for(int i=0;i<params.length;i++) {
			if(param.equals(params[i])) {
				out.println("<div><h1>"+param+"���Ա���</h1></div>");
			}
		}
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
	}
}
