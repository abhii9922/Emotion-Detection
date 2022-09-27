package controller;


import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.jdbc.Connection;

import util.BarChart;
import bean.Emotion;
import db.DAO;
import db.DAOQuires;

/**
 * Servlet implementation class in
 */
public class Algo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Algo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//String lname = request.getParameter("lname");
		String lname = "";
		  String nextPath = "";
		String date  = request.getParameter("date");
		String abc  = request.getParameter("abc");
		Date date1 = new Date();
		double aEmotion12[] = new double[10]; 
		if("emotion".equals(action))
		{
			
			DAOQuires db = new DAOQuires();
			ArrayList<Emotion> aEmotion =db.getRecords(abc,date);
			
			for(int i = 0;i<aEmotion.size();i++)
			{
				Emotion e = aEmotion.get(i);
				aEmotion12[0] = Double.parseDouble(e.getNeutral()) +  aEmotion12[0] ;
				aEmotion12[1] = Double.parseDouble(e.getHappy()) +  aEmotion12[1] ;
				aEmotion12[2] = Double.parseDouble(e.getSad()) +  aEmotion12[2] ;
				aEmotion12[3] = Double.parseDouble(e.getAngry()) +  aEmotion12[3] ;
				aEmotion12[4] = Double.parseDouble(e.getSurprise()) +  aEmotion12[4] ;
				aEmotion12[5] = Double.parseDouble(e.getFear()) +  aEmotion12[5] ;
				aEmotion12[6] = Double.parseDouble(e.getDisgust()) +  aEmotion12[6] ;
				
			}
			
			BarChart b = new BarChart(getServletContext().getRealPath("/"));
		    b.createChart(aEmotion12, "Emotion Chart for Session " + lname);
		    HttpSession session = request.getSession();
		    String type = (String)session.getAttribute("type");
		     nextPath = "/Portal.jsp";
		    request.setAttribute("a", "a");
			
		}else if(action == null){
			String UPLOAD_DIRECTORY = "D:";
			 double startTime = System.currentTimeMillis();
			
				
				 String name = "";
				if(ServletFileUpload.isMultipartContent(request)){
		            try {
		            	//Uploading the video to D drive---Start
		                List<FileItem> multiparts = null;
						try {
							multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
						} catch (FileUploadException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		           String l = "";
		                for(FileItem item : multiparts){
		                    if(!item.isFormField()){
		                          name = new File(item.getName()).getName();
		                        try {
									item.write( new File(UPLOAD_DIRECTORY +"\\"+ File.separator + name));
								} catch (java.lang.Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		                    }else
		                    {
		                    	l = item.getString();
		                    }
		                }
		              //Uploading the video to D drive---End
		                
		                //Extract image from video--Start
		                ThumbnailCreation decode = new ThumbnailCreation(); 
		                decode.saveImage(UPLOAD_DIRECTORY +"\\" + name, getServletContext().getRealPath("/"));

		                //Extract image from video--End
		                Standalone.Emotion e = new Standalone.Emotion();
		        	    //e.setEmotions(UPLOAD_DIRECTORY +"\\image.png");
		        		Runtime.getRuntime().exec("  cmd /c start D:\\bat.bat "+getServletContext().getRealPath("/") + "image.png");  
		        		Thread.sleep(20000);
		        		
        	           	System.out.println("success");
        	           	File f = new File("G:\\data.txt");
        	           	Scanner s = new Scanner(f);
        	           	String data = "";
        	           	while(s.hasNextLine())
        	           	{
        	           		data = data + s.nextLine();
        	           	}
        	           	String time = "";
        	           	String []d = data.split("%");
        	           	System.out.println(d[0]);
        	           	System.out.println(d[2]);
        	           	System.out.println(d[3]);
        	           	System.out.println(d[4]);
        	           	System.out.println(d[5]);
        	           	System.out.println(d[6]);
        	           	s.close();

        	    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	           	DAO a = new DAO();
        	           	java.sql.Connection conn = a.getConnection();
        	           	String sql = "insert into emotion values(?,?,?,?,?,?,?,?,?)";
        	           	PreparedStatement pst =  conn.prepareStatement(sql);
        	           	pst.setString(1, d[0]);
        	           	pst.setString(2, d[1]);
        	           	pst.setString(3, d[2]);
        	           	pst.setString(4, d[3]);
        	           	pst.setString(5, d[4]);
        	           	pst.setString(6, d[5]);
        	           	pst.setString(7, d[6]);
        	           	pst.setString(8, l);
        	           	pst.setString(9, dateFormat.format(date1));
        	           	pst.executeUpdate();
		        	     nextPath = "Upload.jsp";        	   	
		            	}catch(Exception e){
		         
		            		e.printStackTrace();
		         
		            	}
		                
				}
		}
		
		 
		
		
		request.setAttribute("a", "a");
		RequestDispatcher request1 = request.getRequestDispatcher(nextPath );
		request1.forward(request, response);
		
		
	}
}
