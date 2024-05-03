public class Shipments {


    public static int numberOfShipments(int[] weights){
        int maxValue = weights[0];

        int i  = 1;
        int maxShipment = 0;
        int parcelLength = 1;
        while(i < weights.length){
            if(weights[i] > maxValue && parcelLength > 1 && weights[i-1] < maxValue){
                maxShipment++;
                maxValue = weights[i];
                parcelLength =1;

            }else{
                maxValue = Math.max(weights[i], maxValue);
                parcelLength ++;
            }
            i++;
        }
        if(parcelLength > 1) {
            return maxShipment+1;
        }else{
            return maxShipment;
        }


    }

    public static void main(String[] args){
        System.out.println(numberOfShipments(new int[]{1,2,3,2,6,3}));
        System.out.println(numberOfShipments(new int[]{10,9,11,8,45,59, 2,3,6,65,76,8,78,2,19,54,3}));
    }
}
