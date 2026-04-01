class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String t : tokens) {
            // Using a switch is cleaner for multiple string matches
            switch (t) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int a = stack.pop(); // right operand
                    int b = stack.pop(); // left operand
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int x = stack.pop(); // divisor
                    int y = stack.pop(); // dividend
                    stack.push(y / x);
                    break;
                default:
                    // If it's not an operator, it's a number
                    stack.push(Integer.parseInt(t));
                    break;
            }
        }
        return stack.pop();
    }
}