package inputUtility;

//import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.OutputStream;
//import javax.imageio.ImageIO;

//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Servlet implementation class LogoImage_Load
 */
public class LogoImage_Load extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoImage_Load() {
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
		response.setContentType("image/jpeg");
		//OutputStream out = response.getOutputStream();

		String Address = new String(request.getPathInfo().substring(1).getBytes("ISO-8859-1"), "UTF-8");
		String HyoujiSyubetsu = request.getParameter("syubetsu");

		//NewGame_DAO newgamedao = new NewGame_DAO();//詳細情報の検索依頼
		//NewGames_TO NewGData = new NewGames_TO();
		//NewGData = newgamedao.Prop_Syousai(Rep_Code);//検索結果の受け取り
		String ImgDir = null;

		try{
		//String ImgName = NewGData.getLogoAddress();
		if(HyoujiSyubetsu.equals("proprep")){
		ImgDir = "/opt/proprep_files/koukaidata/logo/";
		//ImgDir = "D:/TestDirectory/logo/";
		}else if(HyoujiSyubetsu.equals("gamedata")){
			ImgDir = "/opt/gamelogo_files/";
		}else if(HyoujiSyubetsu.equals("gpro_riron")){
			ImgDir = "/mnt/GRiron_Files/ImageData/";
			//ImgDir = "D:/TestDirectory/GRiron_ImageData/";
		}else if(HyoujiSyubetsu.equals("event_poster")){
			ImgDir = "/mnt/GRiron_Files/Event_Files/Event_Poster/";
			//ImgDir = "D:/TestDirectory/Event_Poster/";
			Address = Address + ".gif";//イベント名そのものがファイル名となるため拡張子を付加
		}else if(HyoujiSyubetsu.equals("event_logo")){
			ImgDir = "/mnt/GRiron_Files/Event_Files/Event_Logo/";
			//ImgDir = "D:/TestDirectory/Event_Logo/";
		}else if(HyoujiSyubetsu.equals("shop_syoukai")){
			ImgDir = "/mnt/GRiron_Files/ShopData/Shop_Syoukai/";//店舗紹介ページ用
			//ImgDir = "D:/TestDirectory/Event_Logo/";
		}else if(HyoujiSyubetsu.equals("shop_photo")){
			ImgDir = "/mnt/GRiron_Files/ShopData/Shop_Photo/";//会場外観用
			//ImgDir = "D:/TestDirectory/Event_Logo/";
			Address = Address + ".jpg";//店名そのものがファイル名となるため拡張子を付加
		}
		//String ImgDir = "D:/TestDirectory/logo/";

		/*
		BufferedImage im = null;

		File f = new File(ImgDir + Address);
		if(f.exists()){
			try{
				im = ImageIO.read(f);
			}catch(IOException e){
				im = new BufferedImage(300,200,BufferedImage.TYPE_INT_RGB);//仮のイメージ
			}
		}else{
			im = new BufferedImage(300,200,BufferedImage.TYPE_INT_RGB);//仮のイメージ
		}

		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(im);

		out.close();
		*/

		String ua = request.getHeader("user-agent");
		/*if(ua.contains("MSIE")){
			Address = URLEncoder.encode(Address, "UTF-8");
		}else{
			Address = MimeUtility.encodeWord(Address, "ISO-2022-JP", "B");
		}
		*/
		if(ua.contains("Safari")){
			response.setContentType("application/octet-stream;");
		}else{
			response.setContentType("image/jpeg; charset=UTF-8;");
			response.setHeader("Content-Disposition", "inline; filename=\"" + Address + "\"");
		}

		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(ImgDir + Address));
		byte[] data = new byte[1048576];
		int len;

		while((len = bin.read(data, 0, 1048576)) != -1){
			out.write(data, 0, len);
		}
		bin.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
