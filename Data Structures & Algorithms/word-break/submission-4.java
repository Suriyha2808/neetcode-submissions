class Solution {

    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {

        memo = new Boolean[s.length()];

        return helper(0, s, wordDict);
    }

    public boolean helper(int i, String s, List<String> wordDict) {

        if (i == s.length()) {
            return true;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        for (String word : wordDict) {

            int j = i + word.length();

            if (j > s.length()) {
                continue;
            }

            if (word.equals(s.substring(i, j))) {

                if (helper(j, s, wordDict)) {
                    memo[i] = true;
                    return true;
                }
            }
        }

        memo[i] = false;
        return false;
    }
}