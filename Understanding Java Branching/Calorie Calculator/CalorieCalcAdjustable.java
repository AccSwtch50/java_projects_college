import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CalorieCalcAdjustable {
	public static void main(String[] args) throws Exception {
		List<String> exercises = new ArrayList<String>();
		List<Integer> exercises_time = new ArrayList<Integer>();
		
		Scanner exercise_input_scanner;
		String exercise_input;
		Scanner exercise_time_input_scanner = null; //I need to be able to check if this was set lol
		int exercise_time_input;
		
		final Float running_calories_per_minute = 60.0f/5.0f;
		final Float pushup_calories_per_minute = 200.0f/30.0f;
		final Float plank_calories_per_minute = 5.0f;
		
		int time_finish_minutes = 0;
		Float calories_burned = 0.0f;
		
		String cumulative_time_finish_minutes = "";
		String cumulative_calories_burned = "";
		
		while (true) {
			exercise_input_scanner = new Scanner(System.in);
			System.out.print("Enter in your exercise (Running, Push-ups, Plank, Done): ");
			exercise_input = exercise_input_scanner.nextLine();
			
			if (Arrays.asList("Running", "Push-ups", "Plank").contains(exercise_input)){
				exercises.add((String) exercise_input);
				
				exercise_time_input_scanner = new Scanner(System.in);
				System.out.print("Enter the amount of minutes you want to do it for: ");
				exercise_time_input = exercise_input_scanner.nextInt();
				exercises_time.add(exercise_time_input);
				
				System.out.println("Current exercises: " + exercises);
				System.out.println("Length of each exercise in minutes: " + exercises_time);
				continue;
			}
			
			if (exercise_input.equals("")) {
				continue;
			}
			
			if (exercise_input.equals("Done")) {
				break;
			}
			
			System.out.println("Invalid Input!");
		}
		
		exercise_input_scanner.close();
		if (exercise_time_input_scanner != null) {
			exercise_time_input_scanner.close();
		}
		
		String exercise_time_string = "";
		
		String exercise;
		int exercise_time;
		
		System.out.print("\n");
		System.out.println("With this sequence of exercises: ");
		
		for (int index = 0; index < exercises.size(); index++) {
			exercise = exercises.get(index);
			exercise_time = exercises_time.get(index);
			
			time_finish_minutes += exercise_time;
			
			if (exercise.equals("Running")) {
				calories_burned += running_calories_per_minute * exercise_time;
			}
			if (exercise.equals("Push-ups")) {
				calories_burned += pushup_calories_per_minute * exercise_time;
			}
			if (exercise.equals("Plank")) {
				calories_burned += plank_calories_per_minute * exercise_time;
			}
			
			exercise_time_string += exercise_time;
			System.out.print(exercise);
			cumulative_calories_burned += calories_burned;
			cumulative_time_finish_minutes += time_finish_minutes;
			if ((index + 1) != exercises.size()) {
				System.out.print(", ");
				exercise_time_string += ", ";
				cumulative_calories_burned += ", ";
				cumulative_time_finish_minutes += ", ";
			}
		}
		System.out.print("\n\n");
		System.out.println("You will burn " + calories_burned + " calories.");
		System.out.println("It will take " + time_finish_minutes + " minutes to do all in total.");
		System.out.print("\n");
		System.out.println("Each exercise will take this amount of time in minutes: \n" + exercise_time_string);
		System.out.print("\n");
		System.out.println("Time elapsed after each exercise: \n" + cumulative_time_finish_minutes);
		System.out.println("Calories burned after each exercise: \n" + cumulative_calories_burned);
	}
}