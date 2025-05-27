package Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandnorderTraversal {
    private int preOrderIndex=0;
    private static Map<Integer,Integer>inorderIndexMap;
    public static TreeNode buildTree(int [] preOrder , int[] inOrder){

        inorderIndexMap= new HashMap<>();
        for (int i =0;i<inOrder.length;i++) {
            inorderIndexMap.put(inOrder[i], i);
        }
        for (int n : inorderIndexMap.keySet()){
            System.out.println(n +" "+ inorderIndexMap.values());
        }
        TreeNode root = new TreeNode();
        return root;
    }

    public static void main(String[] args) {
        int [] inorder ={9,3,15,20,7};
        System.out.println(buildTree(inorder,inorder));
    }
}
