public class MaximumAvgSubArrayI {


    public static double calculateAvg(int start , int end, int[] arr){
        double sum = 0.0;
        for(int i = start; i < end; i++){
            sum += arr[i];
        }
        return sum/(double) (end-start);
    }

    public static double findMaxAverage(int[] nums, int k) {
        if(nums.length == k){
            return calculateAvg(0,nums.length,nums);
        }
        int i = 0 ;
        int j =  i + k;
        double maxAvg = Double.MIN_VALUE;

        while(j <= nums.length){
            double avg = calculateAvg(i,j,nums);
            if(avg > maxAvg){
                maxAvg = avg;
            }
            i++;
            j = i +k;
        }
        return maxAvg;

    }


    public static  void main(String[] args){
        System.out.println(findMaxAverage(new int[]{ 1,12,-5,-6,50,3} ,4));
        System.out.println(findMaxAverage(new int[]{ 1} ,1));
        System.out.println(findMaxAverage(new int []{0,1,1,3,3},4));

    }
}
