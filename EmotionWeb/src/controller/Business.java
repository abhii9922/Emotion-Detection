package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import db.DAOQuires;

import service.LoginService;
import bean.Emotion;
import bean.FileBean;

/**
 * Servlet implementation class in
 */
public class Business extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Business() {
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
		if("emotion".equals(action))
		{
			String lname = request.getParameter("lname");
			String date  = request.getParameter("date");
			DAOQuires db = new DAOQuires();
			ArrayList<Emotion> aEmotion =db.getRecords(lname,date);
			double aEmotion12[] = new double[10]; 
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
			
			
			
		}
		
		
	}
}
