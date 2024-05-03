public class ProductExceptItself {


    public static int[] productExceptSelf(int[] nums) {
        int productArrayLeft[] = new int[nums.length];
        int productArrayRight[] = new int[nums.length];
        int product = 1;

        for(int i = 0 ; i < nums.length ;i++){
            productArrayLeft[i] = product;
            product*= nums[i];

        }

        product = 1;
        for(int i = nums.length-1 ; i >= 0 ; i--){
            productArrayRight[i] = product;
            product *= nums[i];

        }

        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = productArrayLeft[i] * productArrayRight[i];
        }
        return nums;
    }


    public static  void  main(String args[]){
        System.out.println(productExceptSelf(new int[]{0,0}));
        System.out.println(productExceptSelf(new int[]{1,2,3,4}));
        System.out.println(productExceptSelf(new int[]{-1,1,0,-3,3}));

    }
}
