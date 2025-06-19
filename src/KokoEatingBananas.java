import java.util.Arrays;

public class KokoEatingBananas {


    public static int minEatingSpeed(int[] piles, int h) {
        Long maxSpeed = Long.MIN_VALUE;
        Long k = 0L;
        for(int i = 0 ; i < piles.length ;i++){
            maxSpeed = Math.max(piles[i], maxSpeed);
            k = maxSpeed;
        }

        int totalHours;
        Long initialSpeed = 1L;
        int i;

        while(initialSpeed <= maxSpeed){

            Long midSpeed = initialSpeed + (maxSpeed - initialSpeed)/2;

            i = 0;
            totalHours = 0;
            while(i < piles.length){
                totalHours += Math.ceil((double) (long) piles[i] / midSpeed);
                i++;
            }
            if(totalHours <= h){
               k = Math.min(k, midSpeed);
               maxSpeed  = midSpeed - 1;
            }else{
                initialSpeed = midSpeed + 1;
            }
        }


        return Math.toIntExact(k);

    }


    public static void main(String[] args){
        //

        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 6));
        System.out.println(minEatingSpeed(new int[]{378913637,633298277,254760011,224966949,802608742,232697717,427551419,956992368,856798922,260962851,464921383,534280061,102268758,375795572,757986538,104804368,384434280,839734051,159340263}, 174648558));
        System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));
        //
    }
}
