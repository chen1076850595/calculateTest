<%@ page contentType="text/html;charset=gb2312"%>
<jsp:useBean id="testBean" class="mybean.data.test_Bean" scope="session"/>
<html><body bgcolor=#68C66F>
<link rel="stylesheet" href="style.css">
<div class="show">
<br>
<a href="sortServlet">查看排行榜</a>
<a href="inva.jsp">注销</a><br><br><br>

黑色标记为你的答案，红色标记为正确答案：<br><br>

<table>

<% char [][] question = testBean.getQuestion();
   float []yourAnswer = testBean.getYourAnswer();
   float []currentAnswer = testBean.getSum();   //正确答案
   float [] sum = testBean.getSum();
   //out.print("<tr><td>算式题</td><td></td><td>你的答案</td><td>正确答案</td></tr>");
   for(int i=0;i<question.length;i++){
      //打印试题
      out.print("<tr>");
      out.print("<td width=80px>");
      for(int j=0;j<question[i].length;j++){
       out.print(question[i][j]);
       }
       out.print("</td><td width=60px>=</td>");
       out.print("<td width=80px>"+yourAnswer[i]+"</td><td><font color=red>"+sum[i]+"</font></td>");
       out.print("</tr>");
        
   }
  
 %>

 </table>
 </div>
</body></html>