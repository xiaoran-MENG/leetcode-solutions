package q240;

public class SearchA2DMatrixII {
    static class DivideAndConquer {
        // T(n) = O(n)
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            return dfs(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
        }

        private boolean dfs(int[][] matrix, int target, int fromY, int toY, int fromX, int toX) {
            // Base case
            if (fromX > toX || fromY > toY) return false;

            int y = fromY + (toY - fromY) / 2;
            int x = fromX + (toX - fromX) / 2;
            int current = matrix[y][x];

            // Conquer
            if (current == target) return true;

            // Divide and conquer
            return current > target 
                ? dfs(matrix, target, fromY, y - 1, fromX, toX) || dfs(matrix, target, fromY, toY, fromX, x - 1)
                : dfs(matrix, target, y + 1, toY, fromX, toX) || dfs(matrix, target, fromY, toY, x + 1, toX);
        }
    }

    static class TwoPointers {
        // T(n) = O(m + n)
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int y = matrix.length - 1;
            int x = 0;
            while (y >= 0 && x < matrix[0].length) {
                int current = matrix[y][x];
                if (current == target) return true;
                if (current < target) x++;
                else y--;
            }
            return false;
        }
    }
}
