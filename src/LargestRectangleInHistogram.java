import java.util.Stack;



class Coordinates{
    int index ;
    int height;

    public Coordinates(int index, int height){
        this.index = index;
        this.height = height;
    }
}

public class LargestRectangleInHistogram {


    public static int largestRectangleArea(int[] heights) {
        if(heights == null){
            return 0;
        }

        if(heights.length == 1){
            return heights[0];
        }


        int maxArea = Integer.MIN_VALUE;

        Stack<Coordinates> stack = new Stack<>();
        stack.push(new Coordinates(0,heights[0]));
        int i = 1;
        while(i < heights.length && !stack.isEmpty()){
            Coordinates top = stack.peek();
            int index = top.index;
            int height = top.height;
            if(height > heights[i]){

                while(!stack.isEmpty() && stack.peek().height > heights[i]){
                    int area = stack.peek().height * (i - stack.peek().index);
                    maxArea = Math.max(area, maxArea);
                    index = stack.peek().index;
                    height = stack.peek().height;
                    stack.pop();
                }

            }
            if(heights[i] <= height){
                stack.push(new Coordinates(index, heights[i]));
            }else{
                stack.push(new Coordinates(i, heights[i]));
            }


            i++;

        }

        while (!stack.isEmpty()){
            Coordinates top = stack.peek();
            int area = top.height * (i - top.index);
            maxArea = Math.max(area, maxArea);
            stack.pop();
        }
        return  maxArea;
    }


    public static void  main(String [] args){
        //3,6,5,7,4,8,1,0
        System.out.println(largestRectangleArea(new int[]{3,6,5,7,4,8,1,0}));

        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3,2,1,5,6,2,3,2,1,5,6,2,3,2,1,5,6,2,3,2,1,5,6,2,3,2,1,5,6,2,3,2,1,5,6,2,3,2,1,5,6,2,3,2,1,5,6,2,3,2,1,5,6,2,3,2,1,5,6,2,3}));
    }
}
