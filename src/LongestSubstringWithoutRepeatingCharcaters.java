import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharcaters {






    public static int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }
        int i = 0 ;

        int j = i + 1;
        int maxLen = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }else{
                int length = j - i ;
                maxLen = Math.max(length, maxLen);
                i = j;
                j = i+1;
                set = new HashSet<>();
                set.add(s.charAt(i));
            }
        }

        maxLen = Math.max(j - i, maxLen);

        return maxLen;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("  "));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));

        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }
}
