package Tree;

public class ValidateBinarySearchTree {
    public static boolean isValidBst(TreeNode root,  int min , int max){
        if(root==null)return true;

        if(root.val<min || root.val>max) return false;
        return isValidBst(root.left,min,root.val)&&
                isValidBst(root.right,root.val,max);
        }

    }

