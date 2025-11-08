import java.util.Scanner;

class Input {
	public static final Scanner scanner = new Scanner(System.in);
}

public class PalindromeFinder {
	public static void main(String[] args) throws Exception {
		System.out.print("Enter your string: ");
		String entered_string = Input.scanner.nextLine();
		
		String reversed_string = "";
		
		for (int char_index = entered_string.length(); char_index > 0; char_index--) {
			reversed_string += entered_string.toLowerCase().charAt(char_index - 1);
		}
		
		System.out.printf("%s is %s.%n", entered_string, entered_string.toLowerCase().equals(reversed_string) ? "a palindrome" : "not a palindrome");
	}
}
