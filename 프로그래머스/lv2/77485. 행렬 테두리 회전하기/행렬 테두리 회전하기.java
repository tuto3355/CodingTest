class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = num++;
            }
        }
        for (int i = 0; i < queries.length; i++) {            
            int x1 = queries[i][0]-1, y1 = queries[i][1]-1, x2 = queries[i][2]-1, y2 = queries[i][3]-1;
            int tmp = arr[x1][y1];
            int min = tmp;
            for (int j = x1; j < x2; j++) {
                arr[j][y1] = arr[j + 1][y1];
                min = Math.min(min, arr[j][y1]);
            }
            for (int j = y1; j < y2; j++) {
                arr[x2][j] = arr[x2][j+1];
                min = Math.min(min, arr[x2][j]);
            }
            for (int j = x2; j >x1; j--) {
                arr[j][y2] = arr[j - 1][y2];
                min = Math.min(min, arr[j][y2]);
            }
            for (int j = y2; j > y1; j--) {
                arr[x1][j] = arr[x1][j-1];
                min = Math.min(min, arr[x1][j]);
            }
            arr[x1][y1 + 1] = tmp;
            answer[i] = min;
        }
        return answer;
    }
}