package TwoPointer.Easy;

public class ContainerWithMostWater {
    public static void main(String[] args) {
   int [] nums ={1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }
    public static int maxArea(int[] nums){

        int maxArea=Integer.MIN_VALUE;
        int left=0;
        int right=nums.length-1;
        while (left<right){

            int width=right-left;
            int height=Math.min(nums[left],nums[right]);
            int area = width*height;
            maxArea=Math.max(maxArea,area);
            if(nums[left]<nums[right]){
                left++;
            }else {
                right--;
            }

        }
        return maxArea;
    }
}
