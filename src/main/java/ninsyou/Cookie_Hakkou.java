package ninsyou;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Servlet implementation class Cookie_Hakkou
 */
public class Cookie_Hakkou extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie_Hakkou() {
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
		session.setAttribute("errcode", "TopMake-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		int ErrorCount = 0;
		
		Cookie_TO tmp = new Cookie_TO();
		ArrayList<Cookie_TO> Cookie = new ArrayList<Cookie_TO>();
		Cookie_DAO dao = new Cookie_DAO();
		
		try{
			R_jyouhou_TO Seiseki = (R_jyouhou_TO) session.getAttribute("seiseki");
			String HostName = request.getRemoteHost();
			Cookie = dao.Cookie_TourokuCounter(Seiseki.getk_Id());
			
			if(Cookie.size() > 5){
				session.setAttribute("cookies", Cookie);
				NextPage = "/passed/Cookie/Cookie_Uwagaki.jsp";
			}else{
				
				String ran = RandomStringUtils.randomAlphanumeric(12);
				tmp = new Cookie_TO(Seiseki.getk_Id(), ran, HostName);
				for(int i=0; i < Cookie.size() + 1; i++){
					if(Cookie.get(i).getHostName().equals(HostName)){
						ErrorCount = dao.Cookie_UwagakiTouroku(tmp, Cookie.get(i).getGPRO_ID(), Cookie.get(i).getHostName(), Cookie.get(i).getHakkounichiji());
						break;
					}else if(i < Cookie.size()){
						ErrorCount = dao.Cookie_ShinkiTouroku(tmp);
						break;
					}
				}
				
				if(ErrorCount != 0){
					session.setAttribute("errorcount", ErrorCount);
				}
				
				Cookie ck = new Cookie("loginpass", ran);
				ck.setMaxAge(3600 * 24 * 30);
				response.addCookie(ck);
				NextPage = "/passed/Cookie/Cookie_Touroku_Result.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "KData-006");
			NextPage = "/passed/Error_Gamen.jsp";
		}
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
			rd.forward(request, response);
		}
}
