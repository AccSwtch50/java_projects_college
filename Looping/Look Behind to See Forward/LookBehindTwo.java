public class LookBehindTwo {
	public static void main(String[] args) throws Exception {
		System.out.print("\n");
		int prev_num2 = 0;
		int prev_num1 = 1;
		int number = 0;
		System.out.print(prev_num2 + " ");
		System.out.print(prev_num1 + " ");
		for (int i = 1; i <= 8; i++) {
			number = prev_num2 + prev_num1;
			prev_num2 = prev_num1;
			prev_num1 = number;
			System.out.print(number + " ");
		}
		System.out.print("\n");
	}
}
