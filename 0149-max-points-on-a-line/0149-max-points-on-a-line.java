class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 2) return points.length;
        int ans = 0;
        for(int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int same = 1, vertical = 0, currMax = 0;
            for(int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if(dx == 0 && dy == 0) {
                    same++; // duplicate point
                } else if(dx == 0) {
                    vertical++;
                } else {
                    int gcd = gcd(dx, dy);
                    dx /= gcd; dy /= gcd;
                    String slope = dy + "/" + dx;
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    currMax = Math.max(currMax, map.get(slope));
                }
                currMax = Math.max(currMax, vertical);
            }
            ans = Math.max(ans, currMax + same);
        }
        return ans;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}