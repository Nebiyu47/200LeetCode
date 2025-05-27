package Tree;

public class flatten {
    private static TreeNode prev=null;
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root){
        if (root==null)return;
        flatten(root.left);
        flatten(root.right);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}
