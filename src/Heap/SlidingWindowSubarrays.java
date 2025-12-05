package Heap;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowSubarrays {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(maxSlidingWindow(nums,k));
    }
    public static int[] maxSlidingWindow(int[] nums , int k){

        int n = nums.length;
        int [] res = new int[n-k+1];
        for (int i=0;i<=n-k;i++) {
            int max=nums[i];
            for (int j = i; j < i + k; j++) {
                if(max>nums[j]){
                    max=nums[j];
                }

            }
            res[i]=max;
        }
        return res;
    }
}
