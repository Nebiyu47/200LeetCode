package DFS;

import java.util.ArrayList;
import java.util.List;

public class permute {
    public static void main(String[] args) {
        int [] nums={1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int [] nums){

        List<List<Integer>> result = new ArrayList<>();
        backTrack(new ArrayList<>(),nums,result);
        return result;

    }
    public static void backTrack(List<Integer> path, int[] nums , List<List<Integer>> result ){
        if(nums.length==path.size()){
            result.add(new ArrayList<>(path));
        }

        for(int num : nums){
            if(path.contains(num))continue;
            path.add(num);
            backTrack(path, nums, result);
            path.remove(path.size()-1);
        }
    }
}
