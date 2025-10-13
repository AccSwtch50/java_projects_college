import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

class Input {
	String field_label;
	private static final Scanner system_input = new Scanner(System.in);
	
	public static String input(String field_label) {
		System.out.print(field_label);
		return system_input.nextLine();
	}
}

public class ItemTable {
	public static void main(String[] args) throws Exception {
		ArrayList<Item> item_list = new ArrayList<>();
		
		String item_name = "";
		int item_price = 0;
		int item_quantity = 0;
		
		while (true) {
			item_name = Input.input("What's the name of the item? ");
			item_price = Integer.parseInt(Input.input("What's the price of the item? "));
			item_quantity = Integer.parseInt(Input.input("How many of this item do you want to buy? "));
			item_list.add(new Item(item_name, item_price, item_quantity));
			String should_continue_adding = Input.input("Do you still want to add more items (y/n)? ");
			if (should_continue_adding.equals("n")) {
				break;
			}
		}
		
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