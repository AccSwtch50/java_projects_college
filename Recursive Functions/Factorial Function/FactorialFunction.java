import java.util.Arrays;
import java.util.ArrayList;

public class FactorialFunction {
	public static int factorial (int starting_number) {
		if (starting_number == 1) {
			return 1;
		}
		return starting_number * factorial(starting_number - 1);
	}
	public static int exponent (int starting_number, int exponent) {
		if (exponent == 1) {
			return starting_number;
		}
		return starting_number * exponent(starting_number, exponent - 1);
	}
	public static int array_sum (int[] array, int array_length) {
		if (array_length <= 0) {
			return 0;
		}
		return array[array_length - 1] + array_sum(array, array_length - 1);
	}
	public static int arraylist_sum (ArrayList<Integer> array, int array_length) {
		if (array_length <= 0) {
			return 0;
		}
		return array.get(array_length - 1) + arraylist_sum(array, array_length - 1);
	}
	public static ArrayList<Integer> fibbonaci (int iterations, ArrayList<Integer> fibbonaci_numbers) {
		if (iterations < 1) {
			return fibbonaci_numbers;
		}
		try {
			fibbonaci_numbers.get(0);
		} catch (Exception exception) {
			fibbonaci_numbers.add(1);
		}
		if (iterations == 1) {
			return fibbonaci_numbers;
		}
		int fibbonaci_addition[] = {1,1};
		for (int i = 0; i < 2; i++) {
			try {
				fibbonaci_addition[i] = fibbonaci_numbers.get(fibbonaci_numbers.size() - (2 - i));
			} catch(Exception exception) {
				fibbonaci_addition[i] = 0;
			}
		}
		fibbonaci_numbers.add(fibbonaci_addition[0] + fibbonaci_addition[1]);
		return fibbonaci(iterations - 1, fibbonaci_numbers);
	}
	public static int digit_length (int number, int starting_index) {
		String stringified_number = Integer.toString(number);
		char charified_number[] = stringified_number.toCharArray();
		char temp = '0';
		boolean excepted = false;
		try {
			temp = charified_number[starting_index];
		} catch (Exception exception) {
			excepted = true;
			return starting_index;
		} finally {
			if (excepted == false) {
				return digit_length(number, starting_index + 1);
			}
		}
		return 0;
	}
	public static int digit_length_less_dumb (int number) {
		// This is someone else's solution (Syifa's), my solution is a little dumb (see above)
		if (number == 0) {
			return 0;
		} else {
			return 1 + digit_length_less_dumb(number / 10);
		}
	}
	public static void main (String[] args) throws Exception {
		int my_array[] = {3, 4, 6, 2};
		ArrayList<Integer> my_arraylist = new ArrayList<Integer>();
		my_arraylist.add(3);
		my_arraylist.add(4);
		my_arraylist.add(6);
		my_arraylist.add(2);
		int two_raised_eight = exponent(2, 8);
		int factorialized_number = factorial(5);
		int summed_array = array_sum(my_array, my_array.length);
		int summed_arraylist = arraylist_sum(my_arraylist, my_arraylist.size());
		ArrayList<Integer> fibbonaci_numbers = new ArrayList<Integer>();
		// fibbonaci_numbers.add(1);
		// fibbonaci_numbers.add(1);
		int fibbonaci_iterations = 10;
		int my_number = 1234567890;
		
		System.out.printf("Array : %s%n", Arrays.toString(my_array));
		System.out.printf("2^8 : %s%n", two_raised_eight);
		System.out.printf("5! : %s%n", factorialized_number);
		System.out.printf("Array Sum : %s%n", summed_array);
		System.out.printf("ArrayList Sum : %s%n", summed_arraylist);
		System.out.printf("Fibbonaci up to n=%d : %s%n", fibbonaci_iterations, fibbonaci(fibbonaci_iterations, fibbonaci_numbers));
		System.out.printf("Length of the number %s is : %s%n", my_number, digit_length(my_number, 0));
		System.out.printf("(Less dumb method) Length of the number %s is : %s%n", my_number, digit_length_less_dumb(my_number));
	}
}
