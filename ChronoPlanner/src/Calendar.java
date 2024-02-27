/**
 * This program is a calendar scheduler. It uses an 
 * array of Day types, where each Day holds per-hour 
 * scheduling data (whether an hour is scheduled, and 
 * if it is what the appointment is scheduled).
 *
 * Last Modified: 2/4/24
 * Author: Brendan Lambrecht
 */

import java.util.Scanner;

public class Calendar {

	/**
	 * This is the starting point for the calendar appointment scheduling program.
	 * It creates an array of Day objects, one for each day of the year. It then
	 * uses helper methods to print a menu and get user input. It then accesses the
	 * day object selected by the user to do one of a handful of scheduling tasks.
	 *
	 */
	public static void main(String[] args) {
		
		// Create the scanner
		Scanner scan = new Scanner(System.in);

		// Allocate the array of Day references
		Day[] calendar = new Day[365];

		for (int i = 0; i < calendar.length; i++) {
			// Allocate each Day object
			calendar[i] = new Day();
		}

		// These will hold user input of various types
		char menuSelection;
		int day, hour;
		String description;

		// This loop repeatedly prints the menu and
		// handles the user selection until the user
		// chooses to end the program.
		do {
			// Print the menu and get the menu selection
			menuSelection = HandleInput.getMenu(scan);

			// Act on whichever menu item the user selected
			if (menuSelection == 'c') {
				// Check for an appointment

				// Prompt the user for the day of the appointment
				day = HandleInput.getDay(scan);

				// Check if there are any appointments for the day
				if (calendar[day].checkDay()) {
					// If there are appontments for the day, then prompt for the hour
					hour = HandleInput.getHour(scan);

					// Check if there is an appointment during the hour
					if (calendar[day].checkTime(hour)) {
						// Display the single appointment
						System.out.println(calendar[day].getDescription(hour));
					} else {
						System.out.println("No appointment scheduled");
					}
				} else {
					System.out.println("No appointments scheduled for that entire day");
				}
			} else if (menuSelection == 'a') {
				// Add a new appointment

				// Get the day, hour and description from the user
				day = HandleInput.getDay(scan);
				hour = HandleInput.getHour(scan);
				description = HandleInput.getDescription(scan);

				// Add the appointment, printing a message if there is
				// already an appointment at that time
				if (!calendar[day].addAppointment(hour, description)) {
					System.out.println("Time slot already has an appointment: " + calendar[day].getDescription(hour));
				}
			} else if (menuSelection == 'l') {
				// List all appointments for a day

				// Get the day
				day = HandleInput.getDay(scan);

				// Print the toString result
				System.out.println(calendar[day]);
			} else if (menuSelection == 'r') {
				// Remove an appointment

				// Get the day and hour
				day = HandleInput.getDay(scan);
				hour = HandleInput.getHour(scan);

				// Remove the appointment
				calendar[day].removeAppointment(hour);
			}
		} while (menuSelection != 'x');

		// Print an exit message
		System.out.println("Task Complete!");
	}

}
