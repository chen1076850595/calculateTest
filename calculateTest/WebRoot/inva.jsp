<%@ page contentType="text/html;charset=gb2312" %>
<html><body bgcolor=#68C66F>
<% session.invalidate();%>
<center>
session������ע��<br>
<SCRIPT LANGUAGE="JavaScript">    

var maxtime = 5; //һ��Сʱ��������㣬�Լ�����!    
function CountDown(){    
 if(maxtime>=0){    
 minutes = Math.floor(maxtime/60);    //��һ����ӽ�������
 seconds = Math.floor(maxtime%60);    
 msg = seconds+"�����ת����¼����";    
 document.all["timer"].innerHTML=msg;     
 --maxtime;    
 }    
 else{    
 clearInterval(timer);  
 window.location.href='login.jsp';
 }    
}    
timer = setInterval("CountDown()",1000);    
   
</SCRIPT> 
<br>
 <div id="timer" style="color:red;"></div>
 <br>
 <a href="login.jsp">����ǰ��</a>
</center>
</body></html>
