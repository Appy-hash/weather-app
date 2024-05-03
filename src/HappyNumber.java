import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    private static int sumOfSquares(int number){
        int sumOfSquares = 0;
        while(number > 0){
            int remainder = number % 10;  //9
            sumOfSquares += (int) Math.pow(remainder,2);
            number = number/10; //1
        }
        return sumOfSquares;

    }
    public static boolean isHappy(int n) {
        int sum = n;
        Set<Integer> set = new HashSet<>();
        while(sum != 1){
            sum = sumOfSquares(sum);


            if(set.contains(sum)){
                return false;
            }else{
                set.add(sum);
            }
            if(sum ==1){
                return true;
            }
        }
        return false;
    }


    public static  void main(String[] args){
        System.out.println(isHappy(3));
        System.out.println(isHappy(2));
        System.out.println(isHappy(1111111));
    }
}
