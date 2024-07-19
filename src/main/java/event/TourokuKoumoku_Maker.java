package event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TourokuKoumoku_Maker
 */
public class TourokuKoumoku_Maker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourokuKoumoku_Maker() {
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
		session.setAttribute("errcode", "Event-002");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		EventData_TO TourokuJyouhou = new EventData_TO();
		EventData_TO FormData = new EventData_TO();
		EventData_DAO dao = new EventData_DAO();
		
		String KoumokuList_S = null;
		String InputTypeList_S = null;
		String MojikeishikiList_S = null;
		String MaxLengthList_S = null;
		
		String[] KoumokuList_A = null;
		String[] InputTypeList_A = null;
		String[] MojikeishikiList_A = null;
		String[] MaxLengthList_A = null;
		
		try{
			String Event_Code = request.getParameter("event_code");
			TourokuJyouhou = dao.EventInterview_Load(Event_Code);
			if(TourokuJyouhou.getKoumokuList().isEmpty() == false && TourokuJyouhou.getKoumokuList().length() >= 5){
				if(TourokuJyouhou.getKoumokuList().substring(TourokuJyouhou.getKoumokuList().length() - 5, TourokuJyouhou.getKoumokuList().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
			KoumokuList_S = TourokuJyouhou.getKoumokuList().substring(0, TourokuJyouhou.getKoumokuList().length() - 5);//最後の「plus;」を削除
				}
			KoumokuList_A = KoumokuList_S.split("plus;");
		}else{
			KoumokuList_A = new String[1];
			KoumokuList_A[0] = "";
		}
			if(TourokuJyouhou.getInputTypeList().isEmpty() == false && TourokuJyouhou.getInputTypeList().length() >= 5){
				if(TourokuJyouhou.getInputTypeList().substring(TourokuJyouhou.getInputTypeList().length() - 5, TourokuJyouhou.getInputTypeList().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
			InputTypeList_S = TourokuJyouhou.getInputTypeList().substring(0, TourokuJyouhou.getInputTypeList().length() - 5);
				}
			InputTypeList_A = InputTypeList_S.split("plus;");
			}else{
				InputTypeList_A = new String[1];
				InputTypeList_A[0] = "";
			}
			if(TourokuJyouhou.getMojikeishikiList().isEmpty() == false && TourokuJyouhou.getMojikeishikiList().length() >= 5){
				if(TourokuJyouhou.getMojikeishikiList().substring(TourokuJyouhou.getMojikeishikiList().length() - 5, TourokuJyouhou.getMojikeishikiList().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
			MojikeishikiList_S = TourokuJyouhou.getMojikeishikiList().substring(0, TourokuJyouhou.getMojikeishikiList().length() - 5);
				}
			MojikeishikiList_A = MojikeishikiList_S.split("plus;");
			}else{
				MojikeishikiList_A = new String[1];
				MojikeishikiList_A[0] = "";
			}
			if(TourokuJyouhou.getMaxLengthList().isEmpty() == false && TourokuJyouhou.getMaxLengthList().length() >= 5){
				if(TourokuJyouhou.getMaxLengthList().substring(TourokuJyouhou.getMaxLengthList().length() - 5, TourokuJyouhou.getMaxLengthList().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
			MaxLengthList_S = TourokuJyouhou.getMaxLengthList().substring(0, TourokuJyouhou.getMaxLengthList().length() - 5);
				}
			MaxLengthList_A = MaxLengthList_S.split("plus;");
			}else{
				MaxLengthList_A = new String[1];
				MaxLengthList_A[0] = "";
			}
			
			FormData = new EventData_TO(TourokuJyouhou.getEventCode(), TourokuJyouhou.getEventName(), KoumokuList_A, InputTypeList_A, MojikeishikiList_A, MaxLengthList_A);
			
			session.setAttribute("formdata", FormData);
			NextPage = "/free_area/Event/Event_SankaTouroku.jsp";
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "Event-202");
			NextPage = "/free_area/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}

}
