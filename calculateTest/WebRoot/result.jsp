<%@ page contentType="text/html;charset=gb2312"%>
<jsp:useBean id="testBean" class="mybean.data.test_Bean" scope="session"/>
<html><body bgcolor=#68C66F>
<link rel="stylesheet" href="style.css">

<div class="show">

<a href="trueAnswer.jsp">查看正确答案</a>
<a href="sortServlet">查看排行榜</a><br><br>

<font color=blue><%=testBean.getStuName() %></font>你好！
恭喜你完成答题<br>你一共答对了<font color=blue><%=testBean.getCurrentNumber() %></font>道题<br><br>你的得分为：
<font color=blue><%=testBean.getScore() %></font>
<br><br>

<br>
</div>
</body></html>