import java.util.*;

public class MinimumWindowSubstring {


    public static String minWindow(String s, String t) {

        Map<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()){
            if(tMap.containsKey(c)){
                tMap.put(c, tMap.get(c)+1);
            }else{
                tMap.put(c, 1);
            }
        }
        Map<Character,Integer> tMapCopy = new HashMap(tMap);
        int i = 0 ; int j = 0;
        char[] list = t.toCharArray();
        Set<Character> tSet = new HashSet<>();
        for(char c: list){
            tSet.add(c);
        }
        int maxLen = Integer.MAX_VALUE;
        String subString = "";
        while(j < s.length()){
            if(tSet.contains(s.charAt(j)) && tMapCopy.containsKey(s.charAt(j))){
                tMapCopy.put(s.charAt(j), tMapCopy.get(s.charAt(j)) -1);
                if(tMapCopy.get(s.charAt(j)) == 0){
                    tMapCopy.remove(s.charAt(j));
                }

            }
            if(tMapCopy.size() ==0){
                //found substring

                if( j -i < maxLen){
                    subString = s.substring(i , j+1);
                    maxLen = j - i;
                }
                tMapCopy = new HashMap<>(tMap);
                i ++;
                j = i;
            }else{
                j++;
            }



        }
        return subString;


    }


    public static void main(String[] args){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
        System.out.println(minWindow("a","a"));
        System.out.println(minWindow("a","aa"));
    }
}
