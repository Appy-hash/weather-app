public class ReverseWordsInString {


    public static String reverseWords(String s) {
        if(s.length() == 1){
            return s;
        }

        String[] splitSentence = s.trim().split("\\s+");
        int i = 0;
        int j = splitSentence.length-1;


        while(i < j){
            if(!splitSentence[i].equals("") && !splitSentence[j].equals("")){
                String temp = splitSentence[i];
                splitSentence[i] = splitSentence[j];
                splitSentence[j] = temp;
                i++;
                j--;
            }
        }

        String reversedSentence ="";
        for(i = 0 ; i < splitSentence.length;i++){
            reversedSentence += splitSentence[i];
            if(i < splitSentence.length -1){
                reversedSentence += " ";
            }

        }
        return reversedSentence;
    }


    public static  void main(String[] args){
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }

}
