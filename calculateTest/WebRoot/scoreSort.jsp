<%@ page contentType="text/html;charset=gb2312"%>
<jsp:useBean id="testBean" class="mybean.data.test_Bean" scope="session"/>
<html><body bgcolor=#68C66F>
<link rel="stylesheet" href="style.css">
<style>
td{
width:70px;
height:40px;
text-align:center;
}
.sort{
color:blue;
}
</style>
<div class="show">
<br>
<a href="trueAnswer.jsp">�鿴��ȷ��</a>
<a href="inva.jsp">ע��</a><br><br><br>
��ã�<font color=blue><%=testBean.getStuName() %></font>
<BR>��ӭ�鿴���а�<br><br>
��Ŀǰ�������ǵ�&nbsp<font color=blue><%=testBean.getStuSort() %></font>&nbsp��
<br>
<br>
<table border=1 cellspacing="0px">
<tr>
<td>����</td><td>����</td><td>����</td>
</tr>
<%  String [][]sort = testBean.getScoreSort();
    for(int i=0;i<sort.length;i++){
    out.print("<tr>");
    for(int j=0;j<sort[i].length;j++){
       out.print("<td>"+sort[i][j]+"</td>");
    }
    out.print("<td class=sort>"+(i+1)+"</td>");
    out.print("</tr>");
    }
 %>
</table>
</div>
</body></html>