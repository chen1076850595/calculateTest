<%@ page contentType="text/html;charset=gb2312"%>
<jsp:useBean id="testBean" class="mybean.data.test_Bean" scope="session"/>
<html><body bgcolor=#68C66F>
<link rel="stylesheet" href="style.css">
<div class="show">
<br>
<a href="sortServlet">�鿴���а�</a>
<a href="inva.jsp">ע��</a><br><br><br>

��ɫ���Ϊ��Ĵ𰸣���ɫ���Ϊ��ȷ�𰸣�<br><br>

<table>

<% char [][] question = testBean.getQuestion();
   float []yourAnswer = testBean.getYourAnswer();
   float []currentAnswer = testBean.getSum();   //��ȷ��
   float [] sum = testBean.getSum();
   //out.print("<tr><td>��ʽ��</td><td></td><td>��Ĵ�</td><td>��ȷ��</td></tr>");
   for(int i=0;i<question.length;i++){
      //��ӡ����
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