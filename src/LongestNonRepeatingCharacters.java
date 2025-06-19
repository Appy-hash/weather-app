import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestNonRepeatingCharacters {


    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;

        Map<Character, Integer> uniqueSubstringSet = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int count = 0;
        while(j < s.length()){
            if(!uniqueSubstringSet.containsKey(s.charAt(j))) {
                uniqueSubstringSet.put(s.charAt(j), 1);
                maxLen = Math.max(maxLen,j-i+1);
                j++;
            }else{

                maxLen = Math.max(maxLen,j - i );
                count  = uniqueSubstringSet.get(s.charAt(i));
                if(count == 1){
                    uniqueSubstringSet.remove(s.charAt(i));
                }else{
                    uniqueSubstringSet.put(s.charAt(i), count-1);
                }
                i++;

            }

        }


        return  maxLen;

    }



    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("auba"));
        System.out.println(lengthOfLongestSubstring("aaaaaaaaac"));
    }
}
