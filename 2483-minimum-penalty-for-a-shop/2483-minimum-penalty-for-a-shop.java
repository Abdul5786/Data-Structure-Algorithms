class Solution {
    public int bestClosingTime(String customers) {
        int profit = 0 ,maxProfit = 0 , bestTime = -1 ;
        for(int i = 0 ; i < customers.length() ; i++){
            profit += customers.charAt(i) == 'Y' ? 1 : -1 ;
            if(profit > maxProfit){
                bestTime = i ;
                maxProfit = profit ;
            }
        }
        return bestTime+1;
    }
}