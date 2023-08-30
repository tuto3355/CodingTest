import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] arr = new int[]{1, 2, 3, 1};

        ArrayList<Integer> list = new ArrayList<>();
        int num = 0;

        while (true) {
            while (list.size()>=4) {
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    if (!(arr[i] == list.get(list.size() - 4 + i))) {
                        cnt++;
                        break;
                    }
                }
                if (cnt == 0) {
                    for (int i = 0; i < 4; i++) {
                        list.remove(list.size() - 1);
                    }
                    answer++;
                } else {
                    break;
                }
            }
            if (num >= ingredient.length) {
                break;
            }else
                list.add(ingredient[num]);
            num++;
        }

        return answer;
    }
}