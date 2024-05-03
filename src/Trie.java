import java.util.HashMap;
import java.util.Map;

public class Trie {

    Map<Character, TrieNode> dict;

    public Trie() {

        dict = new HashMap<>();

    }

    public void insert(String word) {
        Map<Character, TrieNode> nextData = dict;
        if(null != word){
            for(int i =0 ;i< word.length() ; i++){
                TrieNode node;
                if(nextData.containsKey(word.charAt(i))){
                    node = nextData.get(word.charAt(i));
                    nextData = node.next;

                } else{
                    node = new TrieNode(word.charAt(i));
                    nextData.put(word.charAt(i), node);
                    nextData  = node.next;
                }

                if(i == word.length()-1){
                    node.endWord =true;
                }
            }

            System.out.println("Dict :" + dict);
        }

    }

    public boolean search(String word) {
        int index = 0;
        Map<Character, TrieNode> nextData = dict;
        TrieNode node = null;
        while(index < word.length()) {
            if(nextData.containsKey(word.charAt(index))) {
                node = nextData.get(word.charAt(index));
                nextData = node.next;
                index++;
            }else {
                return false;
            }
        }
        if(node.endWord) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        int index = 0;
        Map<Character, TrieNode> nextData = dict;
        TrieNode node = null;
        while(index < prefix.length()) {
            if(nextData.containsKey(prefix.charAt(index))) {
                node = nextData.get(prefix.charAt(index));
                nextData = node.next;
                index++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_3 = obj.startsWith("app");

    }

}





class TrieNode{
    char ch;
    Map<Character, TrieNode> next ;
    boolean endWord;

    public TrieNode(char c){
        ch = c;
        endWord = false;
        next = new HashMap();

    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */