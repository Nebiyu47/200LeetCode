package Tree;

import java.util.PriorityQueue;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }
    public TreeNode(int val) {this.val=val;}
    public TreeNode(int val , TreeNode left, TreeNode right) {
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class MaximumDepthofBinaryTree {
    public static int MaximumDepthofBinaryTree(TreeNode root ){
        if(root==null)return 0;
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.offer(root);
        int leveDepth =0;
        while (!queue.isEmpty()){
            leveDepth++;
            int size =queue.size();

            for (int i =0;i<size;i++){
                TreeNode current = queue.poll();
                if(current.left!=null)queue.offer(current.left);
                if(current.right!=null)queue.offer(current.right);
            }

        }


return leveDepth;
    }
}
