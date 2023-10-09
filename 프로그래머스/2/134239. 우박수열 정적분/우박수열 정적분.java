import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Double> answer = new ArrayList<>();

        ArrayList<Double> list = new ArrayList<>();
        list.add((double)k);
        while (k != 1) {
            if(k%2==0) k /= 2;
            else k = k * 3 + 1;
            list.add((double)k);
        }
        for (int i = 0; i < ranges.length; i++) {
            double sum=0;
            int left = ranges[i][0], right = list.size() + ranges[i][1]-1;
            if (left > right) {
                answer.add(-1D);
                continue;
            } else if (left == right) {
                answer.add(0D);
                continue;
            }
            for (int j = left; j <= right; j++) {
                if (j == left || j == right) {
                    sum += list.get(j)/2;
                } else {
                    sum += list.get(j);
                }
            }
            answer.add(sum);
        }
        return answer.stream().mapToDouble(a -> a).toArray();
    }
}