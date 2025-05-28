class Solution {
    public String removeDuplicateLetters(String s) 
    {
      int lastIndex[] = new int[26];
      for(int i=0; i<s.length();i++)
      {
         lastIndex[s.charAt(i)-'a']=i;
      }
      
      boolean seen[] = new boolean[26];

     Stack<Character> stack = new Stack<>();

      for(int i=0;i<s.length();i++)
      {
         char ch =  s.charAt(i);

         if(seen[ch-'a'])
         {
            continue;
         }

         while (!stack.isEmpty() && ch < stack.peek() && lastIndex[stack.peek() - 'a'] > i) {
          seen[stack.pop() - 'a'] = false;
         }

         stack.push(ch);
         seen[ch-'a']=true;
      }

            StringBuilder sb  =         new StringBuilder();

            for(char c: stack)
            {
                sb.append(c);
            }

            return sb.toString();
    }
}