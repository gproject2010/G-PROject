package ninsyou;

import java.util.ArrayList;

public class K_Collection<Kaiin_n> {

	protected ArrayList<Kaiin_n>list;

	public ArrayList<Kaiin_n> getList(){
		return this.list;
	}
	public void setList(ArrayList<Kaiin_n> list){
		this.list = list;
	}
	public K_Collection(){
	}

	public void addKaiin(Kaiin_n kaiin_n){
		list.add(kaiin_n);
	}
	public Kaiin_n getKaiin(int index){
		return list.get(index);
	}
	public int getSize(){
		return list.size();
	}
}
