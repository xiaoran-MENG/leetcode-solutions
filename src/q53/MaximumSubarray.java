package q53;

public class MaximumSubarray {
    static class Kadane {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int sum = 0;
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; i++) {
                sum += nums[0];
                result = Math.max(result, sum);
                if (sum < 0) sum = 0;
            }
            return result;
        }
    }

    static class DivideAndConquer {
        public int maxSubArray(int[] nums) {
            return dfs(nums, 0, nums.length - 1);
        }
    
        private int dfs(int[] nums, int i, int j) {
            if (i == j) return nums[i];
            int k = i + (j - i) / 2;
            int left = dfs(nums, i, k);
            int right = dfs(nums, k + 1, j);
            int cross = cross(nums, k, i, j);
            return Math.max(Math.max(left, right), cross);
        }
    
        private int cross(int[] nums, int k, int i, int j) {
            int leftSum = 0;
            int leftMax = Integer.MIN_VALUE;
            for (int x = k; x >= i; x--) {
                leftSum += nums[x];
                leftMax = Math.max(leftMax, leftSum);
            }
    
            int rightSum = 0;
            int rightMax = Integer.MIN_VALUE;
            for (int x = k + 1; x <= j; x++) {
                rightSum = nums[x];
                rightMax = Math.max(rightMax, rightSum);
            }
    
            return leftMax + rightMax;
        }
    }
}
