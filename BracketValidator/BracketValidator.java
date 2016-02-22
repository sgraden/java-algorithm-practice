package testing;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validate("{[]()}")); // true
		System.out.println(validate("{[(])]")); // false
		System.out.println(validate("{[}")); // false
		//System.out.println(validate("{||}")); // true
	}
	
	public static boolean validate(String test) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		//map.put('|', '|');
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < test.length(); i ++) {
			if (map.containsKey(test.charAt(i))) { //If opening character add to stack
				s.push(test.charAt(i));
			} else if (map.containsValue(test.charAt(i))) { //If it is closing character
				if (map.get(s.peek()) != test.charAt(i)) {
					return false;
				} else {
					s.pop();
				}
			}
		}
		return true;
	}

}
