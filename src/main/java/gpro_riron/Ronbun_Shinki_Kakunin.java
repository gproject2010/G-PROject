package gpro_riron;

import inputUtility.CodeMaker;
import inputUtility.Date_Changer;
import inputUtility.HttpUtility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
 * Servlet implementation class Ronbun_Shinki_Kakunin
 */
public class Ronbun_Shinki_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ronbun_Shinki_Kakunin() {
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
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		boolean WrongSource = true;
		boolean WrongLength = true;
		GPRiron_TO ErrorList = new GPRiron_TO("", "", "", "");
		
		session.setAttribute("errcode", "GRiron-004");
		String NextPage = "/passed/Error_Gamen.jsp";
		ServletContext sc = getServletContext();
		Calendar Now = new GregorianCalendar();//（DBとファイル名の登録時刻がずれないようにここで確定）
		
		try{
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
		GPRiron_TO NewData = null;
		GPRiron_TO OldData = null;
		String SourceCode = null;
		String FieldName = null;
		
		String ImgFileName = null;
		String Image1 = null;
		String Image2 = null;
		String Image3 = null;
		
		String SourceFileName = null;
		String storePath = null;
		String FullPath = null;
		String RonbunTitle = null;
		
		String WrongTag = "";
		String WrongWord = "";
		String WrongTitle = "";

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		@SuppressWarnings("unchecked")
		List<FileItem> list = upload.parseRequest(request);
		Iterator<FileItem> iterator = list.iterator();
		
		File imgfile = null;
		
		while(iterator.hasNext()){//アップロードファイル名の処理
			FileItem item = (FileItem)iterator.next();
				if(KaiinData.getk_Id().equals(request.getRemoteUser())){
					if(!(item.isFormField())){
					ImgFileName = item.getName();
					byte[] bytes = ImgFileName.getBytes("iso-8859-1");
					ImgFileName = new String(bytes, "utf-8");
					ImgFileName = new File(ImgFileName).getName();//ファイル名のみを取り出し
					if(item.getFieldName().equals("imagefile1") && ImgFileName != null && (!(ImgFileName.equals("")))){
					Image1 = Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + ImgFileName + ".gif";
					}else if(item.getFieldName().equals("imagefile2") && ImgFileName != null && (!(ImgFileName.equals("")))){
						Image2 = Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + ImgFileName + ".gif";
					}else if(item.getFieldName().equals("imagefile3") && ImgFileName != null && (!(ImgFileName.equals("")))){
						Image3 = Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + ImgFileName + ".gif";
					}
					}else if(item.getFieldName().equals("ronbuntitle")){
						RonbunTitle = item.getString();
						byte[] bytes = RonbunTitle.getBytes("iso-8859-1");
						RonbunTitle = new String(bytes, "utf-8");
						WrongTitle = HttpUtility.NG_Word_Check(RonbunTitle);
					}
				}
		}
			iterator = list.iterator();
			
				while(iterator.hasNext()){//ファイルそのものに対する処理
					FileItem item = (FileItem)iterator.next();
					if(KaiinData.getk_Id().equals(request.getRemoteUser())){
						if(!(item.isFormField())){
							ImgFileName = item.getName();
							byte[] bytes = ImgFileName.getBytes("iso-8859-1");
							ImgFileName = new String(bytes, "utf-8");
				
				factory.setSizeThreshold(4096);
				upload.setSizeMax(-1);
				upload.setHeaderEncoding("UTF-8");
				
					storePath = "/mnt/GRiron_Files/ImageData/";//画像（バイナリ）ファイルのアップロード
					//storePath = "D:/TestDirectory/GRiron_ImageData/";
					if((ImgFileName != null && (!(ImgFileName.equals(""))) && ((Image1 != null) || (Image2 != null) || (Image3 != null)))){
						try{
						imgfile = new File(storePath + Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + ImgFileName + ".gif");
					item.write(imgfile);
					
					item.delete();
						}catch(FileUploadException e){
							e.printStackTrace();
							if(item.getFieldName().equals("imagefile1")){
								ErrorList.setImgFileUploadError1(ImgFileName);
							}if(item.getFieldName().equals("imagefile2")){
								ErrorList.setImgFileUploadError2(ImgFileName);
							}if(item.getFieldName().equals("imagefile3")){
								ErrorList.setImgFileUploadError3(ImgFileName);
							}
						}
					}
					}else{
						try{
						FieldName = item.getFieldName();
						if(FieldName.equals("sourcecode")){
							SourceCode = item.getString();
							byte[] bytes = SourceCode.getBytes("iso-8859-1");
							SourceCode = new String(bytes, "utf-8");
							session.setAttribute("source", SourceCode);
								WrongTag = HttpUtility.NG_Tag_Check(SourceCode);//使用禁止のタグおよび禁止ワードがあるか検査し、問題なければHTMLファイルを作成
								WrongWord = HttpUtility.NG_Word_Check(SourceCode);
								if(SourceCode.length() < 20 || SourceCode.length() > 25000){
									WrongSource = true;
									WrongLength = true;
								}else{
									WrongLength = false;
								}
								if((WrongTag == null || WrongTag.equals("")) && (WrongTitle == null || WrongTitle.equals("")) && WrongLength == false && (WrongWord == null || WrongWord.equals(""))){
									storePath = "/mnt/GRiron_Files/HTMLData/";//HTML（テキスト）ファイルの作成
									//storePath = "D:/TestDirectory/GRiron_HTMLData/";
									SourceCode = item.getString("UTF-8");
								//画像挿入タグをHTML準拠のものに変換
									if(Image1 != null){
								SourceCode = SourceCode.replace("<image1>", "<img src=\"/G-pro_Service/LogoImage_Load?address=" + Image1 + "&syubetsu=gpro_riron\"/>\n");
									}if(Image2 != null){
								SourceCode = SourceCode.replace("<image2>", "<img src=\"/G-pro_Service/LogoImage_Load?address=" + Image2 + "&syubetsu=gpro_riron\"/>\n");
									}if(Image3 != null){
								SourceCode = SourceCode.replace("<image3>", "<img src=\"/G-pro_Service/LogoImage_Load?address=" + Image3 + "&syubetsu=gpro_riron\"/>\n");
									}
									
									SourceCode = SourceCode.replaceFirst("<head>", "<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" + 
									"<meta http-equiv=\"Content-Style-Type\" content=\"text/css\">");
									
								SourceFileName = Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + RonbunTitle + ".html";
								FullPath = storePath + SourceFileName;
								
								PrintWriter fout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FullPath), "UTF-8")));
								fout.write(SourceCode);
								fout.close();
							WrongSource = false;
								}
						}
						}catch(Exception e){
							e.printStackTrace();
							if(FieldName.equals("sourcecode")){
								ErrorList.setHTMLFileUploadError(SourceFileName);
							}
						}
					}
				}
				}
				
				NewData = new GPRiron_TO(CodeMaker.Riron_Code_Maker("gpriron", Now), RonbunTitle, KaiinData.getk_Id(), KaiinData.getlogin_name(), Date_Changer.toDateString(Now), null, null, SourceFileName, Image1, Image2, Image3);
				OldData = NewData.clone();
				
		if(WrongSource == true){
			session.setAttribute("newdata", NewData);
			session.setAttribute("olddata", OldData);//新規登録の場合は編集前・後のデータが同一
			session.setAttribute("wrongtag", WrongTag);
			session.setAttribute("wrongtitle", WrongTitle);
			session.setAttribute("wrongword", WrongWord);
			session.setAttribute("wronglength", WrongLength);
			session.setAttribute("errorlist", ErrorList);
			session.setAttribute("etcerror", false);
			NextPage = "/passed/GPRO_Riron/Ronbun_Shinki_Syusei.jsp";
		}else if(!(ErrorList.getImgFileUploadError1().equals("")) && (ErrorList.getImgFileUploadError2().equals("")) && (ErrorList.getImgFileUploadError3().equals("")) && (ErrorList.getHTMLFileName().equals(""))){
			session.setAttribute("syorisyubetsu", "shinki");
			session.setAttribute("errorlist", ErrorList);
			NextPage = "/passed/GPRO_Riron/Ronbun_Upload_Error.jsp";
		}else{
			session.setAttribute("newdata", NewData);
			NextPage = "/passed/GPRO_Riron/Ronbun_Shinki_Kakunin.jsp";
		}
		session.setAttribute("syorisyubetsu", "shinki");
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "GRiron-004");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
					}
}
