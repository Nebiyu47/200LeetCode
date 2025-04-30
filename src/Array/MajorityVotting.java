package Array;

public class MajorityVotting {
    public static void main(String[] args) {
        int[] nums = {2,1,1,1,5,1,2,3,1};
        System.out.println(MajorityVotting(nums));

     }
    public static int MajorityVotting(int [] nums) {

        int candiate=-1;
        int count=0;
        for (int n : nums){
            if(candiate==n){
                count++;
            }
            if(count==0){
                candiate=n;
            }else {
                count--;
            }

      }
        int frq=0;
        for (int n : nums){
            if(n==candiate)frq++;
        }
     if(frq>nums.length/2){
         return candiate;
     }else
     {
         return -1;
     }

    }
}
