import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CalorieCalc {
	public static void main(String[] args) throws Exception {
		List<String> exercises = new ArrayList<String>();
		Scanner exercise_input_scanner;
		String exercise_input;
		int time_finish_minutes = 0;
		int calories_burned = 0;
		String cumulative_time_finish_minutes = "";
		String cumulative_calories_burned = "";
		
		while (true) {
			exercise_input_scanner = new Scanner(System.in);
			System.out.print("Enter in your exercise (Running, Push-ups, Plank, Done): ");
			exercise_input = exercise_input_scanner.nextLine();
			
			if (Arrays.asList("Running", "Push-ups", "Plank").contains(exercise_input)){
				exercises.add((String) exercise_input);
				System.out.println("Current exercises: " + exercises);
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
		System.out.print("\n");
		System.out.println("With this sequence of exercises: ");
		for (String exercise : exercises) {
			if (exercise.equals("Running")) {
				time_finish_minutes += 5;
				calories_burned += 60;
			}
			if (exercise.equals("Push-ups")) {
				time_finish_minutes += 30;
				calories_burned += 200;
			}
			if (exercise.equals("Plank")) {
				time_finish_minutes += 1;
				calories_burned += 5;
			}
			System.out.print(exercise + ", ");
			cumulative_calories_burned += calories_burned + ", ";
			cumulative_time_finish_minutes += time_finish_minutes + ", ";
		}
		System.out.print("\n\n");
		System.out.println("You will burn " + calories_burned + " calories.");
		System.out.println("It will take " + time_finish_minutes + " minutes to do all in total.");
		System.out.print("\n");
		System.out.println("Running takes 5 minutes.");
		System.out.println("Push-ups takes 30 minutes.");
		System.out.println("Planks takes 1 minute.");
		System.out.print("\n");
		System.out.println("Time elapsed after each exercise: \n" + cumulative_time_finish_minutes);
		System.out.println("Calories burned after each exercise: \n" + cumulative_calories_burned);
	}
}