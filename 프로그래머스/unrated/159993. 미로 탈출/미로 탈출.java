import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();

        // Find the path from 'S' to 'L'
        int slPathLength = bfs(maps, 'S', 'L', rows, cols);

        // Reset visited array
        boolean[][] visited = new boolean[rows][cols];

        // Find the path from 'L' to 'E'
        int lePathLength = bfs(maps, 'L', 'E', rows, cols);

        // If either path is not found, return -1
        if (slPathLength == -1 || lePathLength == -1) {
            return -1;
        }

        // Return the sum of the two path lengths
        return slPathLength + lePathLength;
    }

    private static int bfs(String[] maps, char start, char end, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        int startX = -1, startY = -1;

        // Find the starting position
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i].charAt(j) == start) {
                    startX = i;
                    startY = j;
                    break;
                }
            }
            if (startX != -1) {
                break;
            }
        }

        if (startX == -1 || startY == -1) {
            // Starting position not found
            return -1;
        }

        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int depth = current[2];

            if (maps[x].charAt(y) == end) {
                return depth;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols
                        && !visited[newX][newY] && maps[newX].charAt(newY) != 'X') {
                    queue.add(new int[]{newX, newY, depth + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        // Path not found
        return -1;
    }

    public static void main(String[] args) {
        String maps[] = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        int result = solution(maps);
        System.out.println("Result: " + result);
    }
}