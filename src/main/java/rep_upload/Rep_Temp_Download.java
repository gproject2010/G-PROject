package rep_upload;

//import inputUtility.HttpUtility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Rep_Temp_Download
 */
public class Rep_Temp_Download extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rep_Temp_Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		String Temp = request.getParameter("temp");
		//Temp = HttpUtility.escapeHTML(Temp);
		session.setAttribute("Temp", Temp);
		session.setAttribute("errcode", "Rep-011");
		String NextPage = "/passed/Error_Gamen.jsp";
		try{
		
		if(Temp.equals("ox")){
			NextPage = "/passed/OX_Report/OX_Rep_Shinki.html";
		}
		else if(Temp.equals("kiji")){
			NextPage = "/passed/Kiji_Report/Kiji_Rep_Shinki.html";
		}
		else if(Temp.equals("free")){
			NextPage = "/passed/Free_Report/Free_Rep_Shinki.html";	
		}
		
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "Rep-011");
		NextPage = "/passed/Error_Gamen.jsp";
	}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
