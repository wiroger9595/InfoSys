import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question2 {
	
	
	
	public static void main(String[] args) {
		
		
		
		List<String> logInfos = new ArrayList<String>(Arrays.asList(
			"http://www.yahoo.com/ 150 200" ,
			"https://www.yahoo.com/news/ 200 200",
			"https://sports.yahoo.com/ 10 200" ,
			"https://techcrunch.com/startups/ 30 200" ,
			"https://www.huffingtonpost.com/ 70 200" ,
			"https://www.huffingtonpost.co.uk/ 1000 200" ,
			"https://www.huffingtonpost.co.uk/entry/brexit-secretary?utm_hp_ref=uk-politics 500 404" ,
			"https://developer.github.com/apps/building-oauth-apps/ 40 200" ,
			"https://developer.github.com/v3/ 33 200" ,
			"https://developer.github.com:8080/v3/ 77 500" ));
		
		
		
		
		// first
		
		Map<String, Set<String>> mapResult = new HashMap<>();


		Set<String> set200 = new HashSet<>();
		Set<String> set404 = new HashSet<>();
		Set<String> set500 = new HashSet<>();
		
		
		
		for(int i = 0; i < logInfos.size(); i++) {
			
			
			String[] logInfo = logInfos.get(i).split(" ");
			String breakWord = "";
			
		
			breakWord = logInfo[0].substring(logInfo[0].indexOf("/") + 2);
						
			String[] splitDomain = breakWord.split("/");
			
			
			String domain = "";
			if(splitDomain[0].contains(":")) {
				domain = splitDomain[0].substring(0, splitDomain[0].lastIndexOf(':'));
				System.out.println(domain);
			} else {
				domain = splitDomain[0];
			}
			
			
			
			if(logInfo[2].equals("200")) {
				set200.add(domain);
				mapResult.put(logInfo[2], set200);
			} else if (logInfo[2].equals("404")) {
				set404.add(domain);
				mapResult.put(logInfo[2], set404);
			} else if (logInfo[2].equals("500")) {
				set500.add(domain);
				mapResult.put(logInfo[2], set500);
			}
			
			
			
			
			
			
		}
		
		
		System.out.println("count total status code 200 is "+ mapResult.get("200").size());
		System.out.println("count total status code 404 is "+ mapResult.get("404").size());
		System.out.println("count total status code 200 is "+ mapResult.get("500").size());


		// second && third
		
		
		Map<String, Integer> mapResponseTime = new HashMap<>();
		
		Map<String, Integer> map99Percentile = new HashMap<>();


		
		for(int i = 0; i < logInfos.size(); i++) {
			
			String[] logInfo = logInfos.get(i).split(" ");
			String breakWord = "";
			
		
			breakWord = logInfo[0].substring(logInfo[0].indexOf("/") + 2);
			
			
			String[] splitDomain = breakWord.split("/");
			String domain = "";
			if(splitDomain[0].contains(":")) {
				domain = splitDomain[0].substring(0, splitDomain[0].lastIndexOf(':'));
				System.out.println(domain);
			} else {
				domain = splitDomain[0];
			}
			
			//
			
			if(mapResponseTime.containsKey(domain)) {
				int avgTime = (mapResponseTime.get(domain) + Integer.parseInt(logInfo[1])) / 2;
				mapResponseTime.put(domain, avgTime);

				
			} else {
				mapResponseTime.put(domain, Integer.parseInt(logInfo[1]));
			}
			
			//
			if(logInfo[2].equals("200")) {
				if(map99Percentile.containsKey(domain)) {
					int avgTime = (map99Percentile.get(domain) + Integer.parseInt(logInfo[1])) / 2;
					map99Percentile.put(domain, avgTime);
	
					
				} else {
					map99Percentile.put(domain, Integer.parseInt(logInfo[1]));
				}
			}
			
			
		}
		
		
		
		
		System.out.println("response time is "+ mapResponseTime);

		System.out.println("response 99 percentile is "+ map99Percentile);

		
		
	}
	


}
