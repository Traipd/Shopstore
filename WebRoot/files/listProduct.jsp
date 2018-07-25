<%@ page language="java" import="java.util.*,com.xmx.model.entity.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>产品详情</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
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
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="addrenwu.htm";
   document.getElementById("fom").submit();
}
function deleteUserById(flag){//删除选中的当前选项（可用）
if(window.confirm("是否确认删除编号为:" + flag +"的产品信息?")){
		var url="<%=path%>/ProductServlet?method=delete1&productid="+flag;
		
		window.location.href= url;
	}
}
function editUserById(flag){
	var url="<%=path%>/ProductServlet?method=edit&productid="+flag;
	window.location.href=url;
}

function goToPage(){
	//获取跳转的页面
	var selectedPage =document.getElementById("page").value;
	if(Number(selectedPage)){
		//转到Servlet，获取该页面显示的结果集
		window.location.href=
			"<%=path%>/ProductServlet?method=all&currentpage="+selectedPage; 
	}	
}
function goTofind(){
	var selectedName = document.getElementById("pname").value;
	var requestPage = 1;
	window.location.href=
		"<%=path%>/ProductServlet?method=find&pname="+selectedName+"&currentpage="+requestPage;
}

function deleteMulti(){//删除选中的多个选项（可用）
var selectid=document.getElementsByName("ch1");
var url="<%=path%>/ProductServlet?method=deletemore";
	for(var i=0;i<selectid.length;i++){
	var x=selectid[i];
		if(x.checked==true){
		/**	alert(x.value);
		
		url.concat("&productid=",x.value);**/
			url=url+"&productid"+i+"="+x.value;
		}
	}
	url=url+"&selectlength="+selectid.length;
/**		alert(url);**/
   window.location.href=url;

}
function link(){
	var uri="<%=path%>/files/addProduct.jsp";
	window.location.href=uri;
}
</SCRIPT>

<body
  background="../images/fgo.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;"
>
<form name="fom" id="fom" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21"><img src="../images/ico07.gif" width="20" height="18" /></td>
			  <td width="538">输入产品名称：
<input id="pname" name="pname" type="text" size="12"   />
<input name="Submit4" type="button" class="button button1" value="查 询"  onclick="goTofind()" /></td>
			   <td width="144" align="left"><a href="#" onclick="">
			     <!-- <input name="Submit3" type="button" class="button button1" value="高级搜索" /> -->
			   </a></td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：</span>
	      
	              <input name="Submit" type="button" class="button button1" onclick="deleteMulti()" value="删除所选产品" />
	              <input name="Submit2" type="button" class="button button1" value="添加产品" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td height="22" colspan="7" align="center" style="font-size:16px">产品详细列表</td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
				    <td width="4%" align="center" height="30">选择</td>
                    <td width="10%">产品编号</td>
					<td width="10%">范围编号</td>
                    <td width="10%">产品名称</td>
					<td width="10%">产品单价</td>
					<td width="10%">产品说明</td>
					<td width="10%">注册时间</td>
					<td width="10%">操作</td>
                  </tr>
                 <c:forEach var="p" items="${list}"> 
                  <tr bgcolor="#FFFFFF">
				    <td height="20"><input type="checkbox" id="ch1" name="ch1" value="${p.pid}"/></td>
                    <td>${p.pid}</td>
					<td>${p.category}</td>
                    <td> ${p.pname}</td>
                    <td>${p.pprize}</td>
                    <td>${p.introduction}</td>
                    <td>${p.rigdate}</td>
                    <td><a href="javaScript:editUserById(${p.pid})">编辑</a>|
					<a href="javaScript:deleteUserById(${p.pid})">删除</a></td>
                  </tr>
				 </c:forEach>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">${totalPages}</span> 页 | 第 <span class="right-text09">${currentPage}</span> 页</td>
                <td width="49%" align="right">[<a href="<%=path%>/ProductServlet?method=all&currentpage=1" class="right-font08">首页</a> 
                | <a href="<%=path%>/ProductServlet?method=all&currentpage=${currentPage-1==0?1:(currentPage-1)}" class="right-font08">上一页</a> |
                 <a href="<%=path%>/ProductServlet?method=all&currentpage=${currentPage+1 > totalPages?totalPages:(currentPage+1)}" class="right-font08">下一页</a> |
                 <a href="<%=path%>/ProductServlet?method=all&currentpage=${totalPages}" class="right-font08">末页</a>] 转至：</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="page" id="page" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input  type="button" class="button button1" onclick="goToPage()"  value="跳转" />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
