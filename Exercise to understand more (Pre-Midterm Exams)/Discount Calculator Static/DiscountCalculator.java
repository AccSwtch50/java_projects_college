public class DiscountCalculator {
	public static void main(String[] args) throws Exception {
		final int item_price = 20000;
		final int item_quantity = 35;
		
		System.out.printf("The price of the item is: %s%n", item_price);
		System.out.printf("Budi buys %s items.%n", item_quantity);
		
		int discount_multiplier = (int) (Math.floor(Float.valueOf(item_quantity) / 10.0f));
		final int initial_discount = 5;
		int discount_percentage = initial_discount * discount_multiplier;
		if (discount_percentage > 50) {
			discount_percentage = 50;
		}
		float discount_value = Float.valueOf(discount_percentage) / 100.0f;
		
		int pre_discount_total_price = item_price * item_quantity;
		
		float discount = Float.valueOf(pre_discount_total_price) * discount_value;
		float total_price = Float.valueOf(pre_discount_total_price) - discount;
		
		System.out.printf("He paid %s for %s items.%n", total_price, item_quantity);
	}
}
