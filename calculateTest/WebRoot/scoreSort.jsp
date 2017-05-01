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
<a href="trueAnswer.jsp">查看正确答案</a>
<a href="inva.jsp">注销</a><br><br><br>
你好，<font color=blue><%=testBean.getStuName() %></font>
<BR>欢迎查看排行榜<br><br>
你目前的排名是第&nbsp<font color=blue><%=testBean.getStuSort() %></font>&nbsp名
<br>
<br>
<table border=1 cellspacing="0px">
<tr>
<td>姓名</td><td>分数</td><td>排名</td>
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