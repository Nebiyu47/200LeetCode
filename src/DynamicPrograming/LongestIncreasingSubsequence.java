package DynamicPrograming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int []  nums ={10,9,2,5,3,7,101,18};

    }
    public static int LongestIncreasingSubsequence(int[] nums){

        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);

        int maxLength=0;
        for (int i=1;i<nums.length;i++){
            for (int j=0; j< i ;j++){

                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
