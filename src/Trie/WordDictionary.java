package Trie;

import Trie.TrieNode;


      public class WordDictionary {
          private final TrieNode root;

          public WordDictionary() {
              root = new TrieNode();
          }

          public void addWord(String word) {
              TrieNode node = root;
              for (char ch : word.toCharArray()) {
                  node = node.children.computeIfAbsent(ch, c -> new TrieNode());
              }
              node.isEndOfWord = true;
          }

          public boolean search(String word) {
              return dfs(word.toCharArray(), 0, root);
          }

          private boolean dfs(char[] word, int index, TrieNode node) {
              if (index == word.length) return node.isEndOfWord;

              char ch = word[index];

              if (ch == '.') {
                  for (TrieNode child : node.children.values()) {
                      if (dfs(word, index + 1, child)) return true;
                  }
                  return false;
              }

              if (!node.children.containsKey(ch)) return false;
              return dfs(word, index + 1, node.children.get(ch));
          }
      }


