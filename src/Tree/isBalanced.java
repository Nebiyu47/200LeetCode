package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class isBalanced {
    public boolean isBalanced(TreeNode root){

        if(root==null)return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();

            int leftHeight = geHeight(current.left);
            int rightHeight = geHeight(current.right);
            if(Math.abs(leftHeight-rightHeight)>1){
                return false;
            }
            if(current.left!=null)queue.offer(current.left);
            if(current.right!=null)queue.offer(current.right);
        }
        return true;
    }

    private int geHeight(TreeNode node) {
        if (node==null)return 0;
        return 1+Math.max(geHeight(node.left),geHeight(node.right));
    }

}
