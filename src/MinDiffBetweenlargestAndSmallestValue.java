import java.util.Arrays;

public class MinDiffBetweenlargestAndSmallestValue {




    public static int minDifference(int[] nums) {
        if(nums.length <= 4){
            return 0;
        }
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        minDiff = Math.min(minDiff, nums[nums.length -4] - nums[0]); // remove last 3
        minDiff = Math.min(minDiff, nums[nums.length -3] - nums[1]); //remove last 2 and first smallest
        minDiff = Math.min(minDiff,nums[nums.length-2] - nums[2]); // remove 2 smallest and last highest
        minDiff = Math.min(minDiff, nums[nums.length-1] - nums[3]);//remove first 3 smallest

       return minDiff;

    }

    public static void main(String[] args) {
//        System.out.println(minDifference(new int[]{1,5,0,10,14}));
//        System.out.println(minDifference(new int[]{5,3,2,4}));
//        System.out.println(minDifference(new int[]{3,100,20}));
        System.out.println(minDifference(new int[]{82,81,95,75,20}));
    }
}
