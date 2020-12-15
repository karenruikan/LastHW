import java.util.ArrayList;
import java.util.Arrays;

public class RecursionQuestion {

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
		if (num < 0)
			throw new IllegalArgumentException("this number is not a positive integer");

		// base case - single digit number - return just the number
		if (num < 10)
			return num;

		// recursive call on the number
		return num % 10 + sumDigits(num / 10);

	}

	static void powerSet(int[] arr) {
		ArrayList<ArrayList<Integer>> psets = new ArrayList<ArrayList<Integer>>();
		// base case - arr of length 0
		if (arr.length == 0)
			System.out.println("{}");

		psets.add(new ArrayList<Integer>(Arrays.asList(arr[arr.length-1])));
	
		for (int i = 0; i < arr.length; i++) {
			powerSet(arr);
		}

		System.out.println(permList);

	}

	public static void main(String[] args) {
		System.out.println(killCommas("a,c,v,d,a,c,f"));
		System.out.println(sumDigits(12344));
	}

}
