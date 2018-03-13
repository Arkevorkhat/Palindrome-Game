package logic;

import java.util.Random;

public class Palindrome {
	/*
	 * TODO: Discuss this file, finalize palindrome logic class.
	 */
	public static String reverse(String input) {
		StringBuffer in = new StringBuffer(input);
		in.reverse();
		return in.toString();
	}

	public static Boolean checkPalindrome(String input) {

		String check = reverse(input);
		if (check.equals(input)) {
			return true;
		} else
			return false;
	}

	public static String makePalindrome(int length) {
		/*
		 * FIX ME: crashes when makePalindrome is passed length>~2.147*10^9
		 */
		if (length < Integer.MAX_VALUE) {
			Random r = new Random();
			StringBuffer storage = new StringBuffer();
			for (int i = 0; i < Math.ceil(length / 2); i++) {
				storage.appendCodePoint(r.nextInt(26) + 'a');
			}
			storage.append(reverse(storage.toString()));
			return storage.toString();
		}
		else {
			System.out.println("Palindrome creation Failed - input value too large.");
			return "";
		}
	}
}