import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    static int numOfWaysToDecode;
    static Map<Integer , Integer> waysToDecodeMapAtIndex;
    public static int numDecodings(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }

        waysToDecodeMapAtIndex = new HashMap<>();
        numOfWaysToDecode = 0;
        return finNumOfWaysToDecode(0,s);



    }


//    2,2,6
//    2,26
//    22,6
    private static int finNumOfWaysToDecode(int index, String s){
        String singleDigit = "";
        String doubleDigit = "";
        int ways = 0;
        if(waysToDecodeMapAtIndex.containsKey(index)){
            return  waysToDecodeMapAtIndex.get(index);
        }
        if(index == s.length()){
            return 1;
        }
        if(index + 1 <= s.length()){
            singleDigit = s.substring(index, index+1);
            if(Integer.parseInt(singleDigit) >=1 && Integer.parseInt(singleDigit) <= 26){
                ways = finNumOfWaysToDecode(index+1, s);
            }
        }

        if(index +2 <= s.length()){
            doubleDigit = s.substring(index, index+2);
            if(Integer.parseInt(doubleDigit) >= 1 && Integer.parseInt(doubleDigit) >= 10 && Integer.parseInt(doubleDigit) <= 26){
                ways += finNumOfWaysToDecode(index+2, s);
            }
        }
        waysToDecodeMapAtIndex.put(index, ways);

        return ways;

    }

    public static  void main(String[] args){
        System.out.println(numDecodings("234327"));

        System.out.println(numDecodings("10"));

        System.out.println(numDecodings("226"));

    }

}
