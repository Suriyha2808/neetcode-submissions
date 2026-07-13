class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans=new ArrayList<>();
        generate(n,0,0,new StringBuilder() ,ans);
        return ans;

        
    }
    public void generate(int n,int open,int close,StringBuilder sb,List<String> ans)
    {
        if(sb.length()==2*n)
        {
            ans.add(new String(sb.toString()));
        }
        if(open<n)
        {
            sb.append('(');
            generate(n,open+1,close,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(close<open)
        {
            sb.append(')');
            generate(n,open,close+1,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }

        return;
    }
}
