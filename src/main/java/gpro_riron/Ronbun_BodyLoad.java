package gpro_riron;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ronbun_BodyLoad
 */
public class Ronbun_BodyLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ronbun_BodyLoad() {
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
		
		String str = null;
		String Result = "";
		GPRiron_TO RonbunData = new GPRiron_TO();
		String Timing = request.getParameter("time");
		
		if(Timing.equals("hensyumae")){
		RonbunData = (GPRiron_TO)session.getAttribute("ronbundata");//最初にロードしたデータ（編集する前、もしくは閲覧用の場合）
		}else if(Timing.equals("hensyugo")){
		RonbunData = (GPRiron_TO)session.getAttribute("newdata");//編集を加えた後のデータ（編集した後）
		}else if(Timing.equals("olddata")){
			RonbunData = (GPRiron_TO)session.getAttribute("olddata");//編集前のデータ
			}
		
		//String FileName = new String(request.getPathInfo().substring(1).getBytes("ISO-8859-1"), "UTF-8");
		
		//String ua = request.getHeader("user-agent");
		/*if(ua.contains("MSIE")){
			FileName = URLEncoder.encode(FileName, "UTF-8");
		}else{
			FileName = MimeUtility.encodeWord(FileName, "ISO-2022-JP", "B");
		}
		
		if(ua.contains("Safari")){
			response.setContentType("application/octet-stream;");
		}else{
			response.setContentType("text/html; charset=UTF-8;");
			response.setHeader("Content-Disposition", "inline; filename=\"" + RonbunData.getHTMLFileName() + "\"");
		}
		*/
		String HtmlFileName = "/mnt/GRiron_Files/HTMLData/" + RonbunData.getHTMLFileName();
		//String HtmlFileName = "D:/TestDirectory/GRiron_HTMLData/" + RonbunData.getHTMLFileName();
BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(HtmlFileName), "UTF-8"));
		
		while((str = in.readLine()) != null){
			Result = Result + str;
			Result = Result + "\n";
		}
		

		//byte[] bytes = Result.getBytes("iso-8859-1");
		//Result = new String(bytes, "UTF-8");
		
		ServletOutputStream out = response.getOutputStream();//プレビュー用にHTML化した結果を出力
		
		byte[] data = Result.getBytes();
		
			out.write(data);
		out.close();
		in.close();
	}


}
