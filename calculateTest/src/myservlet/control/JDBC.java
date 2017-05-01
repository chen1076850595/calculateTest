package myservlet.control;
import java.sql.*;
public class JDBC {
	Connection con;   
	public void setCon(String database){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e){
			System.out.println("加载驱动失败");
		}
		try{
			
			String uri = "jdbc:mysql://localhost:3306/"+database;
			String user = "root";
			String password = "123456";
			con = DriverManager.getConnection(uri,user,password);
			System.out.println("连接数据库成功！");
		}
		catch(SQLException exp){
			System.out.println(exp);
			System.out.println("连接数据库失败！");
		}
        
	}

	public Connection getCon(){
		return con;
	}
	//关闭连接通道
	public void closeCon(Connection c){
		try{
			c.close();
		}
		catch(SQLException exp){
			System.out.println(exp);
		}
	}
}
