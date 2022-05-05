package com.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> out = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char tempArray[] = s.toCharArray();
			Arrays.sort(tempArray);
			String sortedString = String.valueOf(tempArray);
			if (map.containsKey(sortedString)) {
				List<String> list = map.get(sortedString);
				list.add(s);
				map.put(sortedString, list);

			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(sortedString, list);
			}

		}
		for (String s : map.keySet()) {
			out.add(map.get(s));
		}

		return out;

	}

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagram groupAnagrams = new GroupAnagram();
		System.out.println(groupAnagrams.groupAnagrams(strs));

	}
}
