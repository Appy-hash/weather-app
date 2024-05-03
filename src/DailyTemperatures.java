import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Weather{
    int day;
    int index;

    Weather(int day, int index){
        this.day = day;
        this.index = index;
    }
}
public class DailyTemperatures {


    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Weather> stack = new Stack<>();
        Weather weather;
        int i = temperatures.length -1;
        int[] warmerDays = new int[temperatures.length];
        while(i >= 0 ){
                while(!stack.isEmpty()){
                    if(temperatures[i] > stack.peek().day){
                        stack.pop();
                    }else{
                            warmerDays[i] = stack.peek().index - i ;
                            stack.push(new Weather(temperatures[i], i));
                            break;

                    }
                }
                if(stack.isEmpty()){
                    stack.push(new Weather(temperatures[i], i));
                }

            i--;


        }
        return warmerDays;
    }


    public static void main(String[] args){
        System.out.println(List.of(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(List.of(dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println(List.of(dailyTemperatures(new int[]{30,60,90})));
//        System.out.println(List.of(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
