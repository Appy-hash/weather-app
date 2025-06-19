import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeros {



    public static void moveZeroes(int[] nums){
        //calculate no of zeros
        int totalZeroesToMove = 0;
        for(int a: nums){
            if (a == 0) {
                totalZeroesToMove ++;
            }
        }


        while(totalZeroesToMove > 0){
            int i = 0 ;
            int j = i+1;
            while(j < nums.length){
                if(nums[i]  == 0 && nums[j] != 0 ){
                    //swap them to move the zeroeth  element towards end
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j = i+1;
                }else if(nums[i] != 0 && nums[j] == 0){
                    i++;

                }else if(nums[i] != 0 & nums[j] != 0){
                    i++;
                    j = i+1;
                }else if(nums[i] == 0 && nums[j] == 0){
                    j++;
                }

            }
            totalZeroesToMove--;
        }
        List<Integer> lis = new ArrayList<>();
        for(int i : nums){
            lis.add(i);
        }

        System.out.println(lis);
    }



    public  static  void main(String[] args){
        moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes(new int[]{0,0,0,3,12});
        moveZeroes(new int[]{1,0,3,12,0,0});
        moveZeroes(new int[]{1,1,0,3,12});

    }
}
