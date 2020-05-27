
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
 * 
 * 
 * 5/26/20 The current version assumes legal input will be received
 *********************************************************/

import java.util.Scanner;
import java.util.HashMap;

/**
 * @author Nora P.
 * @version 05/26/20 This program prompts the user to enter a student name and
 *          grade. If that student is present in the existing record (HashMap
 *          studentGrades), the existing grade is displayed on the console and
 *          the user is prompted to enter a new grade. That input replaces the
 *          value mapped to the key (studentName) and the updated grade record
 *          is displayed on the console.
 */
public class StudentGrades {

	public static void main(String[] args) throws Exception {
		// Problem 2 Starter Code: 
		Scanner scnr = new Scanner(System.in);
		String studentName;
		double studentGrade;

		HashMap<String, Double> studentGrades = new HashMap<String, Double>();

		// Students's grades (pre-entered)
		studentGrades.put("Harry Rawlins", 84.3); // Harry Rawlin 90.0
		studentGrades.put("Stephanie Kong", 91.0);
		studentGrades.put("Shailen Tennyson", 78.6);
		studentGrades.put("Quincy Wraight", 65.4);
		studentGrades.put("Janine Antinori", 98.2);

		///  START  ///
		System.out.println("Enter the full student name, hit the return (enter key),");
		System.out.println("then enter the updated grade.");
		System.out.println("EX: >>> Harry Rawlins \n90.0");
		prompt("Input >>> ");

		try { 
			
			if (scnr.hasNextLine()) {
				
				// consume token and store
				studentName = scnr.nextLine();
				studentGrade = scnr.nextDouble();
				
				scnr.close(); // Close scanner
				
				if (studentGrades.containsKey(studentName)) { // pre-condition: String is present as a key
					
					// get current value mapped to key and output
					double original = studentGrades.get(studentName);
					
					System.out.println(studentName + "'s original grade: " + original + "\n"); 

						// Replace original with new value and output to console
						studentGrades.replace(studentName, original, studentGrade);
						
						System.out.println(studentName + "'s new grade: " + studentGrades.get(studentName) + "\n");
						
					} // END post: records updated and displayed

				} else { // key not present
					System.out.println("No records found");

				} // END outer if	// END if - key not present

			} 	catch (Exception e) {
			System.out.println("Exception thrown: " + e);
	} // END try/catch block

	}// END main

	/**
	 * Helper for testing ease TODO delete
	 * 
	 * @param content The string to be included as the output text for user input
	 *                prompt
	 */
	public static void prompt(String content) {
		System.out.print(content);
	}
	
} // END class
