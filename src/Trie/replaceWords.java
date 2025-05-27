import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;


    private TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.word = word;  // Mark the end of a root
        }
        return root;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = buildTrie(dictionary);
        StringBuilder result = new StringBuilder();

        for (String word : sentence.split(" ")) {
            TrieNode node = trie;
            String replacement = word;

            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c) || node.word != null)
                    break;
                node = node.children.get(c);
            }

            if (node.word != null) {
                replacement = node.word;
            }

            result.append(replacement).append(" ");
        }

        return result.toString().trim();
    }
}
