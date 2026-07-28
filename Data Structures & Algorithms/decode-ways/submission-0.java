class Solution {
    public int numDecodings(String s) {

        int n = s.length();

        if (s.charAt(0) == '0') {
            return 0;
        }

        int next = 1;      // dp[i+1]
        int nextNext = 1;  // dp[i+2]

        for (int i = n - 1; i >= 0; i--) {

            int current;

            if (s.charAt(i) == '0') {
                current = 0;
            } else {

                current = next;

                if (i + 1 < n) {
                    int num = Integer.parseInt(s.substring(i, i + 2));

                    if (num >= 10 && num <= 26) {
                        current += nextNext;
                    }
                }
            }

            nextNext = next;
            next = current;
        }

        return next;
    }
}