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

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {

        root = new TrieNode();
         
    }

    public void insert(String word) {
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

    public boolean search(String word) 
    {
        TrieNode node = root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(!node.checkchar(c))
            {
                return false;
            }
            node=node.getchar(c);
        }
        if(node.isend())
        {
            return true;
        }
        return false;

    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++)
        {
            char c=prefix.charAt(i);
            if(!node.checkchar(c))
            {
                return false;
            }
            node=node.getchar(c);
        }
        
        return true;
       

    }
}
