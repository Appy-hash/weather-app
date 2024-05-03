import java.awt.desktop.SystemEventListener;
import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWords {

    Map<Character,WordNode> map;
    public AddAndSearchWords() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        WordNode wordNode = null;
        Map<Character, WordNode> next = map;

        for(int i = 0 ; i < word.length(); i++){
            if(next.containsKey(word.charAt(i))){
                wordNode = next.get(word.charAt(i));
                next = wordNode.next;
            }else{
                wordNode = new WordNode(word.charAt(i));
                next.put(word.charAt(i),wordNode);
                next = wordNode.next;
            }
            if(i == word.length() - 1){
                wordNode.endIndex = true;
            }
        }

    }


    public boolean searchAllPaths(int index,Map<Character,WordNode> nodeMap, String word){

        if(index == word.length() - 1){
            if(!nodeMap.isEmpty()){
                if(word.charAt(index) == '.'){
                    for(Map.Entry<Character,WordNode> startWord: nodeMap.entrySet()){
                        if(startWord.getValue().endIndex){
                            return true;
                        }
                    }
                }else{
                    return nodeMap.get(word.charAt(index)).endIndex;
                }
            }
        }

        if(index < word.length() - 1){
            if(word.charAt(index) == '.'){
                for(Map.Entry<Character,WordNode> startWord: nodeMap.entrySet()){
                    WordNode wordNode = startWord.getValue();
                    if(searchAllPaths(index+1,wordNode.next,word)){
                        return true;
                    }
                }
            }else{
                WordNode wordNode  = nodeMap.get(word.charAt(index));
                if(wordNode != null){
                    if(searchAllPaths(index+1, wordNode.next,word)){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public boolean search(String word) {
        int index = 0;
        Map<Character,WordNode> nextNode = map;
        WordNode w;
        return searchAllPaths(0,map,word);

    }

    public static void main(String... args){
        AddAndSearchWords obj = new AddAndSearchWords();
        obj.addWord("a");
        obj.addWord("ab");
        obj.addWord("a");
        obj.addWord("add");
        obj.addWord("a");
        System.out.println(obj.search("."));


    }
}

class WordNode{
    char ch;
    Map<Character, WordNode> next;
    boolean endIndex;

    public WordNode(char c){
        ch = c;
        next = new HashMap<>();
        endIndex = false;
    }

}
