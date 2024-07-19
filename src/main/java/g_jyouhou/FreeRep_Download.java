package g_jyouhou;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rep_upload.File_Download_Utility;
import rep_upload.Rep_List_TO;

/**
 * Servlet implementation class FreeRep_Download
 */
public class FreeRep_Download extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeRep_Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Rep_List_TO DLdata = (Rep_List_TO) session.getAttribute("bestrep");
		session.setAttribute("errcode", "GData-002");
		String NextPage = "/passed/Error_Gamen.jsp";
		try{
		String downloadFilePath = "/opt/freerep_files/shinsago/koukaifiles/";//自由形式レポートのレポートデータ本体を格納するディレクトリ（まだ作ってない）
		File downloadFile = new File(downloadFilePath, DLdata.getUploadFileName());//同じくファイル名
		
		File_Download_Utility.execute(downloadFile, response);
		}catch(Exception e){//エラーが発生した場合
			e.printStackTrace();
			session.setAttribute("errcode", "GData-002");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}
}
