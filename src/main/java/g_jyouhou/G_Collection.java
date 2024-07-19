package g_jyouhou;

import java.util.ArrayList;

public class G_Collection {

	protected ArrayList<G_jyouhou_TO> list;

	public ArrayList<G_jyouhou_TO> getList(){
		return this.list;
	}
	public void setList(ArrayList<G_jyouhou_TO> list){
		this.list = list;
	}

	public G_Collection(){
	}


	public void addData(G_jyouhou_TO g_data){
		list.add(g_data);
	}

	public G_jyouhou_TO getg_data(int index){
		return list.get(index);
	}

	public int getsize(){
		return list.size();
	}
}
