package myservlet.control;
import java.sql.*;
public class JDBC {
	Connection con;   
	public void setCon(String database){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e){
			System.out.println("��������ʧ��");
		}
		try{
			
			String uri = "jdbc:mysql://localhost:3306/"+database;
			String user = "root";
			String password = "123456";
			con = DriverManager.getConnection(uri,user,password);
			System.out.println("�������ݿ�ɹ���");
		}
		catch(SQLException exp){
			System.out.println(exp);
			System.out.println("�������ݿ�ʧ�ܣ�");
		}
        
	}

	public Connection getCon(){
		return con;
	}
	//�ر�����ͨ��
	public void closeCon(Connection c){
		try{
			c.close();
		}
		catch(SQLException exp){
			System.out.println(exp);
		}
	}
}
