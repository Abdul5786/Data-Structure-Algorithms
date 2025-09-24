class Solution {
    public int evalRPN(String[] tokens) 
    {
       Stack<Integer> stack = new Stack<>();

       for(String token: tokens)
       {
         if("*-/+".contains(token))
         {
             int a = stack.pop();
             int b= stack.pop();
             
             switch(token)
             {
                case "+" : stack.push(b + a); break;
                    case "-" : stack.push(b - a); break;
                    case "*" : stack.push(b * a); break;
                    case "/" : stack.push(b / a); break; // integer division (truncates towards 0)
             }
         }

           else 
           {
            stack.push(Integer.parseInt(token));
           }
       }

       return stack.pop(); 
    }
}