class Solution {
    public int maxDistance(int[] position, int m) 
    {
        int res=0;
        Arrays.sort(position);

        int l=1, r=position[position.length-1]-position[0]; // binary search boundries

        while(l<=r)
        {
            int mid= l+(r-l)/2;//  calculating minimum force 

            if(isPossible(position,m,mid))
            {
                  res=mid;
                  l=mid+1;
            }

            else
            {
                r=mid-1;
            }
        }

        return res;
    }



        public boolean isPossible(int arr[],int nBalls, int minimumDistance)
        {

            int lastBallPosition =arr[0]; // put first ball 
            int ballsPlaced=1; // now one ball is plac at position 1

            for(int i=1;i<arr.length;i++)
            {

              if(arr[i]-lastBallPosition>=minimumDistance)
              {
                 lastBallPosition=arr[i];
                 ballsPlaced++;
                 if(ballsPlaced==nBalls)
                 {
                    return true;
                 }
              }

              
            }
        

        return false;


}

}