import java.util.Scanner;

public class GradeMatcher {
	public static void main(String[] args) throws Exception {
		Scanner grade_number_input = new Scanner(System.in);
		System.out.print("Enter your grade number: ");
		int grade_number = grade_number_input.nextInt();
		grade_number_input.close();
		
		if (grade_number < 50) {
			System.out.println("F");
			return;
		}
		
		if (grade_number < 60) {
			System.out.println("D");
			return;
		}
		
		if (grade_number < 70) {
			System.out.println("C");
			return;
		}
		
		if (grade_number < 80) {
			System.out.println("B");
			return;
		}
		
		if (grade_number <= 100) {
			System.out.println("A");
			return;
		}

		System.out.println("invalid");
		
	}
}