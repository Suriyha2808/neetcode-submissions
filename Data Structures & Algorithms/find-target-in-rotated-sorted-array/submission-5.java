class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // 1. Identify which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left side is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // Target is in the sorted left side
                    right = mid - 1;
                } else {
                    // Target must be on the right side
                    left = mid + 1;
                }
            } else {
                // Right side is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // Target is in the sorted right side
                    left = mid + 1;
                } else {
                    // Target must be on the left side
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}