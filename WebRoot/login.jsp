<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>产品管理</title>
<style type="text/css">
<!--
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
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
<link href="css/css.css" rel="stylesheet" type="text/css" />

<script language="JavaScript"  type="text/JavaScript">

function reSet(){
	var id=document.getElementById("id");
	var password=document.getElementById("password");
	/* alert(id.value); */
	id.value="";
	password.value="";
}
function login(){
	var id=document.getElementById("id").value;
	var password=document.getElementById("password").value;
	window.location.href=
			"<%=path%>/ProductServlet?method=loginServlet&id="+id+"&password="+password; 
}
</script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
     <td height="147" ><img src="images/logo-201305-b.png" width="500" height="100"  /><img src="images/jinggao.jpg"  height="100"  /></td>
  </tr>
</table>
<table background="images/che.jpg" width="500" height="260" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><!-- <img src="images/ico13.gif" width="107" height="97" /> --></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><!-- <img src="images/line01.gif" width="5" height="292" /> --></td>
      </tr>
    </table></td>
    
    
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">用户名：<br /></td>
        <td width="69%"><input id="id" name="id" type="text" size="30" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密　码：<br /></td>
        <td><input id="password" name="password" type="text" size="30" /></td>
      </tr>
     
      <!--  tr>
        <td height="35" class="login-text02">验证图片：<br /></td>
        <td><img src="images/pic05.gif" width="109" height="40" /> <a href="#" class="login-text03">看不清楚，换张图片</a></td>
      </tr>-->
      <!-- <tr>
        <td height="35" class="login-text02">请输入验证码：</td>
        <td><input name="textfield3" type="text" size="30" /></td>
      </tr> -->
      <tr>
        <td height="35">&nbsp;</td>
        <td><input name="Submit2" type="submit" class="button button1" value="确认登陆" onclick="login()"/>
          <input name="Submit232" type="reset" class="button button1" value="重 置"  onclick="reSet()"/></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>