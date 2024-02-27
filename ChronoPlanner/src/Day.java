/**
 * Class Day: This class is used to represent one day of a schedule. The data is
 * an array of boolean values that represent whether an appointment is scheduled
 * for a particular hour of the day. There is also a description that is
 * associated with each hour of the day - saved in an array of Strings.
 *
 * Last Modified: 2/4/24
 * Author: Brendan Lambrecht
 */

public class Day {
	// Attributes

	// There are 24 hours in a day, so this
	// array should have 24 elements. If an
	// element is true, that means an appointment
	// is scheduled during that hour. If it is
	// false, then there is no appointment scheduled
	// during that hour.
	private boolean[] isBusy;

	// This also should have 24 elements, one
	// for each hour of the day. If an appointment
	// is scheduled for an hour, then this array
	// should hold a String description of the
	// appointment.
	private String[] appointmentDescription;

	/**
	 * Constructor for the Day class. This should allocate memory for the attribute
	 * arrays, and should initialize each hour to have no appointments.
	 * 
	 */
	public Day() {
		isBusy = new boolean[24];
		appointmentDescription = new String[24];
	}

	/**
	 * Checks if there is an appointment scheduled for a specific hour of the day.
	 *
	 * @param hour The hour of the day to check for an appointment (0-23).
	 * @return {@code true} if an appointment is scheduled for the given hour, {@code false} otherwise.
	 */
	public boolean checkTime(int hour) {
		if (this.isBusy[hour]) {
			return true;
		} else{
			return false;
		}
	}

	/**
	 * Checks if there is an appointment scheduled at any hour of the day.
	 *
	 * @return {@code true} if there is an appointment scheduled at any hour of the day, {@code false} otherwise.
	 */
	public boolean checkDay() {
		for (int i = 0; i < 24; i++) {
			if (this.isBusy[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retrieves the description of the appointment scheduled for the specified hour of the day.
	 *
	 * @param hour The hour of the day for which to retrieve the appointment description (0-23).
	 * @return The description of the appointment scheduled for the given hour, or "No appointment scheduled" if no appointment is scheduled.
	 */
	public String getDescription(int hour) {
		if (this.isBusy[hour]) {
			return this.appointmentDescription[hour];
		} else{
			return "No appointment scheduled";
		}
	}

	/**
	 * Adds a new appointment to the given hour for this day, if there is no existing appointment.
	 *
	 * @param hour The hour during this day for which an appointment should be made (0-23).
	 * @param description The text description of the new appointment.
	 * @return {@code false} if there is already an appointment scheduled during the given hour
	 *         (the previous appointment information remains unchanged), {@code true} if adding
	 *         the appointment was successful (there was no previous appointment).
	 */
	public boolean addAppointment(int hour, String description) {
		if (checkTime(hour)){
			return false;
		}
		this.appointmentDescription[hour] = description;
		this.isBusy[hour] = true;
		return true;
	}

	/**
	 * This method should remove an appointment for a given hour for this day. There
	 * should be no effect if there was not an appointment scheduled in the first
	 * place.
	 *
	 * @param hour The hour during this day for which an appointment removed.
	 */
	public void removeAppointment(int hour) {
		if (this.isBusy[hour]) {
			this.isBusy[hour] = false;
			this.appointmentDescription[hour] = "";
		}
	}

	/**
	 * This method should generate a String of all appointment times and
	 * descriptions for a given hour for this day. There should be no print
	 * statements in this method, only the code to create a String.
	 *
	 * @return A String whose text is one line for each appointment on this day.
	 *         Each line should have the appointment time and the appointment
	 *         description. See the program description for the exact formatting.
	 */
	public String toString() {
		String text = "";
		for (int i = 0; i < 24; i++) {
			if (this.isBusy[i]) {
				text += i + ":00 - " + this.getDescription(i) + "\n";
			} else {
				if (!checkDay()){
				text = "No appointments scheduled for this entire day.";
				}
			}
		}
		return text;
	}
}