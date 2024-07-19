package gpro_riron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;

/**
 * Servlet implementation class Ronbun_SyousaiLoad
 */
public class Ronbun_SyousaiLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ronbun_SyousaiLoad() {
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
		session.setAttribute("errcode", "GriRon-002");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		String str = null;
		String Result = "";
		
		try{
			String RonbunCode = request.getParameter("ronbuncode");
			String RonbunSyubetsu = request.getParameter("ronbunsyubetsu");
			String Kaiin_Id = request.getRemoteUser();
			
			String User = request.getRemoteUser();
			R_jyouhou_TO kaiindata = (R_jyouhou_TO) session.getAttribute("seiseki");//提出者情報をsessionから抽出
			
			GPRiron_TO RonbunData = new GPRiron_TO();
			ArrayList<GPRiron_TO> Comment = new ArrayList<GPRiron_TO>();
			GPRiron_DAO dao = new GPRiron_DAO();
			
			RonbunData = dao.RironSyousai_Load(RonbunCode);
			Comment = dao.Comment_Load(RonbunCode);
			
			if(RonbunSyubetsu.equals("mydata") && Kaiin_Id.equals(RonbunData.getPlayer_Id()) && Kaiin_Id.equals(User) && Kaiin_Id.equals(kaiindata.getk_Id())){
				String HtmlFileName = "/mnt/GRiron_Files/HTMLData/" + RonbunData.getHTMLFileName();
				//String HtmlFileName = "D:/TestDirectory/GRiron_HTMLData/" + RonbunData.getHTMLFileName();
				BufferedReader in = new BufferedReader(new FileReader(HtmlFileName));
				while((str = in.readLine()) != null){
					Result = Result + str;
					Result = Result + "\n";
				}
				//画像挿入タグを入力用のものに戻す
				Result = Result.replace("<img src=\"/G-pro_Service/LogoImage_Load/" + RonbunData.getImageFileName1() + "?syubetsu=gpro_riron\"/>\n", "<image1>\n");
				Result = Result.replace("<img src=\"/G-pro_Service/LogoImage_Load/" + RonbunData.getImageFileName2() + "?syubetsu=gpro_riron\"/>\n", "<image2>\n");
				Result = Result.replace("<img src=\"/G-pro_Service/LogoImage_Load/" + RonbunData.getImageFileName3() + "?syubetsu=gpro_riron\"/>\n", "<image3>\n");
				
				Result = Result.replace("<HEAD>", "<head>");
				Result = Result.replaceFirst("<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" + 
				"<meta http-equiv=\"Content-Style-Type\" content=\"text/css\">", "<head>");
				
				session.setAttribute("source", Result);//ソースそのものを文字列としてセッションにセット
				in.close();
				
				session.setAttribute("ronbundata", RonbunData);
				session.setAttribute("comment", Comment);
				NextPage = "/passed/GPRO_Riron/Ronbun_Hensyu.jsp";//自分の論文を編集するときは本人がアクセスしていることを確認したうえで編集画面へフォワード
			}else if(RonbunSyubetsu.equals("otherdata")){
				boolean Touhyouflg = false;
				for(int i=0; i < RonbunData.getShijisyaList().length; i++){
					if(RonbunData.getShijisyaList()[i].equals(Kaiin_Id)){
						Touhyouflg = true;
					}
				}
				for(int i=0; i < RonbunData.getFushijisyalist().length; i++){
					if(RonbunData.getFushijisyalist()[i].equals(Kaiin_Id)){
						Touhyouflg = true;
					}
				}
				session.setAttribute("touhyou", Touhyouflg);
				session.setAttribute("ronbundata", RonbunData);
				session.setAttribute("comment", Comment);
				NextPage = "/passed/GPRO_Riron/Riron_Etsuran.jsp";//他人の論文を閲覧するときは閲覧画面へフォワード
			}else{
				session.setAttribute("errcode", "GriRon-002");//論文の種別を確認できない場合はエラーとする
				NextPage = "/passed/Error_Gamen.jsp";
			}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "GriRon-003");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}

}