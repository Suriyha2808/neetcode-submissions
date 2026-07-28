class Solution {
    public int countSubstrings(String s) {

        int ans=0;

        for(int i=0;i<s.length();i++)
        {
            ans=expand(i,i,ans,s);
            ans=expand(i,i+1,ans,s);

        }

        return ans;
        
    }

    public int expand(int i,int j,int ans,String s)
    {
        while(i>=0 && j<s.length())
        {
            if(s.charAt(i)==s.charAt(j))
            {
                ans++;
                i--;
                j++;
            }

            else
            {
                break;
            }
        }

        return ans;
    }
}
