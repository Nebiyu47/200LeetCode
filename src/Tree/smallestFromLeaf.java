package Tree;




import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode node;
    String path;

    public Pair(TreeNode node, String path) {
        this.node = node;
        this.path = path;
    }
}
public class smallestFromLeaf {
    public static String smallestFromLeaf(TreeNode root){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root," "));
        String smallest =" ";
        while (!queue.isEmpty()){
            Pair current = queue.poll();
            TreeNode node=current.node;
            String path = (char) (node.val+'a')+current.path;
            if(node.left==null&&node.right==null){
                if(path.compareTo(smallest)<0){
                    smallest=path;
                }
            }
            if(node.left!=null)queue.offer(new Pair(node.left,path));
            if(node.right!=null)queue.offer(new Pair(node.right,path));
        }
        return smallest;
    }
}
