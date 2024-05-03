public class ClimbingStairs {

    static  int[] ways;
    public static int recurse(int start, int n){
        if(start == 1){
            return 1;
        }

        if(start == 0){
            return 1;

        }

        return recurse(start+1,n)+ recurse(start+2,n);

    }

    public static int climbStairs(int n){
        ways = new int[n+1];
        return recurse(0,n);

    }

    public static void main(String[] args){
        System.out.println(climbStairs(45));
        System.out.println(climbStairs(3));
    }
}
