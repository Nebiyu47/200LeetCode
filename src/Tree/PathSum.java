package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> pathSum (TreeNode root, int target){

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
         dfs(root, target ,path , result);
         return result;
    }
    public static void dfs(TreeNode root , int target , List<Integer>path, List<List<Integer>> result ){

      if(root==null)return;
      path.add(root.val);
      if(root.left==null&&root.right==null&&target==root.val){
          result.add(new ArrayList<>(path));
      }else {
          dfs(root.left,target-root.val,path,result);
          dfs(root.right,target-root.val,path,result);
      }
      path.remove(path.size()-1);
    }
}
