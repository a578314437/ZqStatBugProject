<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form name="frm" action="index.jsp">
<select name="s1" onChange="redirec(document.frm.s1.options.selectedIndex)">
<option selected>请选择</option>
<option value="脚本语言">脚本语言</option>
<option value="高级语言">高级语言</option>
<option value="其他语言">其他语言</option>
</select>

<select name="s2">
<option  selected>请选择</option>
</select>


<input type="submit">
</form>
<script language="javascript" >
//获取一级菜单长度
var select1_len = document.frm.s1.options.length;
var select2 = new Array(select1_len);
//把一级菜单都设为数组
for (i=0; i<select1_len; i++)
{ select2[i] = new Array();}
//定义基本选项
select2[0][0] = new Option("请选择", " ");

select2[1][0] = new Option("PHP", " ");
select2[1][1] = new Option("ASP", " ");
select2[1][2] = new Option("JSP", " ");

select2[2][0] = new Option("C/C++", " ");
select2[2][1] = new Option("Java", " ");
select2[2][2] = new Option("C#", " ");

select2[3][0] = new Option("Perl", " ");
select2[3][1] = new Option("Ruby", " ");
select2[3][2] = new Option("Python", " ");
//联动函数
function redirec(x)
{
var temp = document.frm.s2;
for (i=0;i<select2[x].length;i++)
{ temp.options[ i]=new Option(select2[x][i].text,select2[x][i].value);}
temp.options[0].selected=true;
}
</script>
</body>
</html>