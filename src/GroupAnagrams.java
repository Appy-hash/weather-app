import java.util.*;

public class GroupAnagrams {

    public static  List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagramList = new ArrayList<>();
        if(null != strs){
            Map<String, List<String>> anagramMap = new HashMap<>();
            for(String word: strs){
                char[] wordArray = word.toCharArray();
                Arrays.sort(wordArray);
                String sortedWord = String.valueOf(wordArray);
                List<String> groupedWords;
                if(!anagramMap.containsKey(sortedWord)){
                    groupedWords = new ArrayList<>();
                }else{
                    groupedWords = anagramMap.get(sortedWord);
                }
                groupedWords.add(word);
                anagramMap.put(sortedWord,groupedWords);
            }
            for(Map.Entry<String, List<String>> groupAnagrams: anagramMap.entrySet()){
                groupAnagramList.add(groupAnagrams.getValue());
            }
        }

       return groupAnagramList;
    }

    public static void main(String... args){
//        String[] anagramArray = {"eat","tea","tan","ate","nat","bat"};
        String[] anagramArray = {"a"};
        System.out.println(groupAnagrams(anagramArray));
    }
}
