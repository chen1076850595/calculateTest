package myservlet.control;
import mybean.data.test_Bean;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Login_Servlet extends HttpServlet {
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	      throws ServletException,IOException{
		HttpSession session = request.getSession(true);        	
		test_Bean testBean = null;
		try{
		    	   testBean = new test_Bean();
		    	   session.setAttribute("testBean", testBean);
			}
		catch(Exception e){
			testBean = new test_Bean();
	    	session.setAttribute("testBean", testBean);
		} 
		String dataBase = "stuTest";
		request.setCharacterEncoding("gb2312");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name;
		String mess;
		boolean login = false;
		//�������ݿ�
	     Connection con = null;
	     JDBC mySql = new JDBC();
	     mySql.setCon(dataBase);
	     con = mySql.getCon();
	     ResultSet rs;
	     Statement sql;
	     if(id==null||id.length()<1){
	    	 mess = "�����뿼�ţ�";
	    	 testBean.setMess(mess);
	    	 response.sendRedirect("login.jsp");
	     }
	     else if(password==null||password.length()<1){
	    	 mess = "���������룡";
	    	 testBean.setMess(mess);
	    	 response.sendRedirect("login.jsp");
	     }
	     else{
	    	 try{
	          sql = con.createStatement();
	          String condition = "SELECT * from student;";
	          rs = sql.executeQuery(condition);
	          while(rs.next()){
	                if(id.equals(rs.getString("stuId"))&&
	                   password.equals(rs.getString("stuPassword"))){
	                   //����Ϣ����Javabean
	                	testBean.setStuId(id);
	                	testBean.setStuName(rs.getString(2));
	                	testBean.setScore(0);
	                    //��������
	                	Question question = new Question(10);
	                	testBean.setQuestion(question.getQuestion());
	                	testBean.setSum(question.getSum());
	                	login = true;	 //��¼�ɹ� 
	                    response.sendRedirect("stuTest.jsp");
	                   
	                }
	          }
	    	 }
	    	 catch(SQLException exp){
	    		 System.out.println(exp);
	    	 }
	    	 if(!login){
	    	 mess = "�û������������";
	    	 testBean.setMess(mess);
	    	 response.sendRedirect("login.jsp");
	    	 }
	     }
	    // testBean.setMess(mess);
	    mySql.closeCon(con);
	      
	 
	}
	
	
}
