public class CrossAndDash {
	public static void main(String[] args) throws Exception {
		System.out.print("\n");
		for (int vert = 1; vert <= 6; vert++){
			for (int horz = 0; horz < 6; horz++){
				if (horz < vert) {
					System.out.print("X ");
				} else {
					System.out.print("_ ");
				}
			}
			System.out.print("\n");
		}
	}
}
