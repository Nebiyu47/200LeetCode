package TwoPointer.Easy;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        System.out.println(removeDuplicate(nums));
    }
    public static int[] removeDuplicate(int [] nums){

        int uniquePointer=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[uniquePointer]){
                uniquePointer++;
                System.out.println("uniquePointer"+uniquePointer);
                nums[uniquePointer]=nums[i];

            }
        }
        int[] result = new int[uniquePointer+1];
        System.arraycopy(nums,0,result,0,uniquePointer+1);
         return result;
    }
}
