package DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> CombinationSum(int[] candidates , int target){
        List<List<Integer>> result= new ArrayList<>();
       backtack(0,candidates,target,new ArrayList<>(),result);
       return result;
    }
    public void backtack(int index,int[] candidates, int target,List<Integer> current ,List<List<Integer>>result){
       if(target==0){
           result.add(new ArrayList<>(current));
           return;
       }
       if(target<0||index>=candidates.length){
           return;
       }
       current.add(candidates[index]);
       backtack(index,candidates,target-candidates[index],current,result);
       current.remove(current.size()-1);
       backtack(index+1,candidates,target,current,result);
    }
}
