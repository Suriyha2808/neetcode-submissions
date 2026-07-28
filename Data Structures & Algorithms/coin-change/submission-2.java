class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] arr =new int[amount+1];
        Arrays.fill(arr,99999);

        arr[0]=0;

        for(int i=1;i<=amount;i++)
        {
            for(int k : coins)
            {
                if(i>=k)
                {
                    arr[i]=Math.min(arr[i],arr[i-k]+1);
                }
            }
        }

        if(arr[amount]>amount)
        {
            return -1;
        }

        return arr[amount];
    }
}
