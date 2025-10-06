public class LoopInLoop4 {
	public static void main(String[] args) throws Exception {
		System.out.print("\n");
		for (int vert = 1; vert <= 3; vert++) {
			// Nested Loops gave me anxiety...
			for (int horz = 1; horz <= 3; horz++) {
				System.out.println(vert + " x " + horz + " = " + (vert * horz));
			}
			System.out.print("\n\n");
		}
	}
}
