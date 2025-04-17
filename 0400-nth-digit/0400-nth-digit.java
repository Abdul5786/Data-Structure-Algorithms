class Solution {
    public int findNthDigit(int n) {

        long digit = 9;
        int first = 1;
        int length = 1;
        while (n > digit * length) {
            n -= digit * length;
            length++;
            first *= 10;
            digit *= 10;
        }
        first += (n - 1) / length;
        String str = String.valueOf(first);
        return Character.getNumericValue(str.charAt((n - 1) % length));
    }
        
    }
