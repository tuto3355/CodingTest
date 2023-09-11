class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        for (int i = 0; i <= 60 * 24; i++) {
            int cnt = 0;
            for (int j = 0; j < book_time.length; j++) {

                int a = Integer.parseInt(book_time[j][0].substring(0, 2)) * 60
                        + Integer.parseInt(book_time[j][0].substring(3, 5));
                int b = Integer.parseInt(book_time[j][1].substring(0, 2)) * 60
                        + Integer.parseInt(book_time[j][1].substring(3, 5)) + 9;
                if(i>=a && i<=b) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}