<%@ page contentType="text/html;charset=gb2312"%>
<jsp:useBean id="testBean" class="mybean.data.test_Bean" scope="session"/>
<html><body bgcolor=#68C66F>
<link rel="stylesheet" href="style.css">
<SCRIPT LANGUAGE="JavaScript">    

var maxtime = 120; //一个小时，按秒计算，自己调整!    
function CountDown(){    
 if(maxtime>=0){    
 minutes = Math.floor(maxtime/60);    //求一个最接近的整数
 seconds = Math.floor(maxtime%60);    
 msg = "距离结束还有"+minutes+"分"+seconds+"秒";    
 document.all["timer"].innerHTML=msg;    
 if(maxtime == 60)
  alert('注意，还有1分钟,请尽快答题！');    
 --maxtime;    
 }    
 else{    
 clearInterval(timer);
 document.form.submit();     //提交表单 
 //window.location.href='gradeServlet';
 }    
}    
timer = setInterval("CountDown()",1000);    
   
</SCRIPT> 
<div class="show">
 <div id="timer" style="color:red;"></div>
 <br>
你好，<font color=blue><%=testBean.getStuName() %></font><br>
已经为你随机生成了10道长度为2-4的算术题<br>
每道题10分，共计100分，限时2分钟！<br>请尽快答题（结果保留两位小数）
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
<input type="submit" value="提交">
</form>
</div>
</body></html>