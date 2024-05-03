import java.util.*;


public class ThreeSum {



    public static List<List<Integer>> threeSum(int[] nums){
        Set<List<Integer>> mainSumlist = new HashSet<>();

        if(null != nums) {
           Map<List<Integer>, Integer> map = new HashMap<>();
           for(int i = 0; i < nums.length ; i++){
               for(int j = i + 1; j < nums.length ; j++){
                   int sum = nums[i]+ nums[j];
                   if( i != j){
                       List<Integer> pairList = new ArrayList<>();
                       pairList.add(i);
                       pairList.add(j);
                       map.put(pairList,sum);
                   }

               }
           }
           List<Integer> triplet = null;
           //Do Two sum using target as 0


           for(Map.Entry<List<Integer>, Integer> entry: map.entrySet()){

               for(int i = 0 ; i < nums.length ; i++){
                   if(entry.getValue() + nums[i] == 0){
                       if(!entry.getKey().contains(i)){

                           triplet = new ArrayList<>(entry.getKey());
                           triplet.set(0,nums[triplet.get(0)]);
                           triplet.set(1,nums[triplet.get(1)]);
                           triplet.add(nums[i]);
                           Collections.sort(triplet);
                           mainSumlist.add(new ArrayList<>(triplet));
                       }
                   }
               }

           }


        }
        return mainSumlist.stream().toList();
    }
    public static void main(String[] args){
        System.out.println(threeSum(new int[]{0,0,0}));
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        System.out.println(threeSum(new int[]{0,1,1}));

    }
}
