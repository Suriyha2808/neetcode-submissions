class Solution {
    public boolean isAnagram(String s, String t) {
         if(s.length() != t.length())
        {
            return false;

        }

        int [] x= new int[26];

        for(int i=0;i<s.length();i++)
        {
            x[s.charAt(i) - 'a']++;
            x[t.charAt(i) - 'a']--;
        }

        for( int y : x)
        {
            if(y != 0)
            {
                return false;
            }
        }
        return true;

    }
}
