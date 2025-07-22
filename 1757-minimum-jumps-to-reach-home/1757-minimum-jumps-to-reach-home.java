class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // Forbidden positions ko ek set mein daal rahe hain
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int pos : forbidden) forbiddenSet.add(pos);

        // Queue BFS ke liye, aur visited states track karne ke liye
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Starting point 0, last jump backward nahi tha
        q.offer(new int[]{0, 0}); // {position, lastJumpWasBackward: 0=false}
        visited.add("0_0");

        int max = 6000; // Limit taaki infinite loop na ho
        int jumps = 0;  // Kitne jumps lag rahe hain

        // BFS start karte hain
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int pos = curr[0], lastBack = curr[1];

                // Agar ghar pahunch gaye toh return jumps
                if (pos == x) return jumps;

                // Forward jump try karo
                int nextF = pos + a;
                String keyF = nextF + "_0";
                // Agar nextF valid hai, forbidden nahi hai, aur visit nahi hua toh queue mein daalo
                if (nextF <= max && !forbiddenSet.contains(nextF) && !visited.contains(keyF)) {
                    visited.add(keyF);
                    q.offer(new int[]{nextF, 0});
                }

                // Backward jump sirf tab allow hai jab last jump backward nahi tha
                int nextB = pos - b;
                String keyB = nextB + "_1";
                if (lastBack == 0 && nextB >= 0 && !forbiddenSet.contains(nextB) && !visited.contains(keyB)) {
                    visited.add(keyB);
                    q.offer(new int[]{nextB, 1});
                }
            }
            jumps++; // Ek level khatam, ek jump badha do
        }
        // Agar kahin se nahi pahunch paaye toh -1 return
        return -1;
    }
}