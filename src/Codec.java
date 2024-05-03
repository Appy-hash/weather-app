import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        if(null != strs){
            for(int i = 0 ; i < strs.size() ; i++){
                encodedString.append(strs.get(i));
                encodedString.append('-');
            }
            encodedString.deleteCharAt(encodedString.length()-1);
        }
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(null != s && s.length() > 0){
            String[] encodedStrsArrays = s.split("-");
            return Arrays.asList(encodedStrsArrays);
        }
        return null;
    }


    public static void main(String... args){
        Codec c = new Codec();
        List<String> codeList = new ArrayList<>();
        codeList.add("Hello");
        codeList.add("World");
        System.out.println(c.encode(codeList));
        System.out.println(c.decode(""));

    }
}