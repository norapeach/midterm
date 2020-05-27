/**
 * StudentGrades.java
 */
/********************************************************
 * REQUIREMENTS - ITC155 MIDTERM 
 * Problem 2: 
 * Given a HashMap pre-filled with student names as keys and grades
 * as values, complete main() by reading in the name of a student, 
 * outputting their original grade, and then reading in and outputting 
 * their new grade.
 * 
 * Ex: If the input is:
 * Quincy Wraight
 * 73.1
 * 
 * the output is:
 * Quincy Wraight's original grade: 65.4
 * Quincy Wraight's new grade: 73.1
 *********************************************************/

import java.util.Scanner;
import java.util.HashMap;

/**
 * @author Nora P.
 * @version 05/19/20 Description: This program prompts the user to enter a
 *          student name, If that student is present in the existing record
 *          (HashMap studentGrades), the existing grade is displayed on the
 *          console and the user is prompted to enter a new grade. That input
 *          replaces the value mapped to the key (studentName) and the updated
 *          grade record is displayed on the console. TODO: 5/22
 */
public class StudentGrades {

	public static void main(String[] args) throws Exception {
		// Problem 2 Starter Code: 
		Scanner scnr = new Scanner(System.in);
		String studentName = "";
		double studentGrade = 0;

		HashMap<String, Double> studentGrades = new HashMap<String, Double>();

		// Students's grades (pre-entered)
		studentGrades.put("Harry Rawlins", 84.3); // Harry Rawlin 90.0
		studentGrades.put("Stephanie Kong", 91.0);
		studentGrades.put("Shailen Tennyson", 78.6);
		studentGrades.put("Quincy Wraight", 65.4);
		studentGrades.put("Janine Antinori", 98.2);

		///  START  ///
		prompt("Enter the full student name (ex: Quincy Wraight 73.1) >>> ");

		try { // attempt to catch exceptions 
			// TODO 5/24 change to nextLine --> reference entire token in variable
			if (scnr.hasNext()) { // next line, next double - no need for adding space - 
				studentName = scnr.next();
				studentName += " " + scnr.next();

				// pre: student is present as key in studentGrades
				if (studentGrades.containsKey(studentName)) {
					// get current value associated to key and output
					double original = studentGrades.get(studentName);
					System.out.println(studentName + "'s original grade: " + original + "\n"); // output the original
																								// grade
					// TODO 5/24 remove to only prompt once then collect line and then next double
					// Collect input to update key/value pair
					prompt("Enter " + studentName + "'s new grade >>> ");
						studentGrade = scnr.nextDouble(); // consume token and store as studentGrade
						scnr.close(); // Close scanner

						// Replace original with new value and output to console
						studentGrades.replace(studentName, original, studentGrade);
						System.out.println(studentName + "'s new grade: " + studentGrades.get(studentName) + "\n");
					} // END post: records updated and displayed

				} else { // key not present
					System.out.println("No records found for " + studentName);

				} // END if - key not present

			} // END outer if

//			

		} catch (Exception e) {
			System.out.println("Exception thrown: " + e);
		} // END try/catch block

	} // END main

	/**
	 * Prompt outputs the String content to the console - to be used in combination
	 * with Scanner(System.in)
	 * 
	 * @param content The string to be included as the output text for user input
	 *                prompt
	 */
	public static void prompt(String content) {
		System.out.print(content);
	}
} // END class
