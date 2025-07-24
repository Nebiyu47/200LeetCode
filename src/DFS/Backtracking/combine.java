package DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class combine {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> combine(int n , int k){

        List<List<Integer>> result = new ArrayList<>();
        backtrack(1,n,k,new ArrayList<>(),result);
        return result;
    }
    public static void backtrack(int start , int n , int k , List<Integer>path , List<List<Integer>>result ){

        if(path.size()==k){
            result.add(new ArrayList<>(path));
        }
        for (int i =start;i<=n;i++){
            path.add(i);
            backtrack(i, n, k, path, result);
            path.remove(path.size()-1);
        }
    }
}
