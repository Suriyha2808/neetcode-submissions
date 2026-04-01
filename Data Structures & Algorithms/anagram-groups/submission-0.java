class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>();
        
        String s;
        for( String str : strs)
        {
            int[] arr = new int[26];
            for(int i=0;i<str.length();i++)
            {
                arr[str.charAt(i) - 'a']++;
            }

            s = Arrays.toString(arr);
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(str);
           
        }
       
        List<List<String>> ans = new ArrayList<>(map.values());

        return ans;
    }
}
