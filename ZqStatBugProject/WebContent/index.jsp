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
<hr color="yellow">
<FORM  id="fm" ACTION="/ZqStatBugProject/StatServlet" METHOD=POST>
	<INPUT TYPE="radio" NAME="stat" VALUE="module" CHECKED>按模块统计
	<INPUT TYPE="radio" NAME="stat" VALUE="slevel" CHECKED>按严重级别统计
	<INPUT TYPE="radio" NAME="stat" VALUE="priority" CHECKED>按优先级统计
	<INPUT TYPE="radio" NAME="stat" VALUE="bugstatus" CHECKED>按bug状态统计
	<INPUT TYPE="radio" NAME="stat" VALUE="activatecount" CHECKED>按激活数量统计
	<INPUT TYPE="radio" NAME="stat" VALUE="solver" CHECKED>按解决者解决数量统计
	<INPUT TYPE="radio" NAME="stat" VALUE="creatortime" CHECKED>按创建时间bug数量统计
	<INPUT TYPE="radio" NAME="stat" VALUE="designatetime" CHECKED>按解决时间bug数量统计
	<INPUT TYPE="radio" NAME="stat" VALUE="bugtype" CHECKED>按解决时间bug数量统计
<INPUT TYPE="submit" VALUE="生成统计结果">
</FORM>
<div>
	<div>
		<dl>
			<dt><h3>bug严重级别定义:</h3></dt>
			<dd><h4>致命bug</h4></dd>
			<dd><h4>严重bug</h4></dd>
			<dd><h4>样式bug</h4></dd>
			<dd><h4>建议bug</h4></dd>
		</dl>
		<hr color="yellow">
		<div id="context" align="left">
		定义规则：<br/>
		<p>致命bug(1):直接导致服务器宕机，程序无法继续正常执行的bug，都可以定义为致命bug。<br/>
		<p>严重bug(2):导致程序功能无法正常实现，或者功能实现异常的bug，都可以定义为严重bug。<br/>
		<p>样式bug(3):页面布局不合理，布局错乱，提示信息不合理或没有必要的提示信息，页面显示不符合UI设计，都可以定义为样式bug。<br/>
		<p>建议bug(4):此问题严格来说不属于bug范畴，只是作为建议性的改进，都可以定义为建议bug。<br/>
		</div>
		<hr color="yellow">
		<dl>
			<dt><h3>bug优先级别定义:</h3></dt>
			<dd><h4>紧急优先级别</h4></dd>
			<dd><h4>高优先级别</h4></dd>
			<dd><h4>中优先级别</h4></dd>
			<dd><h4>低优先级别</h4></dd>
		</dl>
		<hr color="yellow">
		<div id="context" align="left">
		定义规则：<br/>
		<p>紧急优先级别(1):bug导致服务器宕机，影响后续的测试工作，无法开展后续的测试工作，页面样式、布局混乱，都可以定义为紧急优先级。<br/>
		<p>高优先级别(2):导致程序功能无法实现，或者功能实现异常的bug都可以定义为高优先级。<br/>
		<p>中优先级别(3):提示信息不准确，不可合理或者在必要的地方无任何提示信息的bug都可以定义为中优先级。<br/>
		<p>低优先级别(4):一些建议性的bug都可以定义为低优先级。<br/>
		</div>
		<hr color="yellow">
	</div>
	
</div>
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
	
	 document.getElementsByTagName('div')[4].innerHTML="<a href=/ZqStatBugProject/SummarizeServlet?p="+strData+">查看bug概述</a>";
	 //document.write("<a href=stat.jsp?p="+strData+"></a>")
	 //this.location.href="stat.jsp?p=";
	}
	
	//alert(strData);

</script>
</html>