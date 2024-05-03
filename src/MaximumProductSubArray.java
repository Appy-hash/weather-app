public class MaximumProductSubArray {

    public static int maxProduct(int[] nums) {
        int last = nums.length-1;
        int product = nums[last];
        int maxProductSum = nums[last];
        int minProductSum = nums[last];

        for(int i = last -1; i >= 0 ; i--){

           if(nums[i] * product > nums[i]){
               product *= nums[i];
               minProductSum = minProductSum * nums[i];
           }else{
               product = nums[i];

           }

            maxProductSum = Math.max(minProductSum * nums[i] , product);
        }
        return maxProductSum;
    }


    public static  void main(String... args){
        System.out.println(maxProduct(new int[]{-3,-1,-1}));
    }
}
