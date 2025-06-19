public class ReverseVowels {


    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        StringBuffer sf = new StringBuffer(s);

        while (i < j) {
            char firstChar = s.charAt(i);
            char secondChar = s.charAt(j);
            if (isVowel(firstChar) && isVowel(secondChar)) {

                sf.setCharAt(i,s.charAt(j));
                sf.setCharAt(j,s.charAt(i));
                i++;
                j--;


            } else if(!isVowel(firstChar) && !isVowel(secondChar)){
                i++;
                j--;
            } else if (!isVowel(firstChar) && isVowel(secondChar)){

                i++;
            } else if (isVowel(firstChar) && !isVowel(secondChar)){;
                j--;
            }

        }
        return sf.toString();
    }

    public  static  boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return  true;
        }
        return false;
    }

    public static boolean isConsonant(char c ) {
        if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
            return true;
        }
        return false;
    }

        public static void main(String[] args){
            System.out.println(reverseVowels("hello"));
            System.out.println(reverseVowels("leetcode"));
        }
    }
