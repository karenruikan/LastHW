import java.util.ArrayList;
import java.util.List;

/**
 * This class has various recursive, static methods
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */

public class RecursionQuestion {

	/**
	 * This method removes the commas from a string
	 * 
	 * @param s - String input
	 * @return String with commas removed
	 */
	static String killCommas(String s) {

		// base case - string of length 0
		if (s.length() == 0)
			return s;

		// base case - string of length 1 that is a comma
		if (s.charAt(0) == ',')
			return killCommas(s.substring(1));

		// recursive call on remaining substring
		return s.charAt(0) + killCommas(s.substring(1));

	}

	/**
	 * this method sums the digits of a positive number
	 * 
	 * @param num - integer number
	 * @return - int sum of digits
	 * @throws IllegalArgumentException
	 */
	static int sumDigits(int num) throws IllegalArgumentException {
		// base case - not a positive integer
		if (num <= 0)
			throw new IllegalArgumentException("this number is not a positive integer");

		// base case - single digit number - return just the number
		if (num < 10)
			return num;

		// recursive call on the number
		return num % 10 + sumDigits(num / 10);

	}

	/**
	 * This method returns a powerset of an array
	 * 
	 * @param arr - input list of integers
	 */
	static void powerSet(int[] arr) {
		// create a list of each subset
		List<List<Integer>> result = new ArrayList<>();

		// recursive call on the remaining list of numbers
		powerSetHelper(result, new ArrayList<>(), arr, 0);
	}

	/**
	 * recursive helper method to create the pset
	 * 
	 * @param list       - emptyset to begin with
	 * @param resultList - holds the subsets
	 * @param arr        - input array
	 * @param start      - starting position in the array
	 */
	private static void powerSetHelper(List<List<Integer>> list, List<Integer> resultList, int[] arr, int start) {

		// display the current subset
		System.out.println(resultList);

		// add to existing pset
		list.add(new ArrayList<>(resultList));

		// recursive call for each position of the array
		for (int i = start; i < arr.length; i++) {
			resultList.add(arr[i]); // add a new item to the current result
			powerSetHelper(list, resultList, arr, i + 1); // do recursion
			resultList.remove(resultList.size() - 1); // Remove the last item
		}
	}

//	public static void main(String[] args) {
//		int[] arr = { 32, 1, 10, 3, 2 };
//		powerSet(arr);
//
//	}

}
