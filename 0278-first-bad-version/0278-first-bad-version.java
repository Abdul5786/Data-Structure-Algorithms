public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid; // Ho sakta hai answer yahin ho ya left mein
            } else {
                left = mid + 1; // Answer right side mein hi hoga
            }
        }
        return left; // Yeh hi first bad version hai
    }
}