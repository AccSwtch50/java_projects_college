import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Input {
	public static final Scanner scanner = new Scanner(System.in);
}

public class LargestNumber {
	public static void main(String[] args) throws Exception {
		List<Integer> number_list = new ArrayList<Integer>();
		String number_entered = "";
		int current_number_index = 1;
		while (true) {
			System.out.printf("Entering number %s, enter \"done\" to stop enterring numbers. ", current_number_index);
			number_entered = Input.scanner.nextLine();
			if (number_entered.equals("done")) {
				break;
			}
			number_list.add(Integer.parseInt(number_entered));
			current_number_index++;
		}
		int largest_number = Integer.MIN_VALUE;
		int lowest_number = Integer.MAX_VALUE;
		int sum_number_list = 0;
		for (int number : number_list) {
			if (largest_number < number) {
				largest_number = number;
			}
			if (lowest_number > number) {
				lowest_number = number;
			}
			sum_number_list += number;
		}
		System.out.printf("From this list of numbers: %s%n", number_list);
		System.out.printf("The largest number is: %s%n", largest_number);
		System.out.printf("The lowest number is: %s%n", lowest_number);
		System.out.printf("The sum of all the numbers is: %s%n", sum_number_list);
		System.out.printf("The average of all the numbers is: %s%n", (sum_number_list / number_list.size()));
	}
}