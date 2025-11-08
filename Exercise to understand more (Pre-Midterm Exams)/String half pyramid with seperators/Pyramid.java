import java.util.Scanner;

class Input {
	public static final Scanner scanner = new Scanner(System.in);
}

public class Pyramid {
	public static void main(String[] args) throws Exception {
		System.out.print("Enter your String: ");
		String input_string = Input.scanner.nextLine().toUpperCase();
		for (int vert = 0; vert <= input_string.length(); vert++){
			for (int char_index = 0; char_index < vert; char_index++){
				System.out.printf("%s ", input_string.charAt(char_index));
			}
			System.out.print("\n");
		}
	}
}
