package Tree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinaBST {
    public static void main(String[] args) {

    }
    public static int KthSmallestElementinaBST(TreeNode root , int k){
        PriorityQueue<TreeNode>pq = new PriorityQueue<>();
        dfs(root,pq);
        while (--k>0){
            pq.poll();
        }
        return pq.peek().val;
    }
    public static void dfs(TreeNode root, PriorityQueue<TreeNode>pq){
        if(root==null)return;
        pq.offer(root);
        dfs(root.left,pq);
        dfs(root.right,pq);
    }
}
