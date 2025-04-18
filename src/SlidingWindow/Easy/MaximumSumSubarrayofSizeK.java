package SlidingWindow.Easy;

public class MaximumSumSubarrayofSizeK {
    public static void main(String[] args) {
       int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(SumSubarray(nums,k));
    }
    public static int SumSubarray(int[] nums , int k){

       int left=0;
       int right=0;
       int maxSum=0;
       int windSum=0;
       while (right<nums.length){
           windSum+=nums[right];

           if(right-left+1==k){
            maxSum=Math.max(maxSum,windSum);
            maxSum-=nums[left];
            left++;
           }

           right++;
       }
       return maxSum;
    }
}
