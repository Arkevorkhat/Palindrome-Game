package backEnd;

public class PigLatin {
	public static boolean checkPig(String input, String original) {
		//char[] inputA = input.toCharArray();
		//char[] originalA = original.toCharArray();
		if(input.equals(makePig(original))) {
			return true;
		}
		else return false;
	}
	public static String makePig(String input) {
		StringBuffer inputSB = new StringBuffer(input.toUpperCase());
		char storage = inputSB.charAt(0);
		inputSB = inputSB.deleteCharAt(0);
		inputSB = inputSB.append(storage);
		inputSB = inputSB.append("ay");
		return inputSB.toString();
	}
}