package gpro_riron;

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
 * Servlet implementation class Ronbun_Update_Kakunin
 */
public class Ronbun_Update_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ronbun_Update_Kakunin() {
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
		String Source_Henkou = "keep";//ソースに変更があればchange、なければkeep
		GPRiron_TO ErrorList = new GPRiron_TO("", "", "", "");
		
		session.setAttribute("errcode", "GRiron-004");
		String NextPage = "/passed/Error_Gamen.jsp";
		ServletContext sc = getServletContext();
		Calendar Now = new GregorianCalendar();
		
		try{
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
		String BeforeSource = (String)session.getAttribute("source");
		GPRiron_TO OldData = (GPRiron_TO)session.getAttribute("ronbundata");
		GPRiron_TO NewData = OldData.clone();
		String SourceCode = null;
		String FieldName = null;
		String ImgFileName = null;
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
		
		while(iterator.hasNext()){
			FileItem item = (FileItem)iterator.next();
			if(OldData.getPlayer_Id().equals(request.getRemoteUser()) && OldData.getPlayer_Id().equals(KaiinData.getk_Id())){
				if(!(item.isFormField())){
					ImgFileName = item.getName();
					byte[] bytes = ImgFileName.getBytes("iso-8859-1");
					ImgFileName = new String(bytes, "utf-8");
					ImgFileName = new File(ImgFileName).getName();//ファイル名のみを取り出し
				if(item.getFieldName().equals("imagefile1") && ImgFileName != null && (!(ImgFileName.equals(""))) && OldData.getImageFileName1().indexOf(ImgFileName) == -1){
					NewData.setImageFileName1(Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + ImgFileName + ".gif");
				}else if(item.getFieldName().equals("imagefile2") && ImgFileName != null && (!(ImgFileName.equals(""))) && OldData.getImageFileName2().indexOf(ImgFileName) == -1){
					NewData.setImageFileName2(Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + ImgFileName + ".gif");
				}else if(item.getFieldName().equals("imagefile3") && ImgFileName != null && (!(ImgFileName.equals(""))) && OldData.getImageFileName3().indexOf(ImgFileName) == -1){
					NewData.setImageFileName3(Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + ImgFileName + ".gif");
				}
				}else if(item.getFieldName().equals("ronbuntitle")){
					RonbunTitle = item.getString();
					byte[] bytes = RonbunTitle.getBytes("iso-8859-1");
					RonbunTitle = new String(bytes, "utf-8");
					WrongTitle = HttpUtility.NG_Word_Check(RonbunTitle);
					if(WrongTitle == null && NewData != null){
						NewData.setRonbunTitle(RonbunTitle);
					}
				}
			}
		}
		
		iterator = list.iterator();
		
				while(iterator.hasNext()){
					FileItem item = (FileItem)iterator.next();
					if(OldData.getPlayer_Id().equals(request.getRemoteUser())){
						if(!(item.isFormField())){
							ImgFileName = item.getName();
							ImgFileName = new File(ImgFileName).getName();//ファイル名のみを取り出し
				factory.setSizeThreshold(4096);
				upload.setSizeMax(-1);
				upload.setHeaderEncoding("UTF-8");
				
					storePath = "/mnt/GRiron_Files/ImageData/";//画像（バイナリ）ファイルのアップロード
					//storePath = "D:/TestDirectory/GRiron_ImageData/";
					try{
					if((ImgFileName != null) && (!ImgFileName.equals("")) && (OldData.getImageFileName1().indexOf(ImgFileName) == -1 && OldData.getImageFileName2().indexOf(ImgFileName) == -1 && OldData.getImageFileName3().indexOf(ImgFileName) == -1)){								
						imgfile = new File(storePath + Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + ImgFileName + ".gif");//同じ名前のファイルが登録されていない場合のみ新たにファイルを登録
					item.write(imgfile);
					
					item.delete();
					}
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
					}else{
						try{
						FieldName = item.getFieldName();
						if(FieldName.equals("sourcecode")){
							SourceCode = item.getString();
							byte[] bytes = SourceCode.getBytes("iso-8859-1");
							SourceCode = new String(bytes, "utf-8");
							if(!(BeforeSource.equals(SourceCode))){
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
									WrongSource = false;
									storePath = "/mnt/GRiron_Files/HTMLFiles/";//HTML（テキスト）ファイルの作成
									//storePath = "D:/TestDirectory/GRiron_HTMLData/";
									SourceCode = item.getString("UTF-8");
								//画像挿入タグをHTML準拠のものに変換
									if(NewData.getImageFileName1() != null){
								SourceCode = SourceCode.replace("<image1>", "<img src=\"/G-pro_Service/LogoImage_Load?address=" + NewData.getImageFileName1() + "&syubetsu=gpro_riron\"/>");
									}if(NewData.getImageFileName2() != null){
										SourceCode = SourceCode.replace("<image2>", "<img src=\"/G-pro_Service/LogoImage_Load?address=" + NewData.getImageFileName2() + "&syubetsu=gpro_riron\"/>");
									}if(NewData.getImageFileName3() != null){
										SourceCode = SourceCode.replace("<image3>", "<img src=\"/G-pro_Service/LogoImage_Load?address=" + NewData.getImageFileName3() + "&syubetsu=gpro_riron\"/>");
									}
								
								SourceCode = SourceCode.replace("<head>", "<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" + 
								"<meta http-equiv=\"Content-Style-Type\" content=\"text/css\">");
								
								SourceFileName = Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + NewData.getRonbunTitle() + ".html";
								FullPath = storePath + SourceFileName;
								
								PrintWriter fout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FullPath), "UTF-8")));
								NewData.setHTMLFileName(SourceFileName);
								NewData.setKoushinDate(Date_Changer.toDateString(Now));
								fout.write(SourceCode);
								fout.close();
								Source_Henkou = "change";
							}
						}
						}
						session.setAttribute("source_henkou", Source_Henkou);
						}catch(Exception e){
							e.printStackTrace();
							if(FieldName.equals("sourcecode")){
								ErrorList.setHTMLFileUploadError(SourceFileName);
							}
						}
					}
				}
		}
		if(WrongSource == true){
			session.setAttribute("newdata", NewData);
			session.setAttribute("olddata", OldData);//新規登録の場合は編集前・後のデータが同一
			session.setAttribute("wrongtag", WrongTag);
			session.setAttribute("wrongtitle", WrongTitle);
			session.setAttribute("wrongword", WrongWord);
			session.setAttribute("wronglength", WrongLength);
			session.setAttribute("errorlist", ErrorList);
			session.setAttribute("etcerror", false);
			NextPage = "/passed/GPRO_Riron/Ronbun_Hensyu_Syusei.jsp";
		}else if(!(ErrorList.getImgFileUploadError1() == null || ErrorList.getImgFileUploadError1().equals("")) && (ErrorList.getImgFileUploadError2() == null || ErrorList.getImgFileUploadError2().equals("")) && (ErrorList.getImgFileUploadError3() == null || ErrorList.getImgFileUploadError3().equals("")) && (ErrorList.getHTMLFileUploadError() == null || ErrorList.getHTMLFileName().equals(""))){
			session.setAttribute("syorisyubetsu", "koushin");
			session.setAttribute("errorlist", ErrorList);
			NextPage = "/passed/GPRO_Riron/Ronbun_Upload_Error.jsp";
		}else{
			session.setAttribute("olddata", OldData);
			session.setAttribute("newdata", NewData);
			NextPage = "/passed/GPRO_Riron/Ronbun_Hensyu_Kakunin.jsp";
		}
		session.setAttribute("syorisyubetsu", "update");
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "GRiron-005");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		
	}
}
