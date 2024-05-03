public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length- 1;
        int maxArea = Integer.MIN_VALUE;

        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area,maxArea);

            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }

        return maxArea;

    }


    public static void main(String... args){
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }

}
