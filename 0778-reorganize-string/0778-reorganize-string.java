class Solution {
    public String reorganizeString(String s) 
    {
        HashMap<Character,Integer> freqMap = new HashMap<>();  // to calculate freq

        for(char ch:s.toCharArray())
        {
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        // add all elements in priorityQueue basis on frquency

       PriorityQueue<Character> maxHeap =  new PriorityQueue<>((a,b)->freqMap.get(b)-freqMap.get(a));
       maxHeap.addAll(freqMap.keySet());
     
     StringBuilder res =   new StringBuilder();
       while(maxHeap.size()>=2)
       {


         char c1 =maxHeap.poll();
         char c2 = maxHeap.poll();

         res.append(c1);
         res.append(c2);

         // decrease freq
         freqMap.put(c1,freqMap.get(c1)-1);
         freqMap.put(c2,freqMap.get(c2)-1);

         if(freqMap.get(c1)>0) maxHeap.add(c1);
         if(freqMap.get(c2)>0) maxHeap.add(c2);  // heap m duabra daaal diya ahhh ahhh ahh

       }

       if(!maxHeap.isEmpty())
       {
          char ch = maxHeap.poll();

          if(freqMap.get(ch)>1) return "";
          res.append(ch);
       }

       return res.toString();
    }
}