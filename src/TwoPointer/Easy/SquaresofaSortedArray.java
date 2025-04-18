package TwoPointer.Easy;

import java.util.Arrays;

public class SquaresofaSortedArray {
    public static void main(String[] args) {

//        Example:
//        Input: nums = [-4, -1, 0, 3, 10]
//        Output: [0, 1, 9, 16, 100];

        int[] nums={-4, -1, 0, 3, 10};
        int[] squared= sortedSquare(nums);
        System.out.println(Arrays.toString(squared));
    }
    public static int[] sortedSquare(int[] nums){
        int n = nums.length;
        int left=0;
        int right=nums.length-1;
        int rex=nums.length-1;
        int [] result = new int[n];
        while (left<=right){

            int leftSequare=nums[left]*nums[left];
            int rightSequare=nums[right]*nums[right];

            if(leftSequare>rightSequare){
                result[rex--]=leftSequare;
                left++;
            }else {
                result[rex--]=rightSequare;
                right--;
            }
        }
        return result;
    }
}
