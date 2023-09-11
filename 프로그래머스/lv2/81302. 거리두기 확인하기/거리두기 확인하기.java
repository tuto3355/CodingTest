class Solution {
    static boolean[][] visit;
    static int cnt;
    static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void babo(int n, int i, int j, String[][] places, int x) {

        if (x == 1) {
            if (places[n][i].charAt(j) == 'P') {
                cnt++;
                return;
            }            
        }
        
        if (x == 2) {
            if (places[n][i].charAt(j) == 'P') {
                cnt++;                
            }
            return;
        }

        for (int k = 0; k < 4; k++) {
            if (i + d[k][0] >= 0 && i + d[k][0] < 5
                    && j + d[k][1] >= 0 && j + d[k][1] < 5
                    && !visit[i + d[k][0]][j + d[k][1]] && places[n][i+ d[k][0]].charAt(j+ d[k][1]) != 'X') {
                babo(n, i + d[k][0], j + d[k][1], places, x + 1);
            }
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int n = 0; n < places.length; n++) {
            visit = new boolean[5][5];
            cnt = 0;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[n][i].charAt(j) == 'P') {
                        visit[i][j] = true;
                        babo(n, i, j, places, 0);
                        visit[i][j] = false;
                    }
                }
            }
            if (cnt == 0) {
                answer[n] = 1;
            }
        }
        return answer;
    }
}