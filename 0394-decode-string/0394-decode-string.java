import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int index = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);

            } else if (ch == '[') {
                stringStack.push(currentString);
                currentString = "";
                index++;

            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString);
                }
                currentString = temp.toString();
                index++;

            } else {
                currentString += ch;
                index++;
            }
        }

        return currentString;
    }
}