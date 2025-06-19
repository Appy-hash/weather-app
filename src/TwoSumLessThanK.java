import java.util.Arrays;

public class TwoSumLessThanK {

    public static int twoSumLessThanK(int[] nums, int k) {
        if(nums == null){
            return -1;
        }

        Arrays.sort(nums);

        int left = 0 ;
        int right = nums.length-1;
        int maxSum = Integer.MIN_VALUE;

        while(left < right){
           int sum = nums[left] + nums[right];
           if(sum < k){
               maxSum = Math.max(maxSum,sum);
               left++;
           }else{
               right--;
           }
        }
        return  maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }

    public static void main(String[] args){
        System.out.println(twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8}, 32));
        System.out.println(twoSumLessThanK(new int[]{10,20,30}, 15));

    }
}
