public class SubArrayEqualsK {





    public static int subarraySum(int[] nums, int k) {
        int subArrayCount = 0;
        if(nums.length == 1){
            return 1;
        }
        int i = 0 , j= 0;
        int sum = nums[0];
        while(i <= j && j < nums.length){

            if(i == j){
                if(nums[i] == k){
                    subArrayCount++;

                }
                j++;
            }else{
                sum += nums[j];


                if(sum == k){
                    subArrayCount++;
                    j++;
                }else if(sum > k){
                    i++;
                    j = i;
                    sum = nums[i];
                }else{
                    j++;
                }

            }

            if(j == nums.length && i < j){
                i++ ;
                j = i;
                if(i < nums.length){
                    sum = nums[i];
                }


            }
        }

        return subArrayCount;
    }

    public static void  main(String[] args){
        System.out.println(subarraySum(new int[]{28,54,7,-70,22,65,-6},100));
        System.out.println(subarraySum(new int[]{100,1,2,3,4},6));

        System.out.println(subarraySum(new int[]{1,2,3},3));
        System.out.println(subarraySum(new int[]{1,-1,0},0));
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }
}
