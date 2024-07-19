package buppan;

public class Cart extends ItemCollection{//ItemCollectionを継承することによりItemCollection_TOの役割も果たす
	
	public Cart(){
	}
	
	@SuppressWarnings("unlikely-arg-type")//暫定処置
	public void removeItem(String index){
		list.remove(index);
	}
	
	public int getTotalPrice(){
		
		int totalPrice = 0;
		for(ItemData item : list){
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}

}
