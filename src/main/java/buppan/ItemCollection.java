package buppan;

import java.util.ArrayList;

public class ItemCollection {
	
	protected ArrayList<ItemData> list;
	
	public ArrayList<ItemData> getList(){
		return this.list;
	}
	public void setList(ArrayList<ItemData> list){
		this.list = list;
	}
	
	public ItemCollection(){
	}
	
	public void addItem(ItemData item_S){
		list.add(item_S);
	}
	
	public ItemData getItem(ItemData index){
		return index;
	}
	
	public int getsize(){
		return list.size();
	}

}
