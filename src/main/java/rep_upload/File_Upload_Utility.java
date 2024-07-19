package rep_upload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class File_Upload_Utility {

	public static boolean execute(HttpServletRequest request, String storePath) throws IOException, ServletException{//参考ページのpathは本ソースでいうstorepath
		request.setCharacterEncoding("UTF-8");
		
	DiskFileItemFactory factory = new DiskFileItemFactory();
	ServletFileUpload upload = new ServletFileUpload(factory);
	//System.out.println("1st!");
	factory.setSizeThreshold(4096);
	upload.setSizeMax(-1);
	upload.setHeaderEncoding("UTF-8");
	try{
		@SuppressWarnings("rawtypes")
		List list = upload.parseRequest(request);
		//System.out.println("Size="+list.size());
		
		@SuppressWarnings("rawtypes")
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			FileItem fItem = (FileItem)iterator.next();
			//System.out.println("2nd!");
			if(!(fItem.isFormField())){
				
				String filename = fItem.getName();
				
				if((filename != null) && (filename.equals(""))){
					filename = (new File(filename)).getName();
					
					fItem.write(new File(storePath + "/" + filename));
					//System.out.println(storePath + "/" + filename);
			}
		}
		}
		return false;
	}catch(FileUploadException e){
		e.printStackTrace();
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return true;
	}
	}
		
}
