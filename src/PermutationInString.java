import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {


    public static boolean checkInclusion(String s1, String s2) {
        if(s1.equals("")){
            return true;
        }

        if(s1.length() > s2.length()){
            return false;
        }

        if(s2.contains(s1)){
            return true;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        for(char c: s1.toCharArray()){
            s1Map.put(c, s1Map.getOrDefault(c,0)+1);
        }
        Map<Character, Integer> map = new HashMap<>(s1Map);

        Map<Character, Integer> s2Map = new HashMap<>();

        for(char c: s2.toCharArray()){
            s2Map.put(c, s2Map.getOrDefault(c,0)+1);
        }

        int left = 0;
        int right = left + s1.length();





        while(right < s2.length()+1){

            String sub = s2.substring(left, right);

            for(char c: sub.toCharArray()){
                if(s1Map.containsKey(c)){
                    s1Map.put(c, s1Map.get(c)-1);
                    if(s1Map.get(c) == 0){
                        s1Map.remove(c);
                    }

                    if(s1Map.size() == 0){
                        return true;
                    }
                }else{
                    left++;
                    right = left + s1.length();
                    s1Map = new HashMap<>(map);
                    break;
                }
            }


        }
        return false;


    }

    public static void main(String[] args){
        System.out.println(checkInclusion("adc", "dcda"));
    }
}
