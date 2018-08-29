<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>TestResultScreen</title>
</head>
<body>
<h1>选择生成的测试结果分析图</h1>
<hr color="yellow">
<FORM  id="fm" ACTION="/ZqStatBugProject/StatServlet" METHOD=POST>
	<INPUT TYPE="radio" NAME="stat" VALUE="module" CHECKED>按模块统计<br/><br/>
	<INPUT TYPE="radio" NAME="stat" VALUE="slevel" CHECKED>按严重级别统计<br/><br/>
	<INPUT TYPE="radio" NAME="stat" VALUE="priority" CHECKED>按优先级统计<br/><br/>
	<INPUT TYPE="radio" NAME="stat" VALUE="bugstatus" CHECKED>按bug状态统计<br/><br/>
	<INPUT TYPE="radio" NAME="stat" VALUE="activatecount" CHECKED>按激活数量统计<br/><br/>
	<INPUT TYPE="radio" NAME="stat" VALUE="solver" CHECKED>按解决者解决数量统计<br/><br/>
	<INPUT TYPE="radio" NAME="stat" VALUE="creatortime" CHECKED>按创建时间bug数量统计<br/><br/>
	<INPUT TYPE="radio" NAME="stat" VALUE="designatetime" CHECKED>按解决时间bug数量统计<br/><br/>
	<INPUT TYPE="radio" NAME="stat" VALUE="bugtype" CHECKED>按bug类型统计<br/><br/>
	
	<INPUT TYPE="submit" VALUE="生成统计结果">
	<hr color="yellow">
</FORM>
<a href="index.jsp">返回首页</a>
</body>
</html>