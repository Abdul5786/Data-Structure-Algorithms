class Solution 
{
    public static String helper(String s, int n)
    {
        // Step 1 : Base-Case
        if(n == 0)
        {
            return s;
        }

        // Step 2 : Initialize the Previous Counts
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char curr = s.charAt(0);

        // Step 3 : Iterate and Populate the sb with count + digit
        for(int i = 1; i < s.length(); i++)
        {
            if(curr == s.charAt(i))
            {
                count++; 
            }
            else
            {
                // Step 4 : Appending the count + digit 
                sb.append(count);
                sb.append(curr);

                // Step 5 : Resetting the counters for next digit
                count = 1;
                curr = s.charAt(i);
            }
        }

        // Step 6 : Appending Last Group
        sb.append(count);
        sb.append(curr);

        // Step 7 : Inner Function Call
        return helper(sb.toString(), n - 1);
    }

    public String countAndSay(int n) 
    {
        return helper("1", n - 1);
    }
}