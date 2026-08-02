class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        // Build Trie
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        char c = board[i][j];

        if (c == '#') {
            return;
        }

        TrieNode next = node.children[c - 'a'];

        if (next == null) {
            return;
        }

        if (next.word != null) {
            ans.add(next.word);
            next.word = null; // avoid duplicates
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, next);
        dfs(board, i - 1, j, next);
        dfs(board, i, j + 1, next);
        dfs(board, i, j - 1, next);

        board[i][j] = c;
    }
}