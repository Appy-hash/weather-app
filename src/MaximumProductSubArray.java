public class MaximumProductSubArray {


    public static int maxProduct(int[] nums) {

        int minProduct = nums[0];
        int maxProduct = nums[0];
        int maxProductSubArray = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length ; i++){
            int temp = minProduct;
            minProduct = Math.min(nums[i], minProduct* nums[i]);
            minProduct = Math.min(minProduct, maxProduct* nums[i]);

            maxProduct = Math.max(nums[i], maxProduct* nums[i]);
            maxProduct = Math.max(temp* nums[i], maxProduct);

            maxProductSubArray = Math.max(maxProduct, maxProductSubArray);

        }

        return maxProductSubArray == Integer.MIN_VALUE ? nums[0] : maxProductSubArray;
    }


    public static void main(String[] args){
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,-3,-2,10}));
        System.out.println(maxProduct(new int[]{-2,3,-2,10}));

        System.out.println(maxProduct(new int[]{-2,0,-1}));
        System.out.println(maxProduct(new int[]{-2}));
    }
}
