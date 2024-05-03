import java.util.HashMap;
import java.util.Map;

public class GreatestCommonDivisorString {


    public static String repeatString(String s, int time){
        if(time <=0){
            return "";
        }
        return s + repeatString(s, time-1);
    }
    public static String gcdOfStrings(String str1, String str2) {
        String div = "";

        String cloned2 = str2;
        String cloned1 = str1;
            if(str1.length() > str2.length()){

                String div1 = str1.replaceFirst(str2,"");
                String div2 = str2.replaceFirst(div1,"");
                if(div2.equals("")){
                    if(div1.equals(cloned2)){
                        return div1;
                    }else{
                        return "";
                    }
                }else {
                    int timess1 = cloned1.length() / div2.length();
                    int times2 = cloned2.length() / div2.length();
                    if(repeatString(div2,timess1).equals(cloned1) && repeatString(div2,times2).equals(cloned2)){
                        return  div2;
                    }
                }
            }else {

                String div1 = str2.replaceFirst(str1,"");
                String div2 = str1.replaceFirst(div1,"");
                if(div2.equals("")){
                    if(div1.equals(cloned1)){
                        return div1;
                    }else{
                        return "";
                    }
                }else{
                    int timess1 = cloned1.length() / div2.length();
                    int times2 = cloned2.length() / div2.length();
                    if(repeatString(div2,timess1).equals(cloned1) && repeatString(div2,times2).equals(cloned2)){
                        return  div2;
                    }
                }



            }

        return div;

    }


    public static  void  main(String[] args){
        System.out.println(gcdOfStrings("CXTXNCXTXNCXTXNCXTXNCXTXN","CXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXN"));

        System.out.println(gcdOfStrings("ABCDEF","ABC"));
        System.out.println(gcdOfStrings("ABCABC","ABC"));
        System.out.println(gcdOfStrings("ABABAB","ABAB"));
        System.out.println(gcdOfStrings("LEET","CODE"));
        System.out.println(gcdOfStrings("ABABABAC","ABABABACABABABAC"));
    }
}
