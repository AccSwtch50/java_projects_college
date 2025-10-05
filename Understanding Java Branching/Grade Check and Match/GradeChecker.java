import java.util.Scanner;

public class GradeChecker {
	public static void main(String[] args) throws Exception {
		Scanner grade_input = new Scanner(System.in);
		System.out.print("Enter your Grade: ");
		int grade = grade_input.nextInt();
		grade_input.close();
		
		if (grade > 100) {
			System.out.println("invalid");
			return;
		}
		
		if (grade >= 70) {
			System.out.println("pass");
			return;
		}
		
		System.out.println("fail");
	}
}