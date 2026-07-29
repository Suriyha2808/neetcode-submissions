class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][1] < newInterval[0]) {

                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }

            else if (newInterval[1] < intervals[i][0]) {

                list.add(new int[]{newInterval[0], newInterval[1]});

                for (int j = i; j < intervals.length; j++) {
                    list.add(new int[]{intervals[j][0], intervals[j][1]});
                }

                return list.toArray(new int[list.size()][]);
            }

            else {

                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        // Insert merged interval at the end
        list.add(new int[]{newInterval[0], newInterval[1]});

        return list.toArray(new int[list.size()][]);
    }
}