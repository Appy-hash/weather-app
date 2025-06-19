import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {


    static List<Integer> subset ;
    static List<List<Integer>> subsetList;
    public static List<List<Integer>> subsets(int[] nums) {

        subsetList = new ArrayList<>();
        if(null == nums){
            return subsetList;
        }
        subset = new ArrayList<>();
        subsetList.add(subset);
        buildSubSets(nums , 0);



        return subsetList;
    }


    private static void buildSubSets(int[] nums , int index){

        if(subset.size() >=1){
            subsetList.add(new ArrayList<>(subset));

            if(subset.size() == nums.length ) {
                return;

            }
        }
        if(index < nums.length){



            for(int i = index ; i < nums.length ; i++){
                if(!subset.contains(nums[i])){
                    subset.add(nums[i]);
                }
                buildSubSets(nums, i+1);
                subset.remove(subset.size()-1);
            }




        }
    }


    public static  void main(String[] args){
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
