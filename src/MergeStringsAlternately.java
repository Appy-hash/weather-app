public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        String mergedString = "";
        while(i < word1.length() || j < word2.length()){
            if(i == word1.length()){
                mergedString += word2.substring(j,word2.length());
                break;
            }
            if(j == word2.length()){
                mergedString += word1.substring(i,word1.length());
                break;
            }

            mergedString += word1.charAt(i);
            mergedString+= word2.charAt(j);
            i++;
            j++;

        }
        return mergedString;
    }

    public static  void main(String[] args){
        System.out.println(mergeAlternately("c", "pwklsdniasd"));
    }
}
