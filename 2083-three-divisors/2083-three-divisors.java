class Solution {
    public boolean isThree(int n) 
    {
         int count =1;//1
        for(int i=2;i<=n;i++){//2
            if(n%i==0){
                count++;
            }
        }
        if(count==3){
            return true;
        }
        else{
            return false;
        }
    }
}