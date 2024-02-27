/**
 * Class HandleInput:
 * This class is used to hold static methods that can 
 * be used to get input from the user, and validate that 
 * the user entered correct values.
 *
 * Last Modified: 2/4/24
 * Author: Brendan Lambrecht
 */

import java.util.Scanner;

public class HandleInput {
	
	// This class has no attributes

	/**
	 * Constructor for the HandleInput class. 
	 */
	public HandleInput() {
	}

	/**
	 * This method will print a menu, and then read the user's menu selection and
	 * return that selection back to the caller. 
	 *
	 * @param scan The Scanner variable must be passed from the caller, because it is
	 *            expected that only a single Scanner has been created for accessing
	 *            the console.
	 * @return The character that corresponds to the menu item selected by the user.
	 */
	public static char getMenu(Scanner scan) {
		String line;
		boolean done = false;
		char selection;

		// Print out the menu items
		System.out.println("\nCalendar Menu:");
		System.out.println("\tc - Check calendar for appointments");
		System.out.println("\ta - Add a new calendar appointment");
		System.out.println("\tl - List appointments");
		System.out.println("\tr - Remove appointment");
		System.out.println("\tx - eXit the calendar program");

		do {
			// Print out the user prompt
			System.out.print("Enter choice: ");

			// Get the user input, force it to lower case, and
			// get the first character
			line = scan.nextLine();
			line = line.toLowerCase();
			selection = line.charAt(0);

			// Validate the scanner input
			if (selection == 'c' || selection == 'a' || selection == 'l' || selection == 'r' || selection == 'x') {
				done = true;
			} else {
				// Print an error message if they entered a bad input
				System.out.println("ERROR: bad menu item, please select from the list above ");
			}
		} while (!done);
		System.out.println();

		// return the character of the selected menu item
		return selection;
	}

	/**
	 * This method will prompt the user to enter an appointment description, and
	 * then return whatever they typed. Validity checking of their input is not
	 * required, since they could type anything for an appointment description.
	 *
	 * @param scan The Scanner variable for accessing console input.
	 * @return The String appointment description entered by the user.
	 */
	public static String getDescription(Scanner scan) {
		System.out.print("Appointment description: ");
		return scan.nextLine();
	}

	/**
	 * Verifies whether a value is a valid day value.
	 * Days are integers 0 through 364, where 0 corresponds to Jan 1, and 365 corresponds to Dec 31.
	 *
	 * @param day The day value to be checked.
	 * @return {@code true} if the day is a valid value, {@code false} if it is not.
	 */
	public static boolean verifyDay(int day) {
		if (day >= 0 && day < 365) {
			return true;
		}
		return false;
	}

	/**
	 * Verifies whether a value is a valid hour value.
	 * Hours are integers 0 through 23, where 0 corresponds to midnight, and 23 corresponds to 11pm.
	 *
	 * @param hour The hour value to be checked.
	 * @return {@code true} if the hour is a valid value, {@code false} if it is not.
	 */
	public static boolean verifyHour(int hour) {
		if (hour >= 0 && hour < 24) {
			return true;
		}
		return false;
	}

	/**
	 * This method will prompt the user to enter a day. Their input must be validity
	 * checked by using the verifyDay() method from above. If a bad value is
	 * entered, an error message should be printed and the user should be prompted
	 * again (and until they enter a correct value). The day they enter must then be
	 * returned to the caller.
	 *
	 * @param scan The Scanner variable for accessing console input.
	 * @return The day entered by the user. Must be a value between 0 and 364.
	 */
	public static int getDay(Scanner scan) {
		System.out.print("What day? ");
		int day = scan.nextInt();
		scan.nextLine();  // not saving anything, just processing the remaining newline buffer

		while(!verifyDay(day)) {
         System.out.println("ERROR: day must be between 0 and 364");
			System.out.print("What day? ");
			day = scan.nextInt();
			scan.nextLine(); // not saving anything, just processing the remaining newline buffer
		}
		return day;
	}

	/**
	 * This method will prompt the user to enter an hour. Their input must be
	 * validity checked by using the verifyHour() method from above. If a bad value
	 * is entered, an error message should be printed and the user should be
	 * prompted again (and until they enter a correct value). The hour they enter
	 * must then be returned to the caller.
	 *
	 * @param scan The Scanner variable for accessing console input.
	 * @return The hour entered by the user. Must be a value between 0 and 23.
	 */
	public static int getHour(Scanner scan) {
		System.out.print("What hour? ");
		int hour = scan.nextInt();
		scan.nextLine(); // not saving anything, just processing the remaining newline buffer
		
		while(!verifyHour(hour)) {
			System.out.println("ERROR: hour must be between 0 and 23");
			System.out.print("What hour? ");
			hour = scan.nextInt();
			scan.nextLine(); // not saving anything, just processing the remaining newline buffer
		}
		return hour;
	}
}