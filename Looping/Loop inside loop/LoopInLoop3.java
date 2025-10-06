public class LoopInLoop3 {
	public static void main(String[] args) throws Exception {
		System.out.print("\n");
		int num;
		for (int vert = 1; vert <= 3; vert++) {
			num = vert;
			// Nested Loops gave me anxiety...
			for (int horz = 1; horz <= 7; horz++) {
				System.out.print(num + " ");
				num += 2;
			}
			System.out.print("\n");
		}
	}
}
