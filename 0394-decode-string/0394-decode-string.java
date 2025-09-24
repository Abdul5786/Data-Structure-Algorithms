class Solution {
    public String decodeString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack <String> st2 = new Stack<>();
        String current = "";

        int multiper = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                multiper = multiper *10 +(ch- '0');
            }
            else if(ch == '['){
                st1.push(multiper);
                st2.push(current);
                multiper = 0;
                current = "";
            }
            else if(ch == ']'){
                int repeat = st1.pop();
                String previous = st2.pop();
                current = previous +current.repeat(repeat);
            }
            else{
                current += ch;
            }
        }
        return current;
    }
}
  