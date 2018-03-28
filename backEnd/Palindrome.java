package backEnd;

import java.util.Random;

public final class Palindrome {
	/*
	 * 
	 */
	public static String reverse(String input) { //required for correct function of the check and make palindrome methods.
		StringBuffer in = new StringBuffer(input);
		in.reverse();
		return in.toString();
	}

	public static Boolean checkPalindrome(String input) { //returns a boolean whether or not the input is a palindrome.

		String check = reverse(input);
		if (check.equals(input)) {
			return true;
		} else
			return false;
	}

	public static String makePalindrome(int length) {  //returns a String of length length, said string will be palindromic.
		if (length < Integer.MAX_VALUE) {
			Random r = new Random();
			StringBuffer storage = new StringBuffer();
			for (int i = 0; i < Math.ceil(length / 2); i++) {
				storage.appendCodePoint(r.nextInt(26) + 'a');//Generate a random character
			}
			storage.append(reverse(storage.toString())); //add a copy of the generated string 1/2 length long, reversed, to the end of the buffer.
			return storage.toString(); 
		}
		else {
			System.out.println("Palindrome creation Failed - input value too large.");
			return "";
		}
	}
}