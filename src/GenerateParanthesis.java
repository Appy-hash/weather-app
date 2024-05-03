import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    static List<String> combinations ;
    public static List<String> generateParanthesis(int n){
        combinations =  new ArrayList<>();
        if(n > 0){
            int i = 0;
            int openCount = 0; int closeCount = 0;
            StringBuilder sb = new StringBuilder();
            generate(n ,0, 0,sb);

        }
        return combinations;
    }


    public static void generate(int n , int openCount, int closeCount, StringBuilder sb){

        if(openCount == n && closeCount == n){
            combinations.add(sb.toString());
            return;
        }


        if(openCount < n){
            sb.append("(");
            openCount++;
            generate(n, openCount, closeCount, sb);

            openCount--;
            sb.deleteCharAt(sb.length()-1);


        }

        if(closeCount < openCount){
            sb.append(")");
            closeCount++;
            generate(n, openCount, closeCount, sb);

            closeCount--;
            sb.deleteCharAt(sb.length()-1);
        }



    }


    public static void main(String [] args){
        System.out.println(generateParanthesis(3));
    }





}
