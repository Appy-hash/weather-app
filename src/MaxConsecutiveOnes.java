class Pair{


    int start;
    int end;
    Pair(int start , int end){
        this.start = start;
        this.end = end;
    }
}

public class MaxConsecutiveOnes {


    public static  int longestOnes(int[] nums, int k) {
        if(nums.length == 1){
            return 1;
        }

        int i = 0;
        Pair pais;
        while(i < nums.length){
            if(nums[i] == 1){

                i++;
            }else{
                pais = new Pair(2,2);
            }
        }
        return 0;


    }


    public static  void main(String args[]){
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));

    }
}
