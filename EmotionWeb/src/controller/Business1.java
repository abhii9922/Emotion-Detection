package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.bytedeco.javacv.FFmpegFrameGrabber;

import util.BarChart;
import bean.Emotion;
import db.DAOQuires;

/**
 * Servlet implementation class in
 */
public class Business1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Business1() {
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
		String lname = request.getParameter("lname");
		String date  = request.getParameter("date");
		double aEmotion12[] = new double[10]; 
		if("emotion".equals(action))
		{
			
			DAOQuires db = new DAOQuires();
			ArrayList<Emotion> aEmotion =db.getRecords(lname,date);
			
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
		    String nextPath = "/Portal.jsp";
		    request.setAttribute("a", "a");
			
		}else if(action == null){
			String UPLOAD_DIRECTORY = "C:";
			 double startTime = System.currentTimeMillis();
			
				UPLOAD_DIRECTORY = "D:";
				
				 String name = "";
				if(ServletFileUpload.isMultipartContent(request)){
		            try {
		                List<FileItem> multiparts = null;
						try {
							multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
						} catch (FileUploadException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		           
		                for(FileItem item : multiparts){
		                    if(!item.isFormField()){
		                          name = new File(item.getName()).getName();
		                        try {
									item.write( new File(UPLOAD_DIRECTORY +"\\"+ File.separator + name));
								} catch (java.lang.Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		                    }
		                }
		                ThumbnailCreation decode = new ThumbnailCreation(); 
		                decode.saveImage(UPLOAD_DIRECTORY +"\\" + name, UPLOAD_DIRECTORY +"\\"+ name.split("\\.")[0]);
		        	    	   
		        	   	
		            	}catch(Exception e){
		         
		            		e.printStackTrace();
		         
		            	}
		                
				}
		}
		
		 
		
		String nextPath = "";
		RequestDispatcher request1 = request.getRequestDispatcher(nextPath );
		request1.forward(request, response);
		
		
	}
}
