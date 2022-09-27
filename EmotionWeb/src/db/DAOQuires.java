package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.GeneratePassword;
import Standalone.facial_emotion;
import bean.ChartData;
import bean.Emotion;
import bean.RegBean;

public class DAOQuires {

	
	public ArrayList<String> getUserList() {
		// TODO Auto-generated method stub
		DAO data=new DAO();
		Connection conn=data.getConnection();
		ArrayList<String> userlist=new ArrayList<String>();
		String validateUser = "select emailid from  registration";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			
			
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			while(result.next())
			{
				userlist.add(result.getString(1));
				
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		// TODO Auto-generated method stub
		return userlist;

		
	}



	
	public boolean insertReg(RegBean rb) {
		// TODO Auto-generated method stub
		int rows = 0;
	DAO dao=new DAO();
	
	Connection conn=dao.getConnection();
	String password=GeneratePassword.randomPasswordIs();
	rb.setPassword(password);
	String insertquery="insert into registration(fname,lastname,emailid,password,address) values(?,?,?,?,?)";
	PreparedStatement pstmt=null;
	try{
		pstmt=conn.prepareStatement(insertquery);;
		pstmt.setString(1,rb.getFname());
		pstmt.setString(2,rb.getLname());
		pstmt.setString(3,rb.getEmailid());
		pstmt.setString(4, password);
		pstmt.setString(5, rb.getAddress());
		
	
		
	 rows=pstmt.executeUpdate();
	
	}catch(SQLException e){
		System.out.println(e);
	}
	finally{
		try {
			pstmt.close();
		
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	if(rows==0)
		return false;
	
	return true;

	}
	public ArrayList<ChartData> getChart() {
	    DAO data = new DAO();
	    Connection conn = data.getConnection();
	    ArrayList<ChartData> s = new ArrayList<ChartData>();
	  String  validateUser = "select * from  filerecord ";
	    try
	    {
	      PreparedStatement preparedStatement = conn.prepareStatement(validateUser);
	      ResultSet result = preparedStatement.executeQuery();
	      while (result.next())
	      {
	        ChartData subject = new ChartData();
	        subject.setOp(result.getString(4));
	        subject.setTitle("Serial and Parrallel Comparision");
	        subject.setFileSize(result.getString(2));
	        subject.setTime(result.getString(3));
	        
	        s.add(subject);
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return s;
	  
	}


	public int insertDBQuires(String filename,String filesize,String timeupload,String operation) {
		// TODO Auto-generated method stub
		DAO data=new DAO();
		Connection conn=data.getConnection();
		// Generate password
		// Insert into Login Table
		String insertQuery = "insert into filerecord values(?,?,?,?,?)";
		PreparedStatement preparedStatement;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		try {
			preparedStatement = conn.prepareStatement(insertQuery);
			preparedStatement.setString(1, filename);
			preparedStatement.setString(2,filesize);
			preparedStatement.setString(3, timeupload);
			preparedStatement.setString(4, operation);
			preparedStatement.setString(5, dateFormat.format(date));
		int row=	preparedStatement.executeUpdate();
		
		return row;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//insertRegistrationForm(bean);
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
		
		
		
	}
	public String checkLogin(RegBean bean) {
		// TODO Auto-generated method stub
		
		
		 if("admin".equals(bean.getEmailid()) && "admin".equalsIgnoreCase(bean.getPassword())){
		return "admin";	
		}else{
		
		
		DAO data=new DAO();
		Connection conn=data.getConnection();
		System.out.println(bean.getEmailid()+bean.getPassword());
		String validateUser = "select * from  registration where Emailid=? and password = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, bean.getEmailid());
			preparedStatement.setString(2, bean.getPassword());
			
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				System.out.println("------------------------------------------");
				return result.getString(1);
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
		// TODO Auto-generated method stub

		return null;
	}
	public RegBean getForgetPassword(RegBean bean) {
		// TODO Auto-generated method stub
		DAO data=new DAO();
		Connection conn=data.getConnection();
		String validateUser = "select password from  registration where emailid=? ";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, bean.getEmailid());
			
			
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				bean.setPassword(result.getString(1));
				System.out.println("Forgot Password");
				return bean;
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("Forgo1111t Password");
		
		// TODO Auto-generated method stub
		return null;

	}
	public int Changepwd(RegBean rb, String emailid) {
		// TODO Auto-generated method stub
		DAO data=new DAO();
		Connection conn=data.getConnection();
		String validateUser = "select password from  registration where emailid=? ";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, emailid);
			
			
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			System.out.println("emailid"+emailid);
			
			if(result.next())
			{
				System.out.println("pass"+result.getString(1));
				if(result.getString(1).equals(rb.getPassword()))
				{
					validateUser="update registration set password=? where emailid=?";
					preparedStatement=conn.prepareStatement(validateUser);
					preparedStatement.setString(1,rb.getChangepwd());
					preparedStatement.setString(2, emailid);
					System.out.println("emailid"+rb.getChangepwd());
					return preparedStatement.executeUpdate();
					
				}
				else
				{
					return 0;
				}
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		// TODO Auto-generated method stub
		return 0;
		
	}




	public void insertFaceEmotion(List<facial_emotion> emotions, String lecturename) {


		// TODO Auto-generated method stub
		int rows = 0;
Standalone.DAO dao=new Standalone.DAO();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    Date date = new Date();    
	Connection conn=dao.getConnection();
	String insertquery="insert into emotion values(?,?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt=null;
	try{
		pstmt=conn.prepareStatement(insertquery);
		for(int i=0;i<7;i++)
		{
			/*System.out.println( emotions.get(i).toString());
			String value =  emotions.get(i).toString().split("=")[3];
			*/pstmt.setString(i+1, emotions.get(i).getScore()+"");
		}
		pstmt.setString(8,formatter.format(date));
		pstmt.setString(9, lecturename);
	System.out.println(pstmt.toString());
		
	 rows=pstmt.executeUpdate();
	
	}catch(Exception e){
		System.out.println(e);
	}
	finally{
		try {
			pstmt.close();
		
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
		
	}




	public ArrayList<Emotion> getRecords(String lname, String date) {
		// TODO Auto-generated method stub
		ArrayList<Emotion> aemotion = new ArrayList<Emotion>();
		Standalone.DAO data=new Standalone.DAO();
		Connection conn=data.getConnection();
		String validateUser = "select * from  emotion where lecturename=? and time=?  ";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, lname);
			preparedStatement.setString(2, date);
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			System.out.println(preparedStatement.toString());
			while(result.next())
			{
				Emotion e = new Emotion();
				e.setNeutral(result.getString(1));
				e.setHappy(result.getString(2));
				e.setSad(result.getString(3));
				e.setAngry(result.getString(4));
				e.setSurprise(result.getString(5));
				e.setFear(result.getString(6));
				e.setDisgust(result.getString(7));
				aemotion.add(e);
				System.out.println(e.getNeutral() + "Neutral");
				
			}
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
		finally{
			try {
				preparedStatement.close();
			
			conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return aemotion;
	}






	
}
