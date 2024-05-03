import java.util.HashSet;
import java.util.Set;

public class TrappingRainWater {

    public static int trap(int[] height) {
        Set<Integer> visitedIndex = new HashSet<>();
        if(null == height || height.length == 0){
            return 0;
        }

        int i = 0;
        int j = 0;
        int trappingArea = 0;
        int totalArea = 0;

        while(j < height.length ){
            if(height[i] == 0){
                i++;
                j = i+1;
                continue;
            }

            if(height[j] == 0 ){
                j++;
                continue;
            }

            if(height[i] <= height[j]){

                int diff = Math.min(height[i], height[j]);
                int start = i;
                int end = j;
                while(start < end){
                    visitedIndex.add(start);
                    trappingArea += diff - height[start];
                    start++;
                }
                totalArea += trappingArea;
                trappingArea = 0;
                i = j ;
                j = i + 1;
            }else{
                j++;
            }
        }




        i = height.length -1;
        j = height.length -1;

        while(j >=0){
            if(height[i] == 0){
                i--;
                continue;
            }

            if(height[j] == 0 ){
                j--;
                continue;
            }

                if(height[i] <= height[j]){
                    int diff = Math.min(height[i], height[j]);
                    int start = i;
                    int end = j;

                    while(start > end){
                        if(!visitedIndex.contains(start)){
                            trappingArea += diff - height[start];

                        }
                        start--;

                    }
                    totalArea += trappingArea;
                    trappingArea = 0;
                    i = j ;
                    j = i -1;
                }else{
                    j--;
                }






        }


        return totalArea;
    }

    public static  void main(String[] args){
        System.out.println(trap(new int[]{2,0,2}));
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));

    }
}
