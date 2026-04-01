class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int k =matrix[0].length;


        for(int i=0;i<n;i++)
        {
            if(search(matrix[i],target))
            {
                return true;
            }
        }

        return false;

    }
    public boolean search(int[] nums,int target)
    {
            int low =0;
            int high = nums.length-1;
            System.out.println(low);
            System.out.println(high);
            
            
            while(high>=low)
            {
                
                int mid = (high+low) / 2;
                
                if(nums[mid]==target)
                {
                    return true;
                }

                else if((nums[mid]>target))
                {
                    high=mid-1;
                }

                else if((nums[mid]<target))
                {
                    low=mid+1;
                }


            }

            
            return false;
    }
}
