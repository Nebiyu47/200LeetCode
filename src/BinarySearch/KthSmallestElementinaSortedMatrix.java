package BinarySearch;

public class KthSmallestElementinaSortedMatrix {
    public static void main(String[] args) {

    }
    public static int kthSmallest(int[][] matrix, int k){
        int n= matrix.length;
        int low=matrix[0][0];
        int high =matrix[n-1][n-1];
        while (low<high){
            int mid = low+(high-low)/2;
            int count =constLessEqual(matrix,mid);
            if(count<k){
                low=mid+1;
            }else {
                high=mid;
            }
        }
        return low;
    }
    private static int constLessEqual(int[][] matrix , int target){
        int n = matrix.length;
        int count =0;
        int row =n-1;
        int col=0;
        while (row>=0&&col<n){
            if(matrix[row][col]<=target){
                count+=row+1;
                col++;
            }else {
                row--;
            }
        }
        return count;
    }
}
