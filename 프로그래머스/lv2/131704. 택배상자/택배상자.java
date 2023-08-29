import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> arr1 = new Stack<>();
        Stack<Integer> arr2 = new Stack<>();
        for (int i = order.length-1; i >=0; i--) {
            arr1.add(i + 1);
        }

        while (true) {
            if (answer < order.length && !arr1.isEmpty()&&(arr1.peek() == order[answer])) {
                arr1.pop();
                answer++;
                continue;
            } else if (!arr2.isEmpty() && answer < order.length && arr2.peek() == order[answer]) {
                arr2.pop();
                answer++;
                continue;
            } else if (answer < order.length &&!arr1.isEmpty()) {
                arr2.add(arr1.pop());
                continue;
            } else if(arr1.isEmpty()){
                break;
            }
        }

        return answer;
    }
}