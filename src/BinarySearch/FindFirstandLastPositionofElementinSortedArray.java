package BinarySearch;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {


    }
    public static int [] searchRange(int[] nums , int target){
        int[] result = {-1, -1};
        result[0] = findBound(nums, target, true); // First occurrence
        result[1] = findBound(nums, target, false); // Last occurrence
        return result;
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, bound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                bound = mid;
                if (isFirst) {
                    right = mid - 1; // Search left for first occurrence
                } else {
                    left = mid + 1; // Search right for last occurrence
                }
            }
        }
        return bound;
    }
}
