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

import k_jyouhou.R_jyouhou_TO;

/**
 * Servlet implementation class Ronbun_Koushin
 */
public class Ronbun_Koushin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ronbun_Koushin() {
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
		String ImgFilePath = "/mnt/GRiron_Files/ImageData/";
		String PageFilePath = "/mnt/GRiron_Files/HTMLData/";
		//String ImgFilePath = "D:/TestDirectory/GRiron_ImageData/";
		//String PageFilePath = "D:/TestDirectory/GRiron_HTMLData/";
		String NextPage = null;
		File f1 = null;
		File f2 = null;
		File f3 = null;
		File HTMLFile = null;
		boolean DBKoushinError = true;
		String ImgFileUploadError1 = "";
		String ImgFileUploadError2 = "";
		String ImgFileUploadError3 = "";
		String HTMLFileUploadError = "";
		GPRiron_TO ErrorData = null;
		try{
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
		GPRiron_TO KoushinData = (GPRiron_TO)session.getAttribute("newdata");
		GPRiron_TO BaseData = (GPRiron_TO)session.getAttribute("olddata");
		String Source_Henkou = (String)session.getAttribute("source_henkou");
		
		if(BaseData.getPlayer_Id().equals(request.getRemoteUser()) && BaseData.getPlayer_Id().equals(KaiinData.getk_Id())){
		
		GPRiron_DAO dao = new GPRiron_DAO();
		DBKoushinError = dao.Ronbun_Koushin(KoushinData, BaseData);
		
		if(DBKoushinError == false){
			if(KoushinData.getImageFileName1() != null && (!(KoushinData.getImageFileName1().equals(""))) && (!(BaseData.getImageFileName1().equals(KoushinData.getImageFileName1())))){
			f1 = new File(ImgFilePath + BaseData.getImageFileName1());
			if(f1.delete()){
				ImgFileUploadError1 = BaseData.getImageFileName1();
			}
			}
			if(KoushinData.getImageFileName2() != null && (!(KoushinData.getImageFileName2().equals(""))) && (!(BaseData.getImageFileName2().equals(KoushinData.getImageFileName2())))){
			f2 = new File(ImgFilePath + BaseData.getImageFileName2());
			if(f2.delete()){
				ImgFileUploadError2 = BaseData.getImageFileName2();
			}
			}
			if(KoushinData.getImageFileName3() != null && (!(KoushinData.getImageFileName3().equals(""))) && (!(BaseData.getImageFileName3().equals(KoushinData.getImageFileName3())))){
			f3 = new File(ImgFilePath + BaseData.getImageFileName3());
			if(f3.delete()){
				ImgFileUploadError3 = BaseData.getImageFileName3();
			}
			}
			if(KoushinData.getHTMLFileName() != null && (!(KoushinData.getHTMLFileName().equals(""))) && (Source_Henkou.equals("change")) && (!(BaseData.getHTMLFileName().equals(KoushinData.getHTMLFileName())))){
			HTMLFile = new File(PageFilePath + BaseData.getHTMLFileName());
			if(HTMLFile.delete()){
				HTMLFileUploadError = BaseData.getHTMLFileName();
			}
			}
			ErrorData = new GPRiron_TO(ImgFileUploadError1, ImgFileUploadError2, ImgFileUploadError3, HTMLFileUploadError);
			session.setAttribute("syorisyubetsu", "koushin");
			session.setAttribute("uploadresult", ErrorData);
			}
		NextPage = "/passed/GPRO_Riron/Ronbun_Touroku_Result.jsp";
		}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "GRiron-007");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		
	}
}
