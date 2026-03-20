class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0; i<parts.length; i++){
            String part = parts[i];
            if(part.equals("") || part.equals(".")){
                continue;
            }
            if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(part);
            }
        }
        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()){
            result.insert(0, "/" + stack.pop());
        }

        if(result.length() == 0) return "/";
        return result.toString();
    }
}