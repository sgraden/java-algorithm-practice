public class SentenceFlip {

	public static void main(String[] args) {
		System.out.println(flipSentence("rabbid oxen"));
		System.out.println(flipSentence("Silly willy rabbits"));
		System.out.println(flipSentence("Sean stinks and is silly"));
		System.out.println(flipSentence("billy ate it well"));
		System.out.println(flipSentence("Sean is a super silly guy who just farts around"));
		//System.out.println(flipSentenceRecursive("The black doggy"));
		//System.out.println(flipSentenceStack("The black doggy"));
	}
	
	public static String flipSentence(String s) {
		char[] chars = s.toCharArray();
		// flips the entire sentence to begin with
		flipIndex(0, chars.length -1, chars);
		
		int start = 0;
		// find the start and end of 'word' and flip it
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				flipIndex(start, i - 1, chars);
				start = i + 1;
			}
		}
		if (start != chars.length - 1) {
			flipIndex(start, chars.length - 1, chars);
		}
		return new String(chars);
	}
	// Flips a region from start to end
	public static void flipIndex(int start, int end, char[] chars) {
		int length = end - start;
		for (int i = 0; i <= length / 2; i++) {
			char temp = chars[start + i];
			chars[start + i] = chars[end - i];
			chars[end - i] = temp;
		}
	}
	
	// Buffer
	private static String flipSentenceRecursive(String s) {
		return "";
	}
	
	// Data structure 
	private static String flipSentenceStack(String s) {
		return "";
	}

}
