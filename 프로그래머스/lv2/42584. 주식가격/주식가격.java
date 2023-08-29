import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i-stack.pop();
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length-1-stack.pop();
        }

        return answer;
    }
}