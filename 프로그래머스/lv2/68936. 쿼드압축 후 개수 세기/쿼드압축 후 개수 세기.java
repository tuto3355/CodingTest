class Solution {
    static int[] answer = new int[2];

    static void babo(int x, int y, int num, int[][] arr) {
        int tmp = 0;
        for (int i = x; i < x + num; i++) {
            for (int j = y; j < y + num; j++) {
                tmp += arr[i][j];
            }
        }
        if(tmp ==0) answer[0]++;
        else if (tmp == num * num) {
            answer[1]++;
        } else {
            babo(x+num/2,y,num/2,arr);
            babo(x,y+num/2,num/2,arr);
            babo(x,y,num/2,arr);
            babo(x+num/2,y+num/2,num/2,arr);
        }
    }
    public int[] solution(int[][] arr) {
        

        babo(0, 0, arr.length,arr);

        return answer;
    }
}