import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets2 {

    static Set<List<Integer>> subsetsWithDuplicate;
   // static Set<Integer> set ;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
       // set = new HashSet<>();
        subsetsWithDuplicate = new HashSet<>();
         List<Integer> list;
        list = new ArrayList<>();
        if(null == nums){
            return new ArrayList<>(subsetsWithDuplicate);
        }

        subsetsWithDuplicate.add(new ArrayList<>());
        for(int i  = 0 ; i < nums.length ; i++) {
            backTrack(new ArrayList<>(), i, nums);
        }
        return new ArrayList<>(subsetsWithDuplicate);
    }


    private static void backTrack(List<Integer> list,int index, int[] nums){
        if(index >= nums.length){
            return;
        }
        //subsetsWithDuplicate.add(new ArrayList<>(list));

        list.add(nums[index]);
        subsetsWithDuplicate.add(new ArrayList<>(list));






            backTrack(list, index+1, nums);

        list.remove(list.size()-1);
    }


    public static void main(String[] args){
        System.out.println(subsetsWithDup(new int[]{1,2,2,1,2,2}));
    }
}
