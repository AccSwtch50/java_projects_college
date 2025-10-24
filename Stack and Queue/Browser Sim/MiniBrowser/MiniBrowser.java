import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

class Input {
	String prompt;
	private static final Scanner input_scanner = new Scanner(System.in);
	
	public static String input(String prompt) {
		System.out.print(prompt);
		return input_scanner.nextLine();
	}
}

class Fetch {
	String url;
	String page;
	private static HashMap<String, String> url_content = new HashMap<>();
	
	public static String fetch(String url) {
		url_content.put("about:home", "MiniBrowser Homepage");
		url_content.put("http://www.google.com", "Welcome to Google!");
		url_content.put("http://www.youtube.com", "Welcome to YouTube!");
		url_content.put("http://www.facebook.com", "Welcome to FaceBook!");
		
		if (url_content.containsKey(url)) {
			return url_content.get(url);
		} else {
			return "Server not Found.";
		}
	}
}

class Engine {
	String url;
	String page;
	
	public static void RenderPage(String url) {
		String page = Fetch.fetch(url);
		System.out.println(page);
	}
}

public class MiniBrowser {
	public static void main(String[] args) throws Exception {
		Stack<String> history = new Stack<>();
		
		String selected_option = "";
		
		history.push("about:home");
		Engine.RenderPage(history.peek());
		do {
			System.out.println("Options:");
			System.out.println("1. Enter URL");
			System.out.println("2. Go Back");
			System.out.println("3. Show current URL");
			System.out.println("4. Show History");
			System.out.println("5. Exit");
			
			selected_option = Input.input("Select your option: ");
			switch (Integer.parseInt(selected_option)) {
				case 1:
					history.push(Input.input("Enter URL: ").toLowerCase());
					Engine.RenderPage(history.peek());
					break;
				case 2:
					if (history.size() <= 1) {
						System.out.println("Previous URL not found.");
						break;
					}
					history.pop();
					Engine.RenderPage(history.peek());
					break;
				case 3:
					if (history.peek().equals("about:home")) {
						System.out.println("MiniBrowser Homepage");
						break;
					}
					System.out.println(history.peek());
					break;
				case 4:
					if (history.size() == 1) {
						System.out.println("You haven't visited any websites, enter 1 to enter a url.");
						break;
					}
					for (int i = 0; (i + 1) < history.size() ; i++) {
						System.out.printf("%d. %s%n", (i + 1), history.get((history.size() - 1) - i));
					}
					break;
			}
					
		} while(!selected_option.equals("5"));
	}
}