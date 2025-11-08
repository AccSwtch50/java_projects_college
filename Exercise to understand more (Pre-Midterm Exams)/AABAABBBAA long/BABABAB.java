public class BABABAB {
	public static void main(String[] args) throws Exception {
		System.out.print("\n");
		for (int vert = 0; vert < 3; vert++){
			for (int horz = 0; horz < 8; horz++){
				if (((vert + horz) % 2) == 0) {
					System.out.print("A ");
				} else {
					System.out.print("B ");
				}
			}
			System.out.print("\n");
		}
	}
}
