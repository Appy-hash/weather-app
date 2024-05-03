import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {



    public static boolean isPalindrome(String word){
        int i = 0;
        int j = word.length()-1;

        while(i < j){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
    public static String longestPalindrome(String s) {
        int left = 0,right = 0;
        Map<String , Integer> palidromeMap = new HashMap<>();

        while(left < s.length() && right < s.length()){
            String subString = s.substring(left,right+1);
            if(!palidromeMap.containsKey(subString)){
                if(isPalindrome(subString)){
                    if(subString.equals(s)){
                        return subString;
                    }else{
                        palidromeMap.put(subString,subString.length());
                    }
                }
                right++;
            }else{
                right++;
            }
            if(right == s.length()){
                left = left + 1;
                right = left;
            }
        }

        String maxLenPlaindromeSubstring = "";
        int maxLen = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> map: palidromeMap.entrySet()){
            if(map.getValue() > maxLen){
                maxLen = Math.max(maxLen, map.getValue());
                maxLenPlaindromeSubstring = map.getKey();
            }
        }
        return maxLenPlaindromeSubstring;

    }



    public static void main(String ... args){
        System.out.println(longestPalindrome("busislnescsicxpvvysuqgcudefrfjbwwjcchtgqyajdfwvkypfwshnihjdztgmyuuljxgvhdiwphrweyfkbnjgerkmifbirubhseuhrugwrabnjafnbdfjnufdstjbkuwtnpflffaqmjbhssjlnqftgjiglvvequhapasarlkcvbmkwnkuvwktbgfoaxteprobdwswcdyddyvrehvmxrrjiiidatidlpihkbmmruysmhhsncmfdanafdrfpdtfgkglcqpwrrtvacuicohspkounojuziittugpqjyhhkwfnflozbispehrtrnizowrlzcuollagxwtznjwzcumvedjwokueuqktvvouwnsmpxqvvpuwprezrbobrpnwaccwljchdguubjulyilzvmandjjleitweybqkjttschrjjlebnmponvlktzzcdtuybugggcqffkcffpamauvxfbonjrobgpvlyzveiwemmtdvbjciaytvesnocnjrwodtcokgcuoiicxapmrzpkfphjniuvzjrhbnqndfshoduejyktebgdabidxlkstepuwvtrtgbxaeheylicvhrxddijshcvdadxzsccmainyfpfdhqdanfccqkzlmhsfilvoybqojlvbcixjzqpbngdvesuokbxhkomsiqfyukvspqthlzxdnlwthrgaxhtpjzhrugqbfokrdcyurivmzgtynoqfjbafboselxnfupnpqlryvlcxeksirvufepfwczosrrjpudbwqxwldgjyfjhzlzcojxyqjyxxiqvfhjdwtgoqbyeocffnyxhyyiqspnvrpxmrtcnviukrjvpavervvztoxajriuvxqveqsrttjqepvvahywuzwtmgyrzduxfqspeipimyoxmkadrvrdyefekjxcmsmzmtbugyckcbjsrymszftjyllfmoeoylzeahnrxlxpnlvlvzltwnmldi"));
    }
}
