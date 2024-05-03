public class BestTimetoBuyandSellStock {

    public static int maxProfit(int[] prices) {
        if(prices.length == 1)
            return 0;
        int i = 0;
        int j = i +1;



        int maxProfit = Integer.MIN_VALUE;
        while(j < prices.length){
            if(prices[i] > prices[j]){
                i++;
                j = i+1;
            }else{
                //Buying day price is less than selling day price
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
                j++;
            }
        }
        return maxProfit != Integer.MIN_VALUE ? maxProfit : 0;


    }


    public static  void main(String ... args){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

}
