import java.util.Arrays;

public class JumpGame2 {

    static int minJump;

    static int[] minJumpDistance;
    public static int jump(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        minJump = Integer.MAX_VALUE;

        minJumpDistance = new int[nums.length];
        Arrays.fill(minJumpDistance, Integer.MAX_VALUE);

        dfs(nums, 0, 0);
        return  minJump;
    }


    private static void dfs(int[] nums, int start, int jump){

        if(start == nums.length -1){
            minJump = Math.min(minJump, jump);
            return;
        }

        if(start < nums.length -1){
            if(nums[start] > 0){
                for(int i = 1 ; i <= nums[start] ;i++){
                    dfs(nums,start+ i, jump+ 1);
                    minJumpDistance[start] = Math.min(minJumpDistance[start], jump);
                }
            }
        }





    }


    public static  void main(String[] args){
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }

}
