package DynamicPrograming;

import java.util.Arrays;

public class coinChange {
    public static void main(String[] args) {
        int [] nums ={1,2,5};
        System.out.println(coinChange(12,nums));
    }
    public static int coinChange(int amount ,int [] nums){

        int [] dp= new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i=0;i<=amount;i++){
            for (int coin : nums){
                if(i-coin>=0){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
