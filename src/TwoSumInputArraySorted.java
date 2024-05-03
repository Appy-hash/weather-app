import java.util.Arrays;

public class TwoSumInputArraySorted {



    static int[] indices;

    public static int[] twoSum(int[] nums, int target) {
        indices = new int[2];
        int right = nums.length -1;
        for(int left = 0 ; left < nums.length ;left++){
            int mid = left + (right- left)/2;
            if(binarySearch(nums, target - nums[left], left +1 ,right )){
                indices[0] = left +1;
                System.out.println("Answer "+ indices[0] +"," + indices[1]);
                return indices;
            }


        }

        System.out.println("Answer "+ indices[0] +"," + indices[1]);
        return indices;

    }



    public static boolean binarySearch(int[] nums, int target, int left , int right){

        if( left == right){
            if(nums[left] == target){
                indices[1] = left +1;
                return true;
            }
        }

        while(left < right){
            int mid = left + (right- left)/2;
            if(nums[mid] == target){
                indices[1] = mid +1;
                return true;
            }else if(target < nums[mid]){
                if(binarySearch(nums, target, left, mid - 1 )){
                    return true;
                }
                return false;

            }else {
                if(binarySearch(nums, target, mid + 1 , right)){
                    return true;
                }
                return false;

            }
        }

        return false;
    }


    public static void main(String[] args){
        System.out.println(twoSum(new int[]{1,3,4,4}, 8));
        System.out.println(twoSum(new int[]{1,2,3,4,4,9,56,90}, 8));
        System.out.println(twoSum(new int[]{3,24,50,79,88,150,345}, 200));
        System.out.println(twoSum(new int[]{2,7,11,15}, 9));
        System.out.println(twoSum(new int[]{2, 3, 4}, 6));
        System.out.println(twoSum(new int[]{-1, 0}, -1));
    }
}
