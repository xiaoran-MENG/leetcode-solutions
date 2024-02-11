package q560;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    static class PrefixSumLinear {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) // O(n)
                sum[i + 1] = sum[i] + nums[i];
            //   0 1 3 6
            //   1 2 3
            //   0 1 2 3
            //   i
            //       j
            int count = 0;
            for (int i = 0; i < n; i++) { // O(n^2)
                for (int j = i + 1; j <= n; j++) {
                    int sub = sum[j] - sum[i];
                    // j = i + 1: Sum(first)
                    // j = n: Sum(all)
                    if (sub == k) count++;
                }
            }
            return count;
        }
    }

    static class PrefixSumMemoization {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0;
            int count = 0;
            for (int num : nums) {
                sum += num;
                int diff = sum - k;
                if (map.containsKey(diff))
                    count += map.get(diff);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
