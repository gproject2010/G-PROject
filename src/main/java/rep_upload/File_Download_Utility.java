package rep_upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.activation.FileDataSource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class File_Download_Utility {

	public static void execute(File downloadFile, HttpServletResponse response)throws IOException, ServletException{
		
		byte buffer[] = new byte[4096];
		
		String filename = downloadFile.getName();
		
		FileDataSource fds = new FileDataSource(filename);
		String contentType = fds.getContentType();
		
		response.setContentType(contentType);
		
		response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"");
		
		ServletOutputStream out = response.getOutputStream();
		FileInputStream fin = new FileInputStream(downloadFile);
		int size;
		while((size = fin.read(buffer)) != -1){
			out.write(buffer, 0, size);
		}
		fin.close();
		out.close();
	}
}
