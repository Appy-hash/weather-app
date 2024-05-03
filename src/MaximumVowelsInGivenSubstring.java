import java.util.HashSet;
import java.util.Set;

public class MaximumVowelsInGivenSubstring {

    public static int maxVowels(String s, int k) {
        int maxVowels = 0;
        int vowelCount = 0;
        Set<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');


        int i = 0;
        int j = 0;
        while(j < s.length()){
            if(vowelsSet.contains(s.charAt(j))){
                vowelCount++;
            }

            if(j - i + 1 == k){
                maxVowels = Math.max(vowelCount,maxVowels);
                if(vowelsSet.contains(s.charAt(i))){
                    vowelCount--;
                }
                i++;

            }
            j++;


        }
        return  maxVowels;


    }


    public static  void main(String[] args){
//        System.out.println(maxVowels("abciiidef",3));
//        System.out.println(maxVowels("aeiou",2));
//        System.out.println(maxVowels("leetcode",3));
        System.out.println(maxVowels("weallloveyou",7));


        //




    }
}
