import java.nio.charset.CharacterCodingException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestRepeatingCharacterReplacement {




    public static int mostFrequentCharacter(Map<Character, Integer> map){
        int maxLen = 0;
        char key = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() > maxLen){
                maxLen = entry.getValue();
                key = entry.getKey();
            }
        }
        return map.get(key);
    }


    public static int characterReplacement(String s, int k) {


        int start = 0;

        int end = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        int maxLenAfterReplacement = Integer.MIN_VALUE ;



        while(end < s.length()){
            charCount.put(s.charAt(end), charCount.getOrDefault(s.charAt(end),0)+1);
            while(end - start +1 - mostFrequentCharacter(charCount) <= k){
                maxLenAfterReplacement = Math.max(end - start + 1 ,maxLenAfterReplacement);
                end++;

            }
            start++;
            end= start;
            //charCount.put(s.charAt(start), charCount.get(s.charAt(start)) -1);




        }
        return maxLenAfterReplacement;
    }


    public static void main(String args[]){
        System.out.println(characterReplacement("AABABBA", 1));
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("ABAA", 0));
    }
}
