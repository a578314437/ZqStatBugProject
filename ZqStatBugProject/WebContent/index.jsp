<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>TestResult</title>
</head>
<body>
<h1>zq测试总结报告</h1>
<FORM  id="fm" ACTION="/ZqStatBugProject/StatServlet" METHOD=POST>
	<INPUT TYPE="radio" NAME="stat" VALUE="module" CHECKED>按模块统计
	<INPUT TYPE="radio" NAME="stat" VALUE="slevel" CHECKED>按严重级别统计
	<INPUT TYPE="radio" NAME="stat" VALUE="priority" CHECKED>按优先级统计
	<INPUT TYPE="radio" NAME="stat" VALUE="bugstatus" CHECKED>按bug状态统计
	<INPUT TYPE="radio" NAME="stat" VALUE="activatecount" CHECKED>按激活数量统计
	<INPUT TYPE="radio" NAME="stat" VALUE="solver" CHECKED>按解决者解决数量统计
	<INPUT TYPE="radio" NAME="stat" VALUE="creatortime" CHECKED>按创建时间bug数量统计
	<INPUT TYPE="radio" NAME="stat" VALUE="designatetime" CHECKED>按解决时间bug数量统计
<INPUT TYPE="submit" VALUE="生成统计结果">
</FORM>
<div></div>
</body>
<script type="text/javascript">
	document.getElementById('fm').style.display='none';
	//获取表单并付给数组
	var list=document.getElementsByName("stat");
	var strData="";
	//对表单中所有的input进行遍历
	for(var i=0;i<list.length && list[i];i++)
	{ 
	 strData +=list[i].value+",";
	
	 document.getElementsByTagName('div')[0].innerHTML="<a href=/ZqStatBugProject/SummarizeServlet?p="+strData+">查看bug概述</a>";
	 //document.write("<a href=stat.jsp?p="+strData+"></a>")
	 //this.location.href="stat.jsp?p=";
	}
	//alert(strData);

</script>
</html>