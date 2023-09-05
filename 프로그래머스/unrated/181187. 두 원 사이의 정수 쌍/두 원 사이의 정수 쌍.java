class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 1; i < r1; i++) {
            double a = Math.floor(Math.sqrt((double)r2*r2-(double)i*i));
            double b = Math.ceil(Math.sqrt((double)r1*r1-(double)i*i));
            answer += (long)((a-b+1)*4);
        }
        for (int i = r1; i < r2; i++) {
            double b = Math.floor(Math.sqrt((double)r2*r2-(double)i*i));
            answer += (long)((b)*4);
        }
        answer += 4L * (r2 - r1 + 1);

        return answer;
    }
}