<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@   page   contentType="text/html;charset=utf-8"   %>   
<% request.setCharacterEncoding("utf-8");%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>main</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}


function link(){
alert('保存成功！');
    document.getElementById("fom").action="xuqiumingxi.htm";
   document.getElementById("fom").submit();
}



</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 5px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  margin: 4px 2px;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
}

.button1 {
  background-color: white;
  color: black;
  border: 2px solid #4CAF50;
}

.button1:hover {
  background-color: #4CAF50;
  color: white;
}
</style>
</head>

<body class="ContentBody"
  background="../images/fgo.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;"
>
  <form action="<%=path%>/ProductServlet" method="post"  name="fom" id="fom" >
<div class="MainDiv">

<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >编辑产品信息页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
	<!-- 	<tr><td align="left">
		<input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr> -->

		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>编辑产品</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 <input type="hidden" name="method" value="editoperation">
					  <tr>
					    <td nowrap align="right" width="13%">产品编号:</td>
					    <td width="41%"><input name="pid" id="pid" class="text" style="width:250px" type="text" readonly="readonly" value="${product.pid}"/>
				        <span class="red"> *</span></td>
					    <td align="right" width="19%">产品名称:</td>
					    <td width="27%"><input name="pname" id="pname"  style="width:154px" type="text" value="${product.pname}"/></td>
					    </tr>
					  <tr>
					    <td nowrap align="right">范围编号:</td>
					    <td><input name="category" id="category" type="text" style="width:50px"  value="${product.category}"/>
					    </td>
					    <td align="right">单价:</td>
					    <td><input name="pprize" id="pprize" class="text" style="width:154px" value="${product.pprize}"/></td>
					  </tr>
					   <tr>
					    <td nowrap align="right">注册日期:</td>
					     <td><input name="rigdate" id="rigdate" class="text" style="width:154px" value="${product.rigdate}"/></td>
					    
					  </tr>
					  <tr>
					    <td nowrap align="right">产品说明:</td>
					     <td><input name="introduction" id="introduction" class="text" style="width:154px" value="${product.introduction}"/></td>
					    
					  </tr>
					  </table>
			 <br />
				</fieldset>			</TD>
		</TR>
		
		</TABLE>
	
	
	 </td>
  </tr>
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" class="button button1" value="保存" />　
			
			<input type="reset" name="Submit2"class="button button1"  value="返回" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	 </td>
  </tr>
  </table>
</div>
</form>
</body>
</html>