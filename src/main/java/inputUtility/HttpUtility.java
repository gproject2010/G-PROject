package inputUtility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HttpUtility {
	
	public HttpUtility(){
	}

	public static String escapeHTML(String input){
		if(input != null){
		char c;
		StringBuffer output = new StringBuffer();
		int length = input.length();
		for(int i=0; i<length; i++){
			c = input.charAt(i);
			if(c == '<'){
				output.append("&lt;");
			}else if(c == '>'){
				output.append("&gt;");
			}else if(c == '&'){
				output.append("&amp;");
			}else if(c == '"'){
				output.append("&quot;");
			}else{
				output.append(c);
			}
		}
		return output.toString();
		}else{
			return "No_Data";
		}
	}
	
	public static String escapeSQL(String input){
		char c;
		StringBuffer output = new StringBuffer();
		int length = input.length();
		for(int i=0; i<length; i++){
			c = input.charAt(i);
			if(c == '\'' ){
				output.append("''");
			}else if(c == '\\'){
				output.append("\\\\");
			}else if(c == '"'){
				output.append("\\\"");
			}else if(c == ';'){
				output.append("sc");
			}else{
				output.append(c);
			}
		}
		return output.toString();
	}
	
	public static String NG_Word_Check(String input){
		String[] NGWords = {"殺す","死ね","食物連鎖の一番下の人","糞","まんこ","マンコ","ちんちん","ちんぽ","チンポ","ウザい","うざい","アナル","シャブ","クソゲー","ちんこ"};
		for(String NGWord : NGWords){
			if(input.toLowerCase().indexOf(NGWord) != -1){
				return NGWord;
			}
		}
		return null;
	}
	
	public static String NG_Tag_Check(String Input){
		String[] NGTags = {"<isindex", "<base", "<link", "<script", "<noscript", "<pre", "<code", "<samp", "<kbd", "<var", "<cite",
				"<a", "<code", "<form", "<fieldset", "<legend", "<label", "<input", "<button", "<datalist", "<select", "<option",
				"<optgroup", "<textarea", "<keygen", "<output", "<progress", "<meter", "<applet", "<param", "<frameset", "<frame", "<noframes", "<img", "<iframe", "<video",
				"<enbed", "<object", "<audio", "<source", "<track", "<canvas", "<map", "<area", "<ditails", "<summary", "<command", "<menu", "background="};
		for(String list : NGTags){
			if(Input.toLowerCase().indexOf(list) != -1){//使用禁止のタグが検出されたら（大文字・小文字問わず）
				return HttpUtility.escapeHTML(list) + "&gt;";//そのタグをエスケープ処理したうえで返す
			}
		}
		return "";
	}
	
	public static double Round(double BefVal, int Place, String Mode){//処理前の値、小数点以下の桁数、何をするか
		
		BigDecimal Befbd = new BigDecimal(BefVal);
		BigDecimal Aftbd = null;
		
		if(Mode.equals("4/5")){
			Aftbd = Befbd.setScale(Place-1, RoundingMode.HALF_UP);
		}else if(Mode.equals("cut")){
			Aftbd = Befbd.setScale(Place-1, RoundingMode.HALF_DOWN);
		}else if(Mode.equals("roundup")){
			Aftbd = Befbd.setScale(Place-1, RoundingMode.HALF_UP);
		}
		
		return Aftbd.doubleValue();
	}
	
	public static boolean digitAlphabetCheck(String Input){//半角英数字のみならtrue,それ以外の文字が検出されればればfalse
		return Input.matches("^[0-9A-Za-z]+$");
	}
	
	public static boolean digitCheck(String Input){//半角数字のみならtrue,それ以外の文字が検出されればればfalse
		return Input.matches("^[0-9]+$");
	}
}
