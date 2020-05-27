/**
 * DescendingOrder.java
 */


import java.util.*;
import java.util.Scanner;

/**
 * @author Nora P.
 * @version 05/19/20 Description: This program tests the method
 *          selectionSortDescendTrace. TODO: update - change to print out numbers instead of entire array.toString // Clean comments
 */

public class DescendingOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner scnr = new Scanner(System.in);
		int input = 0, i = 0; // Eclipse added the initialization of input = 0, to remove error warning
		int numElements = 0; // TODO: not certain what this is for
		int[] numbers = new int[10]; // TODO: all 10 elements may not be modified

		// Prompt user to enter UP TO 10 positive integers followed by -1
		// Example of user input: 20 10 30 60 70 40 -1
		System.out.print("Enter a MAXIMUM of 10 positive integers followed by -1 >>> ");

		try {
			while (scnr.hasNextInt()) { // confirm token is an integer
				input = scnr.nextInt(); // store input
				if (input < -1) { // if input contains negative value other than -1
					// TODO: prompt user to reenter 10 positive integers followed by -1 as signal
					// for end of input
					System.out.println("");
					System.out.print("Enter a MAXIMUM of 10 positive integers followed by -1 >>> ");
				} else if (input != -1) { // pre: -1 'end of user input signal' has not been reached
					numbers[i] = input; // adds the integer to the array using the i variable for the index identifier
					i++; // increment i to prep modifying numbers array with next input value
					numElements++; // Tracks actual number of input elements added to array (could be less than 10)
					// post: all legal tokens have been added to 'numbers', i is either at 10 or
					// next index position, 'numElements' identifies the actual number of input
					// integers
				} else {
					break; // input holds -1, exit loop, close scanner
				}
			} // END while
			scnr.close();
			selectionSortDescendTrace(numbers, numElements);

		} catch (Exception e) {
			System.out.println("Exception thrown: " + e);
		} // END try/catch

	} // END main

	/**
	 * Helper for selectionSortDescendTrace to verify if the sorting is compete and
	 * stop trace
	 * 
	 * @param a The array of integers to be evaluated
	 * @return true if the given array is in descending order
	 */
	private static boolean isSortedDesc(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < a[i + 1]) {
				return false;
			}
		}
		return true; // post: array is sorted in descending order
	}

	/**
	 * Helper swap method for selection sort
	 * 
	 * @param a The array with the elements to be swapped
	 * @param i - index of larger value
	 * @param j - index of smaller value ( for this program )
	 */
	private static void swap(int[] a, int i, int j) {
		if (i != j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	} // END method

	// REQUIREMENTS:
	// Use nested loops
	// Output the array after each iteration of the outer loop
	/**
	 * Outputs the descending sorting trace of a MAX 10 integer array
	 * 
	 * @param numbers     - the integer array to sort
	 * @param numElements - represents the number of elements in the given array
	 *                    that store the user input
	 */
	public static void selectionSortDescendTrace(int[] numbers, int numElements) {
		for (int i = 0; i < numElements; i++) { // loop through ONLY the modified elements
			if (isSortedDesc(numbers)) {
				break;
			} else {
				int largest = i; // find the index of the largest value in 'numbers'
				for (int j = i + 1; j < numElements + 1; j++) { // range condition +1 to allow for last modified element to
					// be compared
					if (numbers[j] > numbers[largest]) {
						largest = j;
					}
				} // post: largest holds the index of the largest element
				swap(numbers, i, largest);
				// for loop to system.out.print (values instead of )
				System.out.println(Arrays.toString(Arrays.copyOf(numbers, numElements)));
			}
		} // END outer for-loop

	} // END method

} // END class
