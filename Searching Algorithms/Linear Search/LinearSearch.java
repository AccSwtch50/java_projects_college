import java.util.Arrays;

public class LinearSearch {
	public static void main (String[] args) throws Exception {
		int my_array[] = {2, 6, 7, 3, 9, 10, 15};
		int target = 9;
		
		for (int index = 0; index < my_array.length; index++) {
			// This checks every single element in an array
			if (my_array[index] == target) {
				// This runs if the element is the same as the target
				System.out.printf("Target %d is found at index %d in array %s%n", target, index, Arrays.toString(my_array));
				return;
			}
		}
	}
}