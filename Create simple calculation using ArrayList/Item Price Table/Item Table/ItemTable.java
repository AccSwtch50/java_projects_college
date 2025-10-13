import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Item {
	int id;
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
		
		HashMap<String, Integer> column_lengths = new HashMap<>();
		
		column_lengths.put("No", 2);
		column_lengths.put("Item", 4);
		column_lengths.put("Price", 3);
		column_lengths.put("Qty", 5);
		column_lengths.put("Subtotal", 1);
		
		int total_length = 0;
		for (String column_header : column_lengths.keySet()) {
			int column_trailing_length = column_lengths.get(column_header);
			total_length += column_header.length() + column_trailing_length;
		}
		
		final String divider = "-".repeat(total_length);
		
		System.out.print("\n");
		
		for (String column_header : column_lengths.keySet()) {
			int column_trailing_length = column_lengths.get(column_header);
			System.out.print(column_header);
			System.out.print(" ".repeat(column_trailing_length));
		}
		
		System.out.print("\n");
		
		System.out.print(divider);
		
		System.out.print("\n");
		
		int total_price = 0;
		for (int item_index = 0; item_index < item_list.size(); item_index++) {
			Item item = item_list.get(item_index);
			
			for (String column_header : column_lengths.keySet()) {
				int column_trailing_length = column_lengths.get(column_header);
				int column_total_length = column_header.length() + column_trailing_length;
				String value_printed = "";
				if (column_header == "No") {
					value_printed = String.valueOf(item_index + 1) + ".";
				}
				if (column_header == "Item") {
					value_printed = item.name;
				}
				if (column_header == "Price") {
					value_printed = String.valueOf(item.price);
				}
				if (column_header == "Qty") {
					value_printed = String.valueOf(item.quantity);
				}
				if (column_header == "Subtotal") {
					value_printed = String.valueOf(item.subtotal);
					total_price += item.subtotal;
				}
				System.out.print(value_printed);
				System.out.print(" ".repeat(column_total_length - value_printed.length()));
			}
			
			System.out.print("\n");
		}
		
		System.out.print(divider);
		
		System.out.print("\n");
		
		System.out.println("Total " + String.valueOf(total_price));
	}
}