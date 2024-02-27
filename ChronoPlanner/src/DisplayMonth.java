import java.util.Scanner;

/**
 * Class DisplayMonth: This class is designed to display a monthly calendar based 
 * on user input for the day of the week and it's corresponding month.
 *
 * Last Modified: 2/4/24
 * Author: Brendan Lambrecht
 */

public class DisplayMonth {

	public static void main(String[] args) {

		// Scanner, Array, and Variable Storage Presets
		Scanner scan = new Scanner(System.in);
		
		// Days of the Week
		String[] days = {"Su","Mo","Tu","We","Th","Fr","Sa"};

		// Months of the Year
		String[] months = {"January","February","March","April","May","June","July","August", "September", "October", "November", "December"};

		// Storage Variables to be used later
		int selectedDay = 0;
		int selectedMonth = 0;
		
		System.out.println("1=Su., 2=Mo., 3=Tu., 4=We., 5=Th., 6=Fr., 7=Sa.");
		
		// Scanner Asks for Weekday Value
		while (true){	
			System.out.print("Enter a day of the week [1-7]: ");
			selectedDay = scan.nextInt();
			if (selectedDay < 1 || selectedDay > 7) {
				System.out.println("Error: Enter a value between 1 and 7 (inclusive)");
				System.out.println("1=Su., 2=Mo., 4=We., 5=Th., 6=Fr., 7=Sa.");
			} 
			else{
				break;
			}
		}

		System.out.println(" ");
		System.out.println("1=Jan., 2=Feb., ..., 11=Nov., 12=Dec.");

		// Scanner Asks for Month Value
		while (true){	
			System.out.print("Enter the month [1-12]: ");
			selectedMonth = scan.nextInt();
			if (selectedMonth < 1 || selectedMonth > 12) {
				System.out.println("Error: Enter a value between 1 and 12 (inclusive)");
				System.out.println("1=Jan., 2=Feb., ..., 11=Nov., 12=Dec.");
			} else{
				break;
			}
		}
		
		// Evaluates the selected month to print the correct number of days (Stored in dayCounter) 
		int dayCounter = 0;
      
    	// Sets the dayCounter to 31 if one of the following values is selected
		if (selectedMonth == 1 || selectedMonth == 3 || selectedMonth == 5 || selectedMonth == 7 ||
		selectedMonth == 8 || selectedMonth == 10 || selectedMonth == 12) {
			dayCounter = 31;
		}
		
    	// Addresses the February Leap-Year Posabilities
		else if (selectedMonth == 2) {
			while (true) {
				System.out.print("Is this a leap year [1=yes / 0 = no]? ");
				
				// Determines number of days in the month based on leap year contingency
				int febCounter = scan.nextInt();
				if (febCounter == 1) {
					dayCounter = 29;
					break;
				} else if (febCounter == 0) {
					dayCounter = 28;
					break;
				} else {
					System.out.println("Error: Enter either 1 for \"yes\" or = for \"no\"");
				}
			}
         
        // All other months have 30 days, so dayCounter is set to 30
		} else {
			dayCounter = 30;
		}

		System.out.println(""); // Spacer

		// Prints the Selected Month
		System.out.println(months[selectedMonth-1]);

		// Prints the Days of the Week of the Calander (Su, Mo, etc.)
		for (int i = 0; i < days.length; i++) {
			System.out.print(days[i] + " ");
		}

		System.out.println(""); // Spacer

		// Determines where the 1st day starts of that month based off weekday selection
		for (int i = 1; i < selectedDay; i++){
			System.out.print("   ");
		}
      
    	// Prints the days of the month in a sequential order
		for (int num = 1; num <= dayCounter; num++) {
			
        	// Spaces Single-Digit Numbers
        	if (num <= 9) {
				System.out.print(" " + num + " ");
			}
        	// Spaces Double-Digit Numbers
			else if (num > 9) {
				System.out.print(num + " ");
			}
        	// Determines when to move to next line
			if ((selectedDay + num - 1) % 7 == 0) {
				System.out.println("");
			}
		}
      
    	// Closes Scanner Objects
		scan.close();
	}
}