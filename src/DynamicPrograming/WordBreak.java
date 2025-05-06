package DynamicPrograming;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
       String s = "leetcode";
        List<String>wordDict = Arrays.asList("leet", "code");
        System.out.println(WordBreak(s,wordDict));
    }
    public static boolean WordBreak(String s , List<String> wordDist){
        Set<String> word = new HashSet<>(wordDist);
        boolean [] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for (int j=0;j<i;j++){
                if(dp[j]&&word.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
