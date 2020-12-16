import java.util.ArrayList;
import java.util.Arrays;

public class RecursionQuestion {

	private static ArrayList<ArrayList<Integer>> allPsets;

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

	static void powerSet(int[] arr) {
		if (arr.length == 0) {
			allPsets = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> emptySet = new ArrayList<>();
			allPsets.add(emptySet);
		} else {
			int[] subset = Arrays.copyOf(arr, arr.length - 1);
			Integer lastElement = new Integer(arr[arr.length - 1]);
			ArrayList<Integer> singleElement = new ArrayList<>();
			powerSet(subset);

			singleElement.add(lastElement);

			if (!allPsets.contains(lastElement)) {
				ArrayList<ArrayList<Integer>> newSubset = new ArrayList<ArrayList<Integer>>();
				for (ArrayList<Integer> set : allPsets) {
					ArrayList<Integer> newArrLst = new ArrayList<>();
					newArrLst.addAll(set);
					newArrLst.add(lastElement);
					newSubset.add(newArrLst);
				}
				allPsets.addAll(newSubset);
			}
		}
		System.out.println(allPsets);
	}

	public static void main(String[] args) {
		System.out.println(killCommas("a,c,v,d,a,c,f"));
		System.out.println(sumDigits(786));
		int[] test = new int[3];
		test[0] = 1;
		test[1] = 2;
		test[2] = 3;

		powerSet(test);

	}

}
