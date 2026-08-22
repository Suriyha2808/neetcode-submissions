class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String , List<String>> map = new HashMap<>();

        for(String s : strs )
        {
            char[] c = s.toCharArray();
            Arrays.sort(c);

            String key = new String(c);

            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        
        List<List<String>> ans = new ArrayList<>();

        for(List<String> s : map.values())
        {
            ans.add(s);
        }

        return ans;
    }
}
