import java.util.Scanner;

public class NumberSignChecker {
	public static void main(String[] args) throws Exception {
		Scanner number_input = new Scanner(System.in);
		System.out.print("Enter your number: ");
		int number = number_input.nextInt();
		number_input.close();
		
		if (number > 0) {
			System.out.println("Number entered is Positive");
			return;
		}
		
		if (number < 0) {
			System.out.println("Number entered is Negative");
			return;
		}
		
		System.out.println("Number entered is zero");
	}
}