class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
        {
            List<String> ans =  new ArrayList<>();
            return ans;
        }
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        String [] strings = new String[digits.length()];

        for(int i=0;i<digits.length();i++)
        {
            strings[i]=map.get(digits.charAt(i));
        }
        List<String> ans=new ArrayList<>();
        generate(strings,0,ans,new StringBuilder());
        return ans;
        
    }
    public void generate(String[] strings,int index,List<String> ans,StringBuilder sb)
    {
        if(sb.length()==strings.length)
        {
            ans.add(sb.toString());
            return;
        }

        for(int i=0;i<strings[index].length();i++)
        {
            sb.append(strings[index].charAt(i));
            generate(strings,index+1,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}
