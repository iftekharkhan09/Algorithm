package com.src.integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Code {
	static String electionWinner(String[] votes) {
		Map<String, Integer> votersMap = new TreeMap<>();
		for (int i = 0; i < votes.length; i++) {
			String candidateName = votes[i];
			if (votersMap.containsKey(votes[i]))
				votersMap.put(candidateName, votersMap.get(candidateName) + 1);
			else
				votersMap.put(candidateName, 1);
		}
		SortedSet<Map.Entry<String, Integer>> sortedMap = getSortedMap(votersMap);
		return getCandidate(sortedMap);

	}

	private static SortedSet<Map.Entry<String, Integer>> getSortedMap(Map<String, Integer> votersMap) {
		SortedSet<Map.Entry<String, Integer>> sortedMap = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				int res = o2.getValue().compareTo(o1.getValue());
				return res != 0 ? res : 1;
			}
		});
		sortedMap.addAll(votersMap.entrySet());
		return sortedMap;
	}

	private static String getCandidate(SortedSet<Map.Entry<String, Integer>> sortedMap) {
		Iterator<Map.Entry<String, Integer>> it = sortedMap.iterator();
		String firstCandidate = null;
		// int size = sortedMap.size();
		List<String> sameNames = new ArrayList<>();

		int maxValue = sortedMap.first().getValue();
		while (it.hasNext()) {
			Map.Entry<String, Integer> candidate = it.next();
			if (candidate.getValue() == maxValue)
				sameNames.add(candidate.getKey());
		}
		Collections.sort(sameNames, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});

		return sameNames.get(0);
	}

	public static void main(String[] args) {
		String[] votes = { "ABC", "ADE", "ABC", "ADE" };
		System.out.println(Code.electionWinner(votes));
	}
}