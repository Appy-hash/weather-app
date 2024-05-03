import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOneIII {

    public static int longestOnes(int[] nums, int k) {

        Pairs pair = null;
        List<Pairs> pairList = new ArrayList<>();

        int j = 0;
        int i = 0;
        while(j < nums.length){
            if(nums[j] == 1){
                j++;

            }else{
                if(j != 0){
                    if(nums[j-1] == 1){
                        pair = new Pairs(i,j -1);
                        pairList.add(pair);
                        i = j+1;
                        j = i;
                    }
                }
                i++;
                j= i;

            }

        }
        return 0;

    }


    public static  void main(String[] args){
       // System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }
}

class Pairs{
    int start;
    int end;

    Pairs(int start){
        this.start = start;
    }

    Pairs(int start, int end){
        this.start = start;
        this.end = end;
    }

}
