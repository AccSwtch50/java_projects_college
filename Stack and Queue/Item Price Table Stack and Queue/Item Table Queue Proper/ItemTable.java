import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayDeque;
import java.util.Scanner;

class Input {
	public static Scanner scanner = new Scanner(System.in);
}

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
		ArrayDeque<Item> item_list = new ArrayDeque<>();
		
		String item_name = "";
		int item_price = 0;
		int item_quantity = 0;
		String should_continue_adding = "y";
		
		do {
			System.out.print("What's the name of the item? ");
			item_name = Input.scanner.nextLine();
			System.out.print("What's the price of the item? ");
			item_price = Input.scanner.nextInt();
			System.out.print("How many of this item do you want to buy? ");
			item_quantity = Input.scanner.nextInt();
			item_list.add(new Item(item_name, item_price, item_quantity));
			Input.scanner.nextLine();
			System.out.print("Do you still want to add more items (y/n)? ");
			should_continue_adding = Input.scanner.nextLine();
		} while (should_continue_adding.equals("y"));
		
		String header = String.format("%-4s %-10s %-10s %-10s %-10s%n", "No", "Item", "Price", "Qty", "Subtotal");
		final String divider = "-".repeat(header.length());
		
		System.out.println(divider);
		System.out.print(header);
		System.out.println(divider);
		
		int total_price = 0;
		for (int item_index = 0; item_list.size() > 0; item_index++) {
			Item item = item_list.poll();
			
			System.out.printf("%-4s %-10s %-10s %-10s %-10s%n", ((item_index + 1) + "."), item.name, item.price, item.quantity, item.subtotal);
			total_price += item.subtotal;
		}
		
		System.out.println(divider);
		System.out.println("Total " + String.valueOf(total_price));
	}
}
