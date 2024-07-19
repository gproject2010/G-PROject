package rep_upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PropFileDownload
 */
public class PropFileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropFileDownload() {
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
		request.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession(true);
		//session.setAttribute("errcode", "Rep-008");
		//String NextPage = "/passed/Error_Gamen.jsp";
		
		//NewGames_TO SyousaiData = (NewGames_TO)session.getAttribute("syousai");
		//String SetteiShiryou = SyousaiData.getSetteiShiryou();
		//String KikakuKaisetsusyo = SyousaiData.getKikakuKaisetsusyo();
		//String Taikenban = SyousaiData.getTaikenban();
		//String EtcData = SyousaiData.getEtcData();
		//String Movie = SyousaiData.getMovieAddress();
		
		String FileSyubetsu = request.getParameter("FileSyubetsu");
		String FilePath = "";
		String FileName = new String(request.getPathInfo().substring(1).getBytes("ISO-8859-1"), "UTF-8");
		
		try{
		if(FileSyubetsu.equals("setteishiryou")){
			FilePath = "/opt/proprep_files/koukaidata/setteishiryou/";
			//FilePath = "D:/TestDirectory/setteishiryou/";
		    //FileName = SetteiShiryou;
		}else if(FileSyubetsu.equals("kikakukaisetsusyo")){
			FilePath = "/opt/proprep_files/koukaidata/kikakukaisetsusyo/";
			//FilePath = "D:/TestDirectory/kikakukaisetsusyo/";
		    //FileName = KikakuKaisetsusyo;
		}else if(FileSyubetsu.equals("taikenban")){
			FilePath = "/opt/proprep_files/koukaidata/taikenban/";
			//FilePath = "D:/TestDirectory/taikenban/";
			//FileName = Taikenban;
		}else if(FileSyubetsu.equals("etcdata")){
			FilePath = "/opt/proprep_files/koukaidata/etcdata/";
			//FilePath = "D:/TestDirectory/etcdata/";
			//FileName = EtcData;
		}else if(FileSyubetsu.equals("movie")){
			FilePath = "/opt/proprep_files/koukaidata/movie/";
			//FilePath = "D:/TestDirectory/movie/";
			//FileName = Movie;
		}
		
		String ua = request.getHeader("user-agent");
		/*if(ua.contains("MSIE")){
			FileName = URLEncoder.encode(FileName, "UTF-8");
		}else{
			FileName = MimeUtility.encodeWord(FileName, "ISO-2022-JP", "B");
		}
		*/
		if(ua.contains("Safari")){
			response.setContentType("application/octet-stream;");
		}else{
			response.setContentType("text/html; charset=UTF-8;");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + FileName + "\"");
		}
		
		if(FilePath.equals("")){
			//NextPage = "Error.jsp";
		}else{
		File DownLoadFilePath = new File(FilePath, FileName);
		
		File_Download_Utility.execute(DownLoadFilePath, response);
		//NextPage = "/passed/NewGames/PropData_Show.jsp";
		}
		}catch(Exception e){
			e.printStackTrace();
			//session.setAttribute("errcode", "Rep-008");
			//NextPage = "/passed/Error_Gamen.jsp";
		}
		//ServletContext sc = getServletContext();
		//RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		//rd.forward(request, response);
	}

}
