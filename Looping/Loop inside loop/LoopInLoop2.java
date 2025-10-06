public class LoopInLoop2 {
	public static void main(String[] args) throws Exception {
		System.out.print("\n");
		for (int vert = 1; vert <= 4; vert++) {
			// Nested Loops gave me anxiety...
			for (int horz = 1; horz <= 8; horz++) {
				System.out.print(horz + " ");
			}
			System.out.print("\n");
		}
	}
}
