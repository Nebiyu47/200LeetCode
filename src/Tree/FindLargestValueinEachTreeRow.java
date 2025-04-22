package Tree;

import java.util.*;

public class FindLargestValueinEachTreeRow {
    public static void main(String[] args) {

    }
    public static List<Integer> FindLargestValueinEachRow(TreeNode root){

        int maxLength=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()){
            int size = queue.size();
            List <Integer> level =new ArrayList<>();
            for ( int i=0;i < size;i++){
                TreeNode current = queue.poll();
                level.add(current.val);
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null)queue.offer(current.right);

            }
         result.add(Collections.max(level));
        }

    return result;
    }
}
