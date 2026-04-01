class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] counter1 = new int[26];
        int[] counter2 = new int[26];

        // 1. Initial window
        for (int i = 0; i < s1.length(); i++) {
            counter1[s1.charAt(i) - 'a']++;
            counter2[s2.charAt(i) - 'a']++;
        }
        
        // 2. Slide the window
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(counter1, counter2)) return true;
            
            // Add next char on the right
            counter2[s2.charAt(i + s1.length()) - 'a']++;
            // Remove old char on the left
            counter2[s2.charAt(i) - 'a']--;
        }

        // 3. Check the very last window
        return matches(counter1, counter2);
    }

    private boolean matches(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }
}