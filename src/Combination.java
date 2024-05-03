import java.util.ArrayList;
import java.util.List;

public class Combination {


    static List<Integer> list;
    static List<List<Integer>> combination;
    public static List<List<Integer>> combine(int n, int k) {
        combination = new ArrayList<>();

        for(int i = 1 ; i <= n; i++){
            list = new ArrayList<>();
            recurse(n,i,k);
        }
        return combination;
    }


    private static void recurse(int n , int index , int k){



            if(list.size() == k){
                combination.add(new ArrayList<>(list));
                return;
            }

            for(int i = index; i <= n; i++){
                list.add(index);
                recurse(n,i+1 , k);
                list.remove(list.size() - 1);
            }
        }





    public static void main(String args[]){
        System.out.println(combine(4,3));

    }
}
