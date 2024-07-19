package gpro_riron;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ronbun_Touroku_Cansel
 */
public class Ronbun_Touroku_Cansel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ronbun_Touroku_Cansel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		String[] FileError = new String[5];
		boolean EtcError = false;
		GPRiron_TO FileErrorList = new GPRiron_TO();
		String storePath = null;
		
		session.setAttribute("errcode", "GRiron-007");
		String NextPage = "/passed/Error_Gamen.jsp";
		ServletContext sc = getServletContext();
		
		GPRiron_DAO dao = new GPRiron_DAO();
		
		try{
		String Syorisyubetsu = request.getParameter("syubetsu");
		GPRiron_TO NewData = (GPRiron_TO)session.getAttribute("newdata");
		GPRiron_TO OldData = (GPRiron_TO)session.getAttribute("olddata");
		
		storePath = "/mnt/GRiron_Files/ImageData/";
		//storePath = "D:/TestDirectory/GRiron_ImageData/";
		if((NewData.getImageFileName1() != null && (!(NewData.getImageFileName1().equals(OldData.getImageFileName1())))) || Syorisyubetsu.equals("shinki")){
		File f1 = new File(storePath + NewData.getImageFileName1());
		if(f1.delete()){
			FileError[0] = "";
		}else{
			FileError[0]= NewData.getImageFileName1();
		}
		}
		if((NewData.getImageFileName2() != null && (!(NewData.getImageFileName2().equals(OldData.getImageFileName2())))) || Syorisyubetsu.equals("shinki")){
		File f2 = new File(storePath + NewData.getImageFileName2());
		if(f2.delete()){
			FileError[1] = "";
		}else{
			FileError[1]= NewData.getImageFileName2();
		}
		}
		if((NewData.getImageFileName3() != null && (!(NewData.getImageFileName3().equals(OldData.getImageFileName3())))) || Syorisyubetsu.equals("shinki")){
		File f3 = new File(storePath + NewData.getImageFileName3());
		if(f3.delete()){
			FileError[2] = "";
		}else{
			FileError[2] = NewData.getImageFileName3();
		}
		}
		storePath = "/mnt/GRiron_Files/HTMLData/";
		//storePath = "D:/TestDirectory/GRiron_HTMLData/";
	if((NewData.getHTMLFileName() != null && (!(NewData.getHTMLFileName().equals(OldData.getHTMLFileName())))) || Syorisyubetsu.equals("shinki")){
		File htmlfile = new File(storePath + NewData.getHTMLFileName());
		if(htmlfile.delete()){
			FileError[3] = "";
		}else{
			FileError[3] = NewData.getHTMLFileName();
		}
	}
		FileErrorList = new GPRiron_TO(FileError[0], FileError[1], FileError[2],FileError[3]);
		dao.BeforeData_Error_Log(FileErrorList);
		session.setAttribute("errorlist", FileErrorList);
		session.setAttribute("etcerror", EtcError);
		session.setAttribute("ronbundata", NewData);
		session.setAttribute("wrongtag", "");
		session.setAttribute("wrongtitle", "");
		session.setAttribute("wrongword", "");
		session.setAttribute("wronglength", false);
		if(Syorisyubetsu.equals("shinki")){
		NextPage = "/passed/GPRO_Riron/Ronbun_Shinki_Syusei.jsp";
		}else if(Syorisyubetsu.equals("hensyu")){
			NextPage = "/passed/GPRO_Riron/Ronbun_Hensyu_Syusei.jsp";
		}else if(Syorisyubetsu.equals("back")){
			NextPage = "/G-pro_Service/AuthenticationController";
		}
	}catch(Exception e){
		e.printStackTrace();
		EtcError = true;
	}
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		
	}
}
