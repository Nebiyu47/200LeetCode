package DFS.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordBreak2 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String>wordDict = Arrays.asList("leet", "code");
        System.out.println(partition(s,wordDict));
    }
    public static List<List<String>> partition(String s, List<String> wordDict){
        List<List<String>> result = new ArrayList<>();;
        return result;
    }
}
