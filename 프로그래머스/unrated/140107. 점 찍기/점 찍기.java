class Solution {
    public long solution(int k, int d) {
        long answers = 0;

        for (int i = 0; i <= d; i += k) {
            answers += (int) (Math.sqrt((double)d *d - (double) i *i) / k)+1;
        }
        return answers;
    }
}