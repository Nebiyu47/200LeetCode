package String.SlidingWindow.Medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
   String s = "babad";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s){

        int n =s.length();
        int end=0;
        int start=0;

        for(int i=0;i<n;i++){
            int len1=expand(s,i,i);
            int len2=expand(s,i,i+1);
            int len =Math.max(len1,len2);
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public static int expand(String s , int left, int right){


        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){

            left--;
            right++;
        }
        return right-left-1;
    }
}
