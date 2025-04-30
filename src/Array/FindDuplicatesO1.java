package Array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesO1 {
    public static void main(String[] args) {


    }
    public static List<Integer> findDuplicate(int[] nums){
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i]);
            if(nums[index]<0){
                result.add(nums[index]);
            }
            nums[index]=-nums[index];
        }
        return result;
    }
}
