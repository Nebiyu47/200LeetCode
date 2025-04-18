package SlidingWindow.Easy;

public class PermutationinString {
    public static void main(String[] args) {
       String s1 = "ab", s2 = "eidbaooo";
        System.out.println(PermutationinString(s1,s2));
    }
    public static boolean PermutationinString(String s1 , String s2){
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, matched = 0;
        for (int right = 0; right < len2; right++) {
            char c = s2.charAt(right);
            if (count[c - 'a'] > 0) {
                matched++;
            }
            count[c - 'a']--;

            if (matched == len1) {
                return true;
            }

            if (right - left + 1 >= len1) {
                char leftChar = s2.charAt(left);
                if (count[leftChar - 'a'] >= 0) {
                    matched--;
                }
                count[leftChar - 'a']++;
                left++;
            }
        }
        return false;
    }
}
