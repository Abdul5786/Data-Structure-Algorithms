import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Step 1: Create a list to store elements with their closeness
        List<int[]> diffList = new ArrayList<>();
        
        // Step 2: Calculate absolute differences and store in diffList
        for (int num : arr) {
            diffList.add(new int[]{num, Math.abs(num - x)});
        }
        
        // Step 3: Sort diffList by absolute difference and then by value
        Collections.sort(diffList, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]); // Sort by value if difference is same
            }
            return Integer.compare(a[1], b[1]); // Sort by absolute difference
        });
        
        // Step 4: Take the first k elements
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(diffList.get(i)[0]);
        }
        
        // Step 5: Sort the result in ascending order
        Collections.sort(result);
        
        return result;
    }
}