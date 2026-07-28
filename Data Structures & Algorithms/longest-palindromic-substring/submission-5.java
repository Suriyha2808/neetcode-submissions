class Solution {
    public String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder(s);
        String ans = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {

            for (int j = s.length() - 1; j > i; j--) {

                // No need to check shorter substrings
                if ((j - i + 1) <= ans.length()) {
                    break;
                }

                if (check(i, j, sb)) {
                    ans = sb.substring(i, j + 1);
                    break; // First palindrome is the longest for this i
                }
            }
        }

        return ans;
    }

    public boolean check(int i, int j, StringBuilder sb) {

        while (i < j) {

            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}