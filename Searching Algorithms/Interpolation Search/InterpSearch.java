import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class InterpSearch {
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
		/*
		Derivation of the equation:
		
		General equation for a line: array_value = slant_increase * increase_multiplier + initial_value
		
		1. array_value[lower_bound] = (slant_increase * lower_bound) + initial_value
		2. array_value[upper_bound] = (slant_increase * upper_bound) + initial_value
		3. array_value[index] = (slant_increase * index) + initial_value
		
		slant_increase = (array_value[upper_bound] - array_value[lower_bound]) / (upper_bound - lower_bound)
		The above calculates the range.
		
		Subtracting equation 3 with 2 (i.e finding the range of the array between the lower_bound and the index) and rearranging to find the equation for the index:
		
		array_value[index] - array_value[lower_bound] = ((slant_increase * index) + initial_value) - ((slant_increase * lower_bound) + initial_value)
		array_value[index] - array_value[lower_bound] = (slant_increase * index) + initial_value - (slant_increase * lower_bound) - initial_value
		array_value[index] - array_value[lower_bound] = (slant_increase * index) - (slant_increase * lower_bound) + initial_value - initial_value
		array_value[index] - array_value[lower_bound] = (slant_increase * index) - (slant_increase * lower_bound)
		array_value[index] - array_value[lower_bound] = slant_increase * (index - lower_bound)
		(array_value[index] - array_value[lower_bound]) / slant_increase = (slant_increase * (index - lower_bound)) / slant_increase
		(array_value[index] - array_value[lower_bound]) / slant_increase = index - lower_bound
		((array_value[index] - array_value[lower_bound]) / slant_increase) + lower_bound = index - lower_bound + lower_bound
		((array_value[index] - array_value[lower_bound]) / slant_increase) + lower_bound = index
		index = ((array_value[index] - array_value[lower_bound]) / slant_increase) + lower_bound
		
		Substituting the slant_increase for the formula:
		index = ((array_value[index] - array_value[lower_bound]) / ((array_value[upper_bound] - array_value[lower_bound]) / (upper_bound - lower_bound)) + lower_bound
		numerator_1 = array_value[index] - array_value[lower_bound])
		denominator_1 = ((array_value[upper_bound] - array_value[lower_bound]) / (upper_bound - lower_bound))
		index = (numerator_1 / denominator_1) + lower_bound
		
		Do fractional division (Keep, change, flip)
		
		numerator_1 = array_value[index] - array_value[lower_bound]
		denominator_1 = ((upper_bound - lower_bound) / (array_value[upper_bound] - array_value[lower_bound]))
		index = (numerator_1 * denominator_1) + lower_bound
		---
		numerator_1 = (array_value[index] - array_value[lower_bound]) * (upper_bound - lower_bound)
		denominator_1 = (array_value[upper_bound] - array_value[lower_bound])
		index = (numerator_1 / denominator_1) + lower_bound
		---
		numerator_1 = (upper_bound - lower_bound)
		denominator_1 = (array_value[upper_bound] - array_value[lower_bound])
		index = ((array_value[index] - array_value[lower_bound]) * (numerator_1 / denominator_1)) + lower_bound
		---
		numerator_1 = (upper_bound - lower_bound)
		denominator_1 = (array_value[upper_bound] - array_value[lower_bound])
		index = ((numerator_1 / denominator_1) * (array_value[index] - array_value[lower_bound])) + lower_bound
		---
		index_total_range = (upper_bound - lower_bound) // The total range of the index
		value_total_range = (array_value[upper_bound] - array_value[lower_bound]) // The total range of the values if it was a continous line.
		value_chunk_per_index = (index_total_range / value_total_range) // The amount of value per index if the value were linear.
		linear_value_index = (array_value[index] - array_value[lower_bound]) // The index of the interpolated linear array minus one to account for the base value
		// Lower bound is to get the base value, linear_value_index is used in tandem with value_chunk_per_index to calculate the increase from index to index in a hypothetical linear array of the original array.
		index = (value_chunk_per_index * linear_value_index) + lower_bound
		
		I still don't fully understand it, unfortunately.
		*/
		IntUnaryOperator array_value = (array_index) -> array_actual[array[array_index]];
		
		int index_total_range = (upper_bound - lower_bound); // The total range of the index
		int value_total_range = (array_value.applyAsInt(upper_bound) - array_value.applyAsInt(lower_bound)); // The total range of the values if it was a continous line.
		int value_chunk_per_index = (int) Math.floor(((double) index_total_range) / ((double) value_total_range)); // The amount of value per index if the value were linear.
		int linear_value_index = (target - array_value.applyAsInt(lower_bound)); // The index of the interpolated linear array minus one to account for the base value.
		int base_value = lower_bound; // The lower bound is the base value or first index in a linearized interpolated form of the array.
		int chosen_index = (value_chunk_per_index * linear_value_index) + lower_bound;
		int chosen_index_value = array_value.applyAsInt(chosen_index);
		
		// If the value I find is the same as the target, well, return it, duh.
		if (chosen_index_value == target) {
			return array[chosen_index];
		}
		
		// The below line checks if the range is valid and non singular, this is so I can check if the target even exists.
		if (lower_bound < upper_bound) {
			// If the value found is more than the target, it means that the target is on the left of the value
			if (chosen_index_value > target) {
				return binary_search(array, array_actual, target, lower_bound, chosen_index - 1);
			}
			// If the value found is less than the target, it means that the target is on the right of the value
			if (chosen_index_value < target) {
				return binary_search(array, array_actual, target, chosen_index + 1, upper_bound);
			}
		}
		return -1; // The target doesn't exist.
	}
	
	public static void main (String[] args) throws Exception {
		int my_array[] = {1, 8, 3, 2, 5, 9, 4, 10, 6, 7};
		int my_array_index[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int target = 6;
		
		sort_array(my_array_index, my_array, 0, my_array.length - 1); // This sorts the array, but I have another array that maps the indices of the array, I use that to be able to sort without actually modifying the array.
		
		int target_index = binary_search(my_array_index, my_array, target, 0, my_array.length - 1); // This does binary search.
		// The reason why the length is subtracted by one is because if I iterate it until it reached the length of the array, it will be out of bounds and every item checked would be accessing the index after the one I want to check.
		// This is because arrays are zero indexed, so to check the item I want, I have to subtract it by one since the array starts counting from zero.
		System.out.printf("Target %d is found at index %d in array %s%n", target, target_index, Arrays.toString(my_array));
	}
}