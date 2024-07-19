package gpro_ron;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GRon_Wrong_Uketsuke
 */
public class GRon_Wrong_Uketsuke extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GRon_Wrong_Uketsuke() {
        super();
        // TODO Auto-generated constructor stub
    }
    @SuppressWarnings("unchecked")
    public static <T> T automaticCast(Object src) {
        T castedObject = (T) src;  
        return castedObject;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "GRon-009");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		try{
		String Wrong_No_S = request.getParameter("no");
		int Wrong_No = Integer.parseInt(Wrong_No_S);
		
		ArrayList<GRon_Data_TO> Kakikomi_Lv1 = automaticCast(session.getAttribute("tourondata_lv1"));
		ArrayList<GRon_Data_TO> Kakikomi_Lv2 = automaticCast(session.getAttribute("tourondata_lv2"));
		ArrayList<GRon_Data_TO> Kakikomi_Lv3 = automaticCast(session.getAttribute("tourondata_lv3"));
		
		GRon_Data_TO Wrong_Taisyou = new GRon_Data_TO();
		for(GRon_Data_TO Lv1 : Kakikomi_Lv1){
			if(Lv1.getKakikomi_No() == Wrong_No){
				Wrong_Taisyou = Lv1;
				break;
			}
		}
			for(GRon_Data_TO Lv2 : Kakikomi_Lv2){
			if(Lv2.getKakikomi_No() == Wrong_No){
				Wrong_Taisyou = Lv2;
				break;
			}
			}
				for(GRon_Data_TO Lv3 : Kakikomi_Lv3){
				if(Lv3.getKakikomi_No() == Wrong_No){
					Wrong_Taisyou = Lv3;
					break;
				}
				}
				
				session.setAttribute("wrong_taisyou", Wrong_Taisyou);
				
				NextPage = "/passed/G-PRO_Ron/GRon_Wrong_Kakunin.jsp";
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "GRon-009");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	}

}
