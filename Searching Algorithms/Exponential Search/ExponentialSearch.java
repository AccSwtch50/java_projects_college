import java.util.Arrays;

public class ExponentialSearch {
	public static void swap_item (int[] array, int index1, int index2){
		int temp = array[index2];
		array[index2] = array[index1];
		array[index1] = temp;
	}
	
	public static int partition_array (int[] array, int[] array_actual, int lower_bound, int upper_bound) {
		swap_item(array, Integer.valueOf((int) Math.floor(Float.valueOf(upper_bound + lower_bound) / 2.0f)), upper_bound);
		int pivot_value = array_actual[array[upper_bound]];
		int swap_position = lower_bound;
		for (int index = lower_bound; index < upper_bound; index++) {
			if (array_actual[array[index]] <= pivot_value) {
				swap_item(array, index, swap_position);
				swap_position++;
			}
		}
		swap_item(array, upper_bound, swap_position);
		return swap_position;
	}
	
	public static void sort_array (int[] array, int[] array_actual, int lower_bound, int upper_bound) {
		int pivot_index = 0;
		if (lower_bound < upper_bound) {
			pivot_index = partition_array(array, array_actual, lower_bound, upper_bound);
			sort_array(array, array_actual, lower_bound, pivot_index - 1);
			sort_array(array, array_actual, pivot_index + 1, upper_bound);
		}
	}
	
	public static int binary_search (int[] array, int[] array_actual, int target, int lower_bound, int upper_bound) {
		int middle_value_index = Integer.valueOf((int) Math.floor(Float.valueOf(lower_bound + upper_bound) / 2)); // Finds the middle index by adding up the lower bound and upper bound of the range and dividing it by two, rounding down the result.
		int middle_value = array_actual[array[middle_value_index]]; // Gets the value from the middle index.
		
		// If the value I find is the same as the target, well, return it, duh.
		if (middle_value == target) {
			return array[middle_value_index];
		}
		
		// The below line checks if the range is valid and non singular, this is so I can check if the target even exists.
		if (lower_bound < upper_bound) {
			// If the value found is more than the target, it means that the target is on the left of the value
			if (middle_value > target) {
				return binary_search(array, array_actual, target, lower_bound, middle_value_index - 1);
			}
			// If the value found is less than the target, it means that the target is on the right of the value
			if (middle_value < target) {
				return binary_search(array, array_actual, target, middle_value_index + 1, upper_bound);
			}
		}
		return -1; // The target doesn't exist.
	}
	
	public static int exponential_search(int[] array, int[] array_actual, int target, int array_length) {
		if (target == array_actual[array[0]]) {
			/* The reason this check exist is because otherwise, the first item can't be detected, and because of how this algorithm works which is to multiply the index by two, 
			effectively changing the index to the next power of two, and the fact that anything divided by zero is zero, the initial index has to be equal to one (i.e the second index),
			otherwise the search index would never move beyond zero. */
			// If the first item is the same as the target, then return the index of said target.
			// Because I use an array that maps the indices of the actual array if it was sorted, I actually have to use array[index_if_sorted] to get the real index. 
			return array[0];
		}
		
		int index = 1; // Set the searching index to one, because I am trying to search every power of two. The reason it isn't zero is explained above.
		// This loops repeats until the index is at or beyond the length of the array, or when it's larger than the target.
		while (true) {
			if (index >= array_length || array_actual[array[index]] > target) {
				// I used the scratch code styling because it's more readable.
				break;
			}
			index = index * 2; // Multiplying the index by two, thus setting the index to the next power of two.
		}
		
		int previous_index = index / 2; // Dividing the index by two, thus setting the index to the previous power of two.
		// Honestly, the multiply and divide by two could've just been a bitshift to the left or the right, but it's more readable to use multiply/divide.
		
		// Does a binary search between the previous index, and the index or the length of the array, whichever is smaller. the array length is subtracted by one because of zero indexing.
		return binary_search(array, array_actual, target, previous_index, Math.min(index, array_length - 1));
	}
	
	public static void main (String[] args) throws Exception {
		int my_array[] = {1, 8, 3, 2, 5, 9, 4, 10, 6, 7};
		int my_array_index[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int target = 6;
		
		sort_array(my_array_index, my_array, 0, my_array.length - 1); // This sorts the array, but I have another array that maps the indices of the array, I use that to be able to sort without actually modifying the array.
		
		int target_index = exponential_search(my_array_index, my_array, target, my_array.length); // This does exponential search.
		System.out.printf("Target %d is found at index %d in array %s%n", target, target_index, Arrays.toString(my_array));
	}
}