public class LoopInLoop5 {
	public static void main(String[] args) throws Exception {
		System.out.print("\n");
		for (int vert = 1; vert <= 8; vert++) {
			// Nested Loops gave me anxiety...
			for (int horz = vert; horz <= 8; horz++) {
				System.out.print(horz + " ");
			}
			System.out.print("\n");
		}
	}
}
