package Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    Map<Character,TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}
 class Trie{
  private TrieNode root;
  public Trie(){
      root= new TrieNode();
  }
  public void insert(String word){
      TrieNode node =root;
      for (char ch : word.toCharArray()){
         node=node.children.computeIfAbsent(ch,c->new TrieNode());
      }
      node.isEndOfWord=true;
  }
  public boolean search (String word){
      TrieNode node= root;
      for (char ch : word.toCharArray()){
          if (!node.children.containsKey(ch)) return false;
          node=node.children.get(ch);
      }
      return node.isEndOfWord;
  }
  public boolean isPrefix(String word){
      TrieNode node = root;
      for(char ch : word.toCharArray()){
          if (!node.children.containsKey(ch))return false;
          node=node.children.get(ch);
      }
      return true;
  }
}
public class ImplementTriePrefixTree {

}
