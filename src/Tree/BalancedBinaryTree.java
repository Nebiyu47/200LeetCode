package Tree;

public class BalancedBinaryTree {
    public static void main(String[] args) {

    }
    public static boolean isBlanced(TreeNode root) {

        if (dfs(root, 0) <= 1) {
            return true;
        } else {
            return false;

        }
    }
    public static int dfs(TreeNode root, int depth){
        if(root==null)return 0;
        int left=dfs(root.left,depth+1);
        int right=dfs(root.right,depth+1);

        return Math.abs(right-left);
    }


}
