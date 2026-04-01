class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] used = new boolean[strs.length];

        int x [] = new int[26];
        int l=-1;
        int p=1;
        for(int i=0;i<strs.length;i++)
        {
            if (used[i]) continue;
            
            ans.add(new ArrayList<>());
            l++;
            ans.get(l).add(strs[i]);
            used[i] = true;
            for(int j=i+1;j<strs.length;j++)
            {
                if(strs[i].length() != strs[j].length() )
                {
                    continue;
                }
                Arrays.fill(x, 0);

                for(int k=0; k<strs[i].length();k++)
                {
                    x[strs[i].charAt(k) - 'a']++;
                    x[strs[j].charAt(k) - 'a']--;
                }

                for(int c : x)
                {
                    if (c!=0)
                    {
                        p=0;
                    }
                }
                if(p==1)
                {
                    if (used[j]) continue;
                    ans.get(l).add(strs[j]);
                    used[j] = true;
                }
                
                p=1;
                
            }
        }

        return ans;
    }
}