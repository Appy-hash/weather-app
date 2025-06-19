import java.util.HashMap;
import java.util.Map;

public class PrefixTree {

    TrieNode2 node;

    public PrefixTree() {
        node = new TrieNode2('1');
    }

    public void insert(String word) {
        Map<Character, TrieNode2> child = node.child;
        for(int i = 0 ; i < word.length() ;i++){
            char letter = word.charAt(i);
            TrieNode2 trieNode = null;
            if(!child.containsKey(letter)){
                trieNode = new TrieNode2(letter);
            }else{
                trieNode = child.get(letter);
            }
            if(i == word.length() -1){
                trieNode.isEndChar = true;
            }
            child.put(letter,trieNode);
            child = trieNode.child;
        }

    }

    public boolean search(String word) {
        Map<Character, TrieNode2> child = node.child;
        for(int i = 0 ; i < word.length(); i++){
            char letter = word.charAt(i);
            if(!child.containsKey(letter)){
                return false;
            }else{
                TrieNode2 trie = child.get(letter);
                child = trie.child;
                if(i == word.length() -1){
                    return trie.isEndChar;
                }
            }
        }
        return false;

    }

    public boolean startsWith(String prefix) {
        Map<Character, TrieNode2> child = node.child;
        for(int i = 0 ; i < prefix.length() ;i++){
            char letter = prefix.charAt(i);
            if(!child.containsKey(letter)){
                return false;
            }else{
                TrieNode2 trie = child.get(letter);
                child = trie.child;
            }
        }
        return true;
    }


    public static void main(String[] args){
        PrefixTree trie = new PrefixTree();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

class TrieNode2{
    char c;
    Map<Character, TrieNode2> child;
    boolean isEndChar;

    TrieNode2(char c){
        this.c = c;
        this.child = new HashMap<>();
        this.isEndChar = false;
    }



}
