<%@ page contentType="text/html;charset=gb2312"%>
<jsp:useBean id="testBean" class="mybean.data.test_Bean" scope="session"/>
<html><body bgcolor=#68C66F>
<link rel="stylesheet" href="style.css">

<div class="show">

<a href="trueAnswer.jsp">�鿴��ȷ��</a>
<a href="sortServlet">�鿴���а�</a><br><br>

<font color=blue><%=testBean.getStuName() %></font>��ã�
��ϲ����ɴ���<br>��һ�������<font color=blue><%=testBean.getCurrentNumber() %></font>����<br><br>��ĵ÷�Ϊ��
<font color=blue><%=testBean.getScore() %></font>
<br><br>

<br>
</div>
</body></html>