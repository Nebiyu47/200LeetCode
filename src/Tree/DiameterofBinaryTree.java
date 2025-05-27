package Tree;

import java.util.LinkedList;
import java.util.Queue;
//Post order
public class DiameterofBinaryTree {
    private  static int diamter=0;
    public static int DiameterofBinaryTree(TreeNode root) {
        dfs(root);
        return diamter;
    }
    public static int dfs(TreeNode node){
        if(node==null)return 0;
        int left=dfs(node.left);
        int right=dfs(node.right);
        diamter=Math.max(diamter,left+right);
        return 1+Math.max(left,right);
    }
}
