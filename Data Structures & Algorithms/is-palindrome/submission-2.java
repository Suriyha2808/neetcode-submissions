class Solution {
    public boolean isPalindrome(String s) {

        s =s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        System.out.println(s);

        for(int i=0, j=s.length()-1;i<j;i++,j--)
        
        {
            if(!Character.isLetterOrDigit(s.charAt(i)))
            {
                i++;
            }
            if(!Character.isLetterOrDigit(s.charAt(j)))
            {
                j++;
            }
            if(s.charAt(i)==s.charAt(j))
            {
               
                continue;
            }
            return false;
        }

    

        return true;
        
    }
}
