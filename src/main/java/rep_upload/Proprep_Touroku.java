package rep_upload;

import inputUtility.CodeMaker;
import inputUtility.Date_Changer;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Proprep_Touroku
 */
public class Proprep_Touroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proprep_Touroku() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		session.setAttribute("errcode", "Rep-010");
		String NextPage = "/passed/Error_Gamen.jsp";
		ServletContext sc = getServletContext();
		Calendar Now = new GregorianCalendar();
		try{
		R_jyouhou_TO kaiindata = (R_jyouhou_TO) session.getAttribute("seiseki");//提出者情報をsessionから抽出
		NewGames_TO Rep_Data = (NewGames_TO) session.getAttribute("propkoumoku");
		
		NewGames_TO TourokuData = null;
		boolean TourokuError = false;
		boolean FileUploadError = false;
		
		String GameTitle = Rep_Data.getGameTitle();
		String MainGenre = Rep_Data.getMainGenre();
		String SubGenre1 = Rep_Data.getSubGenre1();
		String SubGenre2 = Rep_Data.getSubGenre2();
		String PlatForm = Rep_Data.getPlatForm();
		String CatchCopy = Rep_Data.getCatchCopy();
		String Gaiyou = Rep_Data.getGaiyou();
		String PenName = Rep_Data.getPenName();
		String Kikakusya_Sei = Rep_Data.getKikakusya_Sei();
		String Kikakusya_Mei = Rep_Data.getKikakusya_Mei();
		String Seifurigana = Rep_Data.getSeifurigana();
		String Meifurigana = Rep_Data.getMeifurigana();
		String Hogosyasei = Rep_Data.getHogosyasei();
		String Hogosyamei = Rep_Data.getHogosyamei();
		Calendar Seinengappi = Rep_Data.getSeinengappi();
		String Pref = Rep_Data.getPref();
		String Jyusyo = Rep_Data.getJyusyo();
		String Tel_No = Rep_Data.getTel_No();
		String Keitai_No = Rep_Data.getKeitai_No();
		String Fax_No = Rep_Data.getFax_No();
		String Mailaddress = Rep_Data.getMailAddress();
		String URL = Rep_Data.getUrl();
		String Syokugyou = Rep_Data.getSyokugyou();
		String Kinmusaki = Rep_Data.getTsutomesaki();
		String KinmusakiJyusyo = Rep_Data.getTsutomesakiJyusyo();
		String Seisakurireki = Rep_Data.getSeisakurireki();
		String Kikakuito = Rep_Data.getKikakuito();
		String Target = Rep_Data.getTarget();
		String Sabetsuka = Rep_Data.getSabetsuka();
		String Advantage = Rep_Data.getAdvantage();
		String Kikakuryou_Uketori = Rep_Data.getKikakuryou_Uketori();
		int Kikakuryou = Rep_Data.getKikakuryou();
		double Royality = Rep_Data.getRoyality();
		String Bikou = Rep_Data.getBikou();
		String[] Koukaisettei = Rep_Data.getKoukaisettei();
		String Koukaisettei_S = null;
		Calendar UploadTime = new GregorianCalendar();
		
		for(String list : Koukaisettei){
			Koukaisettei_S = list + Koukaisettei_S + "plus;";
		}
		String FileName = Rep_Data.getFileName();
		
		String Kaiin_ID = kaiindata.getk_Id();
		String Kaiin_Name = kaiindata.getlogin_name();
		
		String Seinengappi_S = Integer.toString(Seinengappi.get(Calendar.YEAR)) + "-" + Integer.toString(Seinengappi.get(Calendar.MONTH)) + "-" + Integer.toString(Seinengappi.get(Calendar.DATE));
		String UploadTime_S = Integer.toString(UploadTime.get(Calendar.YEAR)) + "-" + Integer.toString(UploadTime.get(Calendar.MONTH)) + "-" + Integer.toString(UploadTime.get(Calendar.DATE)) + " " +
		Integer.toString(UploadTime.get(Calendar.HOUR)) + ":" + Integer.toString(UploadTime.get(Calendar.MINUTE)) + ":" + Integer.toString(UploadTime.get(Calendar.SECOND));
		
		String Rep_Code = CodeMaker.Rep_Code_Maker("prop", UploadTime);
		
		TourokuData = new NewGames_TO(Rep_Code, GameTitle, MainGenre, SubGenre1, SubGenre2, PlatForm, CatchCopy, Gaiyou, PenName, Kikakusya_Sei, Kikakusya_Mei, Seifurigana, Meifurigana, Hogosyasei, Hogosyamei,
				Seinengappi_S, Pref, Jyusyo, Tel_No, Keitai_No, Fax_No, Mailaddress, URL, Syokugyou, Kinmusaki, KinmusakiJyusyo, Seisakurireki, Kikakuito, Target, Sabetsuka, Advantage,
				Kikakuryou_Uketori, Kikakuryou, Royality, Bikou, Koukaisettei_S, FileName, Kaiin_ID, Kaiin_Name, UploadTime_S);
		if(TourokuData.getKaiin_ID().equals(request.getRemoteUser())){
		NewGame_DAO dao = new NewGame_DAO();
		TourokuError = dao.Proprep_Touroku(TourokuData);
		}else{
			TourokuError = true;
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		@SuppressWarnings("unchecked")
		List<FileItem> list = upload.parseRequest(request);
		Iterator<FileItem> iterator = list.iterator();
		
		File file = null;
		
		while(iterator.hasNext()){
			FileItem item = (FileItem)iterator.next();
			
			if(kaiindata.getk_Id().equals(request.getRemoteUser()) && (!(item.isFormField()))){
				factory.setSizeThreshold(4096);
				upload.setSizeMax(-1);
				upload.setHeaderEncoding("UTF-8");
				
				try{
					String storePath = "/opt/proprep_files/jyushinbox/";
					//String storePath = "D:/TestDirectory/";
					//file = File.createTempFile(Kaiin_ID + "-", ".zip", new File("/opt/proprep_files/"));
					String filename = item.getName();
					if((filename != null) && (!filename.equals(""))){								
						filename = new File(filename).getName();//ファイル名のみを取り出し
						file = new File(storePath + Date_Changer.CalToString(Now).replace("/", "-") + "_" + request.getRemoteUser() + "_" + filename);
					item.write(file);
					item.delete();
				FileUploadError = false;
					}
			}catch(FileUploadException e){
				e.printStackTrace();
				FileUploadError = true;
			}catch(Exception e){
				e.printStackTrace();
				FileUploadError = true;
			}
		}
	}
		if(TourokuError){
			session.setAttribute("errcode", "Rep-210");
			NextPage = "/passed/Error_Gamen.jsp";
		}else if(FileUploadError){
			session.setAttribute("errcode", "Rep-110");
			NextPage = "/passed/Error_Gamen.jsp";
		
	}else{
		NextPage = "/passed/Rep_Uketsuke_Kanryou.html";
	}
	
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "Rep-010");
		NextPage = "/passed/Error_Gamen.jsp";
	}
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	
}

}
