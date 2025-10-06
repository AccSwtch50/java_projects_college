public class LoopInLoop {
	public static void main(String[] args) throws Exception {
		System.out.print("\n");
		for (int vert = 1; vert <= 3; vert++) {
			// Nested Loops gave me anxiety...
			for (int horz = 0; horz < 8; horz++) {
				System.out.print(vert + " ");
			}
			System.out.print("\n");
		}
	}
}
