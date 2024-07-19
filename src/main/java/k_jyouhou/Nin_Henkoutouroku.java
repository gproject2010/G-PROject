package k_jyouhou;

import gpro_riron.GPRiron_DAO;
import gpro_ron.GRon_Data_DAO;
import inputUtility.Date_Changer;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.Toiawase_DAO;
import ninsyou.N_jyouhou_DAO;
import ninsyou.N_jyouhou_TO;
import pennant_race.PennantData_DAO;
import rep_upload.Rep_List_DAO;
import voteandExpect.VoAndExp_DAO;

/**
 * Servlet implementation class Nin_Henkoutouroku
 */
public class Nin_Henkoutouroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nin_Henkoutouroku() {
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
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "KData-006");
		String NextPage = "/passed/Error_Gamen.jsp";
		boolean k_tourokuerror = true;
		boolean n_tourokuerror = true;
		boolean t_tourokuerror = true;
		boolean gr_tourokuerror = true;
		boolean gp_tourokuerror = true;
		boolean ve_tourokuerror = true;
		boolean pe_tourokuerror = true;
		int affected = 0;
		Calendar Now = new GregorianCalendar();
		
		try{
		K_Touroku_TO Changedata = (K_Touroku_TO)session.getAttribute("n_henkoudata");//変更後のデータ
		N_jyouhou_TO BaseData = (N_jyouhou_TO)session.getAttribute("nin_jyouhou");//変更前のデータ
		//System.out.println("C="+Changedata);
		//System.out.println("B="+BaseData);
		if(Changedata != null && BaseData != null){
			
		//各登録情報を担当するDAOに変更を依頼
		K_jyouhou_DAO dao = new K_jyouhou_DAO();
		k_tourokuerror = dao.N_Data_Upload(Changedata, BaseData);
		
		N_jyouhou_DAO ndao = new N_jyouhou_DAO();
		n_tourokuerror = ndao.N_Data_Upload(Changedata, BaseData, Date_Changer.CalToString(Now));
		
		Rep_List_DAO rdao = new Rep_List_DAO();
		affected = rdao.R_Data_Upload(Changedata, BaseData);
		
		Toiawase_DAO tdao = new Toiawase_DAO();
		t_tourokuerror = tdao.R_Henkou_Upload(Changedata, BaseData);
		
		GRon_Data_DAO grdao = new GRon_Data_DAO();
		gr_tourokuerror = grdao.ID_Henkou_Upload(Changedata, BaseData);
		
		GPRiron_DAO gpdao = new GPRiron_DAO();
		gp_tourokuerror = gpdao.ID_Henkoutouroku(Changedata, BaseData);
		
		VoAndExp_DAO vedao = new VoAndExp_DAO();
		ve_tourokuerror = vedao.VoteId_Change(Changedata, BaseData);
		
		PennantData_DAO pedao = new PennantData_DAO();
		pe_tourokuerror = pedao.IDHenkou_Upload(Changedata, BaseData);
		}
		if(k_tourokuerror == true){
			session.setAttribute("errcode", "KData-306");
			NextPage = "/passed/Error_Gamen.jsp";
		}else if(n_tourokuerror == true){
			session.setAttribute("errcode", "KData-307");
			NextPage = "/passed/Error_Gamen.jsp";
		}else if(affected == -1){
			session.setAttribute("errcode", "KData-308");
			NextPage = "/passed/Error_Gamen.jsp";
		}else if(t_tourokuerror == true){
			session.setAttribute("errcode", "KData-309");
			NextPage = "/passed/Error_Gamen.jsp";
		}else if(gr_tourokuerror == true){
			session.setAttribute("errcode", "KData-310");
			NextPage = "/passed/Error_Gamen.jsp";
		}else if(gp_tourokuerror == true){
			session.setAttribute("errcode", "KData-311");
			NextPage = "/passed/Error_Gamen.jsp";
		}else if(ve_tourokuerror == true){
			session.setAttribute("errcode", "KData-312");
			NextPage = "/passed/Error_Gamen.jsp";
		}else if(pe_tourokuerror == true){
			session.setAttribute("errcode", "KData-313");
			NextPage = "/passed/Error_Gamen.jsp";
		}else{
			session.setAttribute("action", "認証情報");
			session.removeAttribute("n_henkoudata");
			session.removeAttribute("nin_jyouhou");
			session.removeAttribute("wrongdata_henkou");
			NextPage = "/passed/Kaiin_Henkou_Kanryou.jsp";//まだ作ってない
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "KData-006");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
