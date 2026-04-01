class Solution {
    public boolean isPalindrome(String s) {

        s =s.toLowerCase();
        
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        String reversed = new StringBuilder(s).reverse().toString();

        System.out.println(s);

        System.out.println(reversed);

        if(s.equals(reversed))
        {
            return true;
        }

        return false;
        
    }
}
