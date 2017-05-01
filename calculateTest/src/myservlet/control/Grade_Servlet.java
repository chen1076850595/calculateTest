package myservlet.control;
import mybean.data.test_Bean;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Grade_Servlet extends HttpServlet {
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	      throws ServletException,IOException{
		HttpSession session = request.getSession(true);        	
		test_Bean testBean = null;
		try{
		    	   testBean = (test_Bean)session.getAttribute("testBean");
		    	   if(testBean==null){
		    		   testBean = new test_Bean();
		    		   session.setAttribute("testBean", testBean);
		    	   }
		    	   //session.setAttribute("testBean", testBean);
			}
		catch(Exception e){
			testBean = new test_Bean();
	    	session.setAttribute("testBean", testBean);
		}
		float [] yourAnswer = new float[10];
		float [] currectAnswer = testBean.getSum();
		float score=testBean.getScore();
		int currentNumber=0;
		for(int i=0;i<10;i++){
			String n = request.getParameter("Q"+i);
			if(n==null||n.length()<1){
				n="0";
			}
			yourAnswer[i] = Float.parseFloat(n);
		}
		testBean.setYourAnswer(yourAnswer);
		for(int i=0;i<10;i++){
			if(yourAnswer[i]==currectAnswer[i]){
				score +=10;
				currentNumber++;
			}
		}
		testBean.setScore(score);
		testBean.setCurrentNumber(currentNumber);
		//将分数更新至数据库
		String dataBase = "stuTest";
		 Connection con = null;
	     JDBC mySql = new JDBC();
	     mySql.setCon(dataBase);
	     con = mySql.getCon();	     
	     Statement sql;
	     String stuId = testBean.getStuId();
	     String condition = "update student set score="+score+" where "
	     		+ "stuId="+stuId+";";
	     try{
	    	 sql = con.createStatement();
	    	 sql.executeUpdate(condition);
	     }catch(SQLException exp){
	    	 System.out.println(exp);
	    	 System.out.println("数据库更新失败！");
	     }
	     mySql.closeCon(con);
		response.sendRedirect("result.jsp");
		
	      
	 
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		      throws ServletException,IOException{
		  doPost(request,response);
	}
	
	
}
