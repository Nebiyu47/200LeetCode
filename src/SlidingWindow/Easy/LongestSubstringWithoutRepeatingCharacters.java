package SlidingWindow.Easy;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s){

        Set<Character> set = new HashSet<>();
        int left=0;
        int maxLen=0;
        for (int right=0;right<s.length();right++){

            char c= s.charAt(right);

            while (set.contains(c)){
                set.remove(c);
                left++;

            }
            set.add(c);
            maxLen=Math.max(maxLen,right-left+1);

        }
        return maxLen;
    }
}
