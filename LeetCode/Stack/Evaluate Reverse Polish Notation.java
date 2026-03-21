class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<tokens.length; i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                    int b = stack.pop();
                    int a = stack.pop();
                    int res = tokens[i].equals("+") ? a + b : tokens[i].equals("-") ? a - b : tokens[i].equals("*") ? a * b : a / b;
                    stack.push(res);
            }
        }
        return stack.peek();
    }
}