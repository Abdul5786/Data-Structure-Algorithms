

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Step 1: Count frequencies of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check if all frequencies are unique
        HashSet<Integer> frequencySet = new HashSet<>(frequencyMap.values());
        
        // If the size of the HashSet (unique frequencies) matches the size of the HashMap (all frequencies), return true
        return frequencySet.size() == frequencyMap.size();
    }
}