package BFS;

import java.util.*;

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
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> BinaryTreeLevelOrderTraversal(TreeNode node){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()){

            int size= queue.size();
            List<Integer>  level=new ArrayList<>();
            for (int i=0; i< size;i++){
                TreeNode current = queue.poll();
                level.add(current.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
