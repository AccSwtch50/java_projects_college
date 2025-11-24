import java.util.Scanner;

class Input {
	public static final Scanner scanner = new Scanner(System.in);
}

public class ChangeCalc {
	public static void main (String[] args) throws Exception {
		System.out.print("Enter final price: ");
		int price = Input.scanner.nextInt();
		System.out.print("Enter money given: ");
		int given_money = Input.scanner.nextInt();
		
		Double discount_percentage = 0.0;
		
		if (price > 50000) {
			discount_percentage = 10.0;
		}
		
		if (price > 200000) {
			discount_percentage = 20.0;
		}
		
		double discount_subtractor = Double.valueOf(price) * (discount_percentage/100.0);
		int discounted_price = (int) Math.round(Double.valueOf(price) - discount_subtractor);
		
		int change = given_money - discounted_price;
		
		System.out.printf("Your change is %s%n", change);
	}
}
