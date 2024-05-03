public class MaxSubArray {

    static  int maxSum;
    public static  int maxSubArray(int[] nums) {
        maxSum = Integer.MIN_VALUE;
        int i = 1 ;
        int sum = nums[0];

        while(i < nums.length){
            if(sum + nums[i] > nums[i]){
                sum = sum + nums[i];
            }else{
                sum = nums[i];
            }
            i++;
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }


    public static  void main(String ... args){
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
