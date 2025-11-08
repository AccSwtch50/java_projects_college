public class NumberSeries {
	public static void main(String[] args) throws Exception {
		int added_number = 6;
		int subtracted_number = 2;
		int adding_number = 1;
		int subtracting_number = 1;
		
		for (int i = 0; i < 9; i++) {
			if ((i % 2) == 0) {
				System.out.print(added_number + " ");
				added_number += adding_number;
			} else {
				System.out.print(subtracted_number + " ");
				subtracted_number -= subtracting_number;
			}
		}
		System.out.print("\n");
	}
}
