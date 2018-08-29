<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>resultSummarize</title>
</head>
<body>
<h1>zq测试结果报告概况</h1>
<hr color="yellow">
<h5>bug类型筛选：</h5>
<form name="frm" action="/ZqStatBugProject/ResultServlet" method="post">
	<select name="s1" onChange="redirec(document.frm.s1.options.selectedIndex)">
		<option selected>请选择</option>
		<option value="bugstatus">按bug状态筛选</option>
		<option value="module">按bug模块筛选</option>
		<option value="slevel">按bug严重程度筛选</option>
		<option value="priority">按bug优先级筛选</option>
	</select><br/><br/>
	<select name="s2">
		<option  selected>请选择</option>
	</select><br/><br/>
	<input type="submit" value="筛选">
</form>
<hr color="yellow">
<script language="javascript" >
	//获取一级菜单长度
	var select1_len = document.frm.s1.options.length;
	var select2 = new Array(select1_len);
	//把一级菜单都设为数组
	for (i=0; i<select1_len; i++)
	{ 	select2[i] = new Array();}
	//定义基本选项
		select2[0][0] = new Option("请选择", " ");
		
		select2[1][0] = new Option("已激活", 0);
		select2[1][1] = new Option("已关闭", 9);
		select2[1][2] = new Option("已解决", 10);
		
		select2[2][0] = new Option("业务管理模块",1);
		select2[2][1] = new Option("码管理模块", 3);
		select2[2][2] = new Option("权限管理模块",5);
		select2[2][3] = new Option("web端后台管理系统", 7);
		
		select2[2][4] = new Option("客户经理端",2);
		select2[2][5] = new Option("技术人员端", 4);
		select2[2][6] = new Option("关键人端",6);
		select2[2][7] = new Option("装维端", 8);
		
		select2[3][0] = new Option("致命bug", 1);
		select2[3][1] = new Option("严重bug", 2);
		select2[3][2] = new Option("样式bug", 3);
		select2[3][3] = new Option("建议", 4);
		
		select2[4][0] = new Option("紧急优先级", 1);
		select2[4][1] = new Option("高优先级", 2);
		select2[4][2] = new Option("中优先级", 3);
		select2[4][3] = new Option("低优先级", 4);
	//联动函数
	function redirec(x)
	{
	var temp = document.frm.s2;
	for (i=0;i<select2[x].length;i++)
	{ 	temp.options[ i]=new Option(select2[x][i].text,select2[x][i].value);
	}
		temp.options[0].selected=true;
	}
</script>


<p><a href="resultMap.jsp">进入到结果分析页面</a></p>
</body>
</html>