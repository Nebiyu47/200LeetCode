package DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7} ;
        int target = 7;
    }
    public List<List<Integer>> CombinationSum(int[] candidates , int target){
        List<List<Integer>> result= new ArrayList<>();
       backtack(0,candidates,target,new ArrayList<>(),result);
       return result;
    }
    public void backtack(int index,int[] candidates, int target,List<Integer> current ,List<List<Integer>>result){
      if(target<0)return;
      if (target==0)result.add(new ArrayList<>(current));

      for (int i=0;i<candidates.length;i++){
          current.add(candidates[i]);
          backtack(i,candidates ,target-candidates[i],current,result);
          current.remove(current.size()-1);
      }

    }


}
