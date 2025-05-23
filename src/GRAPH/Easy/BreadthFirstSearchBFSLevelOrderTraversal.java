package GRAPH.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class BreadthFirstSearchBFSLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();

        if(root==null)return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){

            int levelSize= queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i =0;i<levelSize;i++){

                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);

            }
            result.add(currentLevel);
        }
        return result;
    }
}
