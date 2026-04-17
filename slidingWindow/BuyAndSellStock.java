class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }

        int buyPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
     int prices[] = {7,1,5,3,6,4};
     System.out.println(maxProfit(prices));
    }
}