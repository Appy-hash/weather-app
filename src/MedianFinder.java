import java.util.ArrayList;
import java.util.List;

public class MedianFinder {

    List<Integer> minHeap;
    List<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new ArrayList<>();
        maxHeap = new ArrayList<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);

        minHeap.add(maxHeap.get(0));
        maxHeap.remove(0);
        buildMinHeap();

        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.get(0));
            minHeap.remove(0);
            buildMaxHeap();

        }
    }


    private void buildMaxHeap(){
        for(int i = 1; i < maxHeap.size() ; i++){
            heapifymax(i);
        }
    }

    private void buildMinHeap(){
        for(int i = 1; i < minHeap.size() ; i++){
            heapifyMin(i);
        }
    }


    private void heapifymax(int index){
        int parent = index/2;

        while(parent >= 0 && maxHeap.get(index) < maxHeap.get(parent)){
            int temp = maxHeap.get(index);

            maxHeap.set(index, maxHeap.get(parent));
            maxHeap.set(parent, temp);

            index = parent;
            parent = index/2;
        }
    }


    private void heapifyMin(int index){
        int parent = index/2;
        while(parent >= 0 && minHeap.get(index) > minHeap.get(parent)){
            int temp = minHeap.get(parent);
            minHeap.set(parent, minHeap.get(index));
            minHeap.set(index,temp);

            index = parent;
            parent = index/2;
        }
    }

    public double findMedian() {

        if(maxHeap.size() > minHeap.size()){
            return (double)maxHeap.get(0);
        }else{
            return (double)( maxHeap.get(0) + minHeap.get(0)) * 0.5;
        }

    }

//[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
    public static void main(String[] args){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());// arr = [1]
           // arr = [1, 2]
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
            // arr[1, 2, 3]
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-4);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-5);
//        System.out.println(medianFinder.findMedian());// return 2.0
    }
}
