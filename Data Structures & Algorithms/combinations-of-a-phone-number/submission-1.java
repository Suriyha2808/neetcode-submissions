

class Solution {
    // Optimization 1: High-speed primitive array lookup table
    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }

        // Optimization 2: Pass 'digits' directly without converting to an intermediate array first
        generate(digits, 0, ans, new StringBuilder());
        return ans;
    }

    private void generate(String digits, int index, List<String> ans, StringBuilder sb) {
        // Base Case
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        // Fetch characters instantly using ASCII subtraction math
        String letters = MAP[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            generate(digits, index + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
    }
}