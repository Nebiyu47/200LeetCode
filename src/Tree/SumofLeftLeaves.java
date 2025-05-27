package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumofLeftLeaves {
    public static void main(String[] args) {

    }
    public static int sum(TreeNode node){
        List<Integer>result = new ArrayList<>();
        SumofLeftLeaves(node,result);
        return  result.stream().mapToInt(Integer::intValue).sum();
    }
    public static void SumofLeftLeaves(TreeNode root, List<Integer> result){

       if(root==null)return;
       if(root.left.left==null&&root.left.right==null&&root.left!=null){
           result.add(root.left.val);
       }
           SumofLeftLeaves(root.left,result);
          SumofLeftLeaves(root.right,result);
    }
}
