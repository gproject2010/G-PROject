package blog;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageFile_Load
 */
public class ImageFile_Load extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageFile_Load() {
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

		String Address = new String(request.getPathInfo().substring(1).getBytes("ISO-8859-1"), "UTF-8");
		//String ImgDir = "/mnt/GRiron_Files/Blog_ImageData/";
		String ImgDir = "F:/GRiron_Files/Blog_ImageData/";

		String ua = request.getHeader("user-agent");
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
	}

}