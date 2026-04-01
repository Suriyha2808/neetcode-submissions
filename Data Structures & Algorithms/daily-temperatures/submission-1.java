class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int [] ans = new int[temperatures.length];
        Arrays.fill(ans,0);
        for(int i=0;i<temperatures.length;i++)
        {
            
            
            if(!stack.isEmpty())
            {
                System.out.println(temperatures[stack.peek()]);
                int count;
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]  )
                {
                    count = stack.pop();
                    ans[count]= i - count ;
                   
                    
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
