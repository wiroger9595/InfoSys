
public class Question4 {

	public static void main(String[] args) {

		// int[] coins = {25, 10, 5};
		int[] coins = {9, 6, 5, 1};
		
//		int V = 30;
		int V = 11;
		
		int coinSize = coins.length;

		int ans = minAmount(coins, coinSize, V);

		System.out.println("answer is " + ans);
	}

	public static int minAmount(int[] coins, int coinSize, int V) {

		
		if(V == 0) {
			return 0;
		}
		
		int totalCoins = Integer.MAX_VALUE;
		
		for(int i = 0; i < coinSize; i++) {
			
			if(coins[i] <= V) {
				
				int subCoins = minAmount(coins, coinSize, V - coins[i]);
				
				
				if(subCoins != Integer.MAX_VALUE && subCoins + 1 < totalCoins) {
					totalCoins = subCoins + 1;
				}
			}
			
		}
		
		
		return totalCoins;
	}

}
