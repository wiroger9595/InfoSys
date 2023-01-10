package CardGame_Question1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

	public static void main(String[] args) {

		//String a = "abc";

		List<Integer> ans = findAnagrams("cbaebabacd", "abc");

		System.out.println(ans);
	}

	public static List<Integer> findAnagrams(String s, String p) {
		
		List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen * pLen == 0 || sLen < pLen) {
            return result;
        }

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
			System.out.println(map + " adfs ");
		}

		int toBeMatched = map.size();
		int start = 0;
		int end = 0;

		while (end < sLen) {
			char eChar = s.charAt(end);
			if (map.containsKey(eChar)) {
				int count = map.get(eChar);
				if (count == 1) {
					toBeMatched--;
				}
				map.put(eChar, count - 1);
			}
			end++;

			if (end - start > pLen) {
				char sChar = s.charAt(start);
				if (map.containsKey(sChar)) {
					int count = map.get(sChar);
					if (count == 0) {
						toBeMatched++;
					}
					map.put(sChar, count + 1);
				}
				start++;
			}

			if (toBeMatched == 0) {
				result.add(start);
			}
		}

		return result;
	}
}

//
//
//Map<Character, Integer> map = new HashMap<>();
//for (int i = 0; i < p.length(); i++) {
//    map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
//}
//
//int toBeMatched = map.size();
//int start = 0;
//int end = 0;
//
//while (end < sLen) {
//    char eChar = s.charAt(end);
//    if (map.containsKey(eChar)) {
//        int count = map.get(eChar);
//        if (count == 1) {
//            toBeMatched--;
//        }
//        map.put(eChar, count - 1);
//    }
//    end++;
//
//    if (end - start > pLen) {
//        char sChar = s.charAt(start);
//        if (map.containsKey(sChar)) {
//            int count = map.get(sChar);
//            if (count == 0) {
//                toBeMatched++;
//            }
//            map.put(sChar, count + 1);
//        }
//        start++;
//    }
//
//    if (toBeMatched == 0) {
//        result.add(start);
//    }
//}
//
//return result;
