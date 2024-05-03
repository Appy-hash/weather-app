import java.util.*;

public class TopKFrequentElements {


    public static int[] topKFrequent(int[] nums, int k) {
        int[] topKFrequentarray = new int[k];
        if(null == nums){
            return topKFrequentarray;
        }

        if(nums.length == 1){
            topKFrequentarray[0] = nums[0];
            return topKFrequentarray;
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((entry, entry2) -> entry2.getValue() - entry.getValue());

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num, 0) +1);


        }

        pq.addAll(frequencyMap.entrySet());


        while(k != 0 && !pq.isEmpty()){
            topKFrequentarray[k-1] = pq.poll().getKey();
            k--;
        }
        return topKFrequentarray;





    }


    public static void main(String[] args){

        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1, 1, 1, 2, 2, 3, 1, 1, 1, 2, 2, 3, 1, 1, 1, 2, 2, 3, 1, 1, 1, 2, 2, 3, 1, 1, 1, 2, 2, 3 }, 3)));
    }
}
