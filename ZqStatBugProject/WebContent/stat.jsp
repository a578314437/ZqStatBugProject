<%@page import="java.util.Date"%>
<%@page import="cn.lixing.stat.db.Object.DataSetObject"%>
<%@page import="org.jfree.chart.ChartUtilities"%>
<%@page import="org.jfree.data.general.DefaultPieDataset"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="static cn.lixing.stat.db.Object.JFreeChartObject.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%String param = request.getParameter("stat");
request.setCharacterEncoding("utf-8");
response.setContentType("image/png");
DataSetObject dataObject;
DefaultPieDataset data;
JFreeChart chart;
dataObject=new DataSetObject();
data=dataObject.getPieDataset(param);
chart=getPieChar(data, "统计结果");
ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 600, 400);
out.clear();
out=pageContext.pushBody();
%>
<p><%=param%></p>
</body>
</html>