class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        // Key = Closing Bracket, Value = Corresponding Opening Bracket
        Map<Character, Character> mapped = new HashMap<>();
        mapped.put(')', '(');
        mapped.put('}', '{');
        mapped.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char chara = s.charAt(i);
            
            // If it's a CLOSING bracket (exists in our Map keys)
            if (mapped.containsKey(chara)) {
                // If stack is empty, there's no opening bracket to match
                if (stack.isEmpty()) return false;
                
                // Pop the top and see if it matches the required opening bracket
                char topElement = stack.pop();
                if (topElement != mapped.get(chara)) {
                    return false;
                }
            } else {
                // It's an OPENING bracket, just push it
                stack.push(chara);
            }
        }
        
        // Final Check: If stack is empty, everything matched perfectly
        return stack.isEmpty();
    }
}