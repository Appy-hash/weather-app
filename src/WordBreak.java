import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;

        Set<String> dict = new HashSet<>(wordDict);

        for(int i = 1 ; i <= s.length() ;i++){
            for(int j = 0 ; j < i ; j++){
                String subString = s.substring(j,i);
                if(dp[j] && dict.contains(subString)){
                    dp[i] = true;
                }
            }
        }


        return dp[dp.length-1];

    }


    public static void main(String[] args){
        List<String> arrayList = new ArrayList<>();
//        arrayList.add("leet");
//        arrayList.add("code");
//        arrayList.add("apple");
//        arrayList.add("pen");
//        "go","goal","goals","special"
        arrayList.add("go");
        arrayList.add("goal");
        arrayList.add("goals");
        arrayList.add("special");
//        arrayList.add("cat");
//        arrayList.add("apple");
//        arrayList.add("pen");
       // System.out.println(wordBreak("aaaaaaa",arrayList));
//        System.out.println(wordBreak("leetcode",arrayList));
//        System.out.println(wordBreak("applepenapple",arrayList));
        System.out.println(wordBreak("goalspecial",arrayList));
//        System.out.println(wordBreak("ab",arrayList));
    }
}
