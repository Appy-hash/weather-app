public class SearchInRotatedSortedArray {




    public static int search(int[] nums, int target) {
        if(null != nums){
            if(nums.length == 1){
                if(nums[0] == target){
                    return 0;
                }else{
                    return -1;
                }
            }

            return searchTargetInRotatedArray(0, nums.length - 1, nums, target);

        }
        return -1;
    }


    public static  int searchTargetInRotatedArray(int left , int right , int[] nums , int target){
        if(left == right){
            if(nums[left] == target){
                return left;
            }else{
                return -1;
            }
        }

        int  mid = left + (right - left)/2;

        if(nums[mid] == target){
            return mid;
        }

        if(nums[mid] >= nums[left]){
            //left is sorted side
            if(target >= nums[left] && target <= nums[mid]){
                //search in left
                return searchTargetInRotatedArray(left,mid, nums,target);

            }else{
                return searchTargetInRotatedArray(mid + 1,right, nums,target);
            }
        }else{
            //right side is sorted
            if(target >= nums[mid] && target <= nums[right]){
                return searchTargetInRotatedArray(mid + 1,right, nums,target);
            }else{
                return searchTargetInRotatedArray(left,mid , nums,target);
            }

        }
    }

    public static void main(String[] args){
        System.out.println(search(new int[]{7,0,1,2,3,5},-1));
        System.out.println(search(new int[]{7,0,1,2,3,5},0));
        System.out.println(search(new int[]{1},0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},3));
    }
}
