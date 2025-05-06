package Tree;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    public static void main(String[] args) {

    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L,0);
        return dfs(root,0,targetSum,prefixSum);

    }
    public static int dfs(TreeNode node , long currentSum , int targetSum , Map<Long,Integer>prefixSum){
        if(node==null)return 0;
        currentSum+=node.val;

        int pathsAtThisEND = prefixSum.getOrDefault(currentSum-targetSum,0);
        prefixSum.put(currentSum,prefixSum.getOrDefault(currentSum,0)+1);
        int pathAtLeft= dfs(node.left,currentSum,targetSum,prefixSum);
        int pathAtRight= dfs(node.right,currentSum,targetSum,prefixSum);
        int total= pathsAtThisEND+pathAtLeft+pathAtRight;
        prefixSum.remove(prefixSum.size()-1);
        return total;
    }
}
