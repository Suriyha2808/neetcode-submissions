class TrieNode
{
    private TrieNode[] links;

    private final int r=26;

    boolean isend;

    public TrieNode()
    {
        links=new TrieNode[26];
    }

    public boolean checkchar(char c)
    {
        return links[c-'a']!=null;
    }

    public void addchar(char c, TrieNode node)
    {
        links[c-'a']=node;

    }
    public TrieNode getchar(char c)
    {
        return links[c-'a'];
    }

    public void setEnd()
    {
        isend=true;
    }

    public boolean isend()
    {
        return isend;
    }


}


class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(!node.checkchar(c))
            {
                node.addchar(c, new TrieNode());
            }
            node=node.getchar(c);
        }
        node.setEnd();

    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    // 2. The recursive helper method using array loops
    private boolean searchInNode(String word, int i, TrieNode node) {
        // Base Case: If we matched every character, check if this final node is the end of a word
        if (i == word.length()) {
            return node.isend();
        }

        char c = word.charAt(i);

        // CASE 1: If it's a dot, we must try ALL 26 possible paths
        if (c == '.') {
            for (char letter = 'a'; letter <= 'z'; letter++) {
                // If a path exists for this letter, explore it recursively
                if (node.checkchar(letter)) {
                    // Move to the next index (i + 1) and step down into that child node
                    if (searchInNode(word, i + 1, node.getchar(letter))) {
                        return true; // Found a match down this path!
                    }
                }
            }
            return false; // None of the 26 letters led to a successful match
        } 
        
        // CASE 2: It's a regular letter ('a'-'z')
        else {
            if (!node.checkchar(c)) {
                return false; // Path broken
            }
            // Move to the next index and step down into the specific child node
            return searchInNode(word, i + 1, node.getchar(c));
        }
    }
}
