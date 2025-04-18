package SlidingWindow.Easy;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(MinimumSizeSubarraySum(nums,s));
    }
    public static int MinimumSizeSubarraySum(int [] nums, int k){


        int left =0;
        int right=0;
        int maxLen=Integer.MAX_VALUE;
        int sum=0;
        while (right<nums.length){

            sum+=nums[right];

            if(sum>=k){
                sum-=nums[left];
                left++;
            }
            right++;
            maxLen=Math.min(maxLen,right-left+1);
        }
        return maxLen;
    }
}
