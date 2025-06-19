public class LongestIncreasingSubsequence {
    static int maxCount;
    public  static int lengthOfLIS(int[] nums) {
        maxCount = Integer.MIN_VALUE;
        if(null != nums){
            for(int i = 0 ; i < nums.length;i++){
                //Pick a number
                calculateSequence(nums[i],nums,i+1,1);

            }

        }
        return maxCount;
    }


    public static void calculateSequence(int curr, int[] nums, int index,int count){
        if(index == nums.length -1){
            if(nums[index] > curr){
                count++;
            }
            maxCount = Math.max(maxCount,count);
            return ;
        }

        if(index < nums.length -1){
            if(nums[index] > curr){
                curr = nums[index];
                count++;
            }
            calculateSequence(curr,nums,index+1,count);
        }
    }
    public static void main(String... args){
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
