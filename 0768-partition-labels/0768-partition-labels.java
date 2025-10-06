class Solution {

    List<Integer> res = new ArrayList<>();
    int start=0;
    int end=0;
    
    public List<Integer> partitionLabels(String s) 
    {
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }
        
        for(int i=0;i<s.length();i++)
        {

             end = Math.max(end, lastOccurrence.get(s.charAt(i)));

            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}