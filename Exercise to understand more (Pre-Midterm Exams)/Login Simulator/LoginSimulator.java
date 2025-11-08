import java.util.Scanner;
import java.util.ArrayList;

class Input {
	public static final Scanner scanner = new Scanner(System.in);
}

class Account {
	String username;
	String password;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
}

class AccountDB {
	String usename;
	static ArrayList<Account> accounts = new ArrayList<Account>();
	
	public static String get_password(String username) {
		accounts.add(new Account("Nugraha", "jng2009ui"));
		accounts.add(new Account("Cat", "meow"));
		accounts.add(new Account("Simpleton", "Password123"));
		accounts.add(new Account("Faizi", "23Dragon"));
		accounts.add(new Account("Elephant", "ilovetrunks20"));
		
		for (Account account : accounts){
			if (account.username.equals(username)){
				return account.password;
			}
		}
		
		return "";
	}
}

class Auth {
	String username;
	String password;
	
	public static boolean password_match (String username, String password){
		if (password.equals("")){
			return false; //Passwords cannot be empty
		}
		if (password.equals(AccountDB.get_password(username))){
			return true;
		} else {
			return false;
		}
	}
}

public class LoginSimulator {
	public static void main(String[] args) throws Exception {
		System.out.print("Username: ");
		String username = Input.scanner.nextLine();
		System.out.print("Password: ");
		String password = Input.scanner.nextLine();
		
		if (Auth.password_match(username, password)){
			System.out.println("username and password valid, you can login into the dashboard");
		} else {
			System.out.println("Wrong username and password");
		}
	}
}
