package Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    private TrieNode root = new TrieNode();
    private Set<String> result = new HashSet<>();
    public static void main(String[] args) {

    }
    public void buildTrie(String[] words){

        for (String word : words){
            TrieNode node =root;
            for (char ch :  word.toCharArray()){
                node=node.children.computeIfAbsent(ch,key->new TrieNode());
            }
            node.isEndOfWord=true;
        }
    }
    public void dfs(char[][] gird, int i , int j ,TrieNode node , StringBuilder path){

        char c= gird[i][j];
        if(c=='#' || !node.children.containsKey(c))return;
        path.append(c);
        node=node.children.get(c);
        if(node.isEndOfWord){
            result.add(path.toString());
            node.isEndOfWord=false;
        }
        gird[i][j]='#';
        if(i>0)dfs(gird,i-1,j,node,path);
        if(i<gird.length)dfs(gird,i+1,j,node,path);
        if (j>0)dfs(gird,i,j-1,node,path);
        if(j< gird.length)dfs(gird, i, j+1, node, path);
        gird[i][j]=c;
        path.deleteCharAt(path.length()-1);
    }
    public List<String> findWords(char [][] board, String [] words){
        buildTrie(words);
        int row=board.length;
        int col=board[0].length;
        for (int i =0;i<row;i++){
            for (int j=0;j<col;j++){
                dfs(board,i,j,root,new StringBuilder());
            }
        }
        return new ArrayList<>(result);
    }

}
