import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfNumber {


    static List<String> letterCombination;

    static StringBuilder comb;
    public static List<String> letterCombinations(String digits) {
        letterCombination = new ArrayList<>();
        if(null == digits || digits.length() == 0){
            return letterCombination;
        }

        Map<Character, String> letterMap = new HashMap<>();
        comb = new StringBuilder();

        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");


            recurse(0,letterMap, digits);




        return letterCombination;
    }


    private static void recurse( int index,Map<Character, String> letterMap, String digits){

        if(comb.length() == digits.length()){
            letterCombination.add(comb.toString());
            comb.deleteCharAt(comb.length()-1);
            return;
        }


       if(index < digits.length()){


           String word = letterMap.get(digits.charAt(index));

           for(int i = 0; i < word.length() ; i++){

               comb.append(word.charAt(i));
               recurse( index +1 ,letterMap, digits);

           }


           if(comb.length() >=1){
               comb.deleteCharAt(comb.length()-1);
           }
       }


    }



    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
    }
}
