class Solution {
    public int findKthPositive(int[] arr, int k) 
    {

           int currentValue=1;
        int index=0;
        int missingNumberCount=0;

        while(missingNumberCount<k)
        {
            if(index < arr.length && arr[index]==currentValue)
            {
                // skip element
                index++;
            }

          else {

              missingNumberCount++;
              if(missingNumberCount==k)
              {
                  return currentValue;
              }
          }

          currentValue++;


        }

        return -1;
    }
    }
    

    //    // using Binary Search 

    //     int low = 0, high = arr.length - 1;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         int missing = arr[mid] - (mid + 1);
    //         if (missing < k) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }
    //     return high + 1 + k;

    
