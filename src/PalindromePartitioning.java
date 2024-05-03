import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    static List<List<String>> palindromeSubString;
    static List<String> palindromeList;
    public static List<List<String>> partition(String s) {
        palindromeSubString = new ArrayList<>();
        palindromeList = new ArrayList<>();
        if(s == null || s.length() == 0){
            return palindromeSubString;
        }


        recurse(0, s);

        return palindromeSubString;

    }


    private static  void recurse(int index,String s){

        if(index >= s.length()){
            palindromeSubString.add(new ArrayList<>(palindromeList));
            palindromeList = new ArrayList<>();
        }

        for(int i = index; i< s.length() ;i++){

            if(isPalindrome(s.substring(index,i+1))){
                palindromeList.add(s.substring(index,i+1));
                recurse(i+1, s);
            }

        }


    }


    private static boolean isPalindrome(String s){
        int i = 0 ; int j = s.length() -1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }


    public static void main(String[] args){
        System.out.println(partition("aab"));

    }
}
