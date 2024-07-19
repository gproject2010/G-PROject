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
 * Servlet implementation class GRon_Etsuran_Load
 */
public class GRon_Etsuran_Load extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GRon_Etsuran_Load() {
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
		session.setAttribute("errcode", "GRon-007");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		//boolean NotEmpty_Lv1 = false;
		//boolean NotEmpty_Lv2 = false;
		//boolean NotEmpty_Lv3 = false;
		
		ArrayList<GRon_Data_TO> GronData_Lv1 = new ArrayList<GRon_Data_TO>();//ベースの書き込み
		ArrayList<GRon_Data_TO> GronData_Lv2 = new ArrayList<GRon_Data_TO>();//返信の書き込み
		ArrayList<GRon_Data_TO> GronData_Lv3 = new ArrayList<GRon_Data_TO>();//返信の返信
		
		try{
			String TaisyouCode = request.getParameter("taisyoucode");
			
			GRon_Data_DAO ronDAO = new GRon_Data_DAO();
			GRon_Data_TO KeijiData = ronDAO.GRon_SyousaiLoad(TaisyouCode);//討論データをロード
			if(KeijiData == null){
				session.setAttribute("errcode", "GRon-109");
				NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
			}else{
				
				ArrayList<GRon_Data_TO> GronData = ronDAO.GRon_Kakikomi_Load(TaisyouCode, "guest");//書き込みの内容を検索(仕分け前)
				
				for(GRon_Data_TO GronData_Bf : GronData){
					if(GronData_Bf.getHenshin_Lv() == 1){//ベースの書き込みなら
						GronData_Lv1.add(GronData_Bf);
					}else if(GronData_Bf.getHenshin_Lv() == 2){//返信なら
						GronData_Lv2.add(GronData_Bf);
					}else if(GronData_Bf.getHenshin_Lv() == 3){//返信の返信なら
						GronData_Lv3.add(GronData_Bf);
					}
				}
				
				session.setAttribute("tourondata_lv1", GronData_Lv1);
				session.setAttribute("tourondata_lv2", GronData_Lv2);
				session.setAttribute("tourondata_lv3", GronData_Lv3);
				
				
					/*
					if(GronData_Lv1 != null){
						NotEmpty_Lv1 = true;
					}
					if(GronData_Lv2 != null){
						NotEmpty_Lv2 = true;
					}
					if(GronData_Lv3 != null){
						NotEmpty_Lv3 = true;
					}*/
			}
			session.setAttribute("keijidata", KeijiData);
			NextPage = "/free_area/GRon_Etsuran/Touron_Etsuran_Page.jsp";
			
			/*}else{
				NextPage = "/error1.jsp";//まだ作ってない
			}*/
			}catch(Exception ex){
				session.setAttribute("errcode", "GRon-009");
				NextPage = "/free_area/Error_Gamen.jsp";//まだ作ってない
				ex.printStackTrace();
			}
			
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
			rd.forward(request, response);
			
	}

}
