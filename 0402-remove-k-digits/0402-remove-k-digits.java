class Solution {
    public String removeKdigits(String num, int k) 
    {
      Stack<Character> stack =   new Stack<>();
      
      for(int i=0; i<num.length();i++)
      {
        char ch= num.charAt(i);

        while(!stack.isEmpty()&&k>0 && ch<stack.peek())
        {
            stack.pop();
            k--;
        }
        stack.push(ch);

      }

      while(k-->0)
      {
        stack.pop();
      }

        StringBuilder sb = new StringBuilder();
        for(char ch: stack)
        {
            sb.append(ch);
        }
           
           // checking for leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString().equals("") ? "0" : sb.toString();
      }
    }
