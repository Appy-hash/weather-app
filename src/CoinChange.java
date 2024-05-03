import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,-1);
        Arrays.sort(coins);
        dp[0] = 0;
        for(int j = 0 ; j < coins.length; j++){
            for(int i = 1 ; i <= amount ; i++){ //amount
                if(i >= coins[j]){
                    if(dp[i - coins[j]] >= 0){
                        dp[i] = Math.min(dp[i],dp[i - coins[j]]+ 1);
                    }

                }
            }

        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String... args){
        System.out.println(coinChange(new int[]{186,419,83,408},6249));
    }
}
