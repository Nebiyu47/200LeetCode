package DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {

    }
    public List<List<String>> partiton(String s){
        List<List<String>> result= new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),result);
        return result;
    }
    private  void  backtrack(String s , int start , List<String> path , List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end =start;end<s.length();end++){
            if(isPalundrome(s,start,end)){
                path.add(s.substring(start,end+1));
                backtrack(s,end+1,path,result);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalundrome(String s, int left , int right){
        while (left<right){
            if(s.charAt(left)!=s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }

}
