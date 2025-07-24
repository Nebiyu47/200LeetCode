package DFS.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {

    }
    public static List<List<Integer>>combinationSumII(int[] candidates , int target  ){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtack(candidates,target,0,new ArrayList<>(),result);
        return result;
    }
    public static void backtack(int[] candidates , int target , int start , List<Integer> current ,List<List<Integer>>result){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if(i>start&&candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            current.add(candidates[i]);
            backtack(candidates,target-candidates[i],i+1,current,result);
            current.remove(current.size()-1);
        }
    }

}
