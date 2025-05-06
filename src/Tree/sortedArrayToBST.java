package Tree;

public class sortedArrayToBST {
    public static void main(String[] args) {

    }
    public static TreeNode sortedArrayToBST(int[] nums){


        return build(nums, 0,nums.length-1);
    }
    public static TreeNode build(int[] nums, int left , int right){

        if(left>right)return null;
        int mid = left+(right-left)/2;
        TreeNode mode = new TreeNode(nums[mid]);
        mode.left =build(nums,left,mid-1);
        mode.right=build(nums,mid+1,right);
        return mode;
    }
}
