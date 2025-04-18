package TwoPointer.Easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(palindrome(s));
    }
    public static boolean palindrome(String s){

        String str=s.toLowerCase().replaceAll("[^a-z0-9]","");

        int left=0;
        int right=str.length()-1;
        while (left<right){

            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
