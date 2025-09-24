class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        
        // Split path by "/" to get directories
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Ignore empty parts and "."
                continue;
            } else if (part.equals("..")) {
                // ".." means go back one directory
                if (!stack.isEmpty()) stack.pop();
            } else {
                // Valid directory name → push to stack
                stack.push(part);
            }
        }

        // Build the simplified path
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        // If stack is empty, return root "/"
        return sb.length() > 0 ? sb.toString() : "/";
    }

    
}
