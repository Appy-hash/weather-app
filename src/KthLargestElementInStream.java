import java.util.*;

class KthLargestElementInStream {



    int k ;
    PriorityQueue<Integer> minHeap;

    public KthLargestElementInStream(int k, int[] nums) {

        this.k = k ;
        this.minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.add(num);
        }

        while(minHeap.size() > k){
            minHeap.poll();
        }
    }




    public int add(int val) {
        minHeap.add(val);
        minHeap.poll();
        if(!minHeap.isEmpty()){
            return minHeap.peek();
        }

        return 0;
    }


    public static void main(String[] args){
        KthLargestElementInStream kthLargest = new KthLargestElementInStream(3, new int[]{4,5,8,2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));   // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8

    }


}



