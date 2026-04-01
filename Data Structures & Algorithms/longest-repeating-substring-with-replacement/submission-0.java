class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int max_occur = 0;
        int ans = 0;
        int[] occur = new int[26];
        
        for (int right = 0; right < s.length(); right++) {
            
            max_occur = Math.max(max_occur, ++occur[s.charAt(right) - 'A']);
            
            if (right - left + 1 - max_occur > k) {
                occur[s.charAt(left) - 'A']--;
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}