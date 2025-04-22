package BFS;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {

    }
    public static int WordLadder(String  beginWord , String endWord , List<String> wordList){

        Set<String>disctWordList= new HashSet<>(wordList);
        Queue<String> queue= new LinkedList<>();
        queue.offer(beginWord);
        int level=1;
        while (!queue.isEmpty()){
            int size= queue.size();
            for (int i =0;i<size;i++){
                char[] current = queue.poll().toCharArray();
                for (int j=0;j<current.length;j++){
                    char orginalChar = current[j];
                    for (char c='a';c<='z';c++){
                        if(current[j]==orginalChar)continue;
                        current[j]=c;
                        String nextWord = new String(current);
                        if(nextWord==endWord) return level+1;
                        if(disctWordList.contains(nextWord)){
                            queue.offer(nextWord);
                            disctWordList.remove(nextWord);
                        }
                    }
                    current[j]=orginalChar;
                }
            }
            level++;
        }
        return 0;


    }
}
