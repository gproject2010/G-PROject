package inputUtility;

import java.io.File;

public class FileSizeMaker {

	public double FileSizeMake(String FileSyubetsu, String FileName){
		String Dir = null;
		long Size = 0;
		double Result = 0;
		
		if(FileSyubetsu.equals("proprep")){//イメージファイル
			Dir = "/opt/proprep_files/koukaidata/logo/";
			//ImgDir = "D:/TestDirectory/logo/";
			}else if(FileSyubetsu.equals("gamedata")){
				Dir = "/opt/gamelogo_files/";
			}else if(FileSyubetsu.equals("gpro_riron")){
				Dir = "/mnt/GRiron_Files/ImageData/";
				//ImgDir = "D:/TestDirectory/GRiron_ImageData/";
			}else if(FileSyubetsu.equals("event_logo")){
				Dir = "/mnt/GRiron_Files/Event_Files/Event_Logo/";
				//ImgDir = "D:/TestDirectory/event_logo/";
			
			}else if(FileSyubetsu.equals("shiryou1")){//通常ファイル
				Dir = "/mnt/GRiron_Files/Event_Files/Shiryou1/";
				//Dir = "D:/TestDirectory/Event_Shiryou1/";
			    //FileName = Eventshiryou1;
			}else if(FileSyubetsu.equals("shiryou2")){
				Dir = "/mnt/GRiron_Files/Event_Files/Shiryou2/";
				//Dir = "D:/TestDirectory/Event_Shiryou2/";
			    //FileName = Eventshiryou2;
			}else if(FileSyubetsu.equals("shiryou3")){
				Dir = "/mnt/GRiron_Files/Event_Files/Shiryou3/";
				//Dir = "D:/TestDirectory/Event_Shiryou3/";
			    //FileName = Eventshiryou3;
			}
		
		File f = new File(Dir + FileName);
		if(f.exists()){
			Size = f.length();
			Result = (double)Size / 100000;
		}else{
			Result = 0;
		}
		return Result;
	}
}
