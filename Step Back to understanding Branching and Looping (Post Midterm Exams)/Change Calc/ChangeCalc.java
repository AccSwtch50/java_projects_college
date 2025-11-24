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
		
		int change = given_money - price;
		
		System.out.printf("Your change is %s%n", change);
	}
}