package inputUtility;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Date_Changer {

	public static Calendar toCalendar(String strDate){
		final String DATE_PATTERN = "yyyy-MM-dd";
		SimpleDateFormat dateformat = new SimpleDateFormat(DATE_PATTERN);
		java.util.Date date = null;
		
		try{
			date = new java.util.Date(dateformat.parse(strDate).getTime());
		}catch(java.text.ParseException e){
			return null;
		}
		
		Calendar cal_created = Calendar.getInstance();
		cal_created.setTime(date);
		return cal_created;
	}
	
	public static String toDateString(Calendar bef){
		MessageFormat mf = new MessageFormat("{0,date,yyyy/MM/dd HH:mm:ss}");
		Object[] objs = {bef.getTime()};
		String Result = mf.format(objs);
		
		return Result;
	}
	public static java.sql.Date CalToDate(Calendar bef){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date aft = new java.sql.Date(cal.getTimeInMillis());
		return aft;
	}
	public static Calendar DatetoCal(Date bef){
		Calendar aft = new GregorianCalendar();
		aft.setTime(bef);
		return aft;
	}
	public static String CalToString(Calendar bef){
		MessageFormat mf = new MessageFormat("{0,date,yyyy/MM/dd}");
		Object[] objs = {bef.getTime()};
		String aft = mf.format(objs);
		return aft;
	}
}
