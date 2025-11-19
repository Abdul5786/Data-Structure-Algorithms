class Solution {
    public String customSortString(String order, String s) 
    {
        HashMap<Character,Integer> map =  new HashMap<>();
        StringBuilder res = new StringBuilder();

        // Step 1: Frequency map
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Characters according to order
        for(char ch : order.toCharArray()) {

            if(map.containsKey(ch)) {

                int freq = map.get(ch);

                // freq > 0  (not < 0)
                while(freq > 0) {
                    res.append(ch);
                    freq--;
                }

                map.remove(ch); 
            }
        }

        // Step 3: Remaining characters
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {

            int freq = entry.getValue();
            char chr = entry.getKey();

            while(freq > 0) {
                res.append(chr);
                freq--;
            }
        }

        return res.toString();
    }
}
