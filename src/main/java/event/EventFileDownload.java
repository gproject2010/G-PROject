package event;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EventFileDownload
 */
public class EventFileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventFileDownload() {
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
		response.setContentType("application/pdf; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession(true);
		//session.setAttribute("errcode", "Rep-008");
		//String NextPage = "/passed/Error_Gamen.jsp";
		
		//EventData_TO EventSyousai = (EventData_TO)session.getAttribute("eventsyousai");
		//String Eventshiryou1 = EventSyousai.getEventshiryou1();
		//String Eventshiryou2 = EventSyousai.getEventshiryou2();
		//String Eventshiryou3 = EventSyousai.getEventshiryou3();
		
		String FileSyubetsu = request.getParameter("filesyubetsu");
		String FilePath = "";
		String FileName = new String(request.getPathInfo().substring(1).getBytes("ISO-8859-1"), "UTF-8");
		
		try{
		if(FileSyubetsu.equals("shiryou1")){
			FilePath = "/mnt/GRiron_Files/Event_Files/Shiryou1/";
			//FilePath = "D:/TestDirectory/Event_Shiryou1/";
		    //FileName = Eventshiryou1;
		}else if(FileSyubetsu.equals("shiryou2")){
			FilePath = "/mnt/GRiron_Files/Event_Files/Shiryou2/";
			//FilePath = "D:/TestDirectory/Event_Shiryou2/";
		    //FileName = Eventshiryou2;
		}else if(FileSyubetsu.equals("shiryou3")){
			FilePath = "/mnt/GRiron_Files/Event_Files/Shiryou3/";
			//FilePath = "D:/TestDirectory/Event_Shiryou3/";
		    //FileName = Eventshiryou3;
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
			response.setContentType("application/pdf; charset=UTF-8;");
			response.setHeader("Content-Disposition", "inline; filename=\"" + FileName + "\"");
		}
		
		if(FilePath.equals("")){
			//NextPage = "Error.jsp";
		}else{
			//クライアントのPCにダウンロードしてから開く場合
		//File DownLoadFilePath = new File(FilePath, FileName);
		//File_Download_Utility.execute(DownLoadFilePath, response);
		
			//一時ファイルとして表示する場合
			ServletOutputStream out = response.getOutputStream();
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(FilePath + FileName));
			byte[] data = new byte[1048576];
			int len;
			
			while((len = bin.read(data, 0, 1048576)) != -1){
				out.write(data, 0, len);
			}
			bin.close();
		
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
