public class RemoveDuplicatesFromSortedArray {

    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int removeDuplicates(int[] nums) {
        int numOfUniqueElements = 1;
        int sum = 0;
        int prevSum = nums[0] + 1;
        int lastUniqueIndex = 0;
        for(int i = 1 ; i < nums.length ; i++){
            sum = nums[i] + 1;

            if(sum != prevSum){
                lastUniqueIndex = lastUniqueIndex+1;
                prevSum = sum;
                swap(nums,lastUniqueIndex,i);
                numOfUniqueElements++;
            }
        }
        return numOfUniqueElements;
    }


    public static  void main(String ... args){
        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(arr);
    }
}
