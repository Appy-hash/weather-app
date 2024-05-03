import java.util.Arrays;

public class MaxNumberKSumPairs {


    public static int maxOperations(int[] nums, int k) {
        if(nums.length == 1)
            return 0;
        Arrays.sort(nums);
        int i = 0 ;
        int j = nums.length-1;
        int numOfOperations = 0;

        while(i < j){
            if(nums[i] + nums[j] == k){
                numOfOperations++;
                i++;
                j--;
            } else if (nums[i] + nums[j] < k) {
                if(nums[i] > nums[j]){
                    j--;
                }else{
                    i++;
                }

            } else if (nums[i] + nums[j] > k) {
                if(nums[i] < nums[j]){
                    j--;
                }else {
                    i++;
                }
            }
        }
        return numOfOperations;
    }

    public static  void  main(String[] args){
        System.out.println(maxOperations(new int[]{3,3,3,4,3}, 6));
        System.out.println(maxOperations(new int[]{1,2,3,4}, 5));

        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));

    }
}
