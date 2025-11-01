class Solution {
    public String reorganizeString(String s) 
    {
          HashMap<Character,Integer> map =   new HashMap<>();

          for(char ch : s.toCharArray())
          {
              map.put(ch,map.getOrDefault(ch,0)+1);
          }

         PriorityQueue<Character> pq =  new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
         pq.addAll(map.keySet());

        StringBuilder res =  new StringBuilder();

        while(pq.size()>=2)
        {


            char c1 = pq.poll();
            char c2 = pq.poll();
             
             res.append(c1);
             res.append(c2);

            map.put(c1,map.get(c1)-1);
            map.put(c2,map.get(c2)-1);


            if(map.get(c1)>0) pq.add(c1);
            if(map.get(c2)>0) pq.add(c2);
               
        }


        if(!pq.isEmpty())
        {
            char ch = pq.poll();

            if(map.get(ch)>1) return "";
             res.append(ch);
        }

        return res.toString();
    }
}