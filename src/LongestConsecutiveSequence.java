import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        int maxLen = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int i = 0 ;
        while(i < nums.length){
            if(!set.contains(nums[i]- 1)){
                maxLen = Math.max(maxLen, calculateLength(set,nums[i]));
            }

            i++;
        }

        return maxLen;
    }

    private static int calculateLength(Set<Integer> set, int startNumber){
        int length = 0;

        while(set.contains(startNumber)){
            length++;
            startNumber = startNumber +1;
        }
        return length;

    }

    public static void  main(String[] args){
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
