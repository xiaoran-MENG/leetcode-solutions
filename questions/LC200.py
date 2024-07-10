from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        height, width, count = len(grid), len(grid[0]), 0
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        def traverse(r, c):
            if r < 0 or r >= height or c < 0 or c >= width or grid[r][c] == '0':
                return
            
            grid[r][c] = '0'

            for x, y in directions:
                traverse(r + x, c + y)

        for r in range(height):
            for c in range(width):
                if grid[r][c] == '1':
                    traverse(r, c)
                    count += 1

        return count
