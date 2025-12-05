package String.SlidingWindow.Easy;

public class LongestRepeatingCharacterReplacement {


    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }
    public static int characterReplacement(String s , int k){


            int[] freq = new int[26]; // Frequency map for characters A-Z
            int left = 0;
            int maxCount = 0; // Tracks the highest frequency in the current window
            int maxLength =0;

            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                freq[c - 'A']++;
                maxCount = Math.max(maxCount, freq[c - 'A']);

                // Shrink the window if replacements needed exceed `k`
                while (right - left + 1 - maxCount > k) {
                    freq[s.charAt(left) - 'A']--;
                    left++;
                }

                maxLength = Math.max(maxLength, right - left + 1);
            }
            return maxLength;
    }

}
