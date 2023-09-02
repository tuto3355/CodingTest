import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};

        int[][] arr = new int[n][n];

        int i = 0, j = 0, num=1, max = n*(n+1)/2;
        while (num<=max) {
            while (true) {
                if(arr[i][j]==0) {
                    arr[i][j] = num;
                    num++;
                }
                if (i + 1 == n || arr[i + 1][j] != 0) {
                    break;
                } else {
                    i++;
                }
            }
            while (true) {
                if(arr[i][j]==0) {
                    arr[i][j] = num;
                    num++;
                }
                if (j+1  > i || arr[i][j+1] != 0) {
                    break;
                } else {
                    j++;
                }
            }
            while (true) {
                if(arr[i][j]==0) {
                    arr[i][j] = num;
                    num++;
                }
                if (i<=1 || j<=1||arr[i-1][j-1] != 0) {
                    break;
                } else {
                    i--;
                    j--;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int ii = 0; ii < n; ii++) {
            for (int jj = 0; jj < n; jj++) {
                if(arr[ii][jj]!=0)
                    list.add(arr[ii][jj]);
            }
        }
        return list.stream().mapToInt(a->a).toArray();
    }
}