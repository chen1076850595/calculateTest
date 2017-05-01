<%@ page contentType="text/html;charset=gb2312" %>
<html><body bgcolor=#68C66F>
<% session.invalidate();%>
<center>
session对象已注销<br>
<SCRIPT LANGUAGE="JavaScript">    

var maxtime = 5; //一个小时，按秒计算，自己调整!    
function CountDown(){    
 if(maxtime>=0){    
 minutes = Math.floor(maxtime/60);    //求一个最接近的整数
 seconds = Math.floor(maxtime%60);    
 msg = seconds+"秒后将跳转到登录界面";    
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
 <a href="login.jsp">立即前往</a>
</center>
</body></html>
