import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {

    static List<Integer> combination;
    static List<List<Integer>> combinationArray;

    static  int index;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combination = new ArrayList<>();
        combinationArray = new ArrayList<>();
        index = 0; Arrays.sort(candidates);
        buildCombination(candidates, target, 0);
        return combinationArray;
    }

    private static void buildCombination(int[] candidates, int target, int sum){

        if(index < candidates.length){

            if(sum >target){
                return;
            }

            if(sum == target){
                combinationArray.add(new ArrayList<>(combination));
                index++;
                return;
            }



            for(int i = index ; i < candidates.length ; i++){
                combination.add(candidates[i]);
                sum +=  candidates[i];
                buildCombination(candidates, target,sum);
                combination.remove(combination.size() -1);
                sum = sum - candidates[i];
            }


        }


    }

    public static void main(String[] args){
        System.out.println(combinationSum(new int[]{7,3,2},18));
    }
}
