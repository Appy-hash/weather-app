import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

    static List<Integer> arrayList;
    static List<List<Integer>> permutationList;
    public static List<List<Integer>> permute(int[] nums) {
        arrayList = new ArrayList<>();
        permutationList = new ArrayList<>();

            buildPermuation(nums, 0);


        return permutationList;
    }

    private static void buildPermuation(int[] nums ,int index){

        if(arrayList.size() == nums.length){
            permutationList.add(new ArrayList<>(arrayList));
            return;
        }

        if(index < nums.length){


            for(int i = 0 ; i < nums.length ; i++){
                if(!arrayList.contains(nums[i])){
                    arrayList.add(nums[i]);
                    buildPermuation(nums, i );
                    arrayList.remove(arrayList.size()-1);
                }

            }

        }

    }


    public static void main(String[] args){
        System.out.println(permute(new int[]{1,2,3}));
    }
}
