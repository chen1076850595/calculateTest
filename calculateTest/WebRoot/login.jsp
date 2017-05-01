<%@ page contentType="text/html;charset=gb2312"%>
<jsp:useBean id="testBean" class="mybean.data.test_Bean" scope="session"/>

<html>
<body bgcolor="00749A">
<center>
<div style="position:relative;top:200px;">
<h3>欢迎进入考试页面</h3>
<br>
<form action="loginServlet" method=post>
输入考号：<input type="text" name="id" size=15 ><br><br>
登录密码：<input type="password" name="password" size=15>

<br><br>
<div style="position:relative;left:20px;">
<input type=submit value="开始考试"></div>
</form>
<% 
   if(testBean.getMess()!=null){
 %>
<font size=3 ><%=testBean.getMess() %></font>
 <%} %>
</div>

</center>
</p>
</html>