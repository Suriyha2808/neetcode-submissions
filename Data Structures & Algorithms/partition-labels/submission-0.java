class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> list = new ArrayList<>();

        int index = -1;
        int last = 0;

        for (int i = 0; i < s.length(); i++) {

            int j = s.length() - 1;

            while (j >= i) {
                if (s.charAt(i) == s.charAt(j)) {
                    index = Math.max(index, j);
                    break;
                }
                j--;
            }

            if (i == index) {
                list.add(i - last + 1);
                last = i + 1;
                index = -1;
            }
        }

        return list;
    }
}