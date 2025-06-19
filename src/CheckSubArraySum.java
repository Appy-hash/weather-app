public class CheckSubArraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 1)
            return false;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum = nums[i];
            for(int j = i + 1; j < nums.length ; j++){
                sum += nums[j];
                if(sum % k == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int nums[] = {23,2,6,4,7};
        System.out.println(checkSubarraySum(nums,7));
    }
}
