class Solution {
    public int countDigitOne(int n) {

        long count = 0;
        long factor = 1;
        long number = n;

        while (number > 0) {
            long higher = number / 10;
            long current = number - (higher * 10);
            long lower = n - (number * factor);

            count += higher * factor;

            if (current == 1) {
                count += lower + 1;
            } else if (current > 1) {
                count += factor;
            }

            factor *= 10;
            number = higher;
        }

        return (int) count;
        
    }
}