package gpro_ron;

//import inputUtility.HttpUtility;

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
 * Servlet implementation class Gron_Resp_PageMaker
 */
public class GRon_Resp_PageMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GRon_Resp_PageMaker() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//レスポンス元の書き込みのデータを抽出
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		ServletContext sc = getServletContext();
		session.setAttribute("errcode", "GRon-005");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		GRon_Data_TO Origin = new GRon_Data_TO();
		try{
		String Origin_No_S = request.getParameter("no");//レスポンスする書き込みの整理番号(指定しない場合は0)
		String Command= request.getParameter("command");
		//Origin_No_S = HttpUtility.escapeHTML(Origin_No_S);
		int Origin_No = Integer.parseInt(Origin_No_S);
		Origin = new GRon_Data_TO(Origin_No, Command);
		
		ArrayList<GRon_Data_TO> Kakikomi_Lv1 = automaticCast(session.getAttribute("tourondata_lv1"));
		ArrayList<GRon_Data_TO> Kakikomi_Lv2 = automaticCast(session.getAttribute("tourondata_lv2"));
		ArrayList<GRon_Data_TO> Kakikomi_Lv3 = automaticCast(session.getAttribute("tourondata_lv3"));
		
		GRon_Data_TO Resp_Taisyou = new GRon_Data_TO();
		for(GRon_Data_TO Lv1 : Kakikomi_Lv1){
			if(Lv1.getKakikomi_No() == Origin_No){
				Resp_Taisyou = Lv1;
				break;
			}
		}
			for(GRon_Data_TO Lv2 : Kakikomi_Lv2){
			if(Lv2.getKakikomi_No() == Origin_No){
				Resp_Taisyou = Lv2;
				break;
			}
			}
				for(GRon_Data_TO Lv3 : Kakikomi_Lv3){
				if(Lv3.getKakikomi_No() == Origin_No){
					Resp_Taisyou = Lv3;
					break;
				}
				}
		session.setAttribute("resp_taisyou", Resp_Taisyou);
		session.setAttribute("origin_no", Origin);
		
		NextPage = "/passed/G-PRO_Ron/GRon_Resp_Uketsuke.jsp";
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "GRon-005");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	}

}
