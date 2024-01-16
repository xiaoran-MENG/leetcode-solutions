package q42;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    public int trap(int[] height) {
        int size = height.length, result = 0;
        Deque<Integer> indices = new ArrayDeque<>();
        
        for (int i = 0; i < size; i++) {
            while (!indices.isEmpty() && height[i] > height[indices.peek()]) {
                int k = indices.pop();

                if (indices.isEmpty()) {
                    break;
                }

                int depth = Math.min(height[indices.peek()], height[i]) - height[k];
                int width = i - indices.peek() - 1;
                int area = depth * width;

                result += area;
            }

            indices.push(i);
        }

        return result;
    }
}
