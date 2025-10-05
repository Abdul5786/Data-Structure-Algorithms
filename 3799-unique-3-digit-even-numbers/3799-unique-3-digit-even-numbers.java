class Solution {
    public int totalNumbers(int[] digits) {
        List<String> ans = new ArrayList();
        int[] dig = new int[3];
        int i =0;
        int j =1;
        int k =2;
        for ( i = 0;i<digits.length -2;i++)
        {
            for ( j = i+1;j<digits.length -1;j++)
            {
                for ( k = j+1; k < digits.length;k++)
                {
                    dig[0] = digits[i];
                    dig[1] = digits[j];
                    dig[2] = digits[k];
                    rec(dig, 0, ans);

                }
            }
        }
        return ans.size();
    }

    private void rec(int[] d, int start, List<String> ans) {
        if (start == d.length) {
            if ( d[d.length - 1]%2 == 0 && d[0] != 0)
            {
                if ( !ans.contains(Arrays.toString(d)))
                    ans.add(Arrays.toString(d));

            }
            return ;
        }

        for (int i = start; i < d.length; i++) {
            int temp = d[i];
            d[i] = d[start];
            d[start] = temp;
            rec(d, start + 1, ans);
            temp = d[i];
            d[i] = d[start];
            d[start] = temp;

        }

    }
}