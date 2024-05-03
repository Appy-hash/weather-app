import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {


    public static String intToRoman(int num) {
       if(num == 0){
           return "Can create roman for the number " + num;
       }
        TreeMap<Integer, String> romanMap = new TreeMap<>();
        romanMap.put(1,"I");
        romanMap.put(5,"V");
        romanMap.put(9,"IX");
        romanMap.put(10,"X");
        romanMap.put(40,"XL");
        romanMap.put(90,"XC");
        romanMap.put(4,"IV");
        romanMap.put(400,"CD");
        romanMap.put(900,"CM");
        romanMap.put(50,"L");
        romanMap.put(100,"C");
        romanMap.put(500,"D");
        romanMap.put(1000,"M");
        StringBuilder romanNumberBuilder = new StringBuilder();

        while(num > 0){
            Map.Entry closerValue = romanMap.floorEntry(num);
            if(closerValue != null){
                romanNumberBuilder.append(closerValue.getValue());
                num = num - (int)closerValue.getKey();
            }

        }


        return romanNumberBuilder.toString();
    }



   public static void main(String[] args){
        System.out.println(intToRoman(480));
   }
}
