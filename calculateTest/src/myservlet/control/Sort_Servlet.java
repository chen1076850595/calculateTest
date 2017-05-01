package myservlet.control;
import mybean.data.test_Bean;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Sort_Servlet extends HttpServlet {
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
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
		
		String dataBase = "stuTest";
		request.setCharacterEncoding("gb2312");
		//连接数据库
	     Connection con = null;
	     JDBC mySql = new JDBC();
	     mySql.setCon(dataBase);
	     con = mySql.getCon();
	     ResultSet rs;
	     Statement sql;
	     String [][]sort;
	     int n=0;
	     try{
	          sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	        		  ResultSet.CONCUR_READ_ONLY);
	          String condition = "SELECT stuName,score from student order by score desc;";
	          rs = sql.executeQuery(condition);
	          while(rs.next()){
	                    
	                   n++;  //获得记录数
	                    //response.sendRedirect("stuTest.jsp");                   
	                }
	          sort = new String[n][2];
	          rs.beforeFirst();
	          int i=0;
	          String stuName = testBean.getStuName();
	          int stuSort;
	          while(rs.next()){
	        	  sort[i][0] = rs.getString("stuName");
	        	  sort[i][1] = rs.getString("score");
	        	  i++;
	        	  //写入该学生排名
	        	  if(stuName.equals(rs.getString("stuName"))){
	        		  stuSort = i;
	        		  testBean.setStuSort(stuSort);
	        	  }
	          }
	          testBean.setScoreSort(sort);
	          }
	    	 
	    	 catch(SQLException exp){
	    		 System.out.println(exp);
	    	 }
	    
	    // testBean.setMess(mess);
	    mySql.closeCon(con);
	    response.sendRedirect("scoreSort.jsp");
	      
	 
	}
	
	
}
