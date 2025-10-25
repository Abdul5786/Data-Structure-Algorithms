class Solution {
    public int totalMoney(int n) 
    {
        int noOfWeeks = n/7;

        int noOfDays = n%7;

        int startingMoneyPrice = 1;

        int totalSavingMoney=0;


        for(int i=1;i<=noOfWeeks;i++)
        {

            for(int j=startingMoneyPrice;j<startingMoneyPrice+7;j++)  // initailley startValue will be 1
            {
                totalSavingMoney += j; 
            }

            startingMoneyPrice++; // now start price is revised  start+1
        }

        // now calculating money for rest of the days


        for(int i=startingMoneyPrice;i<startingMoneyPrice+noOfDays;i++)
        {
           totalSavingMoney +=i;  
        }

          return totalSavingMoney;
    }

  
}