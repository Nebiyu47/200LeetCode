package String.SlidingWindow.Easy;

public class reverseWords {
    public static String reverseWords(String s){
        String[] words = s.trim().split("\\s+");
        int left=0;
        int right=words.length-1;
        while (left<right){
            String temp = words[left];
            words[left]=words[right];
            words[right]=temp;
            left++;
            right--;
        }
        return String.join("",words);
    }
}
