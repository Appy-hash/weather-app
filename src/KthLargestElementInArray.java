public class KthLargestElementInArray {

    static  int largestElement ;
    public static int findKthLargest(int[] nums, int k) {
        largestElement = nums[0];
        int count = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] > largestElement){
                largestElement = Math.max(largestElement,nums[i]);
                count++;

                if(count == k-1){
                    return largestElement;
                }
            }
        }
        return 0;
    }


    public static void main(String... args){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,4));
    }
}

