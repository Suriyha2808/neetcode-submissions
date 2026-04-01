class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for (int i : piles) {
            high = Math.max(high, i);
        }
        int low = 1;
        int ans = high; 
        while (low <= high) {
            int mid = (high + low) / 2;
            long inter = cal(piles, mid); // Use long to prevent overflow

            if (inter <= h) {
                ans = mid;      // Speed works, save it
                high = mid - 1; // Try to find a smaller speed
            } else {
                low = mid + 1;  // Too slow, must increase speed
            }
        }
        return ans;
    }

    public long cal(int[] piles, int mid) {
        long totalHours = 0;
        for (int i : piles) {
            // Faster way to do ceiling division without a while loop
            totalHours += (i + mid - 1) / mid;
        }
        return totalHours;
    }
}