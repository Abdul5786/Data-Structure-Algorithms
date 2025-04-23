class Solution {
    public boolean canArrange(int[] arr, int k) {
         Map<Integer, Integer> m = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int rem = (arr[i] % k + k) % k;
            m.put(rem, m.getOrDefault(rem, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            int rem = (k - key) % k;
            if (!m.containsKey(rem) || m.get(rem) != value || (key == rem && value % 2 != 0)) {
                return false;
            }
        }
        return true;
    }
    }
