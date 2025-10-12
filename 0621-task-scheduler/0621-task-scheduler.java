import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count task frequencies
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // Step 2: Max-Heap for task frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; ++i) {
            if (freq[i] > 0) {
                pq.add(freq[i]);
            }
        }

        // Step 3: Simulate scheduling cycles
        int time = 0;
        while (!pq.isEmpty()) {
            ArrayList<Integer> ls = new ArrayList<>();
            int task = 0;
            int cycle = n + 1; // Each cycle consists of n + 1 slots

            // Fill the current cycle
            while (cycle-- > 0 && !pq.isEmpty()) {
                int cur = pq.poll();
                if (cur > 1) {
                    ls.add(cur - 1); // Decrement frequency if the task still needs to be executed
                }
                task++;
            }

            // Re-add remaining tasks to the heap
            for (int i : ls) {
                pq.add(i);
            }

            // Increment time
            time += (pq.isEmpty()) ? task : n + 1; // If heap is empty, add only the executed tasks; else, a full cycle
        }

        return time;
    }
}