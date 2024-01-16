package q84;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length, result = 0;
        Deque<Integer> indices = new ArrayDeque<>();
        indices.push(-1);
        
        for (int i = 0; i < size; i++) {
            while (indices.peek() != -1 && heights[i] < heights[indices.peek()]) {
                result = Math.max(result, area(heights, indices, i));
            }

            indices.push(i);
        }

        while (indices.peek() != -1) {
            result = Math.max(result, area(heights, indices, size));
        }

        return result;
    }

    private int area(int[] heights, Deque<Integer> indices, int i) {
        int height = heights[indices.pop()];
        int width = i - indices.peek() - 1;
        return height * width;
    }
}
