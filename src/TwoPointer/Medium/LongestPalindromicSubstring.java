package TwoPointer.Medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(LongestPalindromicSubstring("babad"));
    }
    public static int  LongestPalindromicSubstring(String s){
        int left=0;
        int right=s.length()-1;
        int max=Integer.MIN_VALUE;
        while (left<right){
            if(ispalindrome(s,left,right)){
                left++;
                right--;
            }else {
                right--;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
    private static boolean ispalindrome(String s, int left , int right){

        if(s.charAt(left)==s.charAt(right)){
            return true;
        }else {
            return false;
        }
    }
}
