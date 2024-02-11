package q215;

public class KthLargestElementInAnArray {
    // 1 2 3 4 5 | k = 2
    //       i = 5 - 2 = n - k
    
    // T(n) = O(n + n / 2 + n / 4 + ... + 1) = O(2n - 1) = O(n)
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int pivot = nums[j];
            int wall = i;
            for (int x = i; x < j; x++) {
                if (nums[x] < pivot) {
                    swap(nums, x, wall);
                    wall++;
                }
            }
            swap(nums, wall, j);
            if (wall == n - k) break;
            if (wall < n - k) i = wall + 1;
            else j = wall - 1;
        }
        return nums[n - k];
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
