
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        generate(0, ans, new ArrayList<>(), s);
        return ans;
    }

    public void generate(int index, List<List<String>> ans, List<String> curr, String s) {
        // FLAW 1 FIX: Base case check at the very top!
        if (index == s.length()) {
            ans.add(new ArrayList<>(curr)); // Snapshot the valid partition setup
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // BUG 1 FIX: Change ending index to i + 1 so it's inclusive
            String k = s.substring(index, i + 1); 
            
            if (check(k)) {
                curr.add(k); // Commit
                
                // FLAW 2 & 3 FIX: Only recurse inside the match block, starting at i + 1
                generate(i + 1, ans, curr, s); 
                
                curr.remove(curr.size() - 1); // Retract (Backtrack step)
            }
        }
    }

    public boolean check(String s) {
        // BUG 3 FIX: Use modern string checks
        if (s.isEmpty()) {
            return false;
        }
        int i = 0;
        int j = s.length() - 1;

        // BUG 4 FIX: Use i < j to step inward from both sides
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}