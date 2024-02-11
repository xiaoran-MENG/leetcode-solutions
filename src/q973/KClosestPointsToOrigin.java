package q973;

import java.util.Arrays;

public class KClosestPointsToOrigin {
    // T(n) = O(n)
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int[] pivot = points[j];
            int wall = i;
            for (int x = i; x < j; x++) {
                boolean closer = (points[x][0] * points[x][0] + points[x][1] * points[x][1] - 
                    pivot[0] * pivot[0] - pivot[1] * pivot[1]) < 0;
                if (closer) {
                    swap(points, wall, x);
                    wall++;
                }
            }
            swap(points, wall, j);
            if (wall == k) break;
            if (wall < k) i = wall + 1;
            else j = wall - 1;
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private void swap(int[][] points, int i, int j) {
        int[] point = points[i];
        points[i] = points[j];
        points[j] = point;
    }
}
