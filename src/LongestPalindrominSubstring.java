public class LongestPalindrominSubstring {

    static int maxLength;
    static String longestSub;
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }

        if(s.length() == 1){
            return s;
        }
        maxLength = Integer.MIN_VALUE;
        longestSub = "";
        checkForPalidromeSubstring(s, 0,s.length()-1);
        return longestSub.equals("") ? String.valueOf(s.charAt(0)) : longestSub;


    }

    private static boolean checkForPalidromeSubstring(String s, int start , int end){
        boolean left = false;
        boolean right = false;
        if(start > end ){
            return false;
        }
        if(start < s.length() && end >= 0){
            if(start == end){
                return true;
            }

            if(s.charAt(start) == s.charAt(end)){

                if( start +1 == end || checkForPalidromeSubstring(s,start+ 1, end- 1))
                {
                    if(end - start > maxLength){
                        maxLength = end - start;
                        longestSub = s.substring(start,end+1);
                    }
                    return true;
                }else{
                    left = checkForPalidromeSubstring(s,start,end - 1);
                    right = checkForPalidromeSubstring(s,start + 1,end);

                    if(left){
                        if(end -1 - start > maxLength){
                            maxLength = end - start;
                            longestSub = s.substring(start,end);
                        }
                    }

                    if(right){
                        if(end - (start + 1) > maxLength){
                            maxLength = end - start;
                            longestSub = s.substring(start+1,end+1);
                        }
                    }
                    return false;
                }
            }else{
                left = checkForPalidromeSubstring(s,start,end - 1);
                right = checkForPalidromeSubstring(s,start + 1,end);

                if(left){
                    if(end - start > maxLength){
                        maxLength = end - start;
                        longestSub = s.substring(start,end);
                    }
                }

                if(right){
                    if(end - start > maxLength){
                        maxLength = end - start;
                        longestSub = s.substring(start+1,end+1);
                    }
                }
                return false;
            }
        }
        return false;

    }


    public  static  void main(String[] args){
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("cccccc"));
    }

}
