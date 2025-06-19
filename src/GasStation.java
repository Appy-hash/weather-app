public class GasStation {



    public static int canCompleteCircuit(int[] gas, int[] cost) {

        for(int i = 0 ; i < gas.length ; i++){
            if(canReachStartingStation(0,i, i, gas,cost)){
                return i;
            }

        }
        return -1;



    }


    private static boolean canReachStartingStation(int tank, int start, int index, int[] gas, int[] cost){

        while(start < gas.length){
            tank = tank + gas[start];


            if(start+1 == index && tank >= cost[start]){
                return true;
            }

            if(tank > cost[start]){
                tank = tank - cost[start];
                if(start == gas.length - 1){
                    start = 0;

                }else{
                    start++;
                }


            }else{
                if(tank >= cost[cost.length-1] && index == 0){
                    return true;
                }
                return false;
            }
        }




        return false;

    }
    public static void main(String args[]){

        System.out.println(canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2}));
        System.out.println(canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
