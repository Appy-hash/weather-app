public class MinInRotatedArray {



    public static int findMin(int[] nums){
        if(null != nums){

            if(nums.length == 1){
                return nums[0];
            }

            if(nums[0] < nums[nums.length -1]){
                return nums[0];
            }
            return binarySearchInRotatedArray(nums, 0, nums.length -1 );
        }
        return 0;
    }


    public static int binarySearchInRotatedArray(int[] nums, int left , int right){
        if(left + 1 == right){
            if(nums[left] > nums[right]){
                return nums[right];
            }else{
                return nums[left];
            }
        }

        int mid = left + (right - left)/2;

        if(nums[mid] > nums[0]){
            //sorted side
            return binarySearchInRotatedArray(nums, mid, right);
        }else{
            return binarySearchInRotatedArray(nums, left, mid);
        }
    }




    public static void main(String[] args){
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
        System.out.println(findMin(new int[]{11}));
    }
}
