import java.util.function.IntBinaryOperator;
import java.util.Arrays;

public class JumpSearch {
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
	
	public static int jump_search (int[] array, int[] array_actual, int target, int array_length) {
		int step = (int) Math.floor(Math.sqrt((double) array_length)); // Calculates the initial step, which is the square root of the array length. Which is the block size.
		IntBinaryOperator next_step = (step_op, array_length_op) -> Math.min(step_op, array_length_op); // Defines the operation for finding the next step in a loop, which is to find the lesser value between the step and the array length.
		int previous_step = 0; // Holds the value for the previous step.
		
		// Does a loop beginning from the initial step and moves forward by the next step until the value indexed on that step exceeds the target.
		for (int minimum_step = next_step.applyAsInt(step, array_length) - 1; array_actual[array[minimum_step]] < target; minimum_step = Math.min(step, array_length) - 1) {
			previous_step = step; // This saves the previous step as I will recalculate the step after this.
			step += (int) Math.floor(Math.sqrt((double) array_length)); // Literally jumps the step by the square root of the array_length (i.e the block size).
			if (previous_step >= array_length) {
				// If the step we found at the beginning exceeds the length of the array, then the element doesn't exist.
				return -1;
			}
		}
		
		// Does a linear search from the step before it overshot the target.
		while (array_actual[array[previous_step]] < target) {
			previous_step++; // Moves the index forward by one, because linear search does that.
			
			if (previous_step >= next_step.applyAsInt(step, array_length)) {
				// If the index goes to the next step, then it must mean that the element doesn't exist, since the next step is already more than the target and reading further into higher values definitely **doesn't help**.
				return -1;
			}
		}
		
		if (array_actual[array[previous_step]] == target) {
			// The value of the array at that index is the target, so I return the index of that value, since it's pointless to send the target back.
			return array[previous_step];
		}
		
		return -1; // Element doesn't exist, or the method bugged out, I have to put this here since Java will complain to me about missing a general return case otherwise.
	}
	
	public static void main (String[] args) throws Exception {
		int my_array[] = {1, 8, 3, 2, 5, 9, 4, 10, 6, 7};
		int my_array_index[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int target = 9;
		
		sort_array(my_array_index, my_array, 0, my_array.length - 1); // This sorts the array, but I have another array that maps the indices of the array, I use that to be able to sort without actually modifying the array.
		
		int target_index = jump_search(my_array_index, my_array, target, my_array.length); // This does jump search.
		System.out.printf("Target %d is found at index %d in array %s%n", target, target_index, Arrays.toString(my_array));
	}
}