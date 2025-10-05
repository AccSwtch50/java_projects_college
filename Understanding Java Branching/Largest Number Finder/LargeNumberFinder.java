import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LargeNumberFinder {
	public static void main(String[] args) throws Exception {
		Scanner number_input = null;
		List<Integer> numbers = new ArrayList<Integer>();
		String[] number_positions = {"first", "second", "third"};
		char[] variable_names = {'a', 'b', 'c'};
		char largest_variable = 'z';
		
		int a = 0,b = 0,c = 0;
		
		for (int i=0; i < 3; i++) {
			number_input = new Scanner(System.in);
			System.out.print("Enter your " + number_positions[i] + " number (" + variable_names[i] + ") : ");
			numbers.add(number_input.nextInt());
		}
		if (number_input != null) {
			number_input.close();
		}
		
		for (int index = 0; index < 3; index++) {
			int number = numbers.get(index);
			switch (index) {
				case 0:
					a = number;
					break;
				case 1:
					b = number;
					break;
				case 2:
					c = number;
					break;
			}
		}
		
		if (a > b) {
			if (a > c) {
				largest_variable = 'a';
			} else {
				largest_variable = 'c';
			}
		} else {
			if (b > c) {
				largest_variable = 'b';
			} else {
				largest_variable = 'c';
			}
		}
		
		System.out.println("Variable " + largest_variable + " is the largest variable.");
	}
}