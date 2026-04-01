class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> map = new HashSet<>();

        map.add("+");
        map.add("-");
        map.add("*");
        map.add("/");

        for(int i=0;i<tokens.length;i++)
        {
            if(map.contains(tokens[i]))
            {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());

                System.out.println(a + "" + b + "" + tokens[i]);
               
                if(tokens[i].equals("+"))
                {
                    stack.push(String.valueOf(a+b));
                }
                if(tokens[i].equals("-"))
                {
                    stack.push(String.valueOf(b-a));
                }
                if(tokens[i].equals("/"))
                {
                    stack.push(String.valueOf(b/a));
                }
                if(tokens[i].equals("*"))
                {
                    stack.push(String.valueOf(a*b));
                }

            }
            else 
            {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
}
