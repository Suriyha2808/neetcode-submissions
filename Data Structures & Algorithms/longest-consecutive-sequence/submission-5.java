class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> map = new HashSet<>();
       
        System.out.println("arr to set");
        for(int num : nums)
        {
             System.out.println(num);
            map.add(num);
        }
        int i=0;
        System.out.println("set to arr");
        for(int num : map)
        {
            System.out.println(num);
            nums[i++]=num;
        }


        int count=0;
        if(map.size()==1)
        {
            return 1;
        }
        for(int num : map)
        {
            if (map.contains(num-1)  )
            {
                continue;
            }
            int a=num;
            int cur_sum=1;
            while(map.contains(a+1))
            {
                a++;
                cur_sum++;
            }

            count=Math.max(count,cur_sum);

        }


        return count;
    }
}
