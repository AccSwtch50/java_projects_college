import java.util.Scanner;

class Input {
	public static final Scanner scanner = new Scanner(System.in);
}

public class PasswordChecker {
	public static void main (String[] args) throws Exception {
		String password = "admin";
		String password_input = "";
		
		for (int pass_check	= 3; pass_check > 0; pass_check--) {
			System.out.print("Enter your password: ");
			password_input = Input.scanner.nextLine();
			if (password_input.equals(password)) {
				break;
			}
		}
		
		if (password_input.equals(password)) {
			System.out.println("Login Successful!");
		} else {
			System.out.println("Account Locked!");
		}
	}
}