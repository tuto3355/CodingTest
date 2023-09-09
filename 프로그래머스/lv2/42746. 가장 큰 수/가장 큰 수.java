import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            arr.add(numbers[i]);
        }

        Collections.sort(arr,(a,b)-> {
            String x = a.toString();
            String y = b.toString();
            return (y+x).compareTo(x+y);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(arr.get(i));
        }
        String answer = sb.toString();
        while(answer.length()>=2 && answer.charAt(0)=='0' && answer.charAt(1)=='0')
            answer = answer.substring(1);

        return answer;
    }
}