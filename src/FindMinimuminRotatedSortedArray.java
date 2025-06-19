public class FindMinimuminRotatedSortedArray {


    public static int findMin(int[] nums) {


            if(nums[0] < nums[nums.length-1]){
                return nums[0];
            }
            return binarySearch(nums,0, nums.length-1);


    }

    public static  int binarySearch(int[] nums , int start, int end){
        if(start == end){
            return nums[start];
        }

        while(start < end){
            if(start +1 == end){
                if(nums[start] < nums[start+1]){
                    return nums[start];
                }else{
                    return nums[end];
                }
            }
            int mid = start + (end- start)/2;
            //Left array is Sorted
            if(nums[mid] > nums[start]){
                return binarySearch(nums,mid,end);
            }else{
                return binarySearch(nums,start,mid);
            }

        }
        return 0;

    }


    public static void main(String... args){
        int nums[] = {1};
        System.out.println(findMin(nums));
    }
}
