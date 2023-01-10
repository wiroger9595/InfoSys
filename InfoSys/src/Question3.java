import java.util.HashMap;
import java.util.Map;

public class Question3 {
	
	
	
	public static void main(String[] args) {
		
		
		
		//String s = "abcabcbb";
		String s = "bbbbb";

		
		int ans =  longestSubString(s);
		
		System.out.println("answer is "+ ans);
	}
	
	
	public static int longestSubString(String s) {
		
		
		
		int start = 0;
		int totalLength = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			
			
			char eachChar = s.charAt(i);
			if( map.containsKey(eachChar)) {
				start = Math.max(start, map.get(eachChar) + 1);
			}
			map.put(eachChar, i);
			totalLength = Math.max(totalLength, i - start + 1);
			
		}
		
		
		return totalLength;
	}

}
