import java.util.*;

public class SlidingWindowMaximum {



    public static  int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxSlidingWindow = new int[nums.length - k +1];
        if(null == nums || nums.length == 0){
            return maxSlidingWindow;
        }

        if(nums.length == 1){
            maxSlidingWindow[0] = nums[0];
            return maxSlidingWindow;
        }

        int left = 0;
        int right = left + k -1;
        int index = 0;
        Deque<Integer> dequeu = new ArrayDeque<>();


        while(index < nums.length ){

                while(!dequeu.isEmpty() && nums[dequeu.peekLast()] < nums[index]){
                    dequeu.pollLast();
                }

                while(!dequeu.isEmpty() && dequeu.peekFirst() <= index - k){
                    dequeu.pollFirst();
                }
                dequeu.addLast(index);


                if(index > k -1 && !dequeu.isEmpty()){

                    maxSlidingWindow[left] = nums[dequeu.peekFirst()];
                    left++;

                }
                index++;






        }



        return maxSlidingWindow;


    }



    public static void main(String[] args){


        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7, 1, 3, -1, -3, 5, 3, 6, 7, 1, 3, -1, -3, 5, 3, 6, 7, 1, 3, -1, -3, 5, 3, 6, 7, 1, 3, -1, -3, 5, 3, 6, 7, 1, 3, -1, -3, 5, 3, 6, 7,1, 3, -1, -3, 5, 3, 6, 7}, 1)));



    }
}
