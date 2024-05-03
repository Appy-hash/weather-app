import java.util.Arrays;
import java.util.List;

public class QuickSort {



    public static  void swap(int index1 , int index2, int nums[]){
        int temp;
        temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static int partition(int low, int high, int nums[]){

        int pivot = nums[low];
        int pivotIndex = low;
        while(low < high){
            if(nums[low] > pivot && nums[high] <= pivot){
                swap(nums[low],nums[high],nums);

            }
            low++;
            high--;

        }
        swap(pivotIndex,high,nums);
        return high;
    }

    public static void sort(int nums[]){
        int low = 0;
        int high = nums.length-1;
        quickSort(low,high,nums);
    }

    public static void quickSort(int low ,int high,int[] nums){

        if(low < high){
            int pivot = partition(low,high,nums);
            quickSort(low,pivot,nums);
            quickSort(pivot+1,high,nums);
        }


    }

    public static  void main(String[] args){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        sort(nums);
        for(int a: nums){
            System.out.print(a +",");
        }

    }
}
