
/**
 * PhotoLineUp.java
 */
/********************************************************
 * REQUIREMENTS - ITC155 MIDTERM
 * Problem 1: 
 * Write a program that lists all ways people can line up for a photo 
 * (all permutations of a list of Strings). The program will read a 
 * list of one word names (until -1), and use a recursive method to 
 * create and output all possible orderings of those names, 
 * one ordering per line.
 * 
 * When the input is:
 * Julia Lucas Mia -1
 * 
 * then the output is (must match the below ordering):
 * 
 * Julia Lucas Mia 
 * Julia Mia Lucas
 * Lucas Julia Mia
 * Lucas Mia Julia
 * Mia Julia Lucas
 * Mia Lucas Julia
 *********************************************************/

import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Nora P.
 * @version 05/26/20 This program reads in a list of Strings, stopping at the
 *          signal -1. It then tests the recursive allPermutations method that
 *          outputs all permutations the of Strings. Assumption is made that at
 *          this version legal input will be entered.
 */
public class PhotoLineUp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> permList = new ArrayList<String>();
		String name;

		// Read in a list of names; stop when -1 is read. Then call recursive method.
		// Prompt
		System.out.println("Enter a list of names, each separated by a space.");
		System.out.println("Signal the end of your list with -1");
		System.out.println("EX: Julia Lucas Mia -1");
		System.out.print("Input >>> ");

		name = scnr.next(); // get the token

		while (!name.equals("-1")) {

			nameList.add(name);
			if (scnr.hasNext()) {
				name = scnr.next();
			}

		} // post: nameList size is 0 or N Strings to evaluate, name holds -1

		// END while
		scnr.close();
		
		allPermutations(permList, nameList);
		

	} // END main

	/**
	 * An example of recursion by omission/reduction: outputs the elements of
	 * permList at i iterations through the given nameList
	 * 
	 * @param permList data structure will store the permutation built from the
	 *                 given
	 * @param nameList will be copied and the recursive pass will use this list to
	 *                 add to the permList
	 */
	public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
		int i;
		int size = nameList.size();

		if (size == 0) {

			// base case:
			// reached either via recursion through reducing a copy of nameList
			// until it passes the condition and outputs the permList elements
			// onto a single line and then moves to next line OR -1 was entered, permList is
			// empty and loop is skipped
			for (String s : permList) {
				System.out.print(s + " ");
			}
			System.out.println();

		} else {
			// recursive case: base case reached via two arrayLists -
			// one to build each permutation and one to reduce to meet base case
			// and then be output to console

			for (i = 0; i < size; i++) {
				// create an arraylist to store the next permutation (will store elements
				// removed from newNames)
				ArrayList<String> newPerms = new ArrayList<String>(permList); // create an ArrayList to store the next
																				// permutation

				// add the element at i from nameList
				newPerms.add(nameList.get(i));

				// create an arrayList newNames with a copy - allows for remove() below, a
				// reduction must occur to reach the base case
				ArrayList<String> newNames = new ArrayList<String>(nameList);

				// remove the name at current index
				newNames.remove(i);

				// recursive call --> continue to build newPerms until newNames / nameList is
				// empty and base case can be entered
				allPermutations(newPerms, newNames);

			} // END for-loop
		} // END if / else block
	} // END allPermutations
} // END class
