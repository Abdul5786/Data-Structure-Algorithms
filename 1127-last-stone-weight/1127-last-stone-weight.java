
class Solution {
    public int lastStoneWeight(int[] stones) {
        // Step 1: Create a max heap (Priority Queue in Java with reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Step 2: Add all stones to the max heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        
        // Step 3: Smash stones until at most one is left
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // Heaviest stone
            int stone2 = maxHeap.poll(); // Second heaviest stone
            
            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2); // Add the difference back to the heap
            }
        }
        
        // Step 4: Return the last stone weight or 0 if no stones are left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}