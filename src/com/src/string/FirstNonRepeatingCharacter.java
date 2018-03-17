package com.src.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
	public static void main(String[] args) {
		String s = new String("abbacd");
		System.out.println("First Non Repearting Charater is :" + getFirstNonRepeatingChar(s));
	}

	private static Character getFirstNonRepeatingChar(final String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), 1);
			else {
				int count = map.get(s.charAt(i));
				map.put(s.charAt(i), count + 1);
			}
		}
		for (Map.Entry<Character, Integer> set : map.entrySet()) {
			if (set.getValue() == 1)
				return set.getKey();
		}
		return null;
	}
}
