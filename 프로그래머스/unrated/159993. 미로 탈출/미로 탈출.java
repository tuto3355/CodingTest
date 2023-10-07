import java.util.*;

class Solution {
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int end = 0;
    static Queue<int[]> q = new LinkedList<>();

    static void babo(int x, int y, int depth, String[] maps) {
        visit[x][y] = true;
        if (maps[x].charAt(y) == 'L') {
            end = depth;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x2 = x + dx[i];
            int y2 = y + dy[i];
            if (x2 >= 0 && y2 >= 0 && x2 < maps.length && y2 < maps[0].length()
                    && !visit[x2][y2] && (maps[x2].charAt(y2) != 'X')) {
                q.add(new int[]{x2, y2, depth + 1});
            }
        }
    }

    static void babo2(int x, int y, int depth, String[] maps) {
        visit[x][y] = true;
        if (maps[x].charAt(y) == 'E') {
            end = depth;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x2 = x + dx[i];
            int y2 = y + dy[i];
            if (x2 >= 0 && y2 >= 0 && x2 < maps.length && y2 < maps[0].length()
                    && !visit[x2][y2] && (maps[x2].charAt(y2) != 'X')) {
                q.add(new int[]{x2, y2, depth + 1});
            }
        }
    }


    public static int solution(String[] maps) {
        int answer = -1;
        int x = 0, y = 0, xx=0, yy=0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
                else if (maps[i].charAt(j) == 'L') {
                    xx = i;
                    yy = j;
                }
            }
        }
        visit = new boolean[maps.length][maps[0].length()];
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if(!visit[tmp[0]][tmp[1]]) {
                babo(tmp[0], tmp[1], tmp[2], maps);
            }
            if (end != 0) {
                answer = end;
                break;
            }
        }
        end = 0;
        if (answer == -1) {
            return answer;
        }

        int answer2 = -1;

        visit = new boolean[maps.length][maps[0].length()];
        q.clear();
        q.add(new int[]{xx, yy, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if(!visit[tmp[0]][tmp[1]]) {
                babo2(tmp[0], tmp[1], tmp[2], maps);
            }
            if (end != 0) {
                answer2 = end;
                break;
            }
        }
        if (answer2 == -1) {
            return answer2;
        }
        
        return answer + answer2;
    }
}