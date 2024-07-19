package k_jyouhou;
import java.util.ArrayList;

public class K_Rank_Collection {
	
	protected static ArrayList<K_Ranking_TO> list;
	
	public ArrayList<K_Ranking_TO> getList(){
		return K_Rank_Collection.list;
	}
	public void setList(ArrayList<K_Ranking_TO> list){
		K_Rank_Collection.list = list;
	}
	
	public K_Rank_Collection(){
	}
	
	public static void adddata(K_Ranking_TO result){
		list.add(result);
	}
	
	
	public K_Ranking_TO getRank(int index){
		return list.get(index);
	}
	
	public int getsize(){
		return list.size();
	}

}

