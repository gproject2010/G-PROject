package inputUtility;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

//import rep_upload.NewGames_TO;

/**
 * Servlet implementation class Movie_Load
 */
public class Movie_Load extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Movie_Load() {
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
		
		
		//HttpSession session = request.getSession(true);
		String FileName = null;
		
		//NewGames_TO SyousaiData = (NewGames_TO)session.getAttribute("syousai");
		
		FileName = new String(request.getPathInfo().substring(1).getBytes("ISO-8859-1"), "UTF-8");
		String HyoujiSyubetsu = request.getParameter("FileSyubetsu");
		
		String ImgDir = null;
		
		if(HyoujiSyubetsu.equals("proprep")){
			ImgDir = "/opt/proprep_files/koukaidata/movie/";
			//ImgDir = "D:/TestDirectory/movie/";
			}
		
		//response.setContentType("video/mpeg");
		
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
			response.setContentType("video/mpeg; charset=UTF-8;");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + FileName + "\"");
		}
		
			ServletOutputStream out = response.getOutputStream();
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(ImgDir + FileName));
			byte[] data = new byte[1048576];
			int len;
			
			while((len = bin.read(data, 0, 1048576)) != -1){
				out.write(data, 0, len);
			}
			bin.close();
	}

}
