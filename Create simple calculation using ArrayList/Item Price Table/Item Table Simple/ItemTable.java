import java.util.ArrayList;
import java.util.Collections;

class Item {
	String name;
	int price;
	int quantity;
	int subtotal;
	
	public Item (String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.subtotal = this.price * this.quantity;
	}
}

public class ItemTable {
	public static void main(String[] args) throws Exception {
		ArrayList<Item> item_list = new ArrayList<>();
		
		item_list.add(new Item("Bags", 100000, 2));
		item_list.add(new Item("Hat", 20000, 2));
		
		System.out.print("\n");
		
		System.out.print("No");
		System.out.print("\t");
		System.out.print("Item");
		System.out.print("\t");
		System.out.print("Price");
		System.out.print("\t");
		System.out.print("Qty");
		System.out.print("\t");
		System.out.print("Subtotal");
		
		System.out.print("\n");
		
		System.out.print("-".repeat(40));
		
		System.out.print("\n");
		
		int total_price = 0;
		for (int item_index = 0; item_index < item_list.size(); item_index++) {
			Item item = item_list.get(item_index);
			
			System.out.print(String.valueOf(item_index + 1) + ".");
			System.out.print("\t");
			System.out.print(item.name);
			System.out.print("\t");
			System.out.print(String.valueOf(item.price));
			System.out.print("\t");
			System.out.print(String.valueOf(item.quantity));
			System.out.print("\t");
			System.out.print(String.valueOf(item.subtotal));
			total_price += item.subtotal;
			System.out.print("\n");
		}
		
		System.out.print("-".repeat(40));
		
		System.out.print("\n");
		
		System.out.println("Total " + String.valueOf(total_price));
	}
}