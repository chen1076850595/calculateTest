<%@ page contentType="text/html;charset=gb2312"%>
<jsp:useBean id="testBean" class="mybean.data.test_Bean" scope="session"/>
<html><body bgcolor=#68C66F>
<link rel="stylesheet" href="style.css">
<SCRIPT LANGUAGE="JavaScript">    

var maxtime = 120; //һ��Сʱ��������㣬�Լ�����!    
function CountDown(){    
 if(maxtime>=0){    
 minutes = Math.floor(maxtime/60);    //��һ����ӽ�������
 seconds = Math.floor(maxtime%60);    
 msg = "�����������"+minutes+"��"+seconds+"��";    
 document.all["timer"].innerHTML=msg;    
 if(maxtime == 60)
  alert('ע�⣬����1����,�뾡����⣡');    
 --maxtime;    
 }    
 else{    
 clearInterval(timer);
 document.form.submit();     //�ύ�� 
 //window.location.href='gradeServlet';
 }    
}    
timer = setInterval("CountDown()",1000);    
   
</SCRIPT> 
<div class="show">
 <div id="timer" style="color:red;"></div>
 <br>
��ã�<font color=blue><%=testBean.getStuName() %></font><br>
�Ѿ�Ϊ�����������10������Ϊ2-4��������<br>
ÿ����10�֣�����100�֣���ʱ2���ӣ�<br>�뾡����⣨���������λС����
<br><br>
<form action="gradeServlet" method="post" name="form">

<% char [][] question = testBean.getQuestion();
   float [] sum = testBean.getSum();
   for(int i=0;i<question.length;i++){
      for(int j=0;j<question[i].length;j++){
       out.print(question[i][j]);
       }
        out.print("=<input type=text size=6 name=Q"+i+"><br>");
   }
  
 %>
<input type="submit" value="�ύ">
</form>
</div>
</body></html>