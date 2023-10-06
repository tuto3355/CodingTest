class Solution {
    
    static int cnt = 0;
    static boolean visit[];
    
    static void babo(int ban, int[][] wires, int x) {
        cnt++;
        for (int i = 0; i < wires.length; i++) {
            if (i == ban) {
                continue;
            }
            if (wires[i][0] == x) {
                if (!visit[wires[i][1]]) {
                    visit[wires[i][1]] = true;
                    babo(ban, wires, wires[i][1]);
                }
            } else if (wires[i][1] == x) {
                if (!visit[wires[i][0]]) {
                    visit[wires[i][0]] = true;
                    babo(ban, wires, wires[i][0]);
                }
            }  
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 10000;
        int max = 0;

        for (int i = 0; i < wires.length; i++) {
            max = Math.max(Math.max(wires[i][0], wires[i][1]), max);
        }
        visit = new boolean[max + 1];

        for (int i = 0; i < wires.length; i++) {
            cnt = 0;
            visit[wires[i][0]] = true;
            babo(i, wires, wires[i][0]);
            answer = Math.min(answer, Math.abs(max-cnt*2));
            System.out.println("i = " + i + ", cnt = " + cnt + ", answer = " + answer);
            visit = new boolean[max + 1];
        }

        return answer;
    }
}