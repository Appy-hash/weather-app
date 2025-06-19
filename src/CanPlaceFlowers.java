public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0 ;

        if(n == 0){
            return true;
        }
        if(flowerbed.length == 1){
            return flowerbed[i] == 0 ? true: false;
        }

        while(i < flowerbed.length){
            if(flowerbed[i] == 0){
                if(i-1 >= 0 && i + 1 < flowerbed.length ){
                    if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }else if(i == 0 && i + 1 < flowerbed.length){
                    if(flowerbed[i + 1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }else if(i == flowerbed.length-1 && i > 0){
                    if(flowerbed[i - 1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }


            }
            i++;

        }
        if(n <= 0){
            return true;
        }
        return false;

    }


    public static  void main(String[] args){
//        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},1));
//        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},2));

//        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,0,0,1},2));
//
        System.out.println(canPlaceFlowers(new int[]{0,0,1,0,0},1));

    }
}
